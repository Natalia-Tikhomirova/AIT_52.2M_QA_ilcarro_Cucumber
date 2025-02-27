Feature: Adding a car
  Background: Login and navigate to car adding page
    Given the user launches a browser
    When the user opens the home page ilcarro
    And the user clicks on the login link
    And the user enters valid data
    And the user presses the Yalla button
    Then the user checks the display of the message about the successful login


  @AddCar
  Scenario: Adding a car with valid data
    And the user clicks on "Ok" in the success popup
    And the user clicks on "Let the car work"
    And the user enters the location "Haifa, Israel"
    And the user selects address "Haifa, Israel" from the dropdown
    And the user fills in car details:
      | Manufacture | Toyota  |
      | Model       | Corolla |
      | Year        | 2000    |
    And the user selects fuel type "Diesel" from the dropdown
    And the user selects seats "4"
    And the user enters car class "A"
    And the user enters registration number "AB128CD"
    And the user enters price "1000"
    Then the user clicks on "Submit" button
