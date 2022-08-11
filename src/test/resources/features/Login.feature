Feature: Login

  Scenario: Post login user with valid email & valid password
    Given Post login user with valid json file
    When Send request post login user
    Then API response status code should be 200 OK
    And Post login user assert json validation