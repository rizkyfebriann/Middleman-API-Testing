package Middleman.API;

import java.io.File;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class MiddlemanAPI {
    public static final String URL = "https://postme.site";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE_LOGIN = DIR+"/src/test/resources/JSONFile/Login";
    public static String POST_LOGIN_USER = URL+"/login";

    @Step("Post login user or admin")
    public void postLoginUserOrAdmin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }



}
