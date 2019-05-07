Feature: Login

  Scenario: As a registered user, I can login
    Given I enter a valid email and password
    When I click sign in
    Then I am taken to the My Account page

  Scenario Outline: Inputting an invalid email generates an error
    Given I am on the login page
    When I input the necessary details with email <email>
    Then I get the corresponding email error <error>

    Examples:
      | email                       | error                    |
      | "hithere@hithere.hi.there"  | "Authentication failed." |
      | "hithere@@hithere.hi.there" | "Invalid email address." |


  Scenario Outline: Inputting an invalid password generates an error
    Given I am on the login page
    When I input the correct email with an invalid password <password>
    Then I get the corresponding password error <error>

    Examples:
      | password        | error                    |
      | "wrongpassword" | "Authentication failed." |
      | "hi"            | "Invalid password."      |


  Scenario: Inputting a password but not an email address
    Given I am on the login page
    When I input a password but no email
    Then I receive an email error message

  Scenario: Inputting an email but not a password
    Given I am on the login page
    When I input an email but no password
    Then I receive a password error message