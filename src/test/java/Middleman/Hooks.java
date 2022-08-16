package Middleman;

import Middleman.API.MiddlemanAPI_InOutBounds;
import Middleman.API.MiddlemanAPI_Admins;
import Middleman.API.MiddlemanAPI_Users;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;

import static Middleman.API.MiddlemanAPI_InOutBounds.URL;

public class Hooks {
    @Before("@loginAdmins")
    public void login_admins(){
        File json = new File("src/test/resources/JSONFile/Login/ValidLoginAdmin.json");
        Response response= SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .post(URL+"/login");
        JsonPath jsonPath = response.jsonPath();
        MiddlemanAPI_Admins.TOKEN_ADMINS = "Bearer "+ jsonPath.get("data.token");
    }

    @Before("@InvalidToken")
    public void invalidToken(){
        MiddlemanAPI_Admins.TOKEN_ADMINS = "Bearer invalid1234567io";
    }

    @Before("@loginRizkyUser")
    public void loginRizkyUser(){
        File json = new File("src/test/resources/JSONFile/Login/ValidLoginUser.json");
        Response response= SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .post(URL+"/login");
        JsonPath jsonPath = response.jsonPath();
        MiddlemanAPI_InOutBounds.TOKEN_RIZKYUSER = jsonPath.get("data.token");
    }

    @Before("@loginRizkyUser1")
    public void loginRizkyUser1(){
        File json = new File("src/test/resources/JSONFile/Login/ValidLoginUser2.json");
        Response response= SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .post(URL+"/login");
        JsonPath jsonPath = response.jsonPath();
        MiddlemanAPI_InOutBounds.TOKEN_RIZKYUSER = jsonPath.get("data.token");
    }

    @Before("@loginErnaUser")
    public void loginErnaUser(){
        File json = new File("src/test/resources/JSONFile/Login/ValidLoginUser4.json");
        Response response= SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .post(URL+"/login");
        JsonPath jsonPath = response.jsonPath();
        MiddlemanAPI_Users.TOKEN_ERNAUSER = "Bearer "+ jsonPath.get("data.token");
    }

    @Before("@invalidTokenErnaUSer")
    public void invalidTokenErnaUser(){
        MiddlemanAPI_Users.TOKEN_ERNAUSER = "Bearer invalid123456";
    }

    @After("@loginRizkyUser")
    public void reset_token_rizkyUser(){
        MiddlemanAPI_InOutBounds.TOKEN_RIZKYUSER = "";
    }

    @After
    public void reset_token_ernaUser(){ MiddlemanAPI_Users.TOKEN_ERNAUSER = "";
    }

    @After("@loginAdmins")
    public void reset_token_admins(){
        MiddlemanAPI_Admins.TOKEN_ADMINS = "x";
    }
}
