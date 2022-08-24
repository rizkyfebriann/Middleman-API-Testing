package Middleman.API;

import java.io.File;

import Middleman.Constant;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class MiddlemanAPI_Users {

    public static final String JSON_FILE_USER = Constant.DIR + "/src/test/resources/JSONFile/User";
//    public static final String JSON_FILE_USER_PRODUCT = DIR+"/src/test/resources/JSONFile/User_Product";
    public static String TOKEN_ERNAUSER = "";
    public static String GET_USER = Constant.URL+"/users";
    public static String GET_USER_INVALID_PATH = Constant.URL+"/userssss";
    public static String PUT_USER = Constant.URL+"/users";
    public static String PUT_USER_INVALID_PATH = Constant.URL+"/userssszz";
    public static String DELETE_USER = Constant.URL+"/users";
    public static String DELETE_USER_INVALID_PATH = Constant.URL+"/usersSS";

    //public static final String JSON_FILE_LOGIN_USER2 = DIR+"/src/test/resources/JSONFile/User";

    @Step("Get user with valid token")
    public void getUserWithValidToken(){
        SerenityRest.given()
                .headers("Authorization", TOKEN_ERNAUSER);
    }
    @Step("Get user with invalid token")
    public void getUserWithInvalidToken(){
        SerenityRest.given()
                .headers("Authorization", TOKEN_ERNAUSER);
    }

    @Step("Get user without token")
    public void getUserWithoutToken(){
        SerenityRest.given()
                .headers("Authorization", TOKEN_ERNAUSER);
    }

    @Step("Put user with valid token")
    public void putUserWithvalidToken(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .headers("Authorization", TOKEN_ERNAUSER);
    }

    @Step("Delete user with valid token")
    public void deleteUserWithValidToken(){
        SerenityRest.given()
                .headers("Authorization", TOKEN_ERNAUSER);
    }

    @Step("Delete user with invalid token")
    public void deleteUserWithInValidToken() {
        SerenityRest.given()
                .headers("Authorization", TOKEN_ERNAUSER);
    }
}
