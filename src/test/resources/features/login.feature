Feature: Login

  Background:  Open the browser and go to the home page
    Given the user launches a browser
    When the user opens the home page ilcarro


  @Login
  Scenario: Successful user login 1
    And the user clicks on the login link
    And the user enters valid data
    And the user presses the Yalla button
    Then the user checks the display of the message about the successful login
    And the user closes the browser


  @LoginWithString
  Scenario: Successful user login 2
    And the user clicks on the login link
    And The user enters the valid data "test_qa@gmail.com" and "Password@1"
    And the user presses the Yalla button
    Then the user checks the display of the message about the successful login
    And the user closes the browser

  @InvalidPassword
  Scenario Outline: the unsuccessful login of the user
    And the user clicks on the login link
    And the user enters valid data and invalid password
      | email   | password   |
      | <email> | <password> |
    And the user presses the Yalla button
    Then the user checks the display of the message about the unsuccessful login
    And the user closes the browser
    Examples:
      | email             | password   |
      | test_qa@gmail.com | Password1  |
      | test_qa@gmail.com | password@1 |
      | test_qa@gmail.com | Password@  |


