package com.spartaglobal.automationpractice_eng28.StepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheckoutStepDefs {

    //Scenario: I would like to add a delivery address
    @Given("I am currently logged into the website")
    public void i_am_currently_logged_into_the_website() {
    }
    @And("I have added the items I wanted to the basket")
    public void i_have_added_the_items_I_wanted_to_the_basket() {
    }
    @And("I have clicked through the relevant pages to get to the checkout address page")
    public void i_have_clicked_through_the_relevant_pages_to_get_to_the_checkout_address_page() {
    }
    @When("I click on the add address button")
    public void i_click_on_the_add_address_button() {
    }
    @And("I have completed the {string} form")
    public void i_have_completed_the_form(String string) {
    }
    @Then("The new address is available on the choose validity drop down box")
    public void the_new_address_is_available_on_the_choose_validity_drop_down_box() {
    }



}
