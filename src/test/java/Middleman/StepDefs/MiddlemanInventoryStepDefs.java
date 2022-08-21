package Middleman.StepDefs;

import Middleman.API.MiddlemanAPI_Inventory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class MiddlemanInventoryStepDefs {
    @Steps
    MiddlemanAPI_Inventory middlemanAPIinventory;

    @When("Send post create  form to list product user with valid json file")
    public void sendPostCreateFormToListProductUserWithValidJsonFile() {
        File jsonFiles = new File( MiddlemanAPI_Inventory.JSON_FILE_INVENTORY+"/CreateListProductUserValidData.json");
        middlemanAPIinventory.postCreateListProductUser(jsonFiles);
    }

    @When("Send request post create form to list product user")
    public void sendRequestPostCreateFormToListProductUser() {
        SerenityRest.when().post(MiddlemanAPI_Inventory.POST_CREATE_LIST_USER);
    }

    @When("Send post create  form to list product user with invalid qty json file")
    public void sendPostCreateFormToListProductUserWithInvalidQtyJsonFile() {
        File jsonFiles = new File( MiddlemanAPI_Inventory.JSON_FILE_INVENTORY+"/CreateListProductUserInvalidQty.json");
        middlemanAPIinventory.postCreateListProductUser(jsonFiles);
    }

    @When("Send post create  form to list product user without product id json file")
    public void sendPostCreateFormToListProductUserWithoutProductIdJsonFile() {
        File jsonFiles = new File( MiddlemanAPI_Inventory.JSON_FILE_INVENTORY+"/CreateListProductUserWithoutProductID.json");
        middlemanAPIinventory.postCreateListProductUser(jsonFiles);
    }

    @When("Send post create  form to list product user without unit json file")
    public void sendPostCreateFormToListProductUserWithoutUnitJsonFile() {
        File jsonFiles = new File( MiddlemanAPI_Inventory.JSON_FILE_INVENTORY+"/CreateListProductUserWithoutUnit.json");
        middlemanAPIinventory.postCreateListProductUser(jsonFiles);
    }

    @When("Send post create  form to list product user without qty json file")
    public void sendPostCreateFormToListProductUserWithoutQtyJsonFile() {
        File jsonFiles = new File( MiddlemanAPI_Inventory.JSON_FILE_INVENTORY+"/CreateListProductUserWithoutUnit.json");
        middlemanAPIinventory.postCreateListProductUser(jsonFiles);
    }

    @When("Send request post create form to list product user with invalid path {string}")
    public void sendRequestPostCreateFormToListProductUserWithInvalidPath(String arg0) {
        SerenityRest.when().post(MiddlemanAPI_Inventory.POST_CREATE_LIST_USER_INVALIDPATH);
    }
    @When("Send request get all form product inventory user")
    public void sendRequestGetAllFormProductInventoryUser() {
        Response response= SerenityRest.when().get(MiddlemanAPI_Inventory.GET_ALL_PRODUCT_INVENTORY_USER);
        response.prettyPrint();
    }

    @Given("get all form products inventory with authorized user")
    public void getAllFormProductsInventoryWithAuthorizedUser() {
        MiddlemanAPI_Inventory.getAllProductInventoryUser();
    }

    @When("Send request get all form product inventory user with invalid path {string}")
    public void sendRequestGetAllFormProductInventoryUserWithInvalidPath(String arg0) {
        SerenityRest.when().get(MiddlemanAPI_Inventory.GET_ALL_PRODUCT_INVENTORY_USER_INVALIDPATH);
    }

    @Given("get all form products inventory with unauthorized user")
    public void getAllFormProductsInventoryWithUnauthorizedUser() {
        MiddlemanAPI_Inventory.getAllProductInventoryUser();
    }

    @Given("Get detail form product inventory with authorized user")
    public void getDetailFormProductInventoryWithAuthorizedUser() {
        MiddlemanAPI_Inventory.getDetailProductInventoryUser();
    }

    @When("Send request get detail form product inventory user")
    public void sendRequestGetDetailFormProductInventoryUser() {
        SerenityRest.when().get(MiddlemanAPI_Inventory.GET_DETAIL_PRODUCT_INVENTORY_USER);
    }

    @When("Send request get detail form product inventory user with invalid inventory id {string}")
    public void sendRequestGetDetailFormProductInventoryUserWithInvalidInventoryId(String arg0) {
        SerenityRest.when().get(MiddlemanAPI_Inventory.GET_DETAIL_PRODUCT_INVENTORY_USERINVALID_ID);
    }

    @When("Send request get detail form product inventory user with invalid path {string}")
    public void sendRequestGetDetailFormProductInventoryUserWithInvalidPath(String arg0) {
        SerenityRest.when().get(MiddlemanAPI_Inventory.GET_DETAIL_PRODUCT_INVENTORY_USER_INVALIDPATH);
    }

    @Given("Get detail form products inventory with unauthorized user")
    public void getDetailFormProductsInventoryWithUnauthorizedUser() {
        MiddlemanAPI_Inventory.getDetailProductInventoryUser();
    }

    @When("Send post create  form to list product admins with valid json file")
    public void sendPostCreateFormToListProductAdminsWithValidJsonFile() {
        File jsonFiles = new File( MiddlemanAPI_Inventory.JSON_FILE_INVENTORY+"/CreateListProductAdminsValidData.json");
        middlemanAPIinventory.postCreateListProductAdmins(jsonFiles);
    }

    @When("Send request post create form to list product admins")
    public void sendRequestPostCreateFormToListProductAdmins() {
        SerenityRest.when().post(MiddlemanAPI_Inventory.POST_CREATE_LIST_ADMINS);
    }

    @When("Send post create  form to list product admins with invalid qty json file")
    public void sendPostCreateFormToListProductAdminsWithInvalidQtyJsonFile() {
        File jsonFiles = new File( MiddlemanAPI_Inventory.JSON_FILE_INVENTORY+"/CreateListProductAdminsInvalidQty.json");
        middlemanAPIinventory.postCreateListProductAdmins(jsonFiles);
    }

    @When("Send post create  form to list product admins without product id json file")
    public void sendPostCreateFormToListProductAdminsWithoutProductIdJsonFile() {
        File jsonFiles = new File( MiddlemanAPI_Inventory.JSON_FILE_INVENTORY+"/CreateListProductAdminsWithoutProductID.json");
        middlemanAPIinventory.postCreateListProductAdmins(jsonFiles);
    }

    @When("Send post create  form to list product admins without unit json file")
    public void sendPostCreateFormToListProductAdminsWithoutUnitJsonFile() {
        File jsonFiles = new File( MiddlemanAPI_Inventory.JSON_FILE_INVENTORY+"/CreateListProductAdminsWithoutUnit.json");
        middlemanAPIinventory.postCreateListProductAdmins(jsonFiles);
    }

    @When("Send post create  form to list product admins without qty json file")
    public void sendPostCreateFormToListProductAdminsWithoutQtyJsonFile() {
        File jsonFiles = new File( MiddlemanAPI_Inventory.JSON_FILE_INVENTORY+"/CreateListProductAdminsWithoutQty.json");
        middlemanAPIinventory.postCreateListProductAdmins(jsonFiles);
    }

    @When("Send request post create form to list product admins with invalid path {string}")
    public void sendRequestPostCreateFormToListProductAdminsWithInvalidPath(String arg0) {
        SerenityRest.when().post(MiddlemanAPI_Inventory.POST_CREATE_LIST_ADMINS_INVALIDPATH);
    }

    @Given("get all form products inventory with authorized admins")
    public void getAllFormProductsInventoryWithAuthorizedAdmins() {
        MiddlemanAPI_Inventory.getAllProductInventoryAdmins();
    }

    @When("Send request get all form product inventory admins")
    public void sendRequestGetAllFormProductInventoryAdmins() {
        SerenityRest.when().get(MiddlemanAPI_Inventory.GET_ALL_PRODUCT_INVENTORY_ADMINS);

    }

    @When("Send request get all form product inventory admins with invalid path {string}")
    public void sendRequestGetAllFormProductInventoryAdminsWithInvalidPath(String arg0) {
        SerenityRest.when().get(MiddlemanAPI_Inventory.GET_ALL_PRODUCT_INVENTORY_ADMINS_INVALIDPATH);

    }

    @Given("get all form products inventory with unauthorized admins")
    public void getAllFormProductsInventoryWithUnauthorizedAdmins() {
        MiddlemanAPI_Inventory.getAllProductInventoryAdmins();
    }

    @Given("Get detail form product inventory with authorized admins")
    public void getDetailFormProductInventoryWithAuthorizedAdmins() {
        MiddlemanAPI_Inventory.getDetailProductInventoryAdmins();
    }

    @When("Send request get detail form product inventory admins")
    public void sendRequestGetDetailFormProductInventoryAdmins() {
        SerenityRest.when().get(MiddlemanAPI_Inventory.GET_DETAIL_PRODUCT_INVENTORY_ADMINS);

    }

    @When("Send request get detail form product inventory admins with invalid inventory id")
    public void sendRequestGetDetailFormProductInventoryAdminsWithInvalidInventoryId() {
        SerenityRest.when().get(MiddlemanAPI_Inventory.GET_DETAIL_PRODUCT_INVENTORY_ADMINS_INVALIDID);
    }

    @When("Send request get detail form product inventory admins with invalid path")
    public void sendRequestGetDetailFormProductInventoryAdminsWithInvalidPath() {
        SerenityRest.when().get(MiddlemanAPI_Inventory.GET_DETAIL_PRODUCT_INVENTORY_ADMINS_INVALIDPATH);
    }

    @Given("Get detail form products inventory with unauthorized admins")
    public void getDetailFormProductsInventoryWithUnauthorizedAdmins() {
        MiddlemanAPI_Inventory.getDetailProductInventoryAdmins();
    }

    @Given("get all form products inventory without bearer token")
    public void getAllFormProductsInventoryWithoutBearerToken() {
        SerenityRest.given();
    }

    @Given("Post Create a form to list product user without bearer token")
    public void postCreateAFormToListProductUserWithoutBearerToken() {
        SerenityRest.given();
    }

    @Given("Get all form products inventory user without bearer token")
    public void getAllFormProductsInventoryUserWithoutBearerToken() {
        SerenityRest.given();
    }

    @Given("Post create a form to list product admins without bearer token")
    public void postCreateAFormToListProductAdminsWithoutBearerToken() {
        SerenityRest.given();
    }

    @Given("Get detail form products inventory admins without bearer token")
    public void getDetailFormProductsInventoryAdminsWithoutBearerToken() {
        SerenityRest.given();
    }
}
