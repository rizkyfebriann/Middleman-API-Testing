package Middleman;

import Middleman.API.MiddlemanAPI_InOutBounds;
import Middleman.API.MiddlemanAPI_Admins;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;

import static Middleman.API.MiddlemanAPI_InOutBounds.URL;

public class HooksLogin1 {

    @Before("@InvalidToken")
    public void invalidToken(){
        MiddlemanAPI_InOutBounds.TOKEN_ADMIN_INVALID = "Bearer invalid1234567io";
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
        File json = new File("src/test/resources/JSONFile/Login/ValidLoginUser1.json");
        Response response= SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .post(URL+"/login");
        JsonPath jsonPath = response.jsonPath();
        MiddlemanAPI_InOutBounds.TOKEN_RIZKYUSER1 = jsonPath.get("data.token");
    }

    @Before("@loginAdmins")
    public void loginAdmin(){
        File json = new File("src/test/resources/JSONFile/Login/ValidLoginAdmin.json");
        Response response= SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .post(URL+"/login");
        JsonPath jsonPath = response.jsonPath();
        MiddlemanAPI_InOutBounds.TOKEN_ADMIN = jsonPath.get("data.token");
    }

    @After("@loginRizkyUser")
    public void reset_token_User(){
        MiddlemanAPI_InOutBounds.TOKEN_RIZKYUSER = "";
    }
}
