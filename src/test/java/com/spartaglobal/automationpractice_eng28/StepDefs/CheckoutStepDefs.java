package com.spartaglobal.automationpractice_eng28.StepDefs;

import com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages.CheckoutPageFirstHalf;
import com.spartaglobal.automationpractice_eng28.AutomationPractice.SeleniumConfig.SeleniumConfig;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CheckoutStepDefs {

    private static CheckoutPageFirstHalf checkoutPage;
    private static SeleniumConfig driver;
    private static String randomAddressNickName;
    private static String selectAddress;

    @Before
    public void setUp(){
        driver = new SeleniumConfig("chrome");
        checkoutPage = new CheckoutPageFirstHalf(driver.getDriver());
        checkoutPage.goToCheckOutPage();
        checkoutPage.goToHomePage();
        checkoutPage.clickAddToCart();
        checkoutPage.clickProceedToCheckout();
        checkoutPage.clickSecondProceedToCheckout();
        checkoutPage.inputUserName();
        checkoutPage.inputPassWord();
        checkoutPage.clickToLogin();
    }

    //Scenario: I would like to add a new address
    @Given("I am currently logged into the website")
    public void i_am_currently_logged_into_the_website() {
    }
    @And("I have added the items I wanted to the basket")
    public void i_have_added_the_items_I_wanted_to_the_basket() {
    }
    @And("I have clicked through the relevant pages to get to the checkout address page")
    public void i_have_clicked_through_the_relevant_pages_to_get_to_the_checkout_address_page() {
    }
    @When("I untick the use the delivery address as the billing address button")
    public void i_untick_the_use_the_delivery_address_as_the_billing_address_button() {
        checkoutPage.toggleBillingAndDeliveryButtonDropDownBox();
    }
    @And("I click on the add address button")
    public void i_click_on_the_add_address_button() {
        checkoutPage.clickAddNewAddress();
    }
    @And("I have completed the your address form")
    public void i_have_completed_the_your_address_form() {
        // Write code here that turns the phrase above into concrete actions
        randomAddressNickName = checkoutPage.generateRandomAddress("abcdefghijklmnopqrstuvwxyz", 10);
        checkoutPage.sendKeysTo("name", "firstname");
        checkoutPage.sendKeysTo("Verron","lastname");
        checkoutPage.sendKeysTo("12 address", "address1");
        checkoutPage.sendKeysTo("London", "city");
        checkoutPage.selectStateFromDropDown("California");
        checkoutPage.sendKeysTo("90212", "postcode");
        checkoutPage.sendKeysTo("0756321730", "phone_mobile");
        checkoutPage.deleteKeys(By.id("alias"));
        checkoutPage.sendKeysTo(randomAddressNickName, "alias");
        checkoutPage.clickSaveAddressButton();
    }
    @Then("The new address is available on the delivery address drop down box")
    public void the_new_address_is_available_on_the_delivery_address_drop_down_box() {
        Assert.assertTrue(checkoutPage.checkDeliveryAddress(randomAddressNickName));
    }
    @And("The new address is available on the billing address drop down box")
    public void the_new_address_is_available_on_the_billing_address_drop_down_box() {
        Assert.assertTrue(checkoutPage.checkBillingAddress(randomAddressNickName));
    }


    //Scenario: I would like to update my billing address

    @When("I untick the Use the delivery address as the billing address button")
    public void i_untick_the_Use_the_delivery_address_as_the_billing_address_button() {
        checkoutPage.toggleBillingAndDeliveryButtonDropDownBox();
    }
    @And("I click on the update billing address button")
    public void i_click_on_the_update_billing_address_button() {
        checkoutPage.clickUpdateBillingAddressButton();
    }
    @And("I have completed the changes to the your address form")
    public void i_have_completed_the_changes_to_the_your_address_form() {
        randomAddressNickName = checkoutPage.generateRandomAddress("abcdefghijklmnopqrstuvwxyz", 10);
        checkoutPage.deleteKeys(By.id("firstname"));
        checkoutPage.sendKeysTo(checkoutPage.generateRandomAddress("abcdefghijklmnopqrstuvwxyz", 10), "firstname");
        checkoutPage.deleteKeys(By.id("lastname"));
        checkoutPage.sendKeysTo(checkoutPage.generateRandomAddress("abcdefghijklmnopqrstuvwxyz", 10),"lastname");
        checkoutPage.deleteKeys(By.id("address1"));
        checkoutPage.sendKeysTo(checkoutPage.generateRandomAddress("abcdefghijklmnopqrstuvwxyz", 10), "address1");
        checkoutPage.deleteKeys(By.id("city"));
        checkoutPage.sendKeysTo(checkoutPage.generateRandomAddress("abcdefghijklmnopqrstuvwxyz", 10), "city");
        checkoutPage.selectStateFromDropDown("California");
        checkoutPage.deleteKeys(By.id("postcode"));
        checkoutPage.sendKeysTo("90212", "postcode");
        checkoutPage.deleteKeys(By.id("phone_mobile"));
        checkoutPage.sendKeysTo(checkoutPage.generateRandomAddress("1234567890", 9), "phone_mobile");
        checkoutPage.deleteKeys(By.id("alias"));
        checkoutPage.sendKeysTo(randomAddressNickName, "alias");
        checkoutPage.deleteKeys(By.id("address1"));
        checkoutPage.sendKeysTo(randomAddressNickName, "address1");
        checkoutPage.clickSaveAddressButton();
    }
    @Then("The updated billing address is visible and displayed correctly")
    public void the_updated_billing_address_is_visible_and_displayed_correctly() {
        Assert.assertTrue(checkoutPage.checkBillingAddressDetail(randomAddressNickName));
    }


    //Scenario: I would like to view the terms and conditions

    @Given("I have clicked through the relevant pages to get to the checkout shipping page")
    public void i_have_clicked_through_the_relevant_pages_to_get_to_the_checkout_shipping_page() {
        checkoutPage.getToShippingPage();
    }

    @When("I click on the read terms of service button")
    public void i_click_on_the_read_terms_of_service_button() {
        checkoutPage.clickViewTAndCbutton();
    }

    @Then("I can view the terms and conditions")
    public void i_can_view_the_terms_and_conditions() {
        Assert.assertTrue(checkoutPage.isTermsAndConditionsDisplayed());
    }


    //Scenario: I would like to update my delivery address

    @When("I click on the update delivery address button")
    public void i_click_on_the_update_delivery_address_button() {
        checkoutPage.clickUpdateDeliveryAddressButton();
    }
    @Then("The updated delivery address is visible and displayed correctly")
    public void the_updated_delivery_address_is_visible_and_displayed_correctly() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }


    //Scenario: I would like to choose a different delivery address

    @Given("I have previously created the address page that I want to use for delivery")
    public void i_have_previously_created_the_address_page_that_I_want_to_use_for_delivery() {
    }

    @When("I click on the delivery dropdown box")
    public void i_click_on_the_delivery_dropdown_box() {
        selectAddress = "My second address";
        checkoutPage.selectDeliveryAddress(selectAddress);
    }

    @And("I click on the address I want")
    public void i_click_on_the_address_I_want() {
    }

    @Then("the address that I want to be delivered to is displayed")
    public void the_address_that_I_want_to_be_delivered_to_is_displayed() {
        Assert.assertTrue(checkoutPage.checkAddressValueIsSelected(selectAddress));
    }


    //Scenario: After reviewing my order in the final payment page I would like to continue shopping

    @Given("I have clicked through the relevant pages to get to the checkout payment page")
    public void i_have_clicked_through_the_relevant_pages_to_get_to_the_checkout_payment_page() {

        checkoutPage.getToShippingPage().clickAcceptTermsAndConditions().getToPaymentPage();
    }

    @When("I click the continue shopping button")
    public void i_click_the_continue_shopping_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I can see the shopping page")
    public void i_can_see_the_shopping_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }


    //Scenario: I would like to pay by check

    @When("I click on the pay by check button")
    public void i_click_on_the_pay_by_check_button() {
        checkoutPage.clickOnPayByCheckButton();
    }

    @And("I click on the confirm by order button")
    public void i_click_on_the_confirm_by_order_button() {
        checkoutPage.clickConfirmOrderButton();
    }

    @Then("The confirmation order message appears for check")
    public void the_confirmation_order_message_appears_for_check() {
        Assert.assertEquals("Your order on My Store is complete.", checkoutPage.getConfirmationOfOrder());
    }


    //Scenario: I would like to pay by bank wire

    @When("I click on the pay by bank wire button")
    public void i_click_on_the_pay_by_bank_wire_button() {
        checkoutPage.clickPayByBankWire();
    }

    @Then("The confirmation order message appears")
    public void the_confirmation_order_message_appears() {
        Assert.assertEquals("Your order on My Store is complete.", checkoutPage.confirmationOrderMessage());
    }


    //Scenario: I would like to add a comment to the order

    @When("I click on the comment box")
    public void i_click_on_the_comment_box() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @And("I type in the comment that I want to add")
    public void i_type_in_the_comment_that_I_want_to_add() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("The comment has been added to the order")
    public void the_comment_has_been_added_to_the_order() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }


    //Scenario: I would like to continue with my purchase without accepting the terms and conditions

    @Given("terms of service is unticked")
    public void terms_of_service_is_unticked() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I click the proceed to checkout button")
    public void i_click_the_proceed_to_checkout_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("A message appears to accept terms and conditions before proceeding")
    public void a_message_appears_to_accept_terms_and_conditions_before_proceeding() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }










}
