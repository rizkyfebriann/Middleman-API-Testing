package Middleman.API;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class MiddlemanAPI_InOutBounds {
    public static final String URL = "https://postme.site";
    public static final String DIR = System.getProperty("user.dir");

    public static String TOKEN_RIZKYUSER = "";
    public static String TOKEN_RIZKYUSER1 = "";
    public static String GET_ALL_CART_INOUTBOUNDS = URL+"/inoutbounds";

    public static String GET_ALL_CART_INVALID_INOUTBOUNDS = URL+"/inoutbound";





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
                .headers("Authorization", "Bearer " + );
    }




}
