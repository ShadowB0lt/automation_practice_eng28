Feature: Checkout

  Scenario: I would like to add a delivery address
    Given I am currently logged into the website
    And I have added the items I wanted to the basket
    And I have clicked through the relevant pages to get to the checkout address page
    When I click on the add address button
    And I have completed the "your address" form
    Then The new address is available on the choose validity drop down box
