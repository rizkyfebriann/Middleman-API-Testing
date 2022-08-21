package Middleman;

import Middleman.API.MiddlemanAPI_Admins;
import Middleman.API.MiddlemanAPI_InOutBounds;
import Middleman.API.MiddlemanAPI_Inventory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;

import static Middleman.API.MiddlemanAPI_InOutBounds.URL;

public class HooksLogin2 {

    @Before("@loginAdmins")
    public void login_admins_ira(){
        File json = new File("src/test/resources/JSONFile/Login/ValidLoginAdmin.json");
        Response response= SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .post(URL+"/login");
        JsonPath jsonPath = response.jsonPath();
        MiddlemanAPI_Admins.TOKEN_ADMINS = "Bearer "+ jsonPath.get("data.token");
        MiddlemanAPI_Inventory.TOKEN_ADMINS = "Bearer "+ jsonPath.get("data.token");
    }

    @Before("@loginRizkyInventory")
    public void loginRizkyInventory(){
        File json = new File("src/test/resources/JSONFile/Login/ValidLoginUser.json");
        Response response= SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .post(URL+"/login");
        JsonPath jsonPath = response.jsonPath();
        MiddlemanAPI_Inventory.TOKEN_RIZKYUSER_INVENTORY = "Bearer "+ jsonPath.get("data.token");
    }
    @Before("@InvalidBearerToken")
    public void invalidTokenInventory(){
        MiddlemanAPI_Inventory.TOKEN_ADMINS = "Bearer invalid1234567io";
        MiddlemanAPI_Inventory.TOKEN_RIZKYUSER_INVENTORY = "Bearer invalid1234567io";
    }

    @Before("@InvalidToken")
    public void invalidToken(){
        MiddlemanAPI_Admins.TOKEN_ADMINS = "Bearer invalid1234567io";
    }

    @After
    public void reset_token(){
        MiddlemanAPI_Admins.TOKEN_ADMINS = "x";
        MiddlemanAPI_Inventory.TOKEN_RIZKYUSER_INVENTORY = "x";
    }
}
