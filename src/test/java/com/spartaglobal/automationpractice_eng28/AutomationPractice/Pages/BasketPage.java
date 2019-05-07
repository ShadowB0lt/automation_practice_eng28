package com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class BasketPage {

    private WebDriver driver;

    private String homepageURL = "http://automationpractice.com/index.php";
    private By addToCartLink = By.linkText("Add to cart");
    private By proceedToCheckoutLink = By.linkText("Proceed to checkout");
    private By popUpMenuID = By.id("layer_cart");
    private By getPopUpMenuClass = By.className("clearfix");
    private By IncreaseQuantityButtonTitle = By.tagName("title");
    private By productHomePageList = By.id("homefeatured");
    private By productListHomePage = By.tagName("li");


    public BasketPage (WebDriver driver)
    {
        this.driver = driver;
    }

    public void goToHomepage()
    {
        driver.navigate().to(homepageURL);
    }

    public String getCurrentPageURL()
    {
        return driver.getCurrentUrl();
    }

    public void addToCartButton()
    {

        driver.findElement(addToCartLink).click();
    }

    public boolean checkPopUpMenuIsDisplayed()
    {
       return driver.findElement(getPopUpMenuClass).isDisplayed();
    }

    public void checkPopUpMenuIsVisible()
    {

    }
    public void proceedToCheckoutButton()
    {
        driver.findElement(proceedToCheckoutLink).click();
    }

    public List<String> productBasketTableData()
    {
        WebElement table = driver.findElement(By.id("cart_summary"));

        List<WebElement> productTRList = table.findElements(By.tagName("tr"));
        List<String> productIDList = new ArrayList<>();
        for(WebElement element : productTRList)
        {
            productIDList.add(element.getAttribute("id"));
            //System.out.println(element.getAttribute("id"));
        }
        return productIDList;
    }


    public Map<String,String> productHomePageTableData()
    {
        WebElement table = driver.findElement(productHomePageList);

        List<WebElement> productList =  table.findElements(productListHomePage);
        Map<String,String> productNames = new HashMap<>();
        for (WebElement element : productList)
        {
            productNames.put(
                    element.findElement(By.className("product-name")).getText(),
                    element.findElement(By.className("right-block")).findElement(By.className("content_price")).getText());
            }
        System.out.println(productNames.get("Faded Short Sleeve T-shirts"));
        return productNames;
    }

    public boolean checkProductIDMatches(String chosenProductID)
    {
       return productBasketTableData().contains(chosenProductID);
    }

    public void increaseQuantityButton()
    {

    }


}
