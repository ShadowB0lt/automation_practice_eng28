package com.spartaglobal.automationpractice_eng28.UnitTests;

import com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages.BasketPage;
import com.spartaglobal.automationpractice_eng28.AutomationPractice.SeleniumConfig.SeleniumConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class BasketPageTest {

    private static WebDriver driver;
    private static BasketPage basketPage;


    @Before
    public void setup()
    {
        basketPage = new BasketPage(new SeleniumConfig("chrome").getDriver());
        basketPage.goToHomepage();
    }

    @Test
    public void checkQuantityAfterIncreaseButtonValueTest()
    {
        basketPage.addToCartButton();
        basketPage.proceedToCheckoutButton();
        System.out.println(basketPage.getQuantityOfProduct());
        basketPage.increaseQuantityButton();
        System.out.println(basketPage.getQuantityOfProduct());
    }

    @Test
    public void checkQuantityAfterDecreaseButtonvalueTest()
    {
        basketPage.addToCartButton();
        basketPage.continueShoppingButton();
        basketPage.addToCartButton();
        basketPage.proceedToCheckoutButton();
        System.out.println(basketPage.getQuantityOfProduct());
        basketPage.decreaseQuantityButton();
        System.out.println(basketPage.getQuantityOfProduct());
    }

    @Test
    public void inputSpecifiedQuantity()
    {
        basketPage.addToCartButton();
        basketPage.proceedToCheckoutButton();
        basketPage.inputSpecifiedQuantity(5);
        Assert.assertEquals(basketPage.getQuantityOfProduct(),"5");
    }

    @Test
    public void getSummaryOfProducts()
    {
        basketPage.addToCartButton();
        basketPage.proceedToCheckoutButton();
        System.out.println(basketPage.getQuantitySummary());
    }

    @Test
    public void checkIfCheckedOutOfBasket()
    {
        basketPage.addToCartButton();
        basketPage.proceedToCheckoutButton();
        basketPage.proceedToCheckoutButton();
        Assert.assertTrue(basketPage.checkIfCheckedOutOfBasketPage());
    }


}
