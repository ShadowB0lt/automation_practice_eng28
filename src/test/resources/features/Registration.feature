Feature: Registration
  Scenario: I can select one title radio button and the value wil be retrieved
    Given I am on the registration page
    When I click the 'mr' radio button
    Then The 'mr' radio button will be highlighted
    And The value of the button can be retrieved

  Scenario: The name field recognises invalid values
    Given I am on the registration page
    When I enter a first name which includes a number
    Then the name validations
