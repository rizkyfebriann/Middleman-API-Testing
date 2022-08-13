Feature: User

  @register
  Scenario: Create register user with all valid data
    Given Create register user with valid json file
    When Send request post register user
    Then API response status code should be 201 created
    And response body should contains code 201 and message "register success"

  @login
  Scenario: Create login user with valid email & valid password
    Given Create login user with valid json file
    When Send request post login user
    Then API response status code should be 200 OK
    And Post login user assert json validation

  Scenario:Get user with valid token
    Given Set authorization with valid bearer token
    When Send request get user
    Then API response status code should be 200 OK
    And Get all projects assert json validation

  Scenario: Get user with invalid bearer token
    Given Set authorization with invalid bearer token
    When Send request get user
    Then API response status code should be 401 Unauthorized

  Scenario: Update user with all valid data on json file
    Given Set request update user with all valid data
    When Send request update user
    Then API response status code should be 200 OK
    And response body should contains code 200 and message "success update data"

  Scenario: Update user without properti name
    Given Set request update user without properti name
    When Send request update user
    Then API response status code should be 200 OK
    And response body should contains code 200 and message "success update data"

  Scenario: Update user without properti name
    Given Set request update user without properti name
    When Send request update user
    Then API response status code should be 200 OK
    And response body should contains code 200 and message "success update data"

  Scenario: Update user with already registered email
    Given Set request update with already registered email
    When Send request update user
    Then API response status code should be 400 bad request
    And response body should contains code 400 and message "failed update data users, your email already registerd"

  Scenario: Update user with email not valid
    Given Set request update user with email not valid
    When Send request update user
    Then API response status code should be 400 bad request
    And response body should contains code 400 and message "your format email is wrong"

  Scenario: Update user with empty data on json file
    Given Set request update user with empty data on json file
    When Send request update user
    Then API response status code should be 400 bad request
    And response body should contains code 400 and message "nothing to update data"

#  Scenario: Update user with all valid data on invalid path
#    Given Set request update user with invalid path
#    When Send request update user with invalid path
#    Then API response status code should be 404 not found
#    And response body should contains message "Not Found"

  Scenario: Update user with phone number not valid
    Given Set request update user with phone number not valid
    When Send request update user
    Then API response status code should be 400 bad request
    And response body should contains code 400 and message "your format phone is wrong"

#    scenario bug
  Scenario: Delete user with valid bearer token
    Given Set request delete user with register user
    When Send request delete user
    Then API response status code should be 204 no content

  Scenario: Delete user with invalid bearer token
    Given Set request delete user invalid token
    When Send request delete user
    Then API response status code should be 401 Unauthorized

  Scenario: Delete user with valid token on invalid path
    Given Set request update user with invalid path
    When Send request delete user invalid path
    Then API response status code should be 404 not found



