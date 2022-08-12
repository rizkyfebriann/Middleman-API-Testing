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

public class MiddlemanLoginStepDefs {

    @Steps
    MiddlemanAPI middlemanAPI;

    @Given("Post login user with valid json file")
    public void postLoginUserWithValidJsonFile() {
        File jsonFilesValidUser = new File( MiddlemanAPI.JSON_FILE_LOGIN+"/ValidLoginUser.json");
        middlemanAPI.postLoginUserOrAdmin(jsonFilesValidUser);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(MiddlemanAPI.POST_LOGIN_USER);
    }

    @Then("API response status code should be {int} OK")
    public void apiResponseStatusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Post login user assert json validation")
    public void postLoginUserAssertJsonValidation() {
        File jsonFileValidUserValidation = new File(MiddlemanAPI.JSON_FILE_LOGIN+"/ValidLoginUserValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFileValidUserValidation));
    }

    @Then("API response status code should be {int} bad request")
    public void apiResponseStatusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @Given("Post login admin with valid json file")
    public void postLoginAdminWithValidJsonFile() {
        File jsonFilesValidAdmin = new File( MiddlemanAPI.JSON_FILE_LOGIN+"/ValidLoginAdmin.json");
        middlemanAPI.postLoginUserOrAdmin(jsonFilesValidAdmin);
    }

    @And("Post login admin assert json validation")
    public void postLoginAdminAssertJsonValidation() {
        File jsonFileValidAdminValidation = new File(MiddlemanAPI.JSON_FILE_LOGIN+"/ValidLoginAdminValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFileValidAdminValidation));
    }

    @Given("Post login user with invalid json file")
    public void postLoginUserWithInvalidJsonFile() {
        File jsonFilesInvalidLoginUser1 = new File( MiddlemanAPI.JSON_FILE_LOGIN+"/InvalidLoginUserInvalidPassword.json");
        middlemanAPI.postLoginUserOrAdmin(jsonFilesInvalidLoginUser1);
        File jsonFilesInvalidLoginUser2 = new File( MiddlemanAPI.JSON_FILE_LOGIN+"/InvalidLoginUserInvalidEmail.json");
        middlemanAPI.postLoginUserOrAdmin(jsonFilesInvalidLoginUser2);
        File jsonFilesInvalidLoginUser3 = new File( MiddlemanAPI.JSON_FILE_LOGIN+"/InvalidLoginUserInvalidEmailAndPassword.json");
        middlemanAPI.postLoginUserOrAdmin(jsonFilesInvalidLoginUser3);
        File jsonFilesInvalidLoginUser4 = new File( MiddlemanAPI.JSON_FILE_LOGIN+"/InvalidLoginUserWithoutEmail.json");
        middlemanAPI.postLoginUserOrAdmin(jsonFilesInvalidLoginUser4);
        File jsonFilesInvalidLoginUser5 = new File( MiddlemanAPI.JSON_FILE_LOGIN+"/InvalidLoginUserWithoutPassword.json");
        middlemanAPI.postLoginUserOrAdmin(jsonFilesInvalidLoginUser5);
        File jsonFilesInvalidLoginUser6 = new File( MiddlemanAPI.JSON_FILE_LOGIN+"/InvalidLoginUserEmptyEmail.json");
        middlemanAPI.postLoginUserOrAdmin(jsonFilesInvalidLoginUser6);
        File jsonFilesInvalidLoginUser7 = new File( MiddlemanAPI.JSON_FILE_LOGIN+"/InvalidLoginUserEmptyPassword.json");
        middlemanAPI.postLoginUserOrAdmin(jsonFilesInvalidLoginUser7);
    }

    @When("Send request post login user on invalid path")
    public void sendRequestPostLoginUserOnInvalidPath() {
        SerenityRest.when().post(MiddlemanAPI.POST_LOGININVALID_USER);
    }

    @Then("API response status code should be {int} not found")
    public void apiResponseStatusCodeShouldBeNotFound(int not_found) {
        SerenityRest.then().statusCode(not_found);
    }
}
