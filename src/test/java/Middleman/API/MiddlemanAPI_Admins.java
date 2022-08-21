package Middleman.API;

import java.io.File;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class MiddlemanAPI_Admins {

    public static final String URL = "https://postme.site";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE_ADMINS = DIR+"/src/test/resources/JSONFile/Admins";

    public static String IMAGE_FOLDER = DIR + "/src/test/resources/Image";

    public static String TOKEN_ADMINS = "";
    public static String GET_ALL_PRODUCT_ADMINS = URL+"/admins/products";
    public static String GET_INVALIDPATH_ADMINS = URL+"/adminssss/products";
    public static String POST_CREATE_ADMINS = URL+"/admins/products";
    public static String PUT_UPDATE_ADMINS = URL+"/admins/products/6";
    public static String DELETE_PRODUCT_ADMINS = URL+"/admins/products/{id}";
    public static String DELETE_INVALIDPATH_ADMINS = URL+"/adminss/products/{id}";
    public static String GET_SEARCH_PRODUCT_ADMINS_VALIDNAME = URL+"/admins/products/search?productname=tepung";
    public static String GET_SEARCH_PRODUCT_ADMINS_ONEKEYWORD = URL+"/admins/products/search?productname=b";
    public static String GET_SEARCH_PRODUCT_ADMINS_TWOKEYWORD = URL+"/admins/products/search?productname=tt";
    public static String GET_SEARCH_PRODUCT_ADMINS_INVALIDKEYWORD = URL+"/admins/products/search?productname=XXXXXX";
    public static String GET_SEARCH_PRODUCT_ADMINS_INVALIDPATH = URL+"/admins/productssss/search?productname=tepung";

    @Step("Get all product admins")
    public static void getAllProductAdmins(String path) {
        SerenityRest.given()
                .queryParam("path",path);

    }
    @Step("Get search product admins")
    public static void getSearchProductAdmins(String productname) {
        SerenityRest.given()
                .queryParam("productname",productname);
    }

    @Step("Post create product admins")
    public static void postCreateProductAdmins(File json) {
        JsonPath jsonPath = new JsonPath(json);
        SerenityRest.given()
                .header("Authorization", TOKEN_ADMINS)
                .multiPart("product_image", new File(IMAGE_FOLDER + "/Beras Jago.jpeg"))
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
                .multiPart("product_image", new File(IMAGE_FOLDER + "/beras-koi.jpeg"))
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
                .multiPart("product_image", new File(IMAGE_FOLDER + "/beras-koi.jpeg"))
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
    @Step("Put update product admins with empty data")
    public static void putUpdateProductAdminsWithEmptyData(File json) {
        SerenityRest.given()
                .header("Authorization", TOKEN_ADMINS);
    }

    @Step("Delete product admins")
    public void deleteProductAdmins (int id){
        SerenityRest.given()
                .header("Authorization",TOKEN_ADMINS)
                .pathParam ("id",id);
    }

}
