@CheckoutTests
Feature: Checkout

  Scenario: I would like to add a new address
    Given I am currently logged into the website
    And I have added the items I wanted to the basket
    And I have clicked through the relevant pages to get to the checkout address page
    When I untick the use the delivery address as the billing address button
    And I click on the add address button
    And I have completed the your address form
    Then The new address is available on the delivery address drop down box
    And The new address is available on the billing address drop down box


  Scenario: I would like to update my billing address
    Given I am currently logged into the website
    And I have added the items I wanted to the basket
    And I have clicked through the relevant pages to get to the checkout address page
    When I untick the Use the delivery address as the billing address button
    And I click on the update billing address button
    And I have completed the changes to the your address form
    Then The updated billing address is visible and displayed correctly


  Scenario: I would like to view the terms and conditions
    Given I am currently logged into the website
    And I have added the items I wanted to the basket
    And I have clicked through the relevant pages to get to the checkout shipping page
    When I click on the read terms of service button
    Then I can view the terms and conditions

  Scenario: I would like to update my delivery address
    Given I am currently logged into the website
    And I have added the items I wanted to the basket
    And I have clicked through the relevant pages to get to the checkout address page
    When I untick the use the delivery address as the billing address button
    And I click on the update delivery address button
    And I have completed the changes to the your address form
    Then The updated delivery address is visible and displayed correctly

  Scenario: I would like to choose a different delivery address
    Given I am currently logged into the website
    And I have added the items I wanted to the basket
    And I have clicked through the relevant pages to get to the checkout address page
    And I have previously created the address page that I want to use for delivery
    When I untick the Use the delivery address as the billing address button
    And I click on the delivery dropdown box
    And I click on the address I want
    Then the address that I want to be delivered to is displayed


  Scenario: I would like to pay by check
    Given I am currently logged into the website
    And I have added the items I wanted to the basket
    And I have clicked through the relevant pages to get to the checkout payment page
    When I click on the pay by check button
    And I click on the confirm by order button
    Then The confirmation order message appears for check

  Scenario: I would like to pay by bank wire
    Given I am currently logged into the website
    And I have added the items I wanted to the basket
    And I have clicked through the relevant pages to get to the checkout payment page
    When I click on the pay by bank wire button
    And I click on the confirm by order button
    Then The confirmation order message appears

  Scenario: I would like to add a comment to the order
    Given I am currently logged into the website
    And I have added the items I wanted to the basket
    And I have clicked through the relevant pages to get to the checkout address page
    When I click on the comment box
    And I type in the comment that I want to add
    Then The comment has been added to the order

  Scenario: I would like to continue with my purchase without accepting the terms and conditions
    Given I am currently logged into the website
    And I have added the items I wanted to the basket
    And I have clicked through the relevant pages to get to the checkout shipping page
    And terms of service is unticked
    When I click the proceed to checkout button
    Then A message appears to accept terms and conditions before proceeding
