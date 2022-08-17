package Middleman;

import Middleman.API.MiddlemanAPI_Cart;
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
    @Before("@loginErnaUser")
    public void loginErnaUser(){
        File json = new File("src/test/resources/JSONFile/Login/ValidLoginUser4.json");
        Response response= SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .post(URL+"/login");
        JsonPath jsonPath = response.jsonPath();
        MiddlemanAPI_Users.TOKEN_ERNAUSER = "Bearer "+ jsonPath.get("data.token");
        MiddlemanAPI_UserProduct.TOKEN_ERNAUSER = "Bearer "+ jsonPath.get("data.token");
        MiddlemanAPI_Cart.TOKEN_ERNAUSER = "Bearer "+ jsonPath.get("data.token");

    }

    @Before("@invalidTokenErnaUser")
    public void invalidTokenErnaUser(){
        MiddlemanAPI_Users.TOKEN_ERNAUSER = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJR";
    }

    @After
    public void reset_token_ernaUser(){
        MiddlemanAPI_Users.TOKEN_ERNAUSER = "";
    }

}
