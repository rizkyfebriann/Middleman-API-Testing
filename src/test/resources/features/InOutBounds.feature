Feature: InOutBounds

  @inoutbounds
  Scenario: Create a carts on inoutbounds (unauthorized user/admin)
    Given create a cart on inoutbounds without any authorization with valid json file
    When Send request create a cart on inoutbounds
    Then API response status code should be 400 bad request

  @inoutbounds @loginRizkyUser1
  Scenario: Create a carts on inoutbounds with authorized rizky new user (haven't adding product yet)
    Given create a cart on inoutbounds with authorized rizky user with valid json file
    When Send request create a cart on inoutbounds
    Then API response status code should be 404 not found

  @inoutbounds @loginRizkyUser
  Scenario: Create a carts on inoutbounds with authorized rizky user (already added product)
    Given create a cart on inoutbounds with authorized another rizky user with valid json file
    When Send request create a cart on inoutbounds
    Then API response status code should be 201 created

  @inoutbounds @loginRizkyUser
  Scenario: Create a carts on inoutbounds with authorized rizky user which product id not found
    Given create a cart on inoutbounds with valid json file but product id not found
    When Send request create a cart on inoutbounds
    Then API response status code should be 404 not found

  @inoutbounds @loginRizkyUser
  Scenario: Create a carts on inoutbounds with authorized rizky user which product id found
    Given create a cart on inoutbounds with valid json file but product id found
    When Send request create a cart on inoutbounds
    Then API response status code should be 201 created

  @inoutbounds @loginRizkyUser
  Scenario: Create a carts on inoutbounds with authorized rizky user without product id
    Given create a cart on inoutbounds with valid json file without product id
    When Send request create a cart on inoutbounds
    Then API response status code should be 400 bad request

  @inoutbounds @loginRizkyUser
  Scenario: Create a carts on inoutbounds with authorized rizky user without qty
    Given create a cart on inoutbounds with valid json file without qty
    When Send request create a cart on inoutbounds
    Then API response status code should be 400 bad request

  @inoutbounds @loginRizkyUser
  Scenario: Create a carts on inoutbounds with authorized rizky user with invalid product id
    Given create a cart on inoutbounds with valid json file with invalid product id
    When Send request create a cart on inoutbounds
    Then API response status code should be 400 bad request

  @inoutbounds @loginRizkyUser
  Scenario: Create a carts on inoutbounds with authorized rizky user with invalid qty
    Given create a cart on inoutbounds with valid json file with invalid qty
    When Send request create a cart on inoutbounds
    Then API response status code should be 400 bad request

  @inoutbounds @loginAdmins
  Scenario: Create a carts on inoutbounds with authorized admin (haven't adding product yet)
    Given create a cart on inoutbounds with authorized admin with valid json file
    When Send request create a cart on inoutbounds
    Then API response status code should be 404 not found

  @inoutbounds @loginAdmins
  Scenario: Create a carts on inoutbounds with authorized admin (already added product)
    Given create a cart on inoutbounds with authorized admin with valid json file
    When Send request create a cart on inoutbounds
    Then API response status code should be 201 created

  @inoutbounds @loginAdmins
  Scenario: Create a carts on inoutbounds with authorized admin which product id not found
    Given create a cart on inoutbounds with valid json file but product id not found
    When Send request create a cart on inoutbounds
    Then API response status code should be 404 not found

  @inoutbounds @loginAdmins
  Scenario: Create a carts on inoutbounds with authorized admin which product id found
    Given create a cart on inoutbounds with valid json file but product id found
    When Send request create a cart on inoutbounds
    Then API response status code should be 200 OK

  @inoutbounds @loginAdmins
  Scenario: Create a carts on inoutbounds with authorized admin without product id
    Given create a cart on inoutbounds with valid json file without product id
    When Send request create a cart on inoutbounds
    Then API response status code should be 400 bad request

  @inoutbounds @loginAdmins
  Scenario: Create a carts on inoutbounds with authorized admin without qty
    Given create a cart on inoutbounds with valid json file without qty
    When Send request create a cart on inoutbounds
    Then API response status code should be 400 bad request

  @inoutbounds @loginAdmins
  Scenario: Create a carts on inoutbounds with authorized admin with invalid product id
    Given create a cart on inoutbounds with valid json file with invalid product id
    When Send request create a cart on inoutbounds
    Then API response status code should be 400 bad request

  @inoutbounds @loginAdmins
  Scenario: Create a carts on inoutbounds with authorized admin with invalid qty
    Given create a cart on inoutbounds with valid json file with invalid qty
    When Send request create a cart on inoutbounds
    Then API response status code should be 400 bad request

  @inoutbounds @loginAdmins
  Scenario: Create a carts on inoutbounds with authorized admin with invalid path
    Given create a cart on inoutbounds with valid json file
    When Send request create a cart on inoutbounds on invalid path
    Then API response status code should be 404 not found

  @inoutbounds
  Scenario: Get all carts on inoutbounds (unauthorized user/admin)
    Given get all cart on inoutbounds without any authorization
    When Send request get all cart on inoutbounds
    Then API response status code should be 400 bad request

  @inoutbounds @loginRizkyUser1
  Scenario: Get all carts on inoutbounds with authorized rizky user (haven't adding product yet)
    Given get all cart on inoutbounds with authorized rizky user
    When Send request get all cart on inoutbounds
    Then API response status code should be 404 not found

  @inoutbounds @loginRizkyUser
  Scenario: Get all carts on inoutbounds with authorized rizky user (already added product)
    Given get all cart on inoutbounds with authorized another rizky user
    When Send request get all cart on inoutbounds
    Then API response status code should be 200 OK

  @inoutbounds @loginAdmins
  Scenario: Get all carts on inoutbounds with authorized admin (haven't adding product yet)
    Given get all cart on inoutbounds with authorized admin (haven't adding product yet)
    When Send request get all cart on inoutbounds
    Then API response status code should be 200 OK

  @inoutbounds @loginAdmins
  Scenario: Get all carts on inoutbounds with authorized admin (already added product)
    Given get all cart on inoutbounds with authorized admin (already added product)
    When Send request get all cart on inoutbounds
    Then API response status code should be 200 OK

  @inoutbounds @loginAdmins
  Scenario: Get all carts on inoutbounds with invalid path
    Given get all cart on inoutbounds with authorized admin (already added product)
    When Send request get all cart on inoutbounds on invalid path
    Then API response status code should be 404 not found

  @inoutbounds
  Scenario: Update qty product added on inoutbounds (unauthorized user/admin)
    Given update qty product id "3" added on inoutbounds with valid json file
    When Send request update qty product added on inoutbounds
    Then API response status code should be 400 bad request

  @inoutbounds @loginRizkyUser
  Scenario: Update qty product added on inoutbounds with authorized user which product id not found
    Given update qty product id "20" added on inoutbounds with valid json file
    When Send request update qty product added on inoutbounds
    Then API response status code should be 404 not found

  @inoutbounds @loginRizkyUser
  Scenario: Update qty product added on inoutbounds with authorized user which product id invalid
    Given update qty product id "test" added on inoutbounds with valid json file
    When Send request update qty product added on inoutbounds
    Then API response status code should be 404 not found

  @inoutbounds @loginRizkyUser
  Scenario: Update qty product added on inoutbounds with authorized user which product id found
    Given update qty product id "3" added on inoutbounds with valid json file
    When Send request update qty product added on inoutbounds
    Then API response status code should be 200 OK

  @inoutbounds @loginRizkyUser
  Scenario: Update qty product added on inoutbounds with authorized user which invalid qty
    Given update invalid qty product id "3" added on inoutbounds with valid json file
    When Send request update qty product added on inoutbounds
    Then API response status code should be 400 bad request

  @inoutbounds @loginRizkyUser
  Scenario: Update qty product added on inoutbounds with authorized user which empty qty
    Given update empty qty product id "3" added on inoutbounds with valid json file
    When Send request update qty product added on inoutbounds
    Then API response status code should be 400 bad request

  @inoutbounds @loginAdmins
  Scenario: Update qty product added on inoutbounds with authorized admin which product id not found
    Given admin update qty product id "20" added on inoutbounds with valid json file
    When Send request update qty product added on inoutbounds
    Then API response status code should be 404 not found

  @inoutbounds @loginAdmins
  Scenario: Update qty product added on inoutbounds with authorized admin which product id invalid
    Given admin update qty product id "test" added on inoutbounds with valid json file
    When Send request update qty product added on inoutbounds
    Then API response status code should be 404 not found

  @inoutbounds @loginAdmins
  Scenario: Update qty product added on inoutbounds with authorized admin which product id found
    Given admin update qty product id "3" added on inoutbounds with valid json file
    When Send request update qty product added on inoutbounds
    Then API response status code should be 200 OK

  @inoutbounds @loginAdmins
  Scenario: Update qty product added on inoutbounds with authorized admin which invalid qty
    Given admin update invalid qty product id "3" added on inoutbounds with valid json file
    When Send request update qty product added on inoutbounds
    Then API response status code should be 400 bad request

  @inoutbounds @loginAdmins
  Scenario: Update qty product added on inoutbounds with authorized admin which emtpy qty
    Given admin update empty qty product id "3" added on inoutbounds with valid json file
    When Send request update qty product added on inoutbounds
    Then API response status code should be 400 bad request

  @inoutbounds @loginAdmins
  Scenario: Update qty product added on inoutbounds with authorized admin with invalid path
    Given admin update empty qty product id "3" added on inoutbounds with valid json file
    When Send request update qty product added on inoutbounds on invalid path
    Then API response status code should be 404 not found

  @inoutbounds
  Scenario: Delete product added on cart inoutbounds (unauthorized user/admin)
    Given delete product id "3" added on inoutbounds
    When Send request delete product added on inoutbounds
    Then API response status code should be 400 bad request

  @inoutbounds @loginRizkyUser1
  Scenario: Delete product added on cart inoutbounds with authorized user which product id not found
    Given user delete product id "20" added on inoutbounds
    When Send request delete product added on inoutbounds
    Then API response status code should be 404 not found

  @inoutbounds @loginRizkyUser1
  Scenario: Delete product added on cart inoutbounds with authorized user which product id invalid
    Given user delete product id "test" added on inoutbounds
    When Send request delete product added on inoutbounds
    Then API response status code should be 400 bad request

  @inoutbounds @loginRizkyUser1
  Scenario: Delete product added on cart inoutbounds with authorized user which product id found
    Given user delete product id "3" added on inoutbounds
    When Send request delete product added on inoutbounds
    Then API response status code should be 204 no content

  @inoutbounds @loginRizkyUser1
  Scenario: Delete product added on cart inoutbounds with authorized user with invalid path
    Given user delete product id "3" added on inoutbounds
    When Send request delete product added on inoutbounds on invalid path
    Then API response status code should be 404 not found

  @inoutbounds @loginAdmins
  Scenario: Delete product added on cart inoutbounds with authorized admin which product id not found
    Given admin delete product id "20" added on inoutbounds
    When Send request delete product added on inoutbounds
    Then API response status code should be 404 not found

  @inoutbounds @loginAdmins
  Scenario: Delete product added on cart inoutbounds with authorized admin which product id invalid
    Given admin delete product id "test" added on inoutbounds
    When Send request delete product added on inoutbounds
    Then API response status code should be 404 not found

  @inoutbounds @loginAdmins
  Scenario: Delete product added on cart inoutbounds with authorized admin which product id found
    Given admin delete product id "1" added on inoutbounds
    When Send request delete product added on inoutbounds
    Then API response status code should be 204 no content
