package Middleman.API;

import java.io.File;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class MiddlemanAPI_Register {

    public static final String URL = "https://postme.site";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE_REGISTER = DIR+"/src/test/resources/JSONFile/Register";

    public static String POST_REGISTER_USER = URL+"/register";
    public static String POST_REGISTERINVALID_USER = URL+"/registers";

    @Step("Post register user")
    public void postRegisterUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

}
