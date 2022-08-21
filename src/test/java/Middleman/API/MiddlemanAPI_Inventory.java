package Middleman.API;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class MiddlemanAPI_Inventory {

    public static final String URL = "https://postme.site";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE_INVENTORY = DIR+"/src/test/resources/JSONFile/Inventory";

    //public static String IMAGE_FOLDER = DIR + "/src/test/resources/Image";

    public static String TOKEN_RIZKYUSER_INVENTORY = "";
    public static String TOKEN_ADMINS = "";
    public static String POST_CREATE_LIST_USER = URL+"/users/inventory";
    public static String POST_CREATE_LIST_USER_INVALIDPATH = URL+"/users/inventoryyy";
    public static String GET_ALL_PRODUCT_INVENTORY_USER = URL+"/users/inventory";
    public static String GET_ALL_PRODUCT_INVENTORY_USER_INVALIDPATH = URL+"/users/inventoryyy";
    public static String GET_DETAIL_PRODUCT_INVENTORY_USER = URL+"/users/inventory/1660741093";
    public static String GET_DETAIL_PRODUCT_INVENTORY_USERINVALID_ID = URL+"/users/inventory/7699";
    public static String GET_DETAIL_PRODUCT_INVENTORY_USER_INVALIDPATH = URL+"/users/inventoryyy/1660741093";
    public static String POST_CREATE_LIST_ADMINS = URL+"/admins/inventory";
    public static String POST_CREATE_LIST_ADMINS_INVALIDPATH = URL+"/admins/inventoryyy";
    public static String GET_ALL_PRODUCT_INVENTORY_ADMINS = URL+"/admins/inventory";
    public static String GET_ALL_PRODUCT_INVENTORY_ADMINS_INVALIDPATH = URL+"/adminss/inventory";
    public static String GET_DETAIL_PRODUCT_INVENTORY_ADMINS = URL+"/admins/inventory/1660795564";
    public static String GET_DETAIL_PRODUCT_INVENTORY_ADMINS_INVALIDID= URL+"/admins/inventory/ppppp";
    public static String GET_DETAIL_PRODUCT_INVENTORY_ADMINS_INVALIDPATH = URL+"/admins/inventori/1660795564";




    @Step("Post create list product user")
    public static void postCreateListProductUser (File json) {
        SerenityRest.given()
                .header("Authorization", TOKEN_RIZKYUSER_INVENTORY)
                .contentType(ContentType.JSON)
                .body(json);

    }
    @Step("Get all product inventory user")
    public static void getAllProductInventoryUser () {
        SerenityRest.given()
                .header("Authorization", TOKEN_RIZKYUSER_INVENTORY);
    }
    @Step("Get detail product inventory user")
    public static void getDetailProductInventoryUser () {
        SerenityRest.given()
                .header("Authorization", TOKEN_RIZKYUSER_INVENTORY);
    }
    @Step("Post create list product user")
    public static void postCreateListProductAdmins (File json) {
        SerenityRest.given()
                .header("Authorization", TOKEN_ADMINS)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get all product inventory admins")
    public static void getAllProductInventoryAdmins () {
        SerenityRest.given()
                .header("Authorization", TOKEN_ADMINS);
    }
    @Step("Get detail product inventory admins")
    public static void getDetailProductInventoryAdmins () {
        SerenityRest.given()
                .header("Authorization", TOKEN_ADMINS);
    }



//    @Step("Get search product admins")
//    public static void getSearchProductAdmins(String productname) {
//        SerenityRest.given()
//                .queryParam("productname",productname);
//    }
//
//    @Step("Post create product admins")
//    public static void postCreateProductAdmins(File json) {
//        JsonPath jsonPath = new JsonPath(json);
//        SerenityRest.given()
//                .header("Authorization", TOKEN_ADMINS)
//                .multiPart("product_image", new File(IMAGE_FOLDER + "/Beras Jago.jpeg"))
//                .formParam("product_name",jsonPath.get("product_name").toString())
//                .formParam("stock",jsonPath.get("stock").toString())
//                .formParam("unit",jsonPath.get("unit").toString())
//                .formParam("price",jsonPath.get("price").toString());
//    }
//    @Step("Put update product admins")
//    public static void putUpdateProductAdmins(File json) {
//        JsonPath jsonPath = new JsonPath(json);
//        SerenityRest.given()
//                .header("Authorization", TOKEN_ADMINS)
//                .multiPart("product_image", new File(IMAGE_FOLDER + "/beras-koi.jpeg"))
//                .formParam("product_name",jsonPath.get("product_name").toString())
//                .formParam("stock",jsonPath.get("stock").toString())
//                .formParam("unit",jsonPath.get("unit").toString())
//                .formParam("price",jsonPath.get("price").toString());
//    }
//
//    @Step("Put update product admins without product name and stock")
//    public static void putUpdateProductAdminsWithoutNameAndStock(File json) {
//        JsonPath jsonPath = new JsonPath(json);
//        SerenityRest.given()
//                .header("Authorization", TOKEN_ADMINS)
//                .multiPart("product_image", new File(IMAGE_FOLDER + "/beras-koi.jpeg"))
//                .formParam("unit", jsonPath.get("unit").toString())
//                .formParam("price", jsonPath.get("price").toString());
//    }
//    @Step("Put update product admins without unit and price")
//    public static void putUpdateProductAdminsWithoutUnitAndPrice(File json) {
//        JsonPath jsonPath = new JsonPath(json);
//        SerenityRest.given()
//                .header("Authorization", TOKEN_ADMINS)
//                .multiPart("product_image", new File("/Users/nabilahpermata/AUTOMATION_QA5/Testing-API-Capstone/src/test/resources/image/beras-koi.jpeg"))
//                .formParam("product_name",jsonPath.get("product_name").toString())
//                .formParam("stock",jsonPath.get("stock").toString());
//    }
//    @Step("Put update product admins with empty data")
//    public static void putUpdateProductAdminsWithEmptyData(File json) {
//        SerenityRest.given()
//                .header("Authorization", TOKEN_ADMINS);
//    }
//
//    @Step("Delete product admins")
//    public void deleteProductAdmins (int id){
//        SerenityRest.given()
//                .header("Authorization",TOKEN_ADMINS)
//                .pathParam ("id",id);
//    }

}
