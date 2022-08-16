package Middleman.StepDefs;

import Middleman.API.MiddlemanAPI_InOutBounds;
import Middleman.API.MiddlemanAPI_Register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class MiddlemanInOutBoundsStepDefs {

        @Steps
        MiddlemanAPI_InOutBounds middlemanAPI_inOutBounds;

        @Given("get all cart on inoutbounds without any authorization")
        public void getAllCartOnInoutboundsWithoutAnyAuthorization() {
                //no any authorization
        }

        @When("Send request get all cart on inoutbounds")
        public void sendRequestGetAllCartOnInoutbounds() {
                SerenityRest.when().get(MiddlemanAPI_InOutBounds.GET_ALL_CART_INOUTBOUNDS);
        }

        @Given("get all cart on inoutbounds with authorized rizky user")
        public void getAllCartOnInoutboundsWithAuthorizedRizkyUser() {
                MiddlemanAPI_InOutBounds.getAllCartInoutboundsUser1();
        }

        @Given("get all cart on inoutbounds with authorized another rizky user")
        public void getAllCartOnInoutboundsWithAuthorizedAnotherRizkyUser() {
                MiddlemanAPI_InOutBounds.getAllCartInoutboundsUser();
        }

        @Given("get all cart on inoutbounds with authorized admin \\(haven't adding product yet)")
        public void getAllCartOnInoutboundsWithAuthorizedAdminHavenTAddingProductYet() {
                MiddlemanAPI_InOutBounds.getAllCartInoutboundsAdmin();
        }

        @Given("get all cart on inoutbounds with authorized admin \\(already added product)")
        public void getAllCartOnInoutboundsWithAuthorizedAdminAlreadyAddedProduct() {
                MiddlemanAPI_InOutBounds.getAllCartInoutboundsAdmin();
        }

        @When("Send request get all cart on inoutbounds on invalid path")
        public void sendRequestGetAllCartOnInoutboundsOnInvalidPath() {
                SerenityRest.when().get(MiddlemanAPI_InOutBounds.GET_ALL_CART_INVALID_INOUTBOUNDS);
        }

        @Then("API response status code should be {int} unauthorized")
        public void apiResponseStatusCodeShouldBeUnauthorized(int unauthorized) {
                SerenityRest.then().statusCode(unauthorized);
        }

    @Given("create a cart on inoutbounds without any authorization with valid json file")
    public void createACartOnInoutboundsWithoutAnyAuthorizationWithValidJsonFile() {
        File jsonFilesCreateCart1 = new File( MiddlemanAPI_InOutBounds.JSON_FILE_INOUTBOUNDS+"/CreateValidInOutBounds.json");
        middlemanAPI_inOutBounds.createCartInoutboundsUnauthorized(jsonFilesCreateCart1);
    }

    @When("Send request create a cart on inoutbounds")
    public void sendRequestCreateACartOnInoutbounds() {
        SerenityRest.when().post(MiddlemanAPI_InOutBounds.CREATE_A_CART_INOUTBOUNDS);
    }

    @Given("create a cart on inoutbounds with authorized rizky user with valid json file")
    public void createACartOnInoutboundsWithAuthorizedRizkyUserWithValidJsonFile() {
        File jsonFilesCreateCart1 = new File( MiddlemanAPI_InOutBounds.JSON_FILE_INOUTBOUNDS+"/CreateValidInOutBounds.json");
        middlemanAPI_inOutBounds.createCartInoutboundsUser1(jsonFilesCreateCart1);
    }

    @Given("create a cart on inoutbounds with authorized another rizky user with valid json file")
    public void createACartOnInoutboundsWithAuthorizedAnotherRizkyUserWithValidJsonFile() {
        File jsonFilesCreateCart1 = new File( MiddlemanAPI_InOutBounds.JSON_FILE_INOUTBOUNDS+"/CreateValidInOutBounds.json");
        middlemanAPI_inOutBounds.createCartInoutboundsUser(jsonFilesCreateCart1);
    }

    @Given("create a cart on inoutbounds with valid json file but product id not found")
    public void createACartOnInoutboundsWithValidJsonFileButProductIdNotFound() {
        File jsonFilesCreateCart2 = new File( MiddlemanAPI_InOutBounds.JSON_FILE_INOUTBOUNDS+"/CreateProductIDNotFound.json");
        middlemanAPI_inOutBounds.createCartInoutboundsUser(jsonFilesCreateCart2);
    }

    @Given("create a cart on inoutbounds with valid json file but product id found")
    public void createACartOnInoutboundsWithValidJsonFileButProductIdFound() {
        File jsonFilesCreateCart1 = new File( MiddlemanAPI_InOutBounds.JSON_FILE_INOUTBOUNDS+"/CreateValidInOutBounds.json");
        middlemanAPI_inOutBounds.createCartInoutboundsUser(jsonFilesCreateCart1);
    }

    @Given("create a cart on inoutbounds with valid json file without product id")
    public void createACartOnInoutboundsWithValidJsonFileWithoutProductId() {
        File jsonFilesCreateCart3 = new File( MiddlemanAPI_InOutBounds.JSON_FILE_INOUTBOUNDS+"/CreateWithoutProductID.json");
        middlemanAPI_inOutBounds.createCartInoutboundsUser(jsonFilesCreateCart3);
    }

    @Given("create a cart on inoutbounds with valid json file without qty")
    public void createACartOnInoutboundsWithValidJsonFileWithoutQty() {
        File jsonFilesCreateCart4 = new File( MiddlemanAPI_InOutBounds.JSON_FILE_INOUTBOUNDS+"/CreateWithoutQty.json");
        middlemanAPI_inOutBounds.createCartInoutboundsUser(jsonFilesCreateCart4);
    }

    @Given("create a cart on inoutbounds with valid json file with invalid product id")
    public void createACartOnInoutboundsWithValidJsonFileWithInvalidProductId() {
        File jsonFilesCreateCart5 = new File( MiddlemanAPI_InOutBounds.JSON_FILE_INOUTBOUNDS+"/CreateInvalidProductID.json");
        middlemanAPI_inOutBounds.createCartInoutboundsUser(jsonFilesCreateCart5);
    }

    @Given("create a cart on inoutbounds with valid json file with invalid qty")
    public void createACartOnInoutboundsWithValidJsonFileWithInvalidQty() {
        File jsonFilesCreateCart6 = new File( MiddlemanAPI_InOutBounds.JSON_FILE_INOUTBOUNDS+"/CreateInvalidQty.json");
        middlemanAPI_inOutBounds.createCartInoutboundsUser(jsonFilesCreateCart6);
    }

    @Given("create a cart on inoutbounds with authorized admin with valid json file")
    public void createACartOnInoutboundsWithAuthorizedAdminWithValidJsonFile() {
        File jsonFilesCreateCart1 = new File( MiddlemanAPI_InOutBounds.JSON_FILE_INOUTBOUNDS+"/CreateValidInOutBounds.json");
        middlemanAPI_inOutBounds.createCartInoutboundsAdmin(jsonFilesCreateCart1);
    }

    @Given("create a cart on inoutbounds with valid json file")
    public void createACartOnInoutboundsWithValidJsonFile() {
        File jsonFilesCreateCart1 = new File( MiddlemanAPI_InOutBounds.JSON_FILE_INOUTBOUNDS+"/CreateValidInOutBounds.json");
        middlemanAPI_inOutBounds.createCartInoutboundsAdmin(jsonFilesCreateCart1);
    }

    @When("Send request create a cart on inoutbounds on invalid path")
    public void sendRequestCreateACartOnInoutboundsOnInvalidPath() {
        SerenityRest.when().post(MiddlemanAPI_InOutBounds.CREATE_A_CART_INVALID_INOUTBOUNDS);
    }

    @Given("update qty product id {string} added on inoutbounds with valid json file")
    public void updateQtyProductIdAddedOnInoutboundsWithValidJsonFile(String id) {
        File jsonFilesUpdateCart1 = new File( MiddlemanAPI_InOutBounds.JSON_FILE_INOUTBOUNDS+"/UpdateValidInOutBounds.json");
        middlemanAPI_inOutBounds.updateQtyInoutboundsUser(jsonFilesUpdateCart1,id);
    }

    @When("Send request update qty product added on inoutbounds")
    public void sendRequestUpdateQtyProductAddedOnInoutbounds() {
        SerenityRest.when().put(MiddlemanAPI_InOutBounds.UPDATE_A_CART_INOUTBOUNDS);
    }

    @Given("update invalid qty product id {string} added on inoutbounds with valid json file")
    public void updateInvalidQtyProductIdAddedOnInoutboundsWithValidJsonFile(String id) {
        File jsonFilesUpdateCart2 = new File( MiddlemanAPI_InOutBounds.JSON_FILE_INOUTBOUNDS+"/UpdateInvalidQty.json");
        middlemanAPI_inOutBounds.updateQtyInoutboundsUser(jsonFilesUpdateCart2,id);
    }

    @Given("update empty qty product id {string} added on inoutbounds with valid json file")
    public void updateEmptyQtyProductIdAddedOnInoutboundsWithValidJsonFile(String id) {
        File jsonFilesUpdateCart3 = new File( MiddlemanAPI_InOutBounds.JSON_FILE_INOUTBOUNDS+"/UpdateEmptyQty.json");
        middlemanAPI_inOutBounds.updateQtyInoutboundsUser(jsonFilesUpdateCart3,id);
    }

    @When("Send request update qty product added on inoutbounds on invalid path")
    public void sendRequestUpdateQtyProductAddedOnInoutboundsOnInvalidPath() {
        SerenityRest.when().put(MiddlemanAPI_InOutBounds.UPDATE_A_CART_INVALID_INOUTBOUNDS);

    }

    @Given("delete product id {string} added on inoutbounds")
    public void deleteProductIdAddedOnInoutbounds(String id) {
        middlemanAPI_inOutBounds.deleteProductCartInoutboundsUnauthorized(id);
    }

    @When("Send request delete product added on inoutbounds")
    public void sendRequestDeleteProductAddedOnInoutbounds() {
        SerenityRest.when().delete(MiddlemanAPI_InOutBounds.DELETE_PRODUCTS_INOUTBOUNDS);
    }

    @When("Send request delete product added on inoutbounds on invalid path")
    public void sendRequestDeleteProductAddedOnInoutboundsOnInvalidPath() {
        SerenityRest.when().delete(MiddlemanAPI_InOutBounds.DELETE_PRODUCTS_INVALID_INOUTBOUNDS);
    }

    @Given("admin update qty product id {string} added on inoutbounds with valid json file")
    public void adminUpdateQtyProductIdAddedOnInoutboundsWithValidJsonFile(String id) {
        File jsonFilesUpdateCart1 = new File( MiddlemanAPI_InOutBounds.JSON_FILE_INOUTBOUNDS+"/UpdateValidInOutBounds.json");
        middlemanAPI_inOutBounds.updateQtyInoutboundsAdmin(jsonFilesUpdateCart1,id);
    }

    @Given("admin update invalid qty product id {string} added on inoutbounds with valid json file")
    public void adminUpdateInvalidQtyProductIdAddedOnInoutboundsWithValidJsonFile(String id) {
        File jsonFilesUpdateCart2 = new File( MiddlemanAPI_InOutBounds.JSON_FILE_INOUTBOUNDS+"/UpdateInvalidQty.json");
        middlemanAPI_inOutBounds.updateQtyInoutboundsAdmin(jsonFilesUpdateCart2,id);
    }

    @Given("admin update empty qty product id {string} added on inoutbounds with valid json file")
    public void adminUpdateEmptyQtyProductIdAddedOnInoutboundsWithValidJsonFile(String id) {
        File jsonFilesUpdateCart3 = new File( MiddlemanAPI_InOutBounds.JSON_FILE_INOUTBOUNDS+"/UpdateEmptyQty.json");
        middlemanAPI_inOutBounds.updateQtyInoutboundsAdmin(jsonFilesUpdateCart3,id);
    }

    @Given("user delete product id {string} added on inoutbounds")
    public void userDeleteProductIdAddedOnInoutbounds(String id) {
        middlemanAPI_inOutBounds.deleteProductCartInoutboundsUser(id);
    }

    @Given("admin delete product id {string} added on inoutbounds")
    public void adminDeleteProductIdAddedOnInoutbounds(String id) {
        middlemanAPI_inOutBounds.deleteProductCartInoutboundsAdmin(id);
    }
}
