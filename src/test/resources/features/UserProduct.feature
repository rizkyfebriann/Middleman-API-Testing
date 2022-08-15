Feature: User_Product

  @user_product
  Scenario: Get product user with valid bearer token
    Given Set request get product user with valid token
    When Send request get product user
    Then API response status code should be 200 OK
    And Get product user assert json validation

  @user_product
  Scenario: Get product user with invalid bearer token
    Given Set request get product user with invalid token
    When Send request get product user
    Then API response status code should be 401 Unauthorized

  @user_product
  Scenario: Get product user with invalid path
    Given Set request get product user with invalid path
    When Send request get product user with invalid path
    Then API response status code should be 404 not found

  @user_product
  Scenario: Get product user without bearer token
    Given Set request get product user without token
    When Send request get product user
    Then API response status code should be 400 bad request

  @user_product
  Scenario: Create product user with all valid data
    Given Create product user with valid json file
    When Send request post product user
    Then API response status code should be 201 created
    And response body should contains code 201 and message "success create product"

  @user_product
  Scenario: Create product user with all data on empty token
    Given Create product user with all data on empty token
    When Send request post product user
    Then API response status code should be 400 bad request

  @user_product
  Scenario: Create product user with invalid token
    Given Create product user with invalid token
    When Send request post product user
    Then API response status code should be 401 Unauthorized

#    BUG
  @user_product
  Scenario: Create product user with price not valid
    Given Create product user with price not valid
    When Send request post product user
    Then API response status code should be 400 bad request

  @user_product
  Scenario: Create product user with empty price value
    Given Create product user with empty price value
    When Send request post product user
    Then API response status code should be 400 bad request

#    BUG
  @user_product
  Scenario: Create product user without product_image
    Given Create product user with empty product image
    When Send request post product user
    Then API response status code should be 201 created

  @user_product
  Scenario: Update product user with all valid data & valid token
    Given Update product user with id 26 on valid token
    When Send request put product user
    Then API response status code should be 200 OK
    And response body should contains code 200 and message "success update data"

  @user_product
  Scenario: Update product user with all valid data & invalid token
    Given Update product user with id 26 on invalid token
    When Send request put product user
    Then API response status code should be 401 Unauthorized

  @user_product
  Scenario: Update product user without price
    Given Update product user without price on id 27
    When Send request put product user
    Then API response status code should be 200 OK

  @user_product
  Scenario: Update product user without image
    Given Update product user without image on id 27
    When Send request put product user
    Then API response status code should be 200 OK

#  Scenario: Update product user with all data &  price not valid
#    Given Update product user with price not valid on id 27
#    When Send request put product user
#    Then API response status code should be 400 bad request

  @user_product
  Scenario: Update product user with invalid path
    Given Update product user with invalid path on id 27
    When Send request put product user with invalid path
    Then API response status code should be 404 not found

#    BUG
  @user_product
  Scenario: Delete product user with valid token & registered id product
    Given Set request delete product user with id 24
    When Send request delete product user
    Then API response status code should be 200 OK

  @user_product
  Scenario: Delete product user with valid token on invalid path
    Given Set request delete product user id 25 with invalid path
    When Send request delete product user with invalid path
    Then API response status code should be 404 not found

  @user_product
  Scenario: Delete product user with invalid token
    Given Set request delete product user with id 24 on invalid token
    When Send request delete product user
    Then API response status code should be 401 Unauthorized

































