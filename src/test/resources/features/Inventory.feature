Feature: Inventory

  @Inventory @Positive @loginRizkyInventory
  Scenario: Post create a form to list product user (OUT) with valid data
    When Send post create  form to list product user with valid json file
    When Send request post create form to list product user
    Then Status code should be 201 created

  @Inventory @Negative @loginRizkyInventory
  Scenario: Post create a form to list product user (OUT) with invalid qty
    When Send post create  form to list product user with invalid qty json file
    When Send request post create form to list product user
    Then Status code should be 400 wrong input


  @Inventory @Negative @loginRizkyInventory
  Scenario: Post create a form to list product user (OUT) without product id
    When Send post create  form to list product user without product id json file
    When Send request post create form to list product user
    Then Status code should be 404 not found


  @Inventory @Negative @loginRizkyInventory
  Scenario: Post create a form to list product user (OUT) without unit
    When Send post create  form to list product user without unit json file
    When Send request post create form to list product user
    Then Status code should be 404 not found


  @Inventory @Negative @loginRizkyInventory
  Scenario: Post create a form to list product user (OUT) without qty
    When Send post create  form to list product user without qty json file
    When Send request post create form to list product user
    Then Status code should be 404 not found


  @Inventory @Negative @loginRizkyInventory
  Scenario: Post create a form to list product user (OUT) with invalid path
    When Send post create  form to list product user with valid json file
    When Send request post create form to list product user with invalid path "/inventoryy"
    Then Status code should be 404 not found

  @Inventory @Negative @InvalidBearerToken
  Scenario: Post create a form to list product user (OUT) with invalid bearer token
    When Send post create  form to list product user with valid json file
    When Send request post create form to list product user
    Then Status code should be 401 unauthorized

  @Inventory @Negative
  Scenario: Post Create a form to list product user (OUT) without bearer token
    Given Post Create a form to list product user without bearer token
    When Send post create  form to list product user with valid json file
    When Send request post create form to list product user
    Then Status code should be 400 bad request

  @Inventory @Positive @loginRizkyInventory
  Scenario: Get all form products inventory user (OUT)
    Given get all form products inventory with authorized user
    When Send request get all form product inventory user
    Then Status code should be 200 OK

  @Inventory @Negative @loginRizkyInventory
  Scenario: Get all form products inventory user (OUT) with invalid path
    Given get all form products inventory with authorized user
    When Send request get all form product inventory user with invalid path "/inventoryy"
    Then Status code should be 404 not found

  @Inventory @Negative @InvalidBearerToken
  Scenario: Get all form products inventory user (OUT) with invalid bearer token
    Given get all form products inventory with unauthorized user
    When Send request get all form product inventory user
    Then Status code should be 401 unauthorized

  @Inventory @Negative
  Scenario: Get all form products inventory user (OUT) without bearer token
    Given Get all form products inventory user without bearer token
    When Send request get all form product inventory user
    Then Status code should be 400 bad request


  @Inventory @Positive @loginRizkyInventory
  Scenario: Get detail form product inventory (OUT)
    Given Get detail form product inventory with authorized user
    When Send request get detail form product inventory user
    Then  Status code should be 200 OK


  @Inventory @Negative @loginRizkyInventory
  Scenario: Get detail form product inventory (OUT) with invalid inventory id
    Given Get detail form product inventory with authorized user
    When Send request get detail form product inventory user with invalid inventory id "/7699"
    Then  Status code should be 404 not found

  @Inventory @Negative @loginRizkyInventory
  Scenario: Get detail form product inventory (OUT) with invalid path
    Given Get detail form product inventory with authorized user
    When Send request get detail form product inventory user with invalid path "/inventoryy"
    Then  Status code should be 404 not found

  @Inventory @Negative @InvalidBearerToken
  Scenario: Get detail form product inventory (OUT) with invalid token
    Given Get detail form products inventory with unauthorized user
    When Send request get detail form product inventory user
    Then Status code should be 401 unauthorized

  @Inventory @Positive @loginAdmins
  Scenario: Post create a form to list product admins (IN) with valid data
    When Send post create  form to list product admins with valid json file
    When Send request post create form to list product admins
    Then Status code should be 201 created

  @Inventory @Negative @loginAdmins
  Scenario: Post create a form to list product admins (IN) with invalid qty
    When Send post create  form to list product admins with invalid qty json file
    When Send request post create form to list product admins
    Then Status code should be 400 wrong input

    #bug400/201
  @Inventory @Negative @loginAdmins
  Scenario: Post create a form to list product admins (IN) without product id
    When Send post create  form to list product admins without product id json file
    When Send request post create form to list product admins
    Then Status code should be 404 not found

    #bug400/201
  @Inventory @Negative @loginAdmins
  Scenario: Post create a form to list product admins (IN) without unit
    When Send post create  form to list product admins without unit json file
    When Send request post create form to list product admins
    Then Status code should be 404 not found

  #bug400/201
  @Inventory @Negative @loginAdmins
  Scenario: Post create a form to list product admins (IN) without qty
    When Send post create  form to list product admins without qty json file
    When Send request post create form to list product admins
    Then Status code should be 400 bad request

  @Inventory @Negative @loginAdmins
  Scenario: Post create a form to list product admins (IN) with invalid path
    When Send post create  form to list product admins with valid json file
    When Send request post create form to list product admins with invalid path "/inventoryy"
    Then Status code should be 404 not found

  @Inventory @Negative @InvalidBearerToken
  Scenario: Post create a form to list product admins (IN) with invalid bearer token
    When Send post create  form to list product admins with valid json file
    When Send request post create form to list product admins
    Then Status code should be 401 unauthorized

  @Inventory @Negative
    Scenario: Post create a form to list product admins (IN) without bearer token
    Given Post create a form to list product admins without bearer token
    When Send post create  form to list product admins with valid json file
    When Send request post create form to list product admins
    Then Status code should be 401 bad request

  @Inventory @Positive @loginAdmins
    Scenario: Get all form products inventory admins (IN)
    Given get all form products inventory with authorized admins
    When Send request get all form product inventory admins
    Then Status code should be 200 OK

  @Inventory @Negative @loginAdmins
    Scenario: Get all form product inventory admins (IN) with invalid path
    Given get all form products inventory with authorized admins
    When Send request get all form product inventory admins with invalid path "/adminss"
    Then Status code should be 404 not found

  @Inventory @Negative @InvalidBearerToken
  Scenario: Get all form product inventory admins (IN) with invalid bearer token
    Given get all form products inventory with unauthorized admins
    When Send request get all form product inventory admins
    Then Status code should be 401 unauthorized

  @Inventory @Negative
  Scenario: Get all form product inventory admins (IN) without bearer token
    Given get all form products inventory without bearer token
    When Send request get all form product inventory admins
    Then Status code should be 400 bad request

  @Inventory @Positive @loginAdmins
  Scenario: Get detail form product inventory admins (IN)
    Given Get detail form product inventory with authorized admins
    When Send request get detail form product inventory admins
    Then Status code should be 200 OK

    #response 200 tapi data null
  @Inventory @Negative @loginAdmins
  Scenario: Get detail form products inventory admins (IN) with invalid inventory id
    Given Get detail form product inventory with authorized admins
    When Send request get detail form product inventory admins with invalid inventory id
    Then Status code should be 404 not found

  @Inventory @Negative @loginAdmins
  Scenario: Get detail form products inventory admins (IN) with invalid path
    Given Get detail form product inventory with authorized admins
    When Send request get detail form product inventory admins with invalid path
    Then Status code should be 404 not found

  @Inventory @Negative @InvalidBearerToken
    Scenario: Get detail form products inventory admins (IN) with invalid bearer token
    Given Get detail form products inventory with unauthorized admins
    When Send request get detail form product inventory admins
    Then Status code should be 401 unauthorized

  @Inventory @Negative
  Scenario: Get detail form products inventory admins (IN) without bearer token
    Given Get detail form products inventory admins without bearer token
    When Send request get detail form product inventory admins
    Then Status code should be 400 bad request

































