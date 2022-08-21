package Middleman.API;

import Middleman.Constant;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class MiddlemanAPI_Orders {

    public static final String JSON_FILE_ORDERS = Constant.DIR+"/src/test/resources/JSONFile/Orders";
    public static String TOKEN_USER_VALID_EMAIL = "";
    public static String TOKEN_ADMIN = "";

    public static String CREATE_ORDERS = Constant.URL+"/orders/users";
    public static String CREATE_ORDERS_INVALID_PATH = Constant.URL+"/orders/users";
    public static String GET_ALL_ORDERS = Constant.URL+"/orders";
    public static String GET_ALL_ORDERS_INVALID_PATH = Constant.URL+"/order";
    public static String GET_DETAIL_ORDERS = Constant.URL+"/orders/{id}";
    public static String GET_DETAIL_ORDERS_INVALID_PATH = Constant.URL+"/order/{id}";
    public static String ADMIN_GET_INCOMING_ORDERS = Constant.URL+"/orders/admins/incoming";
    public static String ADMIN_GET_INCOMING_ORDERS_INVALID_PATH = Constant.URL+"/order/admins/incoming";
    public static String ADMIN_CONFIRM_ORDERS = Constant.URL+"/orders/confirm/{id}";
    public static String ADMIN_FINISH_ORDERS = Constant.URL+"/orders/done/{id}";

    @Step("Create order - Unauthorized")
    public void createOrdersUnauthorized(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Create orders - User")
    public void createOrdersValidUser(File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_USER_VALID_EMAIL)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Create orders - Invalid User")
    public void createOrdersInvalidUser(File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + "ey8sd9829823")
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get all orders - User")
    public static void getAllOrdersUser() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_USER_VALID_EMAIL);
    }

    @Step("Get all orders - Invalid user")
    public static void getAllOrdersInvalidUser() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + "ey733473423");
    }

    @Step("Get all orders - Admin")
    public static void getAllOrdersAdmin() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_ADMIN);
    }

    @Step("Get detail orders - Unauthorized")
    public static void getDetailOrdersUnauthorized(String id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get detail orders - User")
    public static void getDetailOrdersUser(String id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_USER_VALID_EMAIL)
                .pathParam("id", id);
    }

    @Step("Get detail orders - Invalid User")
    public static void getDetailOrdersInvalidUser(String id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + "ey4849485452")
                .pathParam("id", id);
    }

    @Step("Get detail orders - Admin")
    public static void getDetailOrdersAdmin(String id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_ADMIN)
                .pathParam("id", id);
    }

    @Step("Get incoming orders - Admin")
    public static void getIncomingOrdersAdmin() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_ADMIN);
    }

    @Step("Admin confirm order")
    public static void PUTConfirmOrder(String id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_ADMIN)
                .pathParam("id", id);
    }

    @Step("Admin finish order")
    public static void PUTFinishOrder(String id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_ADMIN)
                .pathParam("id", id);
    }

}
