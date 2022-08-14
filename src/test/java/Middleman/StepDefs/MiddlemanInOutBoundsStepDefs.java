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

    @Given("Get all cart on inoutbounds with no any authorization token")
    public void getAllCartOnInoutboundsWithValidJsonFile() {
        middlemanAPI.getAllCartsInoutboundsUnauthorized();
    }

    @When("Send request get all cart on inoutbounds")
    public void sendRequestGetAllCartOnInoutbounds() {
        SerenityRest.when().get(MiddlemanAPI.GET_ALL_CARTS_INOUTBOUNDS);
    }

    @Given("Get all cart on inoutbounds with authorized user Rizky")
    public void getAllCartOnInoutboundsWithAuthorizedUserRizky() {
        middlemanAPI.getAllCartsInoutboundsAuthorizeduserRizky();
    }

}
