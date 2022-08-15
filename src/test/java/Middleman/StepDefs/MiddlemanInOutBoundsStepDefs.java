package Middleman.StepDefs;

import Middleman.API.MiddlemanAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class MiddlemanInOutBoundsStepDefs {

        @Steps
        MiddlemanAPI middlemanAPI;

        @Given("get all cart on inoutbounds without any authorization")
        public void getAllCartOnInoutboundsWithoutAnyAuthorization() {
                //no any authorization
        }

        @When("Send request get all cart on inoutbounds")
        public void sendRequestGetAllCartOnInoutbounds() {
                SerenityRest.when().get(MiddlemanAPI.GET_ALL_CART_INOUTBOUNDS);
        }

        @Given("get all cart on inoutbounds with authorized rizky user")
        public void getAllCartOnInoutboundsWithAuthorizedRizkyUser() {
                MiddlemanAPI.getAllCartInoutboundsUser();
        }

        @Given("get all cart on inoutbounds with authorized another rizky user")
        public void getAllCartOnInoutboundsWithAuthorizedAnotherRizkyUser() {
                MiddlemanAPI.getAllCartInoutboundsUser1();
        }

        @Given("get all cart on inoutbounds with authorized admin \\(haven't adding product yet)")
        public void getAllCartOnInoutboundsWithAuthorizedAdminHavenTAddingProductYet() {
                MiddlemanAPI.validTokenAdmins();
        }

        @Given("get all cart on inoutbounds with authorized admin \\(already added product)")
        public void getAllCartOnInoutboundsWithAuthorizedAdminAlreadyAddedProduct() {
                MiddlemanAPI.validTokenAdmins();
        }

        @When("Send request get all cart on inoutbounds on invalid path")
        public void sendRequestGetAllCartOnInoutboundsOnInvalidPath() {
                SerenityRest.when().get(MiddlemanAPI.GET_ALL_CART_INVALID_INOUTBOUNDS);
        }

        @Then("API response status code should be {int} unauthorized")
        public void apiResponseStatusCodeShouldBeUnauthorized(int unauthorized) {
                SerenityRest.then().statusCode(unauthorized);
        }
}
