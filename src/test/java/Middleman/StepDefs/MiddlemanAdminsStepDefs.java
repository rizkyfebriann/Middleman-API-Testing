package Middleman.StepDefs;

import Middleman.API.MiddlemanAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class MiddlemanAdminsStepDefs {
    @Steps
    MiddlemanAPI middlemanAPI;


//    @Given("Authorization bearer token")
//    public void authorizationBearerToken() {
//       MiddlemanAPI.TOKEN_ADMINS = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6MTAsIlJvbGUiOiJhZG1pbiIsImV4cCI6MTY2MDQ3NTk2NX0.eonFPMsPeyx0-BAlVawWgb0WwJocWQS1IP3kYbLsU_M";
//
//    }

    @When("Get all product admins with valid json file")
    public void getAllProductAdminsWithValidJsonFile() {
        File jsonFiles = new File( MiddlemanAPI.JSON_FILE_ADMINS+"/GetAllProductAdmins.json");
        middlemanAPI.getAllProductAdmins(jsonFiles);
    }

    @When("Send request get all product admins")
    public void sendRequestGetAllProductAdmins() {
        SerenityRest.when().get(MiddlemanAPI.GET_ALL_PRODUCT_ADMINS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Get all product admins assert json validation")
    public void getAllProductAdminsAssertJsonValidation() {
        File jsonFile = new File(MiddlemanAPI.JSON_FILE_ADMINS +"/GetAllProductAdminsValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


    @When("Send request get all product admins with invalid path")
    public void sendRequestGetAllProductAdminsWithInvalidPath() {
        SerenityRest.when().post(MiddlemanAPI.GET_INVALIDPATH_ADMINS);
    }

    @Then("Status code should be {int} not found")
    public void statusCodeShouldBeNotFound(int not_found) {
        SerenityRest.then().statusCode(not_found);
    }


    @Then("Status code should be {int} bad request")
    public void statusCodeShouldBeBadRequest(int bad_request) {
        SerenityRest.then().statusCode(bad_request);
    }

    @When("Send post create product admins with valid json file")
    public void sendPostCreateProductAdminsWithValidJsonFile() {
        File jsonFiles = new File( MiddlemanAPI.JSON_FILE_ADMINS+"/PostCreateProductAdmins.json");
        middlemanAPI.postCreateProductAdmins(jsonFiles);
    }

    @When("Send request post create a new product admins")
    public void sendRequestPostCreateANewProductAdmins() {
        SerenityRest.when().post(MiddlemanAPI.POST_CREATE_ADMINS);

    }

    @Then("Status code should be {int} created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @When("Send post create product admins with invalid stock on json file")
    public void sendPostCreateProductAdminsWithInvalidStockOnJsonFile() {
        File jsonFiles = new File( MiddlemanAPI.JSON_FILE_ADMINS+"/PostCreateProductAdminsInvalidStock.json");
        middlemanAPI.postCreateProductAdmins(jsonFiles);
    }

    @Then("Status code should be {int} wrong input")
    public void statusCodeShouldBeWrongInput(int wrong_input) {
        SerenityRest.then().statusCode(wrong_input);
    }

    @When("Send post create product admins with invalid price on json file")
    public void sendPostCreateProductAdminsWithInvalidPriceOnJsonFile() {
        File jsonFiles = new File( MiddlemanAPI.JSON_FILE_ADMINS+"/PostCreateProductAdminsInvalidPrice.json");
        middlemanAPI.postCreateProductAdmins(jsonFiles);
    }

    @Given("Authorization invalid bearer token")
    public void authorizationInvalidBearerToken() {
        MiddlemanAPI.TOKEN_ADMINS_INVALID = "invalideyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6MTAsIlJvbGUiOiJhZG1pbiIsImV4cCI6MTY2MDM3MjMxMX0.EoGYbcbsszhfuD_D5hzBGAJynq07LHTjWySqS4kEDBw";

    }

    @Then("Status code should be {int} unauthorized")
    public void statusCodeShouldBeUnauthorized(int unauthorized) {
        SerenityRest.then().statusCode(unauthorized);
    }

    @When("Send put update product admins with valid json file")
    public void sendPutUpdateProductAdminsWithValidJsonFile() {
        File jsonFiles = new File( MiddlemanAPI.JSON_FILE_ADMINS+"/PutUpdateProductAdmins.json");
        middlemanAPI.putUpdateProductAdmins(jsonFiles);
    }

    @When("Send request put update admins")
    public void sendRequestPutUpdateAdmins() {
        SerenityRest.when().put(MiddlemanAPI.PUT_UPDATE_ADMINS);

    }

    @When("Send put update product admins without product name and stock on json file")
    public void sendPutUpdateProductAdminsWithoutProductNameAndStockOnJsonFile() {
        File jsonFiles = new File( MiddlemanAPI.JSON_FILE_ADMINS+"/PutUpdateProductAdminsWithoutNameAndStock.json");
        middlemanAPI.putUpdateProductAdminsWithoutNameAndStock(jsonFiles);

    }

    @When("Send put update product admins without product unit and price on json file")
    public void sendPutUpdateProductAdminsWithoutProductUnitAndPriceOnJsonFile() {
        File jsonFiles = new File( MiddlemanAPI.JSON_FILE_ADMINS+"/PutUpdateProductAdminsWithoutUnitAndPrice.json");
        middlemanAPI.putUpdateProductAdminsWithoutUnitAndPrice(jsonFiles);
    }

    @When("Send put update product admins without product image on json file")
    public void sendPutUpdateProductAdminsWithoutProductImageOnJsonFile() {
        File jsonFiles = new File( MiddlemanAPI.JSON_FILE_ADMINS+"/PutUpdateProductAdminsWithoutProductImage.json");
        middlemanAPI.putUpdateProductAdmins(jsonFiles);
    }

    @When("Send put update product admins with invalid stock json file")
    public void sendPutUpdateProductAdminsWithInvalidStockJsonFile() {
        File jsonFiles = new File( MiddlemanAPI.JSON_FILE_ADMINS+"/PutUpdateProductAdminsWithInvalidStock.json");
        middlemanAPI.putUpdateProductAdmins(jsonFiles);
    }

    @And("Delete comments with id {int}")
    public void deleteCommentsWithId(int id) {
        middlemanAPI.deleteProductAdmins(id);
    }

    @When("Send request delete comments")
    public void sendRequestDeleteComments() {
        SerenityRest.when().delete(MiddlemanAPI.DELETE_PRODUCT_ADMINS);
    }

    @Then("Status code should be {int} No content")
    public void statusCodeShouldBeNoContent(int no_content) {
        SerenityRest.then().statusCode(no_content);
    }

    @When("Send request delete comments with invalid path")
    public void sendRequestDeleteCommentsWithInvalidPath() {
        SerenityRest.when().post(MiddlemanAPI.DELETE_INVALIDPATH_ADMINS);
    }
}
