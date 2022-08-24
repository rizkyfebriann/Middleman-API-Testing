package Middleman;

import Middleman.API.MiddlemanAPI_Cart;
import Middleman.API.MiddlemanAPI_InOutBounds;
import Middleman.API.MiddlemanAPI_UserProduct;
import Middleman.API.MiddlemanAPI_Users;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;

import static Middleman.API.MiddlemanAPI_InOutBounds.URL;

public class HookLogin3 {
    @Before("@invalidTokenErnaUser")
    public void invalidTokenErnaUser(){
        String invalidToken = "Bearer invalid1234567io";
        MiddlemanAPI_Users.TOKEN_ERNAUSER = invalidToken;
        MiddlemanAPI_UserProduct.TOKEN_ERNAUSER = invalidToken;
        MiddlemanAPI_Cart.TOKEN_ERNAUSER = invalidToken;
    }

    @Before("@loginErnaUser")
    public void loginErnaUser(){
        File json = new File("src/test/resources/JSONFile/Login/ValidLoginUser3.json");
        Response response= SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .post(URL+"/login");
        JsonPath jsonPath = response.jsonPath();
        MiddlemanAPI_Users.TOKEN_ERNAUSER = "Bearer "+ jsonPath.get("data.token");
        MiddlemanAPI_UserProduct.TOKEN_ERNAUSER = "Bearer "+ jsonPath.get("data.token");
        MiddlemanAPI_Cart.TOKEN_ERNAUSER = "Bearer "+ jsonPath.get("data.token");

    }

    @After
    public void reset_token_ernaUser(){
        MiddlemanAPI_Users.TOKEN_ERNAUSER = "";
    }

}
