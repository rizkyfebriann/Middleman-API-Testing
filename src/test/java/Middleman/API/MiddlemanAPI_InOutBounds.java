package Middleman.API;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class MiddlemanAPI_InOutBounds {
    public static final String URL = "https://postme.site";
    public static final String DIR = System.getProperty("user.dir");

    public static final String JSON_FILE_INOUTBOUNDS = DIR+"/src/test/resources/JSONFile/InOutBounds";
    public static String TOKEN_RIZKYUSER = "";
    public static String TOKEN_RIZKYUSER1 = "";

    public static String TOKEN_ADMIN = "";
    public static String TOKEN_ADMIN_INVALID = "";

    public static String GET_ALL_CART_INOUTBOUNDS = URL+"/inoutbounds";
    public static String GET_ALL_CART_INVALID_INOUTBOUNDS = URL+"/inoutbound";

    public static String CREATE_A_CART_INOUTBOUNDS = URL+"/inoutbounds";

    public static String CREATE_A_CART_INVALID_INOUTBOUNDS = URL+"/inoutbound";

    public static String UPDATE_A_CART_INOUTBOUNDS = URL+"/inoutbounds/{id}";

    public static String UPDATE_A_CART_INVALID_INOUTBOUNDS = URL+"/inoutbound/{id}";

    public static String DELETE_PRODUCTS_INOUTBOUNDS = URL+"/inoutbounds/{id}";

    public static String DELETE_PRODUCTS_INVALID_INOUTBOUNDS = URL+"/inoutbound/{id}";

    @Step("Get all carts on inoutbounds - User")
    public static void getAllCartInoutboundsUser() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_RIZKYUSER);
    }

    @Step("Get all carts on inoutbounds - User1")
    public static void getAllCartInoutboundsUser1() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_RIZKYUSER1);
    }

    @Step("Get all carts on inoutbounds - Admin")
    public static void getAllCartInoutboundsAdmin() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_ADMIN);
    }

    @Step("Create a cart on inoutbounds - Unauthorized")
    public void createCartInoutboundsUnauthorized(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Create a cart on inoutbounds - User")
    public void createCartInoutboundsUser(File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_RIZKYUSER)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Create a cart on inoutbounds - User1")
    public void createCartInoutboundsUser1(File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_RIZKYUSER1)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Create a cart on inoutbounds - Admin")
    public void createCartInoutboundsAdmin(File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_ADMIN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Update qty product added on inoutbounds - User")
    public void updateQtyInoutboundsUser(File json, String id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_RIZKYUSER)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Update qty product added on inoutbounds - User1")
    public void updateQtyInoutboundsUser1(File json, String id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_RIZKYUSER1)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Update qty product added on inoutbounds - Admin")
    public void updateQtyInoutboundsAdmin(File json, String id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_ADMIN)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete product added on cart inoutbounds - Unauthorized")
    public void deleteProductCartInoutboundsUnauthorized(String id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Delete product added on cart inoutbounds - User")
    public void deleteProductCartInoutboundsUser(String id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_RIZKYUSER)
                .pathParam("id", id);
    }

    @Step("Delete product added on cart inoutbounds - Admin")
    public void deleteProductCartInoutboundsAdmin(String id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_ADMIN)
                .pathParam("id", id);
    }

}
