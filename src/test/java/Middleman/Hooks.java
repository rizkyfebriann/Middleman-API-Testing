package Middleman;

import Middleman.API.MiddlemanAPI;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;

import static Middleman.API.MiddlemanAPI.URL;

public class Hooks {
    @Before("@loginAdmins")
    public void login_admins(){
        File json = new File("src/test/resources/JSONFile/Login/ValidLoginAdmin.json");
        Response response= SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .post(URL+"/login");
        JsonPath jsonPath = response.jsonPath();
        MiddlemanAPI.TOKEN_ADMINS = "Bearer "+ jsonPath.get("data.token");
    }
    @Before("@InvalidToken")
    public void invalidToken(){
        MiddlemanAPI.TOKEN_ADMINS = "Bearer invalid1234567io";
    }

    @Before("@loginRizkyUser")
    public void loginRizkyUser(){
        File json = new File("src/test/resources/JSONFile/Login/ValidLoginUser.json");
        Response response= SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .post(URL+"/login");
        JsonPath jsonPath = response.jsonPath();
        MiddlemanAPI.TOKEN_RIZKYUSER = jsonPath.get("data.token");
    }

    @Before("@loginRizkyUser1")
    public void loginRizkyUser1(){
        File json = new File("src/test/resources/JSONFile/Login/ValidLoginUser2.json");
        Response response= SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .post(URL+"/login");
        JsonPath jsonPath = response.jsonPath();
        MiddlemanAPI.TOKEN_RIZKYUSER = jsonPath.get("data.token");
    }

    @After("@loginRizkyUser")
    public void reset_token_rizkyUser(){
        MiddlemanAPI.TOKEN_RIZKYUSER = "";
    }

    @After("@loginAdmins")
    public void reset_token_admins(){
        MiddlemanAPI.TOKEN_ADMINS = "x";
    }
}
