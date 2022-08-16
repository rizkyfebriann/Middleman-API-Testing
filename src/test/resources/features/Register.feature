#Feature: Register
#
#  @register
#  Scenario: Post register user with all valid data
#    Given Post register user with valid json file
#    When Send request post register user
#    Then API response status code should be 201 created
#    And response body should contains code 201 and message "register success"
#
#  @register
#  Scenario: Post register user without name
#    Given Post register user with invalid json file
#    When Send request post register user
#    Then API response status code should be 400 bad request
#
#  @register
#  Scenario: Post register user without email
#    Given Post register user with invalid json file
#    When Send request post register user
#    Then API response status code should be 400 bad request
#
#  @register
#  Scenario: Post register user without password
#    Given Post register user with invalid json file
#    When Send request post register user
#    Then API response status code should be 400 bad request
#
#  @register
#  Scenario: Post register user without phone
#    Given Post register user with invalid json file
#    When Send request post register user
#    Then API response status code should be 400 bad request
#
#  @register
#  Scenario: Post register user without address
#    Given Post register user with invalid json file
#    When Send request post register user
#    Then API response status code should be 400 bad request
#
#  @register
#  Scenario: Post register user with email already registered
#    Given Post register user already registered with valid json file
#    When Send request post register user
#    Then API response status code should be 400 bad request
#
#  @register
#  Scenario: Post register user with invalid format email
#    Given Post register user with invalid format email on valid json file
#    When Send request post register user
#    Then API response status code should be 400 bad request
#
#  @register
#  Scenario: Post register user with invalid phone
#    Given Post register user with invalid phone on valid json file
#    When Send request post register user
#    Then API response status code should be 400 bad request
#
#  @register
#  Scenario: Post register user on invalid path
#    Given Post register user with valid json file
#    When Send request post register user on invalid path
#    Then API response status code should be 400 bad request