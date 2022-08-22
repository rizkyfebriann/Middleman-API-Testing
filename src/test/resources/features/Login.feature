#Feature: Login
#
#  @login
#  Scenario: Post login user with valid email & valid password
#    Given Post login user with valid json file
#    When Send request post login user
#    Then API response status code should be 200 OK
#    And Post login user assert json validation
#
#  @login
#  Scenario: Post login admin with valid email & valid password
#    Given Post login admin with valid json file
#    When Send request post login user
#    Then API response status code should be 200 OK
#    And Post login admin assert json validation
#
#  @login
#  Scenario: Post login user/admin with valid email & invalid password
#    Given Post login user with invalid json file
#    When Send request post login user
#    Then API response status code should be 400 bad request
#
#  @login
#  Scenario: Post login user/admin with valid email & invalid password
#    Given Post login user with invalid json file
#    When Send request post login user
#    Then API response status code should be 400 bad request
#
#  @login
#  Scenario: Post login user/admin with invalid email & valid password
#    Given Post login user with invalid json file
#    When Send request post login user
#    Then API response status code should be 400 bad request
#
#  @login
#  Scenario: Post login user/admin with invalid email & invalid password
#    Given Post login user with invalid json file
#    When Send request post login user
#    Then API response status code should be 400 bad request
#
#  @login
#  Scenario: Post login user/admin without email
#    Given Post login user with invalid json file
#    When Send request post login user
#    Then API response status code should be 400 bad request
#
#  @login
#  Scenario: Post login user/admin without password
#    Given Post login user with invalid json file
#    When Send request post login user
#    Then API response status code should be 400 bad request
#
#  @login
#  Scenario: Post login user/admin with empty email
#    Given Post login user with invalid json file
#    When Send request post login user
#    Then API response status code should be 400 bad request
#
#  @login
#  Scenario: Post login user/admin with empty password
#    Given Post login user with invalid json file
#    When Send request post login user
#    Then API response status code should be 400 bad request
#
#  @login
#  Scenario: Post login user/admin on invalid path
#    Given Post login user with valid json file
#    When Send request post login user on invalid path
#    Then API response status code should be 404 not found