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
    public static String POST_LOGIN_USER = URL+"/login";
    public static String POST_LOGININVALID_USER = URL+"/logins";

    public static String POST_REGISTER_USER = URL+"/register";
    public static String POST_REGISTERINVALID_USER = URL+"/registers";

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


}
