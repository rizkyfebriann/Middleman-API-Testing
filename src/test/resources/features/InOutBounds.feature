Feature: InOutBounds

  @InOutBounds
  Scenario: Get all cart for stock on inoutbounds (unauhorized user/admin)
    Given Get all cart on inoutbounds with no any authorization token
    When Send request get all cart on inoutbounds
    Then API response status code should be 400 bad request

  @InOutBounds
  Scenario: Get all cart for stock on inoutbounds (authorized user Rizky)
    Given Get all cart on inoutbounds with authorized user Rizky
    When Send request get all cart on inoutbounds
    Then API response status code should be 200 OK


