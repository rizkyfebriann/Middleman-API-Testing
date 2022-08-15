package Middleman.StepDefs;

import Middleman.API.MiddlemanAPI_Login;
import Middleman.API.MiddlemanAPI_Register;
import Middleman.API.MiddlemanAPI_Users;
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
    MiddlemanAPI_Login middlemanAPIlogin;
    MiddlemanAPI_Register middlemanAPIregister;
    MiddlemanAPI_Users middlemanAPIusers;

    @Given("Create login user with valid json file")
    public void createLoginUserWithValidJsonFile() {
        File jsonFilesValidUser = new File( MiddlemanAPI_Login.JSON_FILE_LOGIN+"/ValidLoginUser2.json");
        middlemanAPIlogin.postLoginUserOrAdmin(jsonFilesValidUser);
    }

    @Given("Create register user with valid json file")
    public void createRegisterUserWithValidJsonFile() {
        File jsonFilesRegisterValidUser = new File( MiddlemanAPI_Register.JSON_FILE_REGISTER+"/RegisterValidData2.json");
        middlemanAPIregister.postRegisterUser(jsonFilesRegisterValidUser);
    }
//GET USER
    @Given("Set authorization with valid bearer token")
    public void setAuthorizationWithValidBearerToken() {
        middlemanAPIusers.getUserWithValidToken();
    }
    @When("Send request get user")
    public void sendRequestGetUser() {
        SerenityRest.when().get(MiddlemanAPI_Users.GET_USER);
    }
    @And("Get user assert json validation")
    public void getUserAssertJsonValidation() {
        File jsonFileValidUserValidation = new File(MiddlemanAPI_Users.JSON_FILE_USER+"/GetUserValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFileValidUserValidation));
    }
//Get Invalid User
    @Given("Set authorization with invalid bearer token")
    public void setAuthorizationWithInvalidBearerToken() {
        middlemanAPIusers.getUserWithInvalidToken();
    }

    @Then("API response status code should be {int} Unauthorized")
    public void apiResponseStatusCodeShouldBeUnauthorized(int unauthorized) {
        SerenityRest.then().statusCode(unauthorized);
    }
//Get User without token
    @Given("Set request get user without bearer token")
    public void setRequestGetUserWithoutBearerToken() {
        middlemanAPIusers.getUserWithoutToken();
    }

//Get User Invalid Path
    @Given("Set request get user with invalid path")
    public void setRequestGetUserWithInvalidPath() {
        middlemanAPIusers.getUserWithValidToken();
    }

    @When("Send request get user with invalid path")
    public void sendRequestGetUserWithInvalidPath() {
        SerenityRest.when().get(MiddlemanAPI_Users.GET_USER_INVALID_PATH);
    }
//update user with all valid data
    @Given("Set request update user with all valid data")
    public void setRequestUpdateUserWithAllValidData() {
        File jsonFilesValidUser = new File( MiddlemanAPI_Users.JSON_FILE_USER+"/UpdateUserWithAllValidData.json");
        middlemanAPIusers.putUserWithvalidToken(jsonFilesValidUser);
    }
    @When("Send request update user")
    public void sendRequestUpdateUser() {
        SerenityRest.when().put(MiddlemanAPI_Users.PUT_USER);
    }
//Update user without properti name
    @Given("Set request update user without properti name")
    public void setRequestUpdateUserWithoutPropertiName() {
        File jsonFilesValidUser = new File( MiddlemanAPI_Users.JSON_FILE_USER+"/UpdateUserWithoutPropertiName.json");
        middlemanAPIusers.putUserWithvalidToken(jsonFilesValidUser);
    }
//Update user with already registered email
    @Given("Set request update with already registered email")
    public void setRequestUpdateWithAlreadyRegisteredEmail() {
        File jsonFilesValidUser = new File( MiddlemanAPI_Users.JSON_FILE_USER+"/UpdateUserWithRegisteredEmail.json");
        middlemanAPIusers.putUserWithvalidToken(jsonFilesValidUser);
    }
//Update user with email not valid
    @Given("Set request update user with email not valid")
    public void setRequestUpdateUserWithEmailNotValid() {
        File jsonFilesValidUser = new File( MiddlemanAPI_Users.JSON_FILE_USER+"/UpdateUserWithEmailNotValid.json");
        middlemanAPIusers.putUserWithvalidToken(jsonFilesValidUser);
    }

    @Given("Set request update user with empty data on json file")
    public void setRequestUpdateUserWithEmptyDataOnJsonFile() {
        File jsonFilesValidUser = new File( MiddlemanAPI_Users.JSON_FILE_USER+"/UpdateUserWithEmptyData.json");
        middlemanAPIusers.putUserWithvalidToken(jsonFilesValidUser);
    }
//update user with invalid path
    @Given("Set request update user with invalid path")
    public void setRequestUpdateUserWithInvalidPath() {
        File jsonFilesValidUser = new File( MiddlemanAPI_Users.JSON_FILE_USER+"/UpdateUserWithInvalidPath.json");
        middlemanAPIusers.putUserWithvalidToken(jsonFilesValidUser);
    }
    @When("Send request update user with invalid path")
    public void sendRequestUpdateUserWithInvalidPath() {
        SerenityRest.when().put(MiddlemanAPI_Users.PUT_USER_INVALID_PATH);
    }

    @And("response body should contains message {string}")
    public void responseBodyShouldContainsMessage(String message) {
        SerenityRest.then()
                .body(MiddlemanResponses.MESSAGE,equalTo(message));
    }
//update user with phone number not valid
    @Given("Set request update user with phone number not valid")
    public void setRequestUpdateUserWithPhoneNumberNotValid() {
        File jsonFilesValidUser = new File( MiddlemanAPI_Users.JSON_FILE_USER+"/UpdateUserWithPhoneNotValid.json");
        middlemanAPIusers.putUserWithvalidToken(jsonFilesValidUser);
    }

//Delete User
    @Given("Set request delete user with register user")
    public void setRequestDeleteUserWithRegisterUser() {
        middlemanAPIusers.deleteUserWithValidToken();
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(MiddlemanAPI_Users.DELETE_USER);
    }

    @Then("API response status code should be {int} no content")
    public void apiResponseStatusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

    @Given("Set request delete user invalid token")
    public void setRequestDeleteUserInvalidToken() {
        middlemanAPIusers.deleteUserWithInValidToken();
    }

    @Given("Set request delete user with invalid path")
    public void setRequestDeleteUserWithInvalidPath() {
        middlemanAPIusers.deleteUserWithValidToken();
    }

    @When("Send request delete user invalid path")
    public void sendRequestDeleteUserInvalidPath() {
        SerenityRest.when().delete(MiddlemanAPI_Users.DELETE_USER_INVALID_PATH);
    }

}
