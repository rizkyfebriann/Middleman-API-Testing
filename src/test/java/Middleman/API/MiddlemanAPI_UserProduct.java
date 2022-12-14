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

    public static final String INVALID_TOKEN = "Bearer invalid1234567io";
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

    public static String GET_SEARCH_PRODUCT_USER = Constant.URL+"/users/products/search?productname=";
    public static String GET_SEARCH_PRODUCT_USER_INVALID_PATH = Constant.URL+"/users/productsss/search?productname=";
    public static String GET_SEARCH_PRODUCT_USER_TWO_ALPHABET = Constant.URL+"/users/products/search?productname=gula";
//    public static String GET_SEARCH_PRODUCT_USER_WITH_NUMERIC = Constant.URL+"/users/products/search?productname=12";
//    public static String GET_SEARCH_PRODUCT_USER_SPECIAL_CHART = Constant.URL+"/users/products/search?productname=@";
//    public static String GET_SEARCH_PRODUCT_USER_COMBINATION = Constant.URL+"/users/products/search?productname=gula1";




    @Step("Get product user with valid token")
    public void getProductUserWithValidToken() {
        SerenityRest.given()
                .headers("Authorization", TOKEN_ERNAUSER);
    }

    @Step("Get product user with invalid token")
    public void getProductUserWithInvalidToken(){
        SerenityRest.given()
                .headers("Authorization", "Bearer" + "invalid1234567io");
    }
    @Step("Get product user without token")
    public void getProductUserWithoutToken(){
        SerenityRest.given()
                .headers("Authorization", "");
    }

    @Step("Get search product user")
    public static void getSearchProductUser(String productname) {
        SerenityRest.given()
                .headers("Authorization", TOKEN_ERNAUSER)
                .queryParam("productname",productname);
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

    @Step("Post product user with invalid token")
    public static void postProductUserWithInvalidToken(File json) {
        JsonPath jsonPath = new JsonPath(json);
        SerenityRest.given()
                .headers("Authorization", INVALID_TOKEN)
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
//                .headers("Authorization", TOKEN_ERNAUSER)
                .multiPart("product_image", new File(IMAGE_FOLDER + "/gula_tebu.jpeg"))
                .formParam("product_name",jsonPath.get("product_name").toString())
                .formParam("unit",jsonPath.get("unit").toString())
                .formParam("stock",jsonPath.get("stock").toString())
                .formParam("price",jsonPath.get("price").toString());
    }

//    @Step("Post product user with invalid token")
//    public static void postProductUserWithInvalidToken(File json) {
//        JsonPath jsonPath = new JsonPath(json);
//        SerenityRest.given()
//                .headers("Authorization", TOKEN_ERNAUSER)
//                .multiPart("product_image", new File(IMAGE_FOLDER + "/gula_tebu.jpeg"))
//                .formParam("product_name",jsonPath.get("product_name").toString())
//                .formParam("unit",jsonPath.get("unit").toString())
//                .formParam("stock",jsonPath.get("stock").toString())
//                .formParam("price",jsonPath.get("price").toString());
//    }
    @Step("Put product user with valid token")
    public static void putProductUserWithValidToken(File json, int idProduct) {
        JsonPath jsonPath = new JsonPath(json);
        SerenityRest.given()
                .headers("Authorization", TOKEN_ERNAUSER)
                .pathParam("id", idProduct)
                .multiPart("product_image", new File(IMAGE_FOLDER + "/gula_tebu.jpeg"))
                .formParam("product_name",jsonPath.get("product_name").toString())
                .formParam("unit",jsonPath.get("unit").toString())
                .formParam("stock",jsonPath.get("stock").toString())
                .formParam("price",jsonPath.get("price").toString());
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
                .headers("Authorization", INVALID_TOKEN);
    }


    @Step("Put update product user without price")
    public static void putUpdateProductUserWithoutPrice(File json, int id) {
        JsonPath jsonPath = new JsonPath(json);
        SerenityRest.given()
                .pathParam("id", id)
                .header("Authorization", TOKEN_ERNAUSER)
                .multiPart("product_image", new File(IMAGE_FOLDER + "/gula_pasir.jpeg"))
                .formParam("product_name",jsonPath.get("product_name").toString())
                .formParam("unit", jsonPath.get("unit").toString())
                .formParam("stock",jsonPath.get("stock").toString())
                .formParam("price", jsonPath.get("price").toString())
        ;
    }
    @Step("Put update product user without image")
    public static void putUpdateProductUserWithoutImage(File json, int id) {
        JsonPath jsonPath = new JsonPath(json);
        SerenityRest.given()
                .pathParam("id", id)
                .header("Authorization", TOKEN_ERNAUSER)
                .multiPart("product_image", new File(IMAGE_FOLDER + "/gula_pasir.jpeg"))
                .formParam("product_name",jsonPath.get("product_name").toString())
                .formParam("unit", jsonPath.get("unit").toString())
                .formParam("stock",jsonPath.get("stock").toString())
                .formParam("price", jsonPath.get("price").toString())
        ;
    }

}
