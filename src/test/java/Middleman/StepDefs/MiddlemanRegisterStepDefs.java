package Middleman.StepDefs;

import Middleman.API.MiddlemanAPI;
import Middleman.Responses.MiddlemanResponses;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class MiddlemanRegisterStepDefs {

    @Steps
    MiddlemanAPI middlemanAPI;

    @Given("Post register user with valid json file")
    public void postRegisterUserWithValidJsonFile() {
        File jsonFilesRegisterValidUser = new File( MiddlemanAPI.JSON_FILE_REGISTER+"/RegisterNewValidUser.json");
        middlemanAPI.postRegisterUser(jsonFilesRegisterValidUser);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(MiddlemanAPI.POST_REGISTER_USER);
    }

    @Then("API response status code should be {int} created")
    public void apiResponseStatusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("response body should contains code {int} and message {string}")
    public void responseBodyShouldContainsCodeAndMessage(int code, String message) {
        SerenityRest.then()
                .body(MiddlemanResponses.CODE,equalTo(code))
                .body(MiddlemanResponses.MESSAGE,equalTo(message))
        ;
    }

    @Given("Post register user with invalid json file")
    public void postRegisterUserWithInvalidJsonFile() {
        File jsonFilesInvalidRegisterUser1 = new File( MiddlemanAPI.JSON_FILE_REGISTER+"/RegisterNewUserWithoutName.json");
        middlemanAPI.postLoginUserOrAdmin(jsonFilesInvalidRegisterUser1);
        File jsonFilesInvalidRegisterUser2 = new File( MiddlemanAPI.JSON_FILE_REGISTER+"/RegisterNewUserWithoutEmail.json");
        middlemanAPI.postLoginUserOrAdmin(jsonFilesInvalidRegisterUser2);
        File jsonFilesInvalidRegisterUser3 = new File( MiddlemanAPI.JSON_FILE_REGISTER+"/RegisterNewUserWithoutPassword.json");
        middlemanAPI.postLoginUserOrAdmin(jsonFilesInvalidRegisterUser3);
        File jsonFilesInvalidRegisterUser4 = new File( MiddlemanAPI.JSON_FILE_REGISTER+"/RegisterNewUserWithoutPhone.json");
        middlemanAPI.postLoginUserOrAdmin(jsonFilesInvalidRegisterUser4);
        File jsonFilesInvalidRegisterUser5 = new File( MiddlemanAPI.JSON_FILE_REGISTER+"/RegisterNewUserWithoutAddress.json");
        middlemanAPI.postLoginUserOrAdmin(jsonFilesInvalidRegisterUser5);
    }

    @Given("Post register user already registered with valid json file")
    public void postRegisterUserAlreadyRegisteredWithValidJsonFile() {
        File jsonFilesRegisteredValidUser = new File( MiddlemanAPI.JSON_FILE_REGISTER+"/RegisterNewValidUser.json");
        middlemanAPI.postRegisterUser(jsonFilesRegisteredValidUser);
    }

    @Given("Post register user with invalid format email on valid json file")
    public void postRegisterUserWithEmailNotValidOhValidJsonFile() {
        File jsonFilesRegisterUserInvalidEmail = new File( MiddlemanAPI.JSON_FILE_REGISTER+"/RegisterNewUserWithInvalidFormatEmail.json");
        middlemanAPI.postRegisterUser(jsonFilesRegisterUserInvalidEmail);
    }

    @Given("Post register user with invalid phone on valid json file")
    public void postRegisterUserWithInvalidPhoneOnValidJsonFile() {
        File jsonFilesRegisterUserInvalidPhone = new File( MiddlemanAPI.JSON_FILE_REGISTER+"/RegisterNewUserWithInvalidPhone.json");
        middlemanAPI.postRegisterUser(jsonFilesRegisterUserInvalidPhone);
    }

    @When("Send request post register user on invalid path")
    public void sendRequestPostRegisterUserOnInvalidPath() {
        SerenityRest.when().post(MiddlemanAPI.POST_REGISTERINVALID_USER);
    }
}
