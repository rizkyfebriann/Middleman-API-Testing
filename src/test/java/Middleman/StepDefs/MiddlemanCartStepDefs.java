package Middleman.StepDefs;

import Middleman.API.MiddlemanAPI_Cart;
import Middleman.API.MiddlemanAPI_InOutBounds;
import Middleman.API.MiddlemanAPI_Users;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class MiddlemanCartStepDefs {
    @Steps
    MiddlemanAPI_Cart middlemanAPI_cart;

    @Given("User create new product to cart with valid product id")
    public void userCreateNewProductToCartWithValidProductId() {
        File jsonFilesCreateCart = new File( MiddlemanAPI_Cart.JSON_FILE_CART+"/CreateProductToCartWithValidID.json");
        middlemanAPI_cart.CreateProductToCartWithAuthorizedUser(jsonFilesCreateCart);
    }
    @When("Send request create product to the cart")
    public void sendRequestCreateProductToTheCart() {
        SerenityRest.when().post(MiddlemanAPI_Cart.CREATE_CART);
    }

    @Given("User create new product to cart with invalid product id")
    public void userCreateNewProductToCartWithInvalidProductId() {
        File jsonFilesCreateCart = new File( MiddlemanAPI_Cart.JSON_FILE_CART+"/CreateProductToCartWithInvalidID.json");
        middlemanAPI_cart.CreateProductToCartWithAuthorizedUser(jsonFilesCreateCart);
    }

    @Given("Create new product to cart without any unauthorized user")
    public void createNewProductToCartWithoutAnyUnauthorizedUser() {
        File jsonFilesCreateCart = new File( MiddlemanAPI_Cart.JSON_FILE_CART+"/CreateProductToCartWithValidID.json");
        middlemanAPI_cart.CreateProductToCartWithAuthorizedUser(jsonFilesCreateCart);
    }

    @Given("Create new product to cart with valid id and qty exceeds stock product")
    public void createNewProductToCartWithValidIdAndQtyExceedsStockProduct() {
        File jsonFilesCreateCart = new File( MiddlemanAPI_Cart.JSON_FILE_CART+"/CreateToCartWithQty>Stock.json");
        middlemanAPI_cart.CreateProductToCartWithAuthorizedUser(jsonFilesCreateCart);
    }

    @Given("Create new product to cart with valid id and multiple qty")
    public void createNewProductToCartWithValidIdAndMultipleQty() {
        File jsonFilesCreateCart = new File( MiddlemanAPI_Cart.JSON_FILE_CART+"/CreateToCartWithMultipleQty.json");
        middlemanAPI_cart.CreateProductToCartWithAuthorizedUser(jsonFilesCreateCart);
    }

    @Given("Create new product to cart with empty qty")
    public void createNewProductToCartWithEmptyQty() {
        File jsonFilesCreateCart = new File( MiddlemanAPI_Cart.JSON_FILE_CART+"/CreateToCartWithEmptyQty.json");
        middlemanAPI_cart.CreateProductToCartWithAuthorizedUser(jsonFilesCreateCart);
    }

    @Given("Create new product to cart without qty")
    public void createNewProductToCartWithoutQty() {
        File jsonFilesCreateCart = new File( MiddlemanAPI_Cart.JSON_FILE_CART+"/CreateToCartWithoutQty.json");
        middlemanAPI_cart.CreateProductToCartWithAuthorizedUser(jsonFilesCreateCart);
    }

    @Given("Create new product to cart with invalid path")
    public void createNewProductToCartWithInvalidPath() {
        File jsonFilesCreateCart = new File( MiddlemanAPI_Cart.JSON_FILE_CART+"/CreateProductToCartWithValidID.json");
        middlemanAPI_cart.CreateProductToCartWithAuthorizedUser(jsonFilesCreateCart);
    }

    @When("Send request create product to the cart with invalid path")
    public void sendRequestCreateProductToTheCartWithInvalidPath() {
        SerenityRest.when().post(MiddlemanAPI_Cart.CREATE_CART_INVALID_PATH);
    }
///get all cart
    @Given("Set request get all cart with authorized user")
    public void setRequestGetAllCartWithAuthorizedUser() {
        middlemanAPI_cart.getAllProductToCart();
    }
    @When("Send request get all cart")
    public void sendRequestGetAllCart() {
        SerenityRest.when().get(MiddlemanAPI_Cart.GET_CART);
    }
    @And("Get all cart assert json validation")
    public void getAllCartAssertJsonValidation() {
        File jsonFileCartValidation = new File(MiddlemanAPI_Cart.JSON_FILE_CART+"/GetAllCartValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFileCartValidation));

    }
    @Given("Set request get all cart with unauthorized user")
    public void setRequestGetAllCartWithUnauthorizedUser() {
        middlemanAPI_cart.getAllProductToCart();
    }

    @Given("Set request get all cart with invalid path")
    public void setRequestGetAllCartWithInvalidPath() {
        middlemanAPI_cart.getAllProductToCart();
    }

    @When("Send request get all cart with invalid path")
    public void sendRequestGetAllCartWithInvalidPath() {
        SerenityRest.when().get(MiddlemanAPI_Cart.GET_CART_INVALID_PATH);
    }

    @Given("Update qty in cart with product id {string}")
    public void updateQtyInCartWithProductId(String idProduct) {
        File jsonFilesUpdateCart = new File( MiddlemanAPI_Cart.JSON_FILE_CART+"/UpdateQtyProductOnCart.json");
        middlemanAPI_cart.updateQtyProductOnCart(jsonFilesUpdateCart, idProduct);

    }
    @When("Send request update qty product added on cart")
    public void sendRequestUpdateQtyProductAddedOnCart() {
        SerenityRest.when().put(MiddlemanAPI_Cart.UPDATE_CART);
    }

    @Given("Update qty in cart with invalid product id {string}")
    public void updateQtyInCartWithInvalidProductId(String idProduct) {
        File jsonFilesUpdateCart = new File( MiddlemanAPI_Cart.JSON_FILE_CART+"/UpdateQtyProductOnCart.json");
        middlemanAPI_cart.updateQtyProductOnCart(jsonFilesUpdateCart, idProduct);
    }

    @Given("Update qty in cart without product id {string}")
    public void updateQtyInCartWithoutProductId(String idProduct) {
        File jsonFilesUpdateCart = new File( MiddlemanAPI_Cart.JSON_FILE_CART+"/UpdateQtyProductOnCart.json");
        middlemanAPI_cart.updateQtyProductOnCart(jsonFilesUpdateCart, idProduct);
    }

    @Given("Update product id {string} in cart with empty qty")
    public void updateProductIdInCartWithEmptyQty(String idProduct) {
        File jsonFilesUpdateCart = new File( MiddlemanAPI_Cart.JSON_FILE_CART+"/UpdateProductInCartWithEmptyQty.json");
        middlemanAPI_cart.updateQtyProductOnCart(jsonFilesUpdateCart, idProduct);
    }

    @Then("API response status code should be {int} method not allowed")
    public void apiResponseStatusCodeShouldBeMethodNotAllowed(int not_found) {
        SerenityRest.then().statusCode(not_found);
    }

    @Given("Set request Delete qty in cart with product id {string}")
    public void setRequestDeleteQtyInCartWithProductId(String idProduct) {
        middlemanAPI_cart.deleteProductOnCart(idProduct);
    }

    @When("Send request delete product on cart")
    public void sendRequestDeleteProductOnCart() {
        SerenityRest.when().delete(MiddlemanAPI_Cart.DELETE_PRODUCT_CART);
    }
    @Given("Delete qty in cart with product id {string} on invalid path")
    public void deleteQtyInCartWithProductIdOnInvalidPath(String idProduct) {
        middlemanAPI_cart.deleteProductOnCart(idProduct);
    }

    @When("Send request delete product on cart with invalid path")
    public void sendRequestDeleteProductOnCartWithInvalidPath() {
        SerenityRest.when().delete(MiddlemanAPI_Cart.DELETE_PRODUCT_CART_IVALID_PATH);
    }
}
