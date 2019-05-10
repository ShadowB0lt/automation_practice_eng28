@BasketTest
Feature: Basket

  Background: Add a single product to the basket from the home page and go to basket
    Given I am on the homepage
    When I click add to cart button
    And pop up menu appears saying product has been added to basket
    When I click proceed to checkout button
    Then I am on the Basket Page

  Scenario: Increase Quantity of a product in the Basket
    Given I can see the product in the basket
    When I click on the plus button
    Then I see the quantity has been increased by 1

  Scenario: Decrease quantity of a product in the basket
    Given I can see the product in the basket
    When I click on the minus button
    Then I see the quantity has been decreased by 1

  @demo
  Scenario: Specify quantity of a product in the basket
    Given I can see the product in the basket
    When I input a quantity of 5
    Then I see the quantity has been changed to 5

  Scenario: Proceed to checkout
    Given I have a populated basket
    When I click proceed to checkout button
    Then I am on checkout

#  Scenario: Add multiple different products to the basket from the home page
#    Given I am on the homepage
#    When I click add to cart button for a product
#    And pop up menu appears saying product has been added to the basket
#    When I click continue shopping button
#    And I click add to cart button for a different product
#    Then pop up menu appears saying product has been added to the basket

#   Scenario: Remove a single product from Basket
#    Given I am on the Basket Page
#    When I click on the delete icon
#    Then product is not displayed in basket


# Further Scenarios if needed after First Test Flow Implemented
#    Scenario: Add a product to the basket from the products page
#      Given i am on the home page
#      When i click on the More button