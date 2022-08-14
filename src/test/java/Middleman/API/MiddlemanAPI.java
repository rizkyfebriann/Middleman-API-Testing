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

    public static String GET_ALL_CARTS_INOUTBOUNDS = URL+"/inoutbounds";

//  public String bearer_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6MiwiUm9sZSI6InVzZXIiLCJleHAiOjE2NjAzMjQxMjR9.kOYiRZO8OQXfNERZGtfwcC_g0Jyzlfdg9MBQ27V-Zn8";

    public String unauthorized_account = "";
    public String bearer_token_userRizky = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6NTMsIlJvbGUiOiJ1c2VyIiwiZXhwIjoxNjYwNTc1OTI4fQ.7k8RbEGTBwaRFhRU1d3xqcy8MYjOXvAMaZbvjp2Y71M";

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

    @Step("Get all cart on inoutbounds (unauthorized)")
    public void getAllCartsInoutboundsUnauthorized(){
        SerenityRest.given()
                .headers("Authorization","Bearer " + unauthorized_account);
    }

    @Step("Get all cart on inoutbounds (authorized user Rizky)")
    public void getAllCartsInoutboundsAuthorizeduserRizky(){
        SerenityRest.given()
                .headers("Authorization","Bearer " + bearer_token_userRizky);
    }


}
