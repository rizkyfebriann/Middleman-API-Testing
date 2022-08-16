package Middleman.API;

import java.io.File;


import Middleman.Constant;
import Middleman.API.MiddlemanAPI_Users;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class MiddlemanAPI_UserProduct {
    public static String TOKEN_ERNAUSER = "";
    public static final String JSON_FILE_USER_PRODUCT = Constant.DIR+"/src/test/resources/JSONFile/User_Product";
    public static String IMAGE_FOLDER = Constant.DIR+ "/src/test/resources/Image";
    public static String GET_USER_PRODUCT = Constant.URL+"/users/products";
    public static String GET_USER_PRODUCT_INVALID_PATH = Constant.URL+"/usersxxx/products";
    public static String POST_USER_PRODUCT = Constant.URL+"/users/products";
    public static String PUT_USER_PRODUCT = Constant.URL+"/users/products/{id}";
    public static String PUT_USER_PRODUCT_INVALID_PATH = Constant.URL+"/users/producsss/{id}";
    public static String DELETE_USER_PRODUCT = Constant.URL+"/users/products/{id}";
    public static String DELETE_USER_PRODUCT_INVALID_PATH = Constant.URL+"/users/productsss/{id}";

    MiddlemanAPI_Users middlemanAPI_users;

    @Step("Get product user with valid token")
    public void getProductUserWithValidToken() {
        SerenityRest.given()
                .headers("Authorization", TOKEN_ERNAUSER);
    }

    @Step("Get product user with invalid token")
    public void getProductUserWithInvalidToken(){
        SerenityRest.given()
                .headers("Authorization", TOKEN_ERNAUSER);
    }
    @Step("Get product user without token")
    public void getProductUserWithoutToken(){
        SerenityRest.given()
                .headers("Authorization", TOKEN_ERNAUSER);
    }

    @Step("Post product user with valid token")
    public static void postProductUserWithValidToken(File json) {
        JsonPath jsonPath = new JsonPath(json);
        SerenityRest.given()
                .headers("Authorization", TOKEN_ERNAUSER)
                .multiPart("product_image", new File(IMAGE_FOLDER + "/gula_tebu.jpeg"))
                .formParam("product_name",jsonPath.get("product_name").toString())
                .formParam("unit",jsonPath.get("unit").toString())
                .formParam("stock",jsonPath.get("stock").toString())
                .formParam("price",jsonPath.get("price").toString());
    }

    @Step("Post product user with empty token")
    public static void postProductUserWithEmptyToken(File json) {
        JsonPath jsonPath = new JsonPath(json);
        SerenityRest.given()
                .headers("Authorization", TOKEN_ERNAUSER)
                .multiPart("product_image", new File(IMAGE_FOLDER + "gula_tebu.jpeg"))
                .formParam("product_name",jsonPath.get("product_name").toString())
                .formParam("unit",jsonPath.get("unit").toString())
                .formParam("stock",jsonPath.get("stock").toString())
                .formParam("price",jsonPath.get("price").toString());
    }

    @Step("Post product user with invalid token")
    public static void postProductUserWithInvalidToken(File json) {
        JsonPath jsonPath = new JsonPath(json);
        SerenityRest.given()
                .headers("Authorization", TOKEN_ERNAUSER)
                .multiPart("product_image", new File(IMAGE_FOLDER + "/gula_tebu.jpeg"))
                .formParam("product_name",jsonPath.get("product_name").toString())
                .formParam("unit",jsonPath.get("unit").toString())
                .formParam("stock",jsonPath.get("stock").toString())
                .formParam("price",jsonPath.get("price").toString());
    }
    @Step("Put product user with valid token")
    public static void putProductUserWithValidToken(File json, int idProduct) {
        JsonPath jsonPath = new JsonPath(json);
        SerenityRest.given()
                .headers("Authorization", TOKEN_ERNAUSER)
                .pathParam("id", idProduct)
                .multiPart("product_image", new File(IMAGE_FOLDER + "/gula_pasir_bening.jpeg"))
                .formParam("product_name",jsonPath.get("product_name").toString())
                .formParam("unit",jsonPath.get("unit").toString())
                .formParam("stock",jsonPath.get("stock").toString());
//                .formParam("price",jsonPath.get("price").toString());
    }

    @Step("Put product user with invalid token")
    public static void putProductUserWithInvalidToken(File json, int idProduct) {
        JsonPath jsonPath = new JsonPath(json);
        SerenityRest.given()
                .headers("Authorization", TOKEN_ERNAUSER)
                .pathParam("id", idProduct)
                .multiPart("product_image", new File(IMAGE_FOLDER + "/gula_pasir_bening.jpeg"))
                .formParam("product_name",jsonPath.get("product_name").toString())
                .formParam("unit",jsonPath.get("unit").toString())
                .formParam("stock",jsonPath.get("stock").toString())
                .formParam("price",jsonPath.get("price").toString());
    }
    @Step("Delete product user with valid token")
    public void deleteProductUserWithValidToken(int idProduct){
        SerenityRest.given()
                .pathParam("id", idProduct)
                .headers("Authorization", TOKEN_ERNAUSER);
    }

    @Step("Delete product user with invalid token")
    public void deleteProductUserWithInvalidToken(int idProduct){
        SerenityRest.given()
                .pathParam("id", idProduct)
                .headers("Authorization", TOKEN_ERNAUSER);
    }

}
