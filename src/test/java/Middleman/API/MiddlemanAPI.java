package Middleman.API;

import java.io.File;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class MiddlemanAPI {
    public static final String URL = "https://postme.site";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE_LOGIN = DIR+"/src/test/resources/JSONFile/Login";
    public static final String JSON_FILE_REGISTER = DIR+"/src/test/resources/JSONFile/Register";

    public static final String JSON_FILE_USER = DIR+"/src/test/resources/JSONFile/User";
    public static final String JSON_FILE_USER_PRODUCT = DIR+"/src/test/resources/JSONFile/User_Product";

    public static final String JSON_FILE_ADMINS = DIR+"/src/test/resources/JSONFile/Admins";

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
    public static String GET_USER_PRODUCT = URL+"/users/products";
    public static String GET_USER_PRODUCT_INVALID_PATH = URL+"/usersxxx/products";
    public static String POST_USER_PRODUCT = URL+"/users/products";
    public static String PUT_USER_PRODUCT = URL+"/users/products/{id}";
    public static String PUT_USER_PRODUCT_INVALID_PATH = URL+"/users/producsss/{id}";
    public static String DELETE_USER_PRODUCT = URL+"/users/products/{id}";
    public static String DELETE_USER_PRODUCT_INVALID_PATH = URL+"/users/productsss/{id}";

    //public static final String JSON_FILE_LOGIN_USER2 = DIR+"/src/test/resources/JSONFile/User";

    public static String TOKEN_ADMINS = "";
    public static String TOKEN_ADMINS_INVALID = "";
    public static String GET_ALL_PRODUCT_ADMINS = URL+"/admins";
    public static String GET_INVALIDPATH_ADMINS = URL+"/adminssss";
    public static String POST_CREATE_ADMINS = URL+"/admins";
    public static String PUT_UPDATE_ADMINS = URL+"/admins/6";
    public static String DELETE_PRODUCT_ADMINS = URL+"/admins/{id}";
    public static String DELETE_INVALIDPATH_ADMINS = URL+"/adminss/{id}";

    public static String TOKEN_RIZKYUSER = "";
    public static String TOKEN_RIZKYUSER1 = "";
    public static String GET_ALL_CART_INOUTBOUNDS = URL+"/inoutbounds";

    public static String GET_ALL_CART_INVALID_INOUTBOUNDS = URL+"/inoutbound";

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

    @Step("Get all carts on inoutbounds")
    public static void getAllCartInoutboundsUser() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_RIZKYUSER);
    }

    @Step("Get all carts on inoutbounds")
    public static void getAllCartInoutboundsUser1() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_RIZKYUSER1);
    }

//    @Step("Invalid token admin")
//    public static void invalidTokenAdmins() {
//        SerenityRest.given()
//                .headers("Authorization", "Bearer " + TOKEN_ADMINS_INVALID);
//    }
    @Step("Valid token admin")
    public static void validTokenAdmins() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_ADMINS);
    }

    @Step("Get all product admins")
    public static void getAllProductAdmins(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);

    }
    @Step("Post create product admins")
    public static void postCreateProductAdmins(File json) {
        JsonPath jsonPath = new JsonPath(json);
        SerenityRest.given()
                .header("Authorization", TOKEN_ADMINS)
                .multiPart("product_image", new File("/Users/nabilahpermata/AUTOMATION_QA5/Testing-API-Capstone/src/test/resources/image/Beras Jago.jpeg"))
                .formParam("product_name",jsonPath.get("product_name").toString())
                .formParam("stock",jsonPath.get("stock").toString())
                .formParam("unit",jsonPath.get("unit").toString())
                .formParam("price",jsonPath.get("price").toString());
    }
    @Step("Put update product admins")
    public static void putUpdateProductAdmins(File json) {
        JsonPath jsonPath = new JsonPath(json);
        SerenityRest.given()
                .header("Authorization", TOKEN_ADMINS)
                .multiPart("product_image", new File("/Users/nabilahpermata/AUTOMATION_QA5/Testing-API-Capstone/src/test/resources/image/beras-koi.jpeg"))
                .formParam("product_name",jsonPath.get("product_name").toString())
                .formParam("stock",jsonPath.get("stock").toString())
                .formParam("unit",jsonPath.get("unit").toString())
                .formParam("price",jsonPath.get("price").toString());
    }

    @Step("Put update product admins without product name and stock")
    public static void putUpdateProductAdminsWithoutNameAndStock(File json) {
        JsonPath jsonPath = new JsonPath(json);
        SerenityRest.given()
                .header("Authorization", TOKEN_ADMINS)
                .multiPart("product_image", new File("/Users/nabilahpermata/AUTOMATION_QA5/Testing-API-Capstone/src/test/resources/image/beras-koi.jpeg"))
                .formParam("unit", jsonPath.get("unit").toString())
                .formParam("price", jsonPath.get("price").toString());
    }
    @Step("Put update product admins without unit and price")
    public static void putUpdateProductAdminsWithoutUnitAndPrice(File json) {
        JsonPath jsonPath = new JsonPath(json);
        SerenityRest.given()
                .header("Authorization", TOKEN_ADMINS)
                .multiPart("product_image", new File("/Users/nabilahpermata/AUTOMATION_QA5/Testing-API-Capstone/src/test/resources/image/beras-koi.jpeg"))
                .formParam("product_name",jsonPath.get("product_name").toString())
                .formParam("stock",jsonPath.get("stock").toString());
    }
   @Step("Delete product admins")
   public void deleteProductAdmins (int id){
            SerenityRest.given()
                    .header("Authorization",TOKEN_ADMINS)
                    .pathParam ("id",id);
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
    @Step("Get user without token")
    public void getUserWithoutToken(){
        SerenityRest.given()
                .headers("Authorization","Bearer ");
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
