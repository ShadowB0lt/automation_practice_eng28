package com.spartaglobal.automationpractice_eng28.UnitTests;

import com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages.CheckoutPageFirstHalf;
import com.spartaglobal.automationpractice_eng28.AutomationPractice.SeleniumConfig.SeleniumConfig;
import com.sun.source.tree.AssertTree;
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
        checkoutPage.goToHomePage().clickAddToCart().clickProceedToCheckout().clickSecondProceedToCheckout().inputUserName().inputPassWord().clickToLogin();
    }

    @Test
    public void testSelectDeliveryAddress() {
        String name = "Office Address";
        checkoutPage.toggleBillingAndDeliveryButtonDropDownBox().selectDeliveryAddress("Office Address");
        Boolean automation = checkoutPage.checkAddressValueIsSelected("Office Address");
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
    public void testToggleDropBoxButton(){
        checkoutPage.toggleBillingAndDeliveryButtonDropDownBox();
        Assert.assertFalse(checkoutPage.checkToggleButton());
    }
}

