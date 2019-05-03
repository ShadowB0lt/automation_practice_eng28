Feature: Registration

  Scenario: I can select one title radio button and the value wil be retrieved
    Given I am on the registration page
    When I click the 'mr' radio button
    Then The 'mr' radio button will be highlighted
    And The value of the button can be retrieved

  Scenario Outline: The name fields recognise invalid values
    Given I am on the registration page
    When I enter a string which includes a number into name field with id <id>
    Then the name entry field will be marked as invalid

    Examples:
      | id                 |
      | customer_firstname |
      | customer_lastname  |

    