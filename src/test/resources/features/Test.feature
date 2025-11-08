Feature: Trying something Successfully


  @test
  Scenario Outline: Successfully Login
    Given user navigate to URL
    And user click mobile section
    Then user navigates to search tab
    When user searches for product "<product>"
    And user  navigate to mens tab

    Examples:
    |product|
    |Monitor 27 inch|
