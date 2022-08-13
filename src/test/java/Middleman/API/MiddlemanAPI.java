package Middleman.API;

import java.io.File;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class MiddlemanAPI {
    public static final String URL = "https://postme.site";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE_LOGIN = DIR+"/src/test/resources/JSONFile/Login";
    public static final String JSON_FILE_REGISTER = DIR+"/src/test/resources/JSONFile/Register";
    public static final String JSON_FILE_USER = DIR+"/src/test/resources/JSONFile/User";
    public static String POST_LOGIN_USER = URL+"/login";
    public static String POST_LOGININVALID_USER = URL+"/logins";

    public static String POST_REGISTER_USER = URL+"/register";
    public static String POST_REGISTERINVALID_USER = URL+"/registers";
    public static String GET_USER = URL+"/users";
    public static String GET_USER_INVALID_PATH = URL+"/userssss";
    public static String PUT_USER = URL+"/users";
    public static String PUT_USER_INVALID_PATH = URL+"/userssszz";
    public static String DELETE_USER = URL+"/users";
    public static String DELETE_USER_INVALID_PATH = URL+"/usersSS";


    //public static final String JSON_FILE_LOGIN_USER2 = DIR+"/src/test/resources/JSONFile/User";

//    public String bearer_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6MiwiUm9sZSI6InVzZXIiLCJleHAiOjE2NjAzMjQxMjR9.kOYiRZO8OQXfNERZGtfwcC_g0Jyzlfdg9MBQ27V-Zn8";
//
//    public void apply(RequestTemplate requestTemplate) {
//
//        requestTemplate.header(AUTHORIZATION_HEADER, getBearerTokenHeader());
//
//    }

    @Step("Post login user or admin")
    public void postLoginUserOrAdmin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register user")
    public void postRegisterUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get user with valid token")
    public void getUserWithValidToken(){
        SerenityRest.given()
                .headers("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6NTEsIlJvbGUiOiJ1c2VyIiwiZXhwIjoxNjYwNDg4ODQ4fQ.yo-BKn-4NfBwL5DrXRayToJv5UY1y8W-pymox_R7TFY");
    }
    @Step("Get user with invalid token")
    public void getUserWithInvalidToken(){
        SerenityRest.given()
                .headers("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6NTEsIlJvbGUiOiJ1c2VyIiwiZXhwIjoxNjYwNDg4ODQ4fQ.yo-BKn-4NfBwL5DrXRayToJv5UY1y8W-pymox_R7TFYXXX");
    }

    @Step("Put user with valid token")
    public void putUserWithvalidToken(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .headers("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6NTEsIlJvbGUiOiJ1c2VyIiwiZXhwIjoxNjYwNDg4ODQ4fQ.yo-BKn-4NfBwL5DrXRayToJv5UY1y8W-pymox_R7TFY");

    }

    @Step("Delete user with valid token")
    public void deleteUserWithValidToken(){
        SerenityRest.given()
                .headers("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6NjIsIlJvbGUiOiJ1c2VyIiwiZXhwIjoxNjYwNTEwNzk2fQ.l5NH2frPxHgbLHwqWJA_7em-IF9lyjVt0qGdcX7RNDg");
    }

    @Step("Delete user with invalid token")
    public void deleteUserWithInValidToken(){
        SerenityRest.given()
                .headers("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6NTUsIlJvbGUiOiJ1c2VyIiwiZXhwIjoxNjYwNTA3Nzc2fQ.8pPWFTGlqrpq9xEc3v1j4pGP-HgFq-FjgD9bpr3RajcXXX");
    }
}