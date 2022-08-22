package Middleman.StepDefs;

import Middleman.API.MiddlemanAPI_Orders;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class MiddlemanOrdersStepDefs {

    @Steps
    MiddlemanAPI_Orders middlemanAPI_orders;

    @Given("create order unauthorized with valid json file")
    public void createOrderUnauthorizedWithValidJsonFile() {
        File jsonFilesCreateOrderUnauthorized = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersValid1Products.json");
        middlemanAPI_orders.createOrdersUnauthorized(jsonFilesCreateOrderUnauthorized);
    }

    @When("Send request create orders")
    public void sendRequestCreateOrders() {
        SerenityRest.when().post(MiddlemanAPI_Orders.CREATE_ORDERS);
    }

    @Given("create order authorized invalid user token with valid json file")
    public void createOrderAuthorizedInvalidUserTokenWithValidJsonFile() {
        File jsonFilesCreateOrderAuthorizedInvalid = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersValid1Products.json");
        middlemanAPI_orders.createOrdersInvalidUser(jsonFilesCreateOrderAuthorizedInvalid);
    }


    @Given("create order with valid one products")
    public void createOrderWithValidOneProducts() {
        File jsonFilesCreateOrderValid = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersValid1Products.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrderValid);
    }

    @Given("create order with empty products")
    public void createOrderWithEmptyProducts() {
        File jsonFilesCreateOrderEmpty = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersEmptyProductsOnBody.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrderEmpty);
    }

    @Given("create order with valid one products from other user carts")
    public void createOrderWithValidOneProductsFromOtherUserCarts() {
        File jsonFilesCreateOrderOtherUser = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersWithOthersUserCartsProduct.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrderOtherUser);
    }

    @Given("create order with invalid id of products")
    public void createOrderWithInvalidIdOfProducts() {
        File jsonFilesCreateOrderID1 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersInvalidIDProducts.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrderID1);
    }

    @Given("create order without id of products")
    public void createOrderWithoutIdOfProducts() {
        File jsonFilesCreateOrderID2 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersWithoutIDProducts.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrderID2);
    }

    @Given("create order with empty id of products")
    public void createOrderWithEmptyIdOfProducts() {
        File jsonFilesCreateOrderID3 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersWithEmptyIDProducts.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrderID3);
    }

    @Given("create order with id products not found")
    public void createOrderWithIdProductsNotFound() {
        File jsonFilesCreateOrderID4 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersIDProductsNotFound.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrderID4);
    }

    @Given("create order with different id products from our carts")
    public void createOrderWithDifferentIdProductsFromOurCarts() {
        File jsonFilesCreateOrderID5 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersIDProductsDifferent.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrderID5);
    }

    @Given("create order with invalid name of products")
    public void createOrderWithInvalidNameOfProducts() {
        File jsonFilesCreateOrdeName1 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersInvalidProductName.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrdeName1);
    }

    @Given("create order without name of products")
    public void createOrderWithoutNameOfProducts() {
        File jsonFilesCreateOrdeName2 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersWithoutProductName.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrdeName2);

    }

    @Given("create order with empty name of products")
    public void createOrderWithEmptyNameOfProducts() {
        File jsonFilesCreateOrdeName3 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersWithEmptyProductName.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrdeName3);
    }

    @Given("create order with product name not found")
    public void createOrderWithProductNameNotFound() {
        File jsonFilesCreateOrdeName4 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersProductNameNotFound.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrdeName4);
    }

    @Given("create order with different product name from our carts")
    public void createOrderWithDifferentProductNameFromOurCarts() {
        File jsonFilesCreateOrdeName5 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersProductNameDifferent.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrdeName5);
    }

    @Given("create order with invalid unit of products")
    public void createOrderWithInvalidUnitOfProducts() {
        File jsonFilesCreateOrdeUnit1 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersInvalidUnitProducts.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrdeUnit1);
    }

    @Given("create order without unit of products")
    public void createOrderWithoutUnitOfProducts() {
        File jsonFilesCreateOrdeUnit2 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersWithoutUnitProduct.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrdeUnit2);
    }

    @Given("create order with empty unit of products")
    public void createOrderWithEmptyUnitOfProducts() {
        File jsonFilesCreateOrdeUnit3 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersWithEmptyUnitProducts.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrdeUnit3);
    }

    @Given("create order with different unit from our carts")
    public void createOrderWithDifferentUnitFromOurCarts() {
        File jsonFilesCreateOrdeUnit4 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersDifferentUnitProducts.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrdeUnit4);
    }

    @Given("create order with invalid qty of products")
    public void createOrderWithInvalidQtyOfProducts() {
        File jsonFilesCreateOrderQty1 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersInvalidQtyProducts.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrderQty1);
    }

    @Given("create order without qty of products")
    public void createOrderWithoutQtyOfProducts() {
        File jsonFilesCreateOrderQty1 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersWithoutQtyProducts.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrderQty1);
    }

    @Given("create order with empty qty of products")
    public void createOrderWithEmptyQtyOfProducts() {
        File jsonFilesCreateOrderQty2 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersWithEmptyQtyProducts.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrderQty2);
    }

    @Given("create order with different qty from our carts")
    public void createOrderWithDifferentQtyFromOurCarts() {
        File jsonFilesCreateOrderQty3 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersDifferentQtyProducts.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrderQty3);
    }

    @Given("create order with invalid subtotal of products")
    public void createOrderWithInvalidSubtotalOfProducts() {
        File jsonFilesCreateOrderSubtotal1 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersInvalidSubtotalProducts.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrderSubtotal1);
    }

    @Given("create order without subtotal of products")
    public void createOrderWithoutSubtotalOfProducts() {
        File jsonFilesCreateOrderSubtotal2 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersWithoutSubtotalProducts.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrderSubtotal2);
    }

    @Given("create order with empty subtotal of products")
    public void createOrderWithEmptySubtotalOfProducts() {
        File jsonFilesCreateOrderSubtotal3 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersWithEmptySubtotalProducts.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrderSubtotal3);
    }

    @Given("create order with different subtotal from our carts")
    public void createOrderWithDifferentSubtotalFromOurCarts() {
        File jsonFilesCreateOrderSubtotal4 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersDifferentSubtotalProducts.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrderSubtotal4);
    }

    @Given("create order with invalid grand total of products")
    public void createOrderWithInvalidGrandTotalOfProducts() {
        File jsonFilesCreateOrderGrandtotal1 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersInvalidGrandTotalProducts.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrderGrandtotal1);
    }

    @Given("create order without grand total of products")
    public void createOrderWithoutGrandTotalOfProducts() {
        File jsonFilesCreateOrderGrandtotal2 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersWithoutGrandTotalProducts.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrderGrandtotal2);
    }

    @Given("create order with empty grand total of products")
    public void createOrderWithEmptyGrandTotalOfProducts() {
        File jsonFilesCreateOrderGrandtotal3 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersEmptyGrandTotalProducts.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrderGrandtotal3);
    }

    @Given("create order with different grand total from our carts")
    public void createOrderWithDifferentGrandTotalFromOurCarts() {
        File jsonFilesCreateOrderGrandtotal3 = new File( MiddlemanAPI_Orders.JSON_FILE_ORDERS+"/CreateOrdersDifferentGrandTotalProducts.json");
        middlemanAPI_orders.createOrdersValidUser(jsonFilesCreateOrderGrandtotal3);
    }

    @When("Send request create orders on invalid path")
    public void sendRequestCreateOrdersOnInvalidPath() {
        SerenityRest.when().post(MiddlemanAPI_Orders.CREATE_ORDERS_INVALID_PATH);
    }

    @Given("get all orders authorized with invalid token")
    public void getAllOrdersAuthorizedWithInvalidToken() {
        MiddlemanAPI_Orders.getAllOrdersInvalidUser();
    }

    @When("Send request get all orders")
    public void sendRequestGetAllOrders() {
        SerenityRest.when().get(MiddlemanAPI_Orders.GET_ALL_ORDERS);
    }

    @Given("get all orders user which already created orders")
    public void getAllOrdersUserWhichAlreadyCreatedOrders() {
        MiddlemanAPI_Orders.getAllOrdersUser();
    }

    @Given("get all orders user which haven't already create orders")
    public void getAllOrdersUserWhichHavenTAlreadyCreateOrders() {
        MiddlemanAPI_Orders.getAllOrdersUser();
    }

    @When("Send request get all orders on invalid path")
    public void sendRequestGetAllOrdersOnInvalidPath() {
        SerenityRest.when().get(MiddlemanAPI_Orders.GET_ALL_ORDERS_INVALID_PATH);
    }

    @Given("get detail order unauthorized with id {string}")
    public void getDetailOrderUnauthorized(String id) {
        MiddlemanAPI_Orders.getDetailOrdersUnauthorized(id);
    }

    @When("Send request get detail orders")
    public void sendRequestGetDetailOrders() {
        SerenityRest.when().get(MiddlemanAPI_Orders.GET_DETAIL_ORDERS);
    }

    @Given("get detail order authorized with invalid user with id {string}")
    public void getDetailOrderAuthorizedWithInvalidUser(String id) {
        MiddlemanAPI_Orders.getDetailOrdersInvalidUser(id);
    }

    @Given("get detail order with id {string}")
    public void getDetailOrderWithId(String id) {
        MiddlemanAPI_Orders.getDetailOrdersUser(id);
    }

    @When("Send request get detail orders on invalid path")
    public void sendRequestGetDetailOrdersOnInvalidPath() {
        SerenityRest.when().get(MiddlemanAPI_Orders.GET_DETAIL_ORDERS_INVALID_PATH);
    }

    @Given("get all orders user which few users already created orders")
    public void getAllOrdersUserWhichFewUsersAlreadyCreatedOrders() {
        MiddlemanAPI_Orders.getAllOrdersAdmin();
    }

    @When("Send request get incoming orders")
    public void sendRequestGetIncomingOrders() {
        SerenityRest.when().get(MiddlemanAPI_Orders.ADMIN_GET_INCOMING_ORDERS);
    }

    @Given("get incoming orders on admin")
    public void getIncomingOrdersOnAdmin() {
        MiddlemanAPI_Orders.getIncomingOrdersAdmin();
    }

    @When("Send request get incoming orders on invalid path")
    public void sendRequestGetIncomingOrdersOnInvalidPath() {
        SerenityRest.when().get(MiddlemanAPI_Orders.ADMIN_GET_INCOMING_ORDERS_INVALID_PATH);
    }

    @Given("PUT confirm orders on admin with id orders {string}")
    public void getConfirmOrdersOnAdminWithIdOrders(String id) {
        MiddlemanAPI_Orders.PUTConfirmOrder(id);
    }

    @When("Send request PUT confirm orders")
    public void sendRequestPUTConfirmOrders() {
        SerenityRest.when().put(MiddlemanAPI_Orders.ADMIN_CONFIRM_ORDERS);
    }

    @Given("PUT finish orders on admin with id orders {string}")
    public void putFinishOrdersOnAdminWithIdOrders(String id) {
        MiddlemanAPI_Orders.PUTFinishOrder(id);
    }

    @When("Send request PUT finish orders")
    public void sendRequestPUTFinishOrders() {
        SerenityRest.when().put(MiddlemanAPI_Orders.ADMIN_FINISH_ORDERS);
    }
}
