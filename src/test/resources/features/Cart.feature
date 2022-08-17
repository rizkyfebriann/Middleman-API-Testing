Feature: Cart

  @cart @loginErnaUser
  Scenario: Create new product to cart (authorized user) with valid id
    Given User create new product to cart with valid product id
    When Send request create product to the cart
    Then API response status code should be 201 created
    And response body should contains code 201 and message "success"

  @cart @loginErnaUser
  Scenario: Create new products to cart (authorized user) with invalid product id
    Given User create new product to cart with invalid product id
    When Send request create product to the cart
    Then API response status code should be 404 not found

  @cart
  Scenario: Create new products to the cart (unauthorized user)
    Given Create new product to cart without any unauthorized user
    When Send request create product to the cart
    Then API response status code should be 400 bad request

  Scenario: Create new product to cart with valid product id and qty exceeds stock product
    Given Create new product to cart with valid id and qty exceeds stock product
    When Send request create product to the cart
    Then API response status code should be 400 bad request

  @cart @loginErnaUser
  Scenario: Create new product to cart with valid product id and multiple qty
    Given Create new product to cart with valid id and multiple qty
    When Send request create product to the cart
    Then API response status code should be 201 created
    And response body should contains code 201 and message "success"

  @cart @loginErnaUser
  Scenario: Create new product to cart (authorized user) with empty qty
    Given Create new product to cart with empty qty
    When Send request create product to the cart
    Then API response status code should be 400 bad request

  @cart @loginErnaUser
  Scenario: Create new product to cart(authorized user) without qty
    Given Create new product to cart without qty
    When Send request create product to the cart
    Then API response status code should be 400 bad request

  @cart @loginErnaUser
  Scenario: Create new product to cart(authorized user) with invalid path
    Given Create new product to cart with invalid path
    When Send request create product to the cart with invalid path
    Then API response status code should be 404 not found

  @cart @loginErnaUser
  Scenario: Get all cart with valid product id (authorized user)
    Given Set request get all cart with authorized user
    When Send request get all cart
    Then API response status code should be 200 OK
    And Get all cart assert json validation

  @cart
  Scenario: Get all cart with valid product id (unauthorized user)
    Given Set request get all cart with unauthorized user
    When Send request get all cart
    Then API response status code should be 400 bad request

  @cart
  Scenario: Get all cart with invalid path (authorized user)
    Given Set request get all cart with invalid path
    When Send request get all cart with invalid path
    Then API response status code should be 404 not found

  @cart @loginErnaUser
  Scenario: Update qty of products added in cart (authorized user)
    Given Update qty in cart with product id "1"
    When Send request update qty product added on cart
    Then API response status code should be 200 OK

  @cart @loginErnaUser
  Scenario: Update qty of products added in cart (authorized user)
    Given Update qty in cart with product id "1"
    When Send request update qty product added on cart
    Then API response status code should be 200 OK
    And response body should contains code 200 and message "success"

  @cart @loginErnaUser
  Scenario: Update qty of products added in cart (authorized user) with invalid product id
    Given Update qty in cart with invalid product id "100"
    When Send request update qty product added on cart
    Then API response status code should be 404 not found

  @cart @loginErnaUser
  Scenario: Update qty of products added in cart (authorized user) without product id
    Given Update qty in cart without product id ""
    When Send request update qty product added on cart
    Then API response status code should be 404 not found

  @cart @loginErnaUser
  Scenario: Update qty of products added in cart (authorized user) with empty qty
    Given Update product id "1" in cart with empty qty
    When Send request update qty product added on cart
    Then API response status code should be 400 bad request

  @user @loginErnaUser
  Scenario: Delete qty of product on cart (authorized user) with valid id product
    Given Set request Delete qty in cart with product id "4"
    When Send request delete product on cart
    Then API response status code should be 200 OK

  @user
  Scenario: Delete qty of product on cart with valid id product (unauthorized user)
    Given Set request Delete qty in cart with product id "4"
    When Send request delete product on cart
    Then API response status code should be 400 bad request

  @user @loginErnaUser
  Scenario: Delete qty of product on cart with product id not found (authorized user)
    Given Set request Delete qty in cart with product id "100"
    When Send request delete product on cart
    Then API response status code should be 404 not found

  @user @loginErnaUser
  Scenario: Delete qty product on cart with invalid path
    Given Delete qty in cart with product id "6" on invalid path
    When Send request delete product on cart with invalid path
    Then API response status code should be 404 not found




















