Feature: Orders

  @orders
  Scenario: Create orders (unauthorized user)
    Given create order unauthorized with valid json file
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders
  Scenario: Create orders (authorized with invalid user)
    Given create order authorized invalid user token with valid json file
    When Send request create orders
    Then API response status code should be 401 unauthorized

  @orders @loginUserValidTesting
  Scenario: Create orders with valid 1 products
    Given create order with valid one products
    When Send request create orders
    Then API response status code should be 201 created

#scenario ini masih error
  @orders @loginRizkyUser1
  Scenario: User create orders but haven't created any carts
    Given create order with valid one products
    When Send request create orders
    Then API response status code should be 400 bad request

#scenario ini masih error
  @orders @loginUserValidTesting
  Scenario: User create orders with empty products on carts
    Given create order with empty products
    When Send request create orders
    Then API response status code should be 400 bad request

#scenario ini masih error
  @orders @loginUserValidTesting
  Scenario: User create orders with other user product added on their carts
    Given create order with valid one products from other user carts
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders with invalid id products
    Given create order with invalid id of products
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders without id products
    Given create order without id of products
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders with empty id products
    Given create order with empty id of products
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders with id products not found
    Given create order with id products not found
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders with different id products from product added on carts
    Given create order with different id products from our carts
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders with invalid product name
    Given create order with invalid name of products
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders without product name
    Given create order without name of products
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders with empty product name
    Given create order with empty name of products
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders with iproduct name not found
    Given create order with product name not found
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders with different product name from product added on carts
    Given create order with different product name from our carts
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders with invalid unit
    Given create order with invalid unit of products
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders without unit
    Given create order without unit of products
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders with empty unit
    Given create order with empty unit of products
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders with different uniy from product added on carts
    Given create order with different unit from our carts
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders with invalid qty
    Given create order with invalid qty of products
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders without qty
    Given create order without qty of products
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders with empty qty
    Given create order with empty qty of products
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders with different qty from product added on carts
    Given create order with different qty from our carts
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders with invalid subtotal
    Given create order with invalid subtotal of products
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders without subtotal
    Given create order without subtotal of products
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders with empty subtotal
    Given create order with empty subtotal of products
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders with different subtotal from product added on carts
    Given create order with different subtotal from our carts
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders with invalid grand total
    Given create order with invalid grand total of products
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders without grand total
    Given create order without grand total of products
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders with empty grand total
    Given create order with empty grand total of products
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders with different grand total from product added on carts
    Given create order with different grand total from our carts
    When Send request create orders
    Then API response status code should be 400 bad request

  @orders @loginUserValidTesting
  Scenario: User create orders on invalid path
    Given create order with valid one products
    When Send request create orders on invalid path
    Then API response status code should be 404 not found

  @orders
  Scenario: User get all orders (authorized with invalid token
    Given get all orders authorized with invalid token
    When Send request get all orders
    Then API response status code should be 401 unauthorized

  @orders @loginUserValidTesting
  Scenario: User get all orders with already created orders
    Given get all orders user which already created orders
    When Send request get all orders
    Then API response status code should be 200 OK

  @orders @loginRizkyUser1
  Scenario: User get all orders with haven't create orders
    Given get all orders user which haven't already create orders
    When Send request get all orders
    Then API response status code should be 200 OK

  @orders @loginUserValidTesting
  Scenario: User get all orders on invalid path
    Given get all orders user which already created orders
    When Send request get all orders on invalid path
    Then API response status code should be 404 not found

  @orders
  Scenario: User get detail orders (unauthorized)
    Given get detail order unauthorized with id "1661001285"
    When Send request get detail orders
    Then API response status code should be 400 bad request

  @orders
  Scenario: User get detail orders (authorized with invalid user)
    Given get detail order authorized with invalid user with id "1661001285"
    When Send request get detail orders
    Then API response status code should be 401 unauthorized

  @orders @loginUserValidTesting
  Scenario: User get detail orders with valid id order from existing user
    Given get detail order with id "1661001285"
    When Send request get detail orders
    Then API response status code should be 200 OK

  @orders @loginUserValidTesting
  Scenario: User get detail orders with valid id order from other user
    Given get detail order with id "1661001300"
    When Send request get detail orders
    Then API response status code should be 404 not found

  @orders @loginUserValidTesting
  Scenario: User get detail orders with invalid id order
    Given get detail order with id "58"
    When Send request get detail orders
    Then API response status code should be 404 not found

  @orders @loginUserValidTesting
  Scenario: User get detail orders on invalid path
    Given get detail order with id "1661001285"
    When Send request get detail orders on invalid path
    Then API response status code should be 404 not found

  @orders @loginAdmins
  Scenario: Admin get all orders with few users already created orders
    Given get all orders user which few users already created orders
    When Send request get all orders
    Then API response status code should be 200 OK

  @orders @loginAdmins
  Scenario: Admins get all orders on invalid path
    Given get all orders user which few users already created orders
    When Send request get all orders on invalid path
    Then API response status code should be 404 not found

  @orders @loginAdmins
  Scenario: Admin get detail orders with valid id order
    Given get detail order with id "1661001285"
    When Send request get detail orders
    Then API response status code should be 200 OK

  @orders @loginAdmins
  Scenario: Admin get detail orders with invalid id order
    Given get detail order with id "58"
    When Send request get detail orders
    Then API response status code should be 404 not found

  @orders @loginAdmins
  Scenario: Admin get detail orders on invalid path
    Given get detail order with id "1661001285"
    When Send request get detail orders on invalid path
    Then API response status code should be 404 not found

  @orders
  Scenario: Admin get incoming orders (unauthorized)
    When Send request get incoming orders
    Then API response status code should be 400 bad request

  @orders @loginAdmins
  Scenario: Admin get incoming orders
    Given get incoming orders on admin
    When Send request get incoming orders
    Then API response status code should be 200 OK

  @orders @loginAdmins
  Scenario: Admin get incoming orders
    Given get incoming orders on admin
    When Send request get incoming orders on invalid path
    Then API response status code should be 404 not found

  @orders @loginAdmins
  Scenario: Admin confirm orders with valid id order
    Given PUT confirm orders on admin with id orders "1661001285"
    When Send request PUT confirm orders
    Then API response status code should be 200 OK

  @orders @loginAdmins
  Scenario: Admin confirm orders with invalid id order
    Given PUT confirm orders on admin with id orders "58"
    When Send request PUT confirm orders
    Then API response status code should be 400 bad request

  @orders @loginAdmins
  Scenario: Admin finish orders with valid id order
    Given PUT finish orders on admin with id orders "1661001285"
    When Send request PUT finish orders
    Then API response status code should be 200 OK

  @orders @loginAdmins
  Scenario: Admin finish orders with invalid id order
    Given PUT finish orders on admin with id orders "58"
    When Send request PUT finish orders
    Then API response status code should be 400 bad request


