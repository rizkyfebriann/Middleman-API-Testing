package Middleman.API;

import Middleman.Constant;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class MiddlemanAPI_Cart {
    public static final String JSON_FILE_CART = Constant.DIR + "/src/test/resources/JSONFile/Cart";
    public static String TOKEN_ERNAUSER = "";
    public static String CREATE_CART = Constant.URL+"/carts";
    public static String CREATE_CART_INVALID_PATH = Constant.URL+"/cartsss";

    public static String GET_CART = Constant.URL+"/carts";
    public static String GET_CART_INVALID_PATH = Constant.URL+"/cartsss";
    public static String UPDATE_CART = Constant.URL+"/carts/{id}";

    public static String DELETE_PRODUCT_CART = Constant.URL+"/carts/{id}";
    public static String DELETE_PRODUCT_CART_IVALID_PATH = Constant.URL+"/cartss/{id}";

    @Step("Create product to the cart with authorized user")
    public void CreateProductToCartWithAuthorizedUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .headers("Authorization", TOKEN_ERNAUSER);
    }

    @Step("Get all cart with authorized user")
    public void getAllProductToCart(){
        SerenityRest.given()
                .headers("Authorization", TOKEN_ERNAUSER);
    }

    @Step("Update qty product added on Cart")
    public void updateQtyProductOnCart(File json, String id){
        SerenityRest.given()
                .headers("Authorization", TOKEN_ERNAUSER)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete product on cart with authorized user")
    public void deleteProductOnCart(String id){
        SerenityRest.given()
                .headers("Authorization", TOKEN_ERNAUSER)
                .pathParam("id", id);
    }

}
