Feature: HOME PAGE

  @HomeComponent
  Scenario: Check that the heading of the home page is displayed
    Given the user launches a browser
    When the user opens the home page ilcarro
    Then check that the heading of the home page is displayed
    #And the user closes the browser