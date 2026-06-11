Feature: UI Login Failure


  @test11222
  Scenario Outline: Successfully Login
    Given user navigate to URL
    When I send a GET request
    Then user navigates to aboutUS tab
    And user click home tab
    When user types user name as "<user>" and password as "<user>"
#    And user click products tab

    Examples:
      | user  | user   |
      | Arpit | Mishra |
