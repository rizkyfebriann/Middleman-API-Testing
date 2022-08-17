package Middleman.StepDefs;

import Middleman.API.MiddlemanAPI_Admins;
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
    MiddlemanAPI_Admins middlemanAPIadmins;


    @When("Get all product admins with valid json file")
    public void getAllProductAdminsWithValidJsonFile() {
        File jsonFiles = new File( MiddlemanAPI_Admins.JSON_FILE_ADMINS+"/GetAllProductAdmins.json");
        middlemanAPIadmins.getAllProductAdmins(jsonFiles);
    }

    @When("Send request get all product admins")
    public void sendRequestGetAllProductAdmins() {
        SerenityRest.when().get(MiddlemanAPI_Admins.GET_ALL_PRODUCT_ADMINS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Get all product admins assert json validation")
    public void getAllProductAdminsAssertJsonValidation() {
        File jsonFile = new File(MiddlemanAPI_Admins.JSON_FILE_ADMINS +"/GetAllProductAdminsValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


    @When("Send request get all product admins with invalid path")
    public void sendRequestGetAllProductAdminsWithInvalidPath() {
        SerenityRest.when().post(MiddlemanAPI_Admins.GET_INVALIDPATH_ADMINS);
    } @Given("Get search product admins with valid product name")


    public void getSearchProductAdminsWithValidProductName() {
        File jsonFiles = new File( MiddlemanAPI_Admins.JSON_FILE_ADMINS+"/GetSearchProductAdminsValidProductName.json");
        middlemanAPIadmins.getSearchProductAdmins(jsonFiles);
    }

    @When("Send request get search with valid product name")
    public void sendRequestGetSearchWithValidProductName() {
        SerenityRest.when().get(MiddlemanAPI_Admins.GET_SEARCH_PRODUCT_ADMINS_VALIDNAME );
    }

    @And("Get all search product admins assert json validation")
    public void getAllSearchProductAdminsAssertJsonValidation() {
        File jsonFile = new File(MiddlemanAPI_Admins.JSON_FILE_ADMINS +"/GetSearchProductAdminsValidProductNameValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Get search product admins with one alphabet contains from product name")
    public void getSearchProductAdminsWithOneAlphabetContainsFromProductName() {
        File jsonFiles = new File( MiddlemanAPI_Admins.JSON_FILE_ADMINS+"/GetSearchProductAdminsValidProductName.json");
        middlemanAPIadmins.getSearchProductAdmins(jsonFiles);

    }

    @When("Send request get search with one alphabet contains from product name")
    public void sendRequestGetSearchWithOneAlphabetContainsFromProductName() {
        SerenityRest.when().get(MiddlemanAPI_Admins.GET_SEARCH_PRODUCT_ADMINS_ONEKEYWORD );
    }

    @Given("Get search product with two alphabet contains from product name")
    public void getSearchProductWithTwoAlphabetContainsFromProductName() {
        File jsonFiles = new File( MiddlemanAPI_Admins.JSON_FILE_ADMINS+"/GetSearchProductAdminsValidProductName.json");
        middlemanAPIadmins.getSearchProductAdmins(jsonFiles);

    }

    @When("Send request get search with two alphabet contains from product name")
    public void sendRequestGetSearchWithTwoAlphabetContainsFromProductName() {
        SerenityRest.when().get(MiddlemanAPI_Admins.GET_SEARCH_PRODUCT_ADMINS_TWOKEYWORD);
    }

    @Given("Get search product admins with invalid keyword value")
    public void getSearchProductAdminsWithInvalidKeywordValue() {
        File jsonFiles = new File( MiddlemanAPI_Admins.JSON_FILE_ADMINS+"/GetSearchProductAdminsValidProductName.json");
        middlemanAPIadmins.getSearchProductAdmins(jsonFiles);

    }

    @When("Send request get search with invalid keyword")
    public void sendRequestGetSearchWithInvalidKeyword() {
        SerenityRest.when().get(MiddlemanAPI_Admins.GET_SEARCH_PRODUCT_ADMINS_INVALIDKEYWORD);
    }

    @Given("Get search product admins with invalid path param")
    public void getSearchProductAdminsWithInvalidPathParam() {
        File jsonFiles = new File( MiddlemanAPI_Admins.JSON_FILE_ADMINS+"/GetSearchProductAdminsValidProductName.json");
        middlemanAPIadmins.getSearchProductAdmins(jsonFiles);
    }

    @When("Send request get search with invalid path param")
    public void sendRequestGetSearchWithInvalidPathParam() {
        SerenityRest.when().get(MiddlemanAPI_Admins.GET_SEARCH_PRODUCT_ADMINS_INVALIDPATH);
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
        File jsonFiles = new File( MiddlemanAPI_Admins.JSON_FILE_ADMINS+"/PostCreateProductAdmins.json");
        middlemanAPIadmins.postCreateProductAdmins(jsonFiles);
    }

    @When("Send request post create a new product admins")
    public void sendRequestPostCreateANewProductAdmins() {
        SerenityRest.when().post(MiddlemanAPI_Admins.POST_CREATE_ADMINS);

    }

    @Then("Status code should be {int} created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @When("Send post create product admins with invalid stock on json file")
    public void sendPostCreateProductAdminsWithInvalidStockOnJsonFile() {
        File jsonFiles = new File( MiddlemanAPI_Admins.JSON_FILE_ADMINS+"/PostCreateProductAdminsInvalidStock.json");
        middlemanAPIadmins.postCreateProductAdmins(jsonFiles);
    }

    @Then("Status code should be {int} wrong input")
    public void statusCodeShouldBeWrongInput(int wrong_input) {
        SerenityRest.then().statusCode(wrong_input);
    }

    @When("Send post create product admins with invalid price on json file")
    public void sendPostCreateProductAdminsWithInvalidPriceOnJsonFile() {
        File jsonFiles = new File( MiddlemanAPI_Admins.JSON_FILE_ADMINS+"/PostCreateProductAdminsInvalidPrice.json");
        middlemanAPIadmins.postCreateProductAdmins(jsonFiles);
    }

    @Then("Status code should be {int} unauthorized")
    public void statusCodeShouldBeUnauthorized(int unauthorized) {
        SerenityRest.then().statusCode(unauthorized);
    }

    @When("Send put update product admins with valid json file")
    public void sendPutUpdateProductAdminsWithValidJsonFile() {
        File jsonFiles = new File( MiddlemanAPI_Admins.JSON_FILE_ADMINS+"/PutUpdateProductAdmins.json");
        middlemanAPIadmins.putUpdateProductAdmins(jsonFiles);
    }

    @When("Send request put update admins")
    public void sendRequestPutUpdateAdmins() {
        SerenityRest.when().put(MiddlemanAPI_Admins.PUT_UPDATE_ADMINS);

    }

    @When("Send put update product admins without product name and stock on json file")
    public void sendPutUpdateProductAdminsWithoutProductNameAndStockOnJsonFile() {
        File jsonFiles = new File( MiddlemanAPI_Admins.JSON_FILE_ADMINS+"/PutUpdateProductAdminsWithoutNameAndStock.json");
        middlemanAPIadmins.putUpdateProductAdminsWithoutNameAndStock(jsonFiles);

    }

    @When("Send put update product admins without product unit and price on json file")
    public void sendPutUpdateProductAdminsWithoutProductUnitAndPriceOnJsonFile() {
        File jsonFiles = new File( MiddlemanAPI_Admins.JSON_FILE_ADMINS+"/PutUpdateProductAdminsWithoutUnitAndPrice.json");
        middlemanAPIadmins.putUpdateProductAdminsWithoutUnitAndPrice(jsonFiles);
    }

    @When("Send put update product admins without product image on json file")
    public void sendPutUpdateProductAdminsWithoutProductImageOnJsonFile() {
        File jsonFiles = new File( MiddlemanAPI_Admins.JSON_FILE_ADMINS+"/PutUpdateProductAdminsWithoutProductImage.json");
        middlemanAPIadmins.putUpdateProductAdmins(jsonFiles);
    }

    @When("Send put update product admins with invalid stock json file")
    public void sendPutUpdateProductAdminsWithInvalidStockJsonFile() {
        File jsonFiles = new File( MiddlemanAPI_Admins.JSON_FILE_ADMINS+"/PutUpdateProductAdminsWithInvalidStock.json");
        middlemanAPIadmins.putUpdateProductAdmins(jsonFiles);
    }

    @And("Delete comments with id {int}")
    public void deleteCommentsWithId(int id) {
        middlemanAPIadmins.deleteProductAdmins(id);
    }

    @When("Send request delete comments")
    public void sendRequestDeleteComments() {
        SerenityRest.when().delete(MiddlemanAPI_Admins.DELETE_PRODUCT_ADMINS);
    }

    @Then("Status code should be {int} No content")
    public void statusCodeShouldBeNoContent(int no_content) {
        SerenityRest.then().statusCode(no_content);
    }

    @When("Send request delete comments with invalid path")
    public void sendRequestDeleteCommentsWithInvalidPath() {
        SerenityRest.when().post(MiddlemanAPI_Admins.DELETE_INVALIDPATH_ADMINS);
    }

    @When("Send post create product admins with registered product name on json file")
    public void sendPostCreateProductAdminsWithRegisteredProductNameOnJsonFile() {
        File jsonFiles = new File( MiddlemanAPI_Admins.JSON_FILE_ADMINS+"/PostCreateProductAdminsWithRegisteredProductName.json");
        middlemanAPIadmins.postCreateProductAdmins(jsonFiles);
    }

    @Then("Status code should be {int} and response body {string}")
    public void statusCodeShouldBeAndResponseBody(int internal_server_error, String arg1 ) {
        SerenityRest.then().statusCode(internal_server_error);
    }

    @When("Send put update product admins with empty data on json file")
    public void sendPutUpdateProductAdminsWithEmptyDataOnJsonFile() {
        File jsonFiles = new File( MiddlemanAPI_Admins.JSON_FILE_ADMINS+"/PutUpdateProductAdminsWithoutProductImage.json");
        middlemanAPIadmins.putUpdateProductAdminsWithEmptyData(jsonFiles);

    }
}
