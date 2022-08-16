Feature: User

#  @register
#  Scenario: Create register user with all valid data
#    Given Create register user with valid json file
#    When Send request post register user
#    Then API response status code should be 201 created
#    And response body should contains code 201 and message "register success"
#
#  @login
#  Scenario: Create login user with valid email & valid password
#    Given Create login user with valid json file
#    When Send request post login user
#    Then API response status code should be 200 OK
#    And Post login user assert json validation
#
#  @register
#  Scenario: Create register user with all valid data3
#    Given Create register user with valid json file3
#    When Send request post register user
#    Then API response status code should be 201 created
#    And response body should contains code 201 and message "register success"

  @user @login @loginErnaUser
  Scenario: Create login user with valid email & valid password3
    Given Create login user with valid json file3
    When Send request post login user
    Then API response status code should be 200 OK
    And Post login user assert json validation

  @user @loginErnaUser
  Scenario:Get user with valid token
    Given Set request get user with valid bearer token
    When Send request get user
    Then API response status code should be 200 OK
    And Get user assert json validation

  @user @invalidTokenErnaUSer
  Scenario: Get user with invalid bearer token
    Given Set request get user with invalid bearer token
    When Send request get user
    Then API response status code should be 401 Unauthorized

  @user
  Scenario: Get user without bearer token
    Given Set request get user without bearer token
    When Send request get user
    Then API response status code should be 400 bad request

  @user @loginErnaUser
  Scenario: Get user with valid token on invalid path
    Given Set request get user with invalid path
    When Send request get user with invalid path
    Then API response status code should be 404 not found

  @user @loginErnaUser
  Scenario: Update user with all valid data on json file
    Given Set request update user with all valid data
    When Send request update user
    Then API response status code should be 200 OK
    And response body should contains code 200 and message "success update data"

##    Duplikat biar abis update langsung login lg
  @user @loginErnaUser
  Scenario: Create login user with valid email & valid password3
    Given Create login user with valid json file4
    When Send request post login user
    Then API response status code should be 200 OK
    And Post login user assert json validation

  @user @loginErnaUser
  Scenario: Update user with email not valid
    Given Set request update user with email not valid
    When Send request update user
    Then API response status code should be 400 bad request
#    And response body should contains code 400 and message "your format email is wrong"

#    AS EXPECTED
  @user @loginErnaUser
  Scenario: Update user with phone number not valid
    Given Set request update user with phone number not valid
    When Send request update user
    Then API response status code should be 400 bad request

# AS EXPECTED
  @user @loginErnaUser
  Scenario: Update user with phone number<10
    Given Set request update user with phone number<10
    When Send request update user
    Then API response status code should be 400 bad request

# AS EXPECTED
  @user @loginErnaUser
  Scenario: Update user with empty data on json file
    Given Set request update user with empty data on json file
    When Send request update user
    Then API response status code should be 400 bad request

  @user @loginErnaUser
  Scenario: Update user with all valid data on invalid path
    Given Set request update user with invalid path
    When Send request update user with invalid path
    Then API response status code should be 404 not found
    And response body should contains message "Not Found"

  @user @loginErnaUser
  Scenario: Update user with already registered email
    Given Set request update with already registered email
    When Send request update user
    Then API response status code should be 400 bad request

# scenario bug
  @user @loginErnaUser
  Scenario: Update user without properti name
    Given Set request update user without properti name
    When Send request update user
    Then API response status code should be 200 OK
#    And response body should contains code 200 and message "success update data"

  @user @invalidTokenErnaUSer
  Scenario: Delete user with invalid bearer token
    Given Set request delete user invalid token
    When Send request delete user
    Then API response status code should be 401 Unauthorized

  @user @loginErnaUser
  Scenario: Delete user with valid token on invalid path
    Given Set request delete user with invalid path
    When Send request delete user invalid path
    Then API response status code should be 404 not found

#  @user @loginErnaUser
#  Scenario: Delete user with valid bearer token
#    Given Set request delete user with register user
#    When Send request delete user
#    Then API response status code should be 200 OK



