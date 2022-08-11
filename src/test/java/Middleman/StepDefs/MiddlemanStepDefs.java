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

import static org.hamcrest.Matchers.equalTo;

public class MiddlemanStepDefs {

    @Steps
    MiddlemanAPI middlemanAPI;

    @Given("Post login user with valid json file")
    public void postLoginUserWithValidJsonFile() {
        File jsonFiles = new File( MiddlemanAPI.JSON_FILE+"/ValidLoginUser.json");
        middlemanAPI.postLoginUserOrAdmin(jsonFiles);
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
        File jsonFile = new File(MiddlemanAPI.JSON_FILE+"/ValidLoginUserValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
}
