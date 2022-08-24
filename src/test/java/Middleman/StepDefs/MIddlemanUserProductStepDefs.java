package Middleman.StepDefs;

import Middleman.API.MiddlemanAPI_Admins;
import Middleman.API.MiddlemanAPI_UserProduct;
import Middleman.API.MiddlemanAPI_Users;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class MIddlemanUserProductStepDefs {
    @Steps
    MiddlemanAPI_UserProduct middlemanAPIUserProduct;
    @Given("Set request get product user with valid token")
    public void setRequestGetProductUserWithValidToken() {
        middlemanAPIUserProduct.getProductUserWithValidToken();
    }

    @When("Send request get product user")
    public void sendRequestGetProductUser() {
        SerenityRest.when().get(MiddlemanAPI_UserProduct.GET_USER_PRODUCT);
    }

    @And("Get product user assert json validation")
    public void getProductUserAssertJsonValidation() {
        File jsonFileValidUserValidation = new File(MiddlemanAPI_UserProduct.JSON_FILE_USER_PRODUCT+"/GetProductUserValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFileValidUserValidation));
    }

    @Given("Set request get product user with invalid token")
    public void setRequestGetProductUserWithInvalidToken() {
        middlemanAPIUserProduct.getProductUserWithInvalidToken();
    }

    @Given("Set request get product user with invalid path")
    public void setRequestGetProductUserWithInvalidPath() {
        middlemanAPIUserProduct.getProductUserWithValidToken();
    }

    @When("Send request get product user with invalid path")
    public void sendRequestGetProductUserWithInvalidPath() {
        SerenityRest.when().get(MiddlemanAPI_UserProduct.GET_USER_PRODUCT_INVALID_PATH);
    }

    @Given("Set request get product user without token")
    public void setRequestGetProductUserWithoutToken() {
        middlemanAPIUserProduct.getProductUserWithoutToken();
    }

    @Given("Create product user with valid json file")
    public void createProductUserWithValidJsonFile() {
        File jsonFiles = new File(MiddlemanAPI_UserProduct.JSON_FILE_USER_PRODUCT + "/CreateProductUserWithAllValidData.json");
        middlemanAPIUserProduct.postProductUserWithValidToken(jsonFiles);
    }
    @When("Send request post product user")
    public void sendRequestPostProductUser() {
        SerenityRest.when().post(MiddlemanAPI_UserProduct.POST_USER_PRODUCT);
    }

    @Given("Create product user with all data on empty token")
    public void createProductUserWithAllDataOnEmptyToken() {
        File jsonFiles = new File(MiddlemanAPI_UserProduct.JSON_FILE_USER_PRODUCT + "/CreateProductUserWithAllValidData.json");
        middlemanAPIUserProduct.postProductUserWithEmptyToken(jsonFiles);
    }

    @Given("Create product user with invalid token")
    public void createProductUserWithInvalidToken() {
        File jsonFiles = new File(MiddlemanAPI_UserProduct.JSON_FILE_USER_PRODUCT + "/CreateProductUserWithAllValidData.json");
        middlemanAPIUserProduct.postProductUserWithValidToken(jsonFiles);
    }

    @Given("Create product user with price not valid")
    public void createProductUserWithPriceNotValid() {
        File jsonFiles = new File(MiddlemanAPI_UserProduct.JSON_FILE_USER_PRODUCT + "/CreateProductUserWithPriceNotValid.json");
        middlemanAPIUserProduct.postProductUserWithValidToken(jsonFiles);
    }

    @Given("Create product user with empty price value")
    public void createProductUserWithEmptyPriceValue() {
        File jsonFiles = new File(MiddlemanAPI_UserProduct.JSON_FILE_USER_PRODUCT + "/CreateProductUserWithEmptyPriceValue.json");
        middlemanAPIUserProduct.postProductUserWithValidToken(jsonFiles);
    }

    @Given("Create product user with empty product image")
    public void createProductUserWithEmptyProductImage() {
        File jsonFiles = new File(MiddlemanAPI_UserProduct.JSON_FILE_USER_PRODUCT + "/CreateProductUserWithEmptyProductImage.json");
        middlemanAPIUserProduct.postProductUserWithValidToken(jsonFiles);
    }

    @Given("Update product user with id {int} on valid token")
    public void updateProductUserWithIdOnValidToken(int idProduct) {
        File jsonFiles = new File(MiddlemanAPI_UserProduct.JSON_FILE_USER_PRODUCT + "/UpdateProductUserWithAllValidData.json");
        middlemanAPIUserProduct.putProductUserWithValidToken(jsonFiles, idProduct);
    }

    @When("Send request put product user")
    public void sendRequestPutProductUser() {
        SerenityRest.when().put(MiddlemanAPI_UserProduct.PUT_USER_PRODUCT);
    }

    @Given("Update product user with id {int} on invalid token")
    public void updateProductUserWithIdOnInvalidToken(int idProduct) {
        File jsonFiles = new File(MiddlemanAPI_UserProduct.JSON_FILE_USER_PRODUCT + "/UpdateProductUserWithAllValidData.json");
        middlemanAPIUserProduct.putProductUserWithInvalidToken(jsonFiles, idProduct);
    }

    @Given("Update product user without price on id {int}")
    public void updateProductUserWithoutPriceOnId(int idProduct) {
        File jsonFiles = new File(MiddlemanAPI_UserProduct.JSON_FILE_USER_PRODUCT + "/UpdateProductUserWithoutPrice.json");
        middlemanAPIUserProduct.putUpdateProductUserWithoutPrice(jsonFiles, idProduct);

    }
    @Given("Update product user without image on id {int}")
    public void updateProductUserWithoutImageOnId(int idProduct) {
        File jsonFiles = new File(MiddlemanAPI_UserProduct.JSON_FILE_USER_PRODUCT + "/UpdateProductUserWithoutImage.json");
        middlemanAPIUserProduct.putUpdateProductUserWithoutImage(jsonFiles, idProduct);
    }

    @Given("Update product user with invalid path on id {int}")
    public void updateProductUserWithInvalidPathOnId(int idProduct) {
        File jsonFiles = new File(MiddlemanAPI_UserProduct.JSON_FILE_USER_PRODUCT + "/UpdateProductUserWithAllValidData.json");
        middlemanAPIUserProduct.putProductUserWithValidToken(jsonFiles, idProduct);
    }
    @When("Send request put product user with invalid path")
    public void sendRequestPutProductUserWithInvalidPath() {
        SerenityRest.when().put(MiddlemanAPI_UserProduct.PUT_USER_PRODUCT_INVALID_PATH);
    }

    @Given("Set request delete product user with id {int}")
    public void setRequestDeleteProductUserWithId(int idProduct) {
        middlemanAPIUserProduct.deleteProductUserWithValidToken(idProduct);
    }

    @When("Send request delete product user")
    public void sendRequestDeleteProductUser() {
        SerenityRest.when().delete(MiddlemanAPI_UserProduct.DELETE_USER_PRODUCT);
    }

    @Given("Set request delete product user with invalid path")
    public void setRequestDeleteProductUserWithInvalidPath(int idProduct) {
        middlemanAPIUserProduct.deleteProductUserWithValidToken(idProduct);
    }

    @Given("Set request delete product user with id {int} on invalid token")
    public void setRequestDeleteProductUserWithIdOnInvalidToken(int idProduct) {
        middlemanAPIUserProduct.deleteProductUserWithInvalidToken(idProduct);
    }

    @Given("Set request delete product user id {int} with invalid path")
    public void setRequestDeleteProductUserIdWithInvalidPath(int idProduct) {
        middlemanAPIUserProduct.deleteProductUserWithValidToken(idProduct);
    }

    @When("Send request delete product user with invalid path")
    public void sendRequestDeleteProductUserWithInvalidPath() {
        SerenityRest.when().delete(MiddlemanAPI_UserProduct.DELETE_USER_PRODUCT_INVALID_PATH);
    }

    @Given("Get search product user with valid parameter name {string}")
    public void getSearchProductUserWithValidParameterName(String productname) {
        middlemanAPIUserProduct.getSearchProductUser(productname);
    }

    @Given("Get search product user with two alphabet contains from product name {string}")
    public void searchProductWithTwoAlphabets(String productName) {
        getSearchProductUserWithValidParameterName(productName);
    }

    @When("Send request get search product user")
    public void sendRequestGetSearchProductUser() {
        SerenityRest.when().get(MiddlemanAPI_UserProduct.GET_SEARCH_PRODUCT_USER);
    }
    @And("Get all search product user assert json validation")
    public void getAllSearchProductUserAssertJsonValidation() {
        File jsonFile = new File(MiddlemanAPI_UserProduct.JSON_FILE_USER_PRODUCT+"/GetSearchProductUserValidProductNameValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

//    @Given("Get search product user with two alphabet contains from product name {string}")
//    public void getSearchProductUserWithTwoAlphabetContainsFromProductName(String productname) {
//        middlemanAPIUserProduct.getSearchProductUser(productname);
//    }
//    @Given("Get search product user with keyword numeric {string}")
//    public void getSearchProductUserWithKeywordNumeric(String productName) {
//        middlemanAPIUserProduct.getSearchProductUser(productName);
//    }
//
//    @Given("Get search product user with special chart {string}")
//    public void getSearchProductUserWithSpecialChart(String productName) {
//        middlemanAPIUserProduct.getSearchProductUser(productName);
//    }
//
//    @Given("Get search product user with combination of alphanumeric character {string}")
//    public void getSearchProductUserWithCombinationOfAlphanumericCharacter(String productName) {
//        middlemanAPIUserProduct.getSearchProductUser(productName);
//    }
//
//    @Given("Get search product user with empty value param {string}")
//    public void getSearchProductUserWithEmptyValueParam(String productName) {
//        middlemanAPIUserProduct.getSearchProductUser(productName);
//    }
//
//    @Given("Get search product user with id {string} on invalid path")
//    public void getSearchProductUserWithIdOnInvalidPath(String productName) {
//        middlemanAPIUserProduct.getSearchProductUser(productName);
//    }

    @When("Send request get search product user with invalid path")
    public void sendRequestGetSearchProductUserWithInvalidPath() {
        SerenityRest.when().get(MiddlemanAPI_UserProduct.GET_SEARCH_PRODUCT_USER_INVALID_PATH);

    }

    @Given("Update product user with price not valid on id {int}")
    public void updateProductUserWithPriceNotValidOnId(int price) {
        File jsonFiles = new File(MiddlemanAPI_UserProduct.JSON_FILE_USER_PRODUCT + "/UpdateProductUserWithPriceNotValid.json");
        middlemanAPIUserProduct.putProductUserWithValidToken(jsonFiles, price);
    }

//    @Given("Update product user with price not valid on id {int}")
//    public void updateProductUserWithPriceNotValidOnId(int idProduct) {
//        File jsonFiles = new File(MiddlemanAPI.JSON_FILE_USER_PRODUCT + "/UpdateProductUserWithPriceNotValid.json");
//        middlemanAPI.putProductUserWithValidToken(jsonFiles, idProduct);
//
//    }
}
