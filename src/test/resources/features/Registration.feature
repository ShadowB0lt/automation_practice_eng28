Feature: Registration

  Scenario: I can select one title radio button and the value wil be retrieved
    Given I am on the registration page
    When I click the 'mr' radio button
    Then The 'mr' radio button will be highlighted
    And The value of the button can be retrieved

  Scenario Outline: The name fields recognise invalid values
    Given I am on the registration page
    When I enter a string which includes a number into name field with id <id>
    Then the name entry field <id> will be marked as invalid

    Examples:
      | id                 |
      | customer_firstname |
      | customer_lastname  |

  Scenario Outline: The text entry fields display the keys sent
    Given I am on the registration page
    When I type into the menu item with id <id>
    Then the field <id> will display the typed string

    Examples:
      | id                 |
      | firstname          |
      | lastname           |
      | customer_firstname |
      | customer_lastname  |
      | company            |
      | address1           |
      | address2           |
      | city               |
      | postcode           |
      | other              |
      | phone_mobile       |
      | phone              |
      | alias              |

  Scenario: Registration is permitted once the form is correctly filled in
    Given I am on the registration page
    And I have added valid data into the mandatory fields
    When I click the submit button
    Then I will arrive at the manage account screen

  Scenario: Registration is not permitted if both phone numbers are missing
    Given I am on the registration page
    And I have added valid data into all fields except the phone number fields
    When I click the submit button
    Then I will receive an error saying a phone number must be present

  Scenario: The address name field defaults to 'My Address'
    Given I am on the registration page
    When I view the Address Alias field
    Then I see the value 'My address'

  Scenario: The displayed email on the registration screen defaults to the email from the previous screen
    Given I have typed a valid email address on the log-in screen
    And I am on the registration page
    When I read the email address field
    Then it is equal to the email address I typed on the log in screen

  Scenario Outline: The omission of a mandatory field leads to an error on form submission
    Given I am on the registration page
    And I have added valid data into the mandatory fields
    And I have deleted the entry in the field with id <id>
    When I click the submit button
    Then I will receive an error containing <error>

    Examples:
      | id                 | error                   |
      | customer_firstname | "firstname is required" |
      | customer_lastname  | "lastname is required"  |
      | address1           | "address1 is required"  |
      | city               | "city is required"      |