package Middleman.StepDefs;

import Middleman.API.MiddlemanAPI;
import Middleman.Responses.MiddlemanResponses;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class MiddlemanUserStepDefs {
    @Steps
    MiddlemanAPI middlemanAPI;
    @Given("Create login user with valid json file")
    public void createLoginUserWithValidJsonFile() {
        File jsonFilesValidUser = new File( MiddlemanAPI.JSON_FILE_LOGIN+"/ValidLoginUser2.json");
        middlemanAPI.postLoginUserOrAdmin(jsonFilesValidUser);
    }

    @Given("Create register user with valid json file")
    public void createRegisterUserWithValidJsonFile() {
        File jsonFilesRegisterValidUser = new File( MiddlemanAPI.JSON_FILE_REGISTER+"/RegisterValidData2.json");
        middlemanAPI.postRegisterUser(jsonFilesRegisterValidUser);
    }
//GET USER
    @Given("Set authorization with valid bearer token")
    public void setAuthorizationWithValidBearerToken() {
        middlemanAPI.getUserWithValidToken();
    }
    @When("Send request get user")
    public void sendRequestGetUser() {
        SerenityRest.when().get(MiddlemanAPI.GET_USER);
    }
    @And("Get user assert json validation")
    public void getUserAssertJsonValidation() {
        File jsonFileValidUserValidation = new File(MiddlemanAPI.JSON_FILE_USER+"/GetUserValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFileValidUserValidation));
    }
//Get Invalid User
    @Given("Set authorization with invalid bearer token")
    public void setAuthorizationWithInvalidBearerToken() {
        middlemanAPI.getUserWithInvalidToken();
    }

    @Then("API response status code should be {int} Unauthorized")
    public void apiResponseStatusCodeShouldBeUnauthorized(int unauthorized) {
        SerenityRest.then().statusCode(unauthorized);
    }
//Get User without token
    @Given("Set request get user without bearer token")
    public void setRequestGetUserWithoutBearerToken() {
        middlemanAPI.getUserWithoutToken();
    }

//Get User Invalid Path
    @Given("Set request get user with invalid path")
    public void setRequestGetUserWithInvalidPath() {
        middlemanAPI.getUserWithValidToken();
    }

    @When("Send request get user with invalid path")
    public void sendRequestGetUserWithInvalidPath() {
        SerenityRest.when().get(MiddlemanAPI.GET_USER_INVALID_PATH);
    }
//update user with all valid data
    @Given("Set request update user with all valid data")
    public void setRequestUpdateUserWithAllValidData() {
        File jsonFilesValidUser = new File( MiddlemanAPI.JSON_FILE_USER+"/UpdateUserWithAllValidData.json");
        middlemanAPI.putUserWithvalidToken(jsonFilesValidUser);
    }
    @When("Send request update user")
    public void sendRequestUpdateUser() {
        SerenityRest.when().put(MiddlemanAPI.PUT_USER);
    }
//Update user without properti name
    @Given("Set request update user without properti name")
    public void setRequestUpdateUserWithoutPropertiName() {
        File jsonFilesValidUser = new File( MiddlemanAPI.JSON_FILE_USER+"/UpdateUserWithoutPropertiName.json");
        middlemanAPI.putUserWithvalidToken(jsonFilesValidUser);
    }
//Update user with already registered email
    @Given("Set request update with already registered email")
    public void setRequestUpdateWithAlreadyRegisteredEmail() {
        File jsonFilesValidUser = new File( MiddlemanAPI.JSON_FILE_USER+"/UpdateUserWithRegisteredEmail.json");
        middlemanAPI.putUserWithvalidToken(jsonFilesValidUser);
    }
//Update user with email not valid
    @Given("Set request update user with email not valid")
    public void setRequestUpdateUserWithEmailNotValid() {
        File jsonFilesValidUser = new File( MiddlemanAPI.JSON_FILE_USER+"/UpdateUserWithEmailNotValid.json");
        middlemanAPI.putUserWithvalidToken(jsonFilesValidUser);
    }

    @Given("Set request update user with empty data on json file")
    public void setRequestUpdateUserWithEmptyDataOnJsonFile() {
        File jsonFilesValidUser = new File( MiddlemanAPI.JSON_FILE_USER+"/UpdateUserWithEmptyData.json");
        middlemanAPI.putUserWithvalidToken(jsonFilesValidUser);
    }
//update user with invalid path
    @Given("Set request update user with invalid path")
    public void setRequestUpdateUserWithInvalidPath() {
        File jsonFilesValidUser = new File( MiddlemanAPI.JSON_FILE_USER+"/UpdateUserWithInvalidPath.json");
        middlemanAPI.putUserWithvalidToken(jsonFilesValidUser);
    }
    @When("Send request update user with invalid path")
    public void sendRequestUpdateUserWithInvalidPath() {
        SerenityRest.when().put(MiddlemanAPI.PUT_USER_INVALID_PATH);
    }

    @And("response body should contains message {string}")
    public void responseBodyShouldContainsMessage(String message) {
        SerenityRest.then()
                .body(MiddlemanResponses.MESSAGE,equalTo(message));
    }
//update user with phone number not valid
    @Given("Set request update user with phone number not valid")
    public void setRequestUpdateUserWithPhoneNumberNotValid() {
        File jsonFilesValidUser = new File( MiddlemanAPI.JSON_FILE_USER+"/UpdateUserWithPhoneNotValid.json");
        middlemanAPI.putUserWithvalidToken(jsonFilesValidUser);
    }

//Delete User
    @Given("Set request delete user with register user")
    public void setRequestDeleteUserWithRegisterUser() {
        middlemanAPI.deleteUserWithValidToken();
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(MiddlemanAPI.DELETE_USER);
    }

    @Then("API response status code should be {int} no content")
    public void apiResponseStatusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

    @Given("Set request delete user invalid token")
    public void setRequestDeleteUserInvalidToken() {
        middlemanAPI.deleteUserWithInValidToken();
    }

    @Given("Set request delete user with invalid path")
    public void setRequestDeleteUserWithInvalidPath() {
        middlemanAPI.deleteUserWithValidToken();
    }

    @When("Send request delete user invalid path")
    public void sendRequestDeleteUserInvalidPath() {
        SerenityRest.when().delete(MiddlemanAPI.DELETE_USER_INVALID_PATH);
    }

}
