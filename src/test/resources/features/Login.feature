Feature: Login

  Scenario: As a registered user, I can login
    Given I enter a valid email and password
    When I click sign in
    Then I am taken to the My Account page

  Scenario Outline: Inputting an invalid email generates an error
    Given I am on the login page
    When I input the necessary details with email <email>
    Then I get the corresponding error <error>

    Examples:
      | email                     | error                      |
      | "hithere@hithere.hi.there"  | "1. Authentication failed" |
      | "hithere@@hithere.hi.there" | "1. Invalid email address" |


  Scenario Outline: Inputting an invalid password generates an error
    Given I am on the login page
    When I input the correct email with an invalid password <password>
    Then I get the corresponding error <error>

    Examples:
      | password         | error                      |
      | "wrongpassword" | "1. Authentication failed" |
      | "hi"            | "1. Invalid password"      |
