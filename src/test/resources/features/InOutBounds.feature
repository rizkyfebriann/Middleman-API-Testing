Feature: InOutBounds

  @inoutbounds
  Scenario: Get all carts on inoutbounds (unauthorized user/admin)
    Given get all cart on inoutbounds without any authorization
    When Send request get all cart on inoutbounds
    Then API response status code should be 401 unauthorized

  @inoutbounds @loginRizkyUser
  Scenario: Get all carts on inoutbounds with authorized rizky user (haven't adding product yet)
    Given get all cart on inoutbounds with authorized rizky user
    When Send request get all cart on inoutbounds
    Then API response status code should be 400 bad request

  @inoutbounds @loginRizkyUser1
  Scenario: Get all carts on inoutbounds with authorized rizky user (already added product)
    Given get all cart on inoutbounds with authorized another rizky user
    When Send request get all cart on inoutbounds
    Then API response status code should be 200 OK

  @inoutbounds @loginAdmins
  Scenario: Get all carts on inoutbounds with authorized admin (haven't adding product yet)
    Given get all cart on inoutbounds with authorized admin (haven't adding product yet)
    When Send request get all cart on inoutbounds
    Then API response status code should be 400 bad request

  @inoutbounds @loginAdmins
  Scenario: Get all carts on inoutbounds with authorized rizky user (already added product)
    Given get all cart on inoutbounds with authorized admin (already added product)
    When Send request get all cart on inoutbounds
    Then API response status code should be 200 OK

  @inoutbounds @loginAdmins
  Scenario: Get all carts on inoutbounds with invalid path
    Given get all cart on inoutbounds with authorized admin (already added product)
    When Send request get all cart on inoutbounds on invalid path
    Then API response status code should be 404 not found

