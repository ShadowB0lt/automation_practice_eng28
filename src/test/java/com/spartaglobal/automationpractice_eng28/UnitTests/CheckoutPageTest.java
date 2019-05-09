package com.spartaglobal.automationpractice_eng28.UnitTests;

import com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages.CheckoutPageFirstHalf;
import com.spartaglobal.automationpractice_eng28.AutomationPractice.SeleniumConfig.SeleniumConfig;
import com.sun.source.tree.AssertTree;
import cucumber.api.java.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckoutPageTest {

    private static CheckoutPageFirstHalf checkoutPage;
    private static SeleniumConfig driver;

    @Before
    public void setUp() {
        driver = new SeleniumConfig("chrome");
        checkoutPage = new CheckoutPageFirstHalf(driver.getDriver());
        checkoutPage.goToCheckOutPage();
        checkoutPage.goToHomePage().addProductToCart().clickProceedToCheckout().clickSecondProceedToCheckout().inputUserName().inputPassWord().clickToLogin();
    }

    @Test
    public void testSelectDeliveryAddress() {
        String name = "My second address";
        checkoutPage.toggleBillingAndDeliveryButtonDropDownBox().selectDeliveryAddress(name);
        Boolean automation = checkoutPage.checkAddressValueIsSelected(name);
        Assert.assertEquals(true, automation);
    }

    @Test
    public void testCheckDeliveryAddressDetail() {
        String address = "125 London Wall";
        checkoutPage.selectDeliveryAddress("Office Address");
        Boolean checkAddress = checkoutPage.checkDeliveryAddressDetail(address);
        Assert.assertEquals(true, checkAddress);
    }

    @Test
    public void testcheckBillingAddressDetail() {
        String address = "54 avenue";
        Boolean checkAddress = checkoutPage.checkBillingAddressDetail(address);
        Assert.assertEquals(true, checkAddress);
    }

    @Test
    public void testToggleDropBoxButton() {
        checkoutPage.toggleBillingAndDeliveryButtonDropDownBox();
        Assert.assertFalse(checkoutPage.checkToggleButton());
    }

    @Test
    public void testPayByCheckButton() {
        checkoutPage.getToShippingPage().clickAcceptTermsAndConditions().getToPaymentPage().clickOnPayByCheckButton();
        Assert.assertEquals("CHECK PAYMENT", checkoutPage.checkPayByCheckButton());
    }

    @Test
    public void testCheckOrderConfirmation() {
        checkoutPage.getToShippingPage().clickAcceptTermsAndConditions().getToPaymentPage().clickOnPayByCheckButton().clickConfirmOrderButton();
        Assert.assertEquals(checkoutPage.getConfirmationOfOrder(), "Your order on My Store is complete.");
    }

    @After
    public void quitDriver(){
        driver.quitDriver();
    }
}



