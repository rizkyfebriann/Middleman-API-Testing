Feature: Login

  Scenario: Post login user with valid email & valid password
    Given Post login user with valid json file
    When Send request post login user
    Then API response status code should be 200 OK
    And Post login user assert json validation

  Scenario: Post login admin with valid email & valid password
    Given Post login admin with valid json file
    When Send request post login user
    Then API response status code should be 200 OK
    And Post login admin assert json validation

  Scenario: Post login user/admin with valid email & invalid password
    Given Post login user with invalid json file
    When Send request post login user
    Then API response status code should be 400 bad request

  Scenario: Post login user/admin with valid email & invalid password
    Given Post login user with invalid json file
    When Send request post login user
    Then API response status code should be 400 bad request

  Scenario: Post login user/admin with invalid email & valid password
    Given Post login user with invalid json file
    When Send request post login user
    Then API response status code should be 400 bad request

  Scenario: Post login user/admin with invalid email & invalid password
    Given Post login user with invalid json file
    When Send request post login user
    Then API response status code should be 400 bad request

  Scenario: Post login user/admin without email
    Given Post login user with invalid json file
    When Send request post login user
    Then API response status code should be 400 bad request

  Scenario: Post login user/admin without password
    Given Post login user with invalid json file
    When Send request post login user
    Then API response status code should be 400 bad request

  Scenario: Post login user/admin with empty email
    Given Post login user with invalid json file
    When Send request post login user
    Then API response status code should be 400 bad request

  Scenario: Post login user/admin with empty password
    Given Post login user with invalid json file
    When Send request post login user
    Then API response status code should be 400 bad request