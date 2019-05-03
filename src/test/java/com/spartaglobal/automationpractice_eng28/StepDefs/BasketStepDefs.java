package com.spartaglobal.automationpractice_eng28.StepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BasketStepDefs {

    //Add a single product to the basket from the home page
    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {

    }

    @When("I click add to cart button")
    public void i_click_add_to_cart_button() {

    }

    @Then("pop up menu appears saying product has been added to basket")
    public void pop_up_menu_appears_saying_product_has_been_added_to_basket() {

    }
    //Go to Basket page after a product confirmed to have been added
    @Given("I have the pop up menu opened")
    public void i_have_the_pop_up_menu_opened() {

    }

    @When("I click proceed to checkout button")
    public void i_click_proceed_to_checkout_button() {

    }

    @Then("I am on the Basket Page")
    public void i_am_on_the_Basket_Page() {

    }
    //Increase Quantity of a product in the Basket
    @Given("I can see the product in the basket")
    public void i_can_see_the_product_in_the_basket() {

    }

    @When("I click on the plus button")
    public void i_click_on_the_plus_button() {

    }

    @Then("I see the quantity has been increased by {int}")
    public void i_see_the_quantity_has_been_increased_by(Integer int1) {

    }

    //Decrease quantity of a product in the basket
    @When("i click on the minus button")
    public void i_click_on_the_minus_button() {

    }


    @When("i input a quantity of {int}")
    public void i_input_a_quantity_of(Integer int1) {

    }

    //Specify quantity of a product in the basket
    @Then("i see the quantity has been decreased by {int}")
    public void i_see_the_quantity_has_been_decreased_by(Integer int1) {

    }

    @Then("i see the quantity has been changed to {int}")
    public void i_see_the_quantity_has_been_changed_to(Integer int1) {

    }
    //Proceed to checkout
    @Given("i have a populated basket")
    public void i_have_a_populated_basket() {

    }

    @When("i click proceed to checkout")
    public void i_click_proceed_to_checkout() {

    }

    @Then("i am on checkout")
    public void i_am_on_checkout() {

    }

    //Add multiple different products to the basket from the home page
    @Given("i am on the home page")
    public void i_am_on_the_home_page() {

    }

    @And("i click add to cart button for a product")
    public void i_click_add_to_cart_button_for_a_product() {

    }

    @When("I click continue shopping button")
    public void i_click_continue_shopping_button() {

    }

    @And("I click add to cart button for a different product")
    public void i_click_add_to_cart_button_for_a_different_product() {

    }

    @Then("pop up menu appears saying product has been added to the basket")
    public void pop_up_menu_appears_saying_product_has_been_added_to_the_basket() {

    }

    //Remove a single product from Basket
    @Given("I am on the basket page")
    public void i_am_on_the_basket_page() {

    }

    @When("I click on the delete icon")
    public void i_click_on_the_delete_icon() {

    }

    @Then("product is not displayed in basket")
    public void product_is_not_displayed_in_basket() {

    }


}
