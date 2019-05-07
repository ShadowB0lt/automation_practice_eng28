package com.spartaglobal.automationpractice_eng28.StepDefs;

import com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages.BasketPage;
import com.spartaglobal.automationpractice_eng28.AutomationPractice.SeleniumConfig.SeleniumConfig;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class BasketStepDefs {

    private static BasketPage basketPage = new BasketPage(new SeleniumConfig("chrome").getDriver());
    //Add a single product to the basket from the home page
    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        basketPage.goToHomepage();
        basketPage.productHomePageTableData();
        Assert.assertEquals(basketPage.getCurrentPageURL(),"http://automationpractice.com/index.php");
    }

    @When("I click add to cart button")
    public void i_click_add_to_cart_button() {
        basketPage.addToCartButton();
    }

    @Then("pop up menu appears saying product has been added to basket")
    public void pop_up_menu_appears_saying_product_has_been_added_to_basket() {
        Assert.assertTrue(basketPage.checkPopUpMenuIsDisplayed());
    }

    //Add multiple different products to the basket from the home page
    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
      basketPage.goToHomepage();

    }

    @And("I click add to cart button for a product")
    public void i_click_add_to_cart_button_for_a_product() {
        throw new cucumber.api.PendingException();
    }

    @When("I click continue shopping button")
    public void i_click_continue_shopping_button() {
        throw new cucumber.api.PendingException();
    }

    @And("I click add to cart button for a different product")
    public void i_click_add_to_cart_button_for_a_different_product() {
        throw new cucumber.api.PendingException();
    }

    @Then("pop up menu appears saying product has been added to the basket")
    public void pop_up_menu_appears_saying_product_has_been_added_to_the_basket() {
        throw new cucumber.api.PendingException();
    }

    //Go to Basket page after a product confirmed to have been added
    @Given("I have the pop up menu opened")
    public void i_have_the_pop_up_menu_opened() {
        Assert.assertTrue(basketPage.checkPopUpMenuIsDisplayed());
    }

    @When("I click proceed to checkout button")
    public void i_click_proceed_to_checkout_button()
    {
        basketPage.proceedToCheckoutButton();
    }

    @Then("I am on the Basket Page")
    public void i_am_on_the_Basket_Page() {
        Assert.assertEquals(basketPage.getCurrentPageURL(),"http://automationpractice.com/index.php?controller=order");
    }
    //Increase Quantity of a product in the Basket
    @Given("I can see the product in the basket")
    public void i_can_see_the_product_in_the_basket() {

//        String productId = "";
//        for(int i=0;i<basketPage.productBasketTableData().size();i++) {
//            productId = basketPage.productBasketTableData().get(i);
//        }
        Assert.assertTrue(basketPage.checkProductIDMatches("product_1_1_0_0"));
       // Assert.assertEquals(productId, "product_1_1_0_0");
    }

    @When("I click on the plus button")
    public void i_click_on_the_plus_button() {

    }

    @Then("I see the quantity has been increased by {int}")
    public void i_see_the_quantity_has_been_increased_by(Integer int1) {
        throw new cucumber.api.PendingException();
    }

    //Decrease quantity of a product in the basket
    @When("I click on the minus button")
    public void i_click_on_the_minus_button() {
        throw new cucumber.api.PendingException();
    }

    @When("I input a quantity of {int}")
    public void i_input_a_quantity_of(Integer int1) {
        throw new cucumber.api.PendingException();
    }

    //Specify quantity of a product in the basket
    @Then("I see the quantity has been decreased by {int}")
    public void i_see_the_quantity_has_been_decreased_by(Integer int1) {
        throw new cucumber.api.PendingException();
    }

    @Then("I see the quantity has been changed to {int}")
    public void i_see_the_quantity_has_been_changed_to(Integer int1) {
        throw new cucumber.api.PendingException();
    }
    //Proceed to checkout
    @Given("I have a populated basket")
    public void i_have_a_populated_basket() {
        throw new cucumber.api.PendingException();
    }

    @When("I click proceed to checkout")
    public void i_click_proceed_to_checkout() {
        throw new cucumber.api.PendingException();
    }

    @Then("I am on checkout")
    public void i_am_on_checkout() {
        throw new cucumber.api.PendingException();
    }

    //Remove a single product from Basket
    @Given("I am on the basket page")
    public void i_am_on_the_basket_page() {
        throw new cucumber.api.PendingException();
    }

    @When("I click on the delete icon")
    public void i_click_on_the_delete_icon() {
        throw new cucumber.api.PendingException();
    }

    @Then("product is not displayed in basket")
    public void product_is_not_displayed_in_basket() {
        throw new cucumber.api.PendingException();
    }


}
