Feature: UI Login Failure


  @test11222
  Scenario Outline: Try Login
    Given user navigate to URL
    Then user navigates to aboutUS tab
    And user click home tab
    When user types user name as "<user>" and password as "<user>"
    Then user fetches error for login

    Examples:
      | user  | user   |
      | Arpit | Mishra |
