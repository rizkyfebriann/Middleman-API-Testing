Feature: Admins

  @Admins @Positive
  Scenario: Get all product admins with valid data
    Given Get all product admins with valid json file
    When Send request get all product admins
    Then Status code should be 200 OK
    And Get all product admins assert json validation

  @Admins @Negative
  Scenario: Get all product admins with invalid path
    Given Get all product admins with valid json file
    When Send request get all product admins with invalid path
    Then Status code should be 404 not found

  @Admins @Positive
  Scenario: Get search product admins with valid product name
    Given Get search product admins with valid product name
    When Send request get search with valid product name
    Then Status code should be 200 OK
    And Get all search product admins assert json validation

  @Admins @Positive
  Scenario: Get search product with one alphabet contains from product name
    Given Get search product admins with one alphabet contains from product name
    When Send request get search with one alphabet contains from product name
    Then Status code should be 200 OK
    And Get all search product admins assert json validation

  @Admins @Positive
  Scenario: Get search product with two alphabet contains from product name
    Given Get search product with two alphabet contains from product name
    When Send request get search with two alphabet contains from product name
    Then Status code should be 200 OK
    And Get all search product admins assert json validation

  @Admins @Negative
  Scenario: Get search product admins with invalid keyword value
    Given Get search product admins with invalid keyword value
    When Send request get search with invalid keyword
    Then Status code should be 200 OK
    And Get all search product admins assert json validation

  @Admins @Negative
  Scenario: Get search product admins with invalid path param
    Given Get search product admins with invalid path param
    When Send request get search with invalid path param
    Then Status code should be 404 not found

  @Admins @Positive @loginAdmins
  Scenario: Post create a new product admins with valid data
    When Send post create product admins with valid json file
    When Send request post create a new product admins
    Then Status code should be 201 created

  @Admins @Negative @loginAdmins
  Scenario: Post create a new product admins with invalid stock
    When Send post create product admins with invalid stock on json file
    When Send request post create a new product admins
    Then Status code should be 400 wrong input

  @Admins @Negative @loginAdmins
  Scenario: Post create a new product admins with invalid price
    When Send post create product admins with invalid price on json file
    When Send request post create a new product admins
    Then Status code should be 400 wrong input

  @Admins @Negative @loginAdmins
  Scenario: Post create a new product admins with registered product name
    When Send post create product admins with registered product name on json file
    When Send request post create a new product admins
    Then Status code should be 500 and response body "failed to get file"

  @Admins @Negative @InvalidToken
  Scenario: Post create a new product admins with invalid bearer token
    When Send post create product admins with valid json file
    When Send request post create a new product admins
    Then Status code should be 401 unauthorized

  @Admins @Negative
  Scenario: Post create a new product admins without bearer token
    When Send post create product admins with valid json file
    When Send request post create a new product admins
    Then Status code should be 400 bad request

  @Admins @Positive @loginAdmins
  Scenario: Put update product admins
    When Send put update product admins with valid json file
    When Send request put update admins
    Then Status code should be 200 OK

  @Admins @Positive @loginAdmins
  Scenario: Put update product admins without product name and stock
    When Send put update product admins without product name and stock on json file
    When Send request put update admins
    Then Status code should be 200 OK

  @Admins @Positive @loginAdmins
  Scenario: Put update product admins without unit and price
    When Send put update product admins without product unit and price on json file
    When Send request put update admins
    Then Status code should be 200 OK

  @Admins @Positive @loginAdmins
  Scenario: Put update product admins without product image
    When Send put update product admins without product image on json file
    When Send request put update admins
    Then Status code should be 200 OK

  @Admins @Negative @loginAdmins
  Scenario: Put update product admins with invalid stock
    When Send put update product admins with invalid stock json file
    When Send request put update admins
    Then Status code should be 400 wrong input

  @Admins @Positive @loginAdmins
  Scenario: Put update product admins with empty data
    When Send put update product admins with empty data on json file
    When Send request put update admins
    Then Status code should be 200 OK

  @Admins @Negative @InvalidToken
  Scenario: Put update product admins with invalid bearer token
    When Send put update product admins with valid json file
    When Send request put update admins
    Then Status code should be 401 unauthorized

  @Admins @Negative
  Scenario: Put update product admins without bearer token
    When Send put update product admins with valid json file
    When Send request put update admins
    Then Status code should be 400 bad request

  @Admins @Positive @loginAdmins
  Scenario: Delete product admins with valid id
    When Delete comments with id 11
    When Send request delete comments
    Then Status code should be 204 No content

  @Admins @Negative @loginAdmins
  Scenario: Delete product admins with invalid path
    When Delete comments with id 10
    When Send request delete comments with invalid path
    Then Status code should be 404 not found

  @Admins @Negative @InvalidToken
  Scenario: Delete product admins with invalid bearer token
    When Delete comments with id 10
    When Send request delete comments
    Then Status code should be 401 unauthorized

  @Admins @Negative
  Scenario: Delete product admins without bearer token
    When Delete comments with id 11
    When Send request delete comments
    Then Status code should be 400 bad request






































