package Middleman.API;

import java.io.File;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class MiddlemanAPI_UserProduct {

    public static final String URL = "https://postme.site";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE_USER_PRODUCT = DIR+"/src/test/resources/JSONFile/User_Product";

    public static String GET_USER_PRODUCT = URL+"/users/products";
    public static String GET_USER_PRODUCT_INVALID_PATH = URL+"/usersxxx/products";
    public static String POST_USER_PRODUCT = URL+"/users/products";
    public static String PUT_USER_PRODUCT = URL+"/users/products/{id}";
    public static String PUT_USER_PRODUCT_INVALID_PATH = URL+"/users/producsss/{id}";
    public static String DELETE_USER_PRODUCT = URL+"/users/products/{id}";
    public static String DELETE_USER_PRODUCT_INVALID_PATH = URL+"/users/productsss/{id}";

    @Step("Get product user with valid token")
    public void getProductUserWithValidToken(){
        SerenityRest.given()
                .headers("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6NTgsIlJvbGUiOiJ1c2VyIiwiZXhwIjoxNjYwNTQ5MjU5fQ.6314U0ewoKOTVdfLxDJejY5SbINC9RNihRoKqB0II1A");
    }
    @Step("Get product user with invalid token")
    public void getProductUserWithInvalidToken(){
        SerenityRest.given()
                .headers("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6MjAsIlJvbGUiOiJ1c2VyIiwiZXhwIjoxNjYwMjUyNjg3fQ.aw_gkc1CV24ekogKQJ6029ALVtOjF8IJUMVDlZyzxiMxxx");
    }
    @Step("Get product user without token")
    public void getProductUserWithoutToken(){
        SerenityRest.given()
                .headers("Authorization","Bearer ");
    }

    @Step("Post product user with valid token")
    public static void postProductUserWithValidToken(File json) {
        JsonPath jsonPath = new JsonPath(json);
        SerenityRest.given()
                .headers("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6NTgsIlJvbGUiOiJ1c2VyIiwiZXhwIjoxNjYwNTQ5MjU5fQ.6314U0ewoKOTVdfLxDJejY5SbINC9RNihRoKqB0II1A")
                .multiPart("product_image", new File("/Users/caraerna/projects/Testing-API-Capstone/src/test/resources/image/gula_pasir.jpeg"))
                .formParam("product_name",jsonPath.get("product_name").toString())
                .formParam("unit",jsonPath.get("unit").toString())
                .formParam("stock",jsonPath.get("stock").toString())
                .formParam("price",jsonPath.get("price").toString());
    }

    @Step("Post product user with empty token")
    public static void postProductUserWithEmptyToken(File json) {
        JsonPath jsonPath = new JsonPath(json);
        SerenityRest.given()
                .headers("Authorization","Bearer ")
                .multiPart("product_image", new File("/Users/caraerna/projects/Testing-API-Capstone/src/test/resources/image/gula_pasir.jpeg"))
                .formParam("product_name",jsonPath.get("product_name").toString())
                .formParam("unit",jsonPath.get("unit").toString())
                .formParam("stock",jsonPath.get("stock").toString())
                .formParam("price",jsonPath.get("price").toString());
    }

    @Step("Post product user with invalid token")
    public static void postProductUserWithInvalidToken(File json) {
        JsonPath jsonPath = new JsonPath(json);
        SerenityRest.given()
                .headers("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6MTgsIlJvbGUiOiJ1c2VyIiwiZXhwIjoxNjYwMjQ4NDkxfQ.xID84sw3_zdnB3wxXkfjN3BumuwT-5hA4Zn_M7EW8ewXXXX")
                .multiPart("product_image", new File("/Users/caraerna/projects/Testing-API-Capstone/src/test/resources/image/gula_pasir.jpeg"))
                .formParam("product_name",jsonPath.get("product_name").toString())
                .formParam("unit",jsonPath.get("unit").toString())
                .formParam("stock",jsonPath.get("stock").toString())
                .formParam("price",jsonPath.get("price").toString());
    }
    @Step("Put product user with valid token")
    public static void putProductUserWithValidToken(File json, int idProduct) {
        JsonPath jsonPath = new JsonPath(json);
        SerenityRest.given()
                .headers("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6NTgsIlJvbGUiOiJ1c2VyIiwiZXhwIjoxNjYwNTQ5MjU5fQ.6314U0ewoKOTVdfLxDJejY5SbINC9RNihRoKqB0II1A")
                .pathParam("id", idProduct)
                .multiPart("product_image", new File("/Users/caraerna/projects/Testing-API-Capstone/src/test/resources/image/gula_pasir.jpeg"))
                .formParam("product_name",jsonPath.get("product_name").toString())
                .formParam("unit",jsonPath.get("unit").toString())
                .formParam("stock",jsonPath.get("stock").toString());
//                .formParam("price",jsonPath.get("price").toString());
    }

    @Step("Put product user with invalid token")
    public static void putProductUserWithInvalidToken(File json, int idProduct) {
        JsonPath jsonPath = new JsonPath(json);
        SerenityRest.given()
                .headers("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6NTgsIlJvbGUiOiJ1c2VyIiwiZXhwIjoxNjYwNTQ5MjU5fQ.6314U0ewoKOTVdfLxDJejY5SbINC9RNihRoKqB0II1AXXX")
                .pathParam("id", idProduct)
                .multiPart("product_image", new File("/Users/caraerna/projects/Testing-API-Capstone/src/test/resources/image/gula_pasir.jpeg"))
                .formParam("product_name",jsonPath.get("product_name").toString())
                .formParam("unit",jsonPath.get("unit").toString())
                .formParam("stock",jsonPath.get("stock").toString())
                .formParam("price",jsonPath.get("price").toString());
    }
    @Step("Delete product user with valid token")
    public void deleteProductUserWithValidToken(int idProduct){
        SerenityRest.given()
                .pathParam("id", idProduct)
                .headers("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6NTgsIlJvbGUiOiJ1c2VyIiwiZXhwIjoxNjYwNTcxNTM2fQ.pXZ1kvdsNwGo4esPSnG-2EaeRrFg4ZBP-IykVgwWmFU");
    }

    @Step("Delete product user with invalid token")
    public void deleteProductUserWithInvalidToken(int idProduct){
        SerenityRest.given()
                .pathParam("id", idProduct)
                .headers("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6NTgsIlJvbGUiOiJ1c2VyIiwiZXhwIjoxNjYwNTcxNTM2fQ.pXZ1kvdsNwGo4esPSnG-2EaeRrFg4ZBP-IykVgwWmFUXXX");
    }

}
