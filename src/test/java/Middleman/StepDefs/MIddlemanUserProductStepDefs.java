package Middleman.StepDefs;

import Middleman.API.MiddlemanAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class MIddlemanUserProductStepDefs {
    @Steps
    MiddlemanAPI middlemanAPI;
    @Given("Set request get product user with valid token")
    public void setRequestGetProductUserWithValidToken() {
        middlemanAPI.getProductUserWithValidToken();
    }

    @When("Send request get product user")
    public void sendRequestGetProductUser() {
        SerenityRest.when().get(MiddlemanAPI.GET_USER_PRODUCT);
    }

    @And("Get product user assert json validation")
    public void getProductUserAssertJsonValidation() {
        File jsonFileValidUserValidation = new File(MiddlemanAPI.JSON_FILE_USER_PRODUCT+"/GetProductUserValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFileValidUserValidation));
    }

    @Given("Set request get product user with invalid token")
    public void setRequestGetProductUserWithInvalidToken() {
        middlemanAPI.getProductUserWithInvalidToken();
    }

    @Given("Set request get product user with invalid path")
    public void setRequestGetProductUserWithInvalidPath() {
        middlemanAPI.getProductUserWithValidToken();
    }

    @When("Send request get product user with invalid path")
    public void sendRequestGetProductUserWithInvalidPath() {
        SerenityRest.when().get(MiddlemanAPI.GET_USER_PRODUCT_INVALID_PATH);
    }

    @Given("Set request get product user without token")
    public void setRequestGetProductUserWithoutToken() {
        middlemanAPI.getProductUserWithoutToken();
    }

    @Given("Create product user with valid json file")
    public void createProductUserWithValidJsonFile() {
        File jsonFiles = new File(MiddlemanAPI.JSON_FILE_USER_PRODUCT + "/CreateProductUserWithAllValidData.json");
        middlemanAPI.postProductUserWithValidToken(jsonFiles);
    }
    @When("Send request post product user")
    public void sendRequestPostProductUser() {
        SerenityRest.when().post(MiddlemanAPI.POST_USER_PRODUCT);
    }

    @Given("Create product user with all data on empty token")
    public void createProductUserWithAllDataOnEmptyToken() {
        File jsonFiles = new File(MiddlemanAPI.JSON_FILE_USER_PRODUCT + "/CreateProductUserWithAllValidData.json");
        middlemanAPI.postProductUserWithEmptyToken(jsonFiles);
    }

    @Given("Create product user with invalid token")
    public void createProductUserWithInvalidToken() {
        File jsonFiles = new File(MiddlemanAPI.JSON_FILE_USER_PRODUCT + "/CreateProductUserWithAllValidData.json");
        middlemanAPI.postProductUserWithInvalidToken(jsonFiles);
    }

    @Given("Create product user with price not valid")
    public void createProductUserWithPriceNotValid() {
        File jsonFiles = new File(MiddlemanAPI.JSON_FILE_USER_PRODUCT + "/CreateProductUserWithPriceNotValid.json");
        middlemanAPI.postProductUserWithValidToken(jsonFiles);
    }

    @Given("Create product user with empty price value")
    public void createProductUserWithEmptyPriceValue() {
        File jsonFiles = new File(MiddlemanAPI.JSON_FILE_USER_PRODUCT + "/CreateProductUserWithEmptyPriceValue.json");
        middlemanAPI.postProductUserWithValidToken(jsonFiles);
    }

    @Given("Create product user with empty product image")
    public void createProductUserWithEmptyProductImage() {
        File jsonFiles = new File(MiddlemanAPI.JSON_FILE_USER_PRODUCT + "/CreateProductUserWithEmptyProductImage.json");
        middlemanAPI.postProductUserWithValidToken(jsonFiles);
    }

    @Given("Update product user with id {int} on valid token")
    public void updateProductUserWithIdOnValidToken(int idProduct) {
        File jsonFiles = new File(MiddlemanAPI.JSON_FILE_USER_PRODUCT + "/UpdateProductUserWithAllValidData.json");
        middlemanAPI.putProductUserWithValidToken(jsonFiles, idProduct);
    }

    @When("Send request put product user")
    public void sendRequestPutProductUser() {
        SerenityRest.when().put(MiddlemanAPI.PUT_USER_PRODUCT);
    }

    @Given("Update product user with id {int} on invalid token")
    public void updateProductUserWithIdOnInvalidToken(int idProduct) {
        File jsonFiles = new File(MiddlemanAPI.JSON_FILE_USER_PRODUCT + "/UpdateProductUserWithAllValidData.json");
        middlemanAPI.putProductUserWithInvalidToken(jsonFiles, idProduct);
    }

    @Given("Update product user without price on id {int}")
    public void updateProductUserWithoutPriceOnId(int idProduct) {
        File jsonFiles = new File(MiddlemanAPI.JSON_FILE_USER_PRODUCT + "/UpdateProductUserWithoutPrice.json");
        middlemanAPI.putProductUserWithValidToken(jsonFiles, idProduct);

    }
    @Given("Update product user without image on id {int}")
    public void updateProductUserWithoutImageOnId(int idProduct) {
        File jsonFiles = new File(MiddlemanAPI.JSON_FILE_USER_PRODUCT + "/UpdateProductUserWithoutImage.json");
        middlemanAPI.putProductUserWithValidToken(jsonFiles, idProduct);
    }

    @Given("Update product user with invalid path on id {int}")
    public void updateProductUserWithInvalidPathOnId(int idProduct) {
        File jsonFiles = new File(MiddlemanAPI.JSON_FILE_USER_PRODUCT + "/UpdateProductUserWithAllValidData.json");
        middlemanAPI.putProductUserWithValidToken(jsonFiles, idProduct);
    }
    @When("Send request put product user with invalid path")
    public void sendRequestPutProductUserWithInvalidPath() {
        SerenityRest.when().put(MiddlemanAPI.PUT_USER_PRODUCT_INVALID_PATH);
    }

    @Given("Set request delete product user with id {int}")
    public void setRequestDeleteProductUserWithId(int idProduct) {
        middlemanAPI.deleteProductUserWithValidToken(idProduct);
    }

    @When("Send request delete product user")
    public void sendRequestDeleteProductUser() {
        SerenityRest.when().delete(MiddlemanAPI.DELETE_USER_PRODUCT);
    }

    @Given("Set request delete product user with invalid path")
    public void setRequestDeleteProductUserWithInvalidPath(int idProduct) {
        middlemanAPI.deleteProductUserWithValidToken(idProduct);
    }

    @Given("Set request delete product user with id {int} on invalid token")
    public void setRequestDeleteProductUserWithIdOnInvalidToken(int idProduct) {
        middlemanAPI.deleteProductUserWithInvalidToken(idProduct);
    }

    @Given("Set request delete product user id {int} with invalid path")
    public void setRequestDeleteProductUserIdWithInvalidPath(int idProduct) {
        middlemanAPI.deleteProductUserWithValidToken(idProduct);
    }

    @When("Send request delete product user with invalid path")
    public void sendRequestDeleteProductUserWithInvalidPath() {
        SerenityRest.when().delete(MiddlemanAPI.DELETE_USER_PRODUCT_INVALID_PATH);
    }

//    @Given("Update product user with price not valid on id {int}")
//    public void updateProductUserWithPriceNotValidOnId(int idProduct) {
//        File jsonFiles = new File(MiddlemanAPI.JSON_FILE_USER_PRODUCT + "/UpdateProductUserWithPriceNotValid.json");
//        middlemanAPI.putProductUserWithValidToken(jsonFiles, idProduct);
//
//    }
}
