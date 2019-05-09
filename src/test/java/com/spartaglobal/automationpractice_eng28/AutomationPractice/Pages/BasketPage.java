package com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasketPage {

    private WebDriver driver;

    private String homepageURL = "http://automationpractice.com/index.php";
    private By addToCartLink = By.linkText("Add to cart");
    private By moreLink = By.linkText("More");
    private By continueShoppingLink = By.tagName("span");
    private By proceedToCheckoutLink = By.linkText("Proceed to checkout");
    private By popUpMenuID = By.id("layer_cart");
    private By getPopUpMenuClass = By.className("clearfix");
    private By IncreaseQuantityButtonTitle = By.tagName("title");
    private By productHomePageList = By.id("homefeatured");
    private By productHomePageListTagName = By.tagName("li");
    private By productBasketProductID = By.id("cart_summary");
    private By basketTableRows = By.tagName("tr");

    //Map for holding product table from home page
    private Map<String,String> productDetails;
    //List for holding list of products
    private List<WebElement> productList;
    private Products products;

    public BasketPage (WebDriver driver)
    {
        this.driver = driver;
    }

    public void goToHomepage()
    {
        driver.navigate().to(homepageURL);
        productHomePageTableData();
    }

    public String getCurrentPageURL()
    {
        return driver.getCurrentUrl();
    }

    public void addSpecifiedProductToCart()
    {

    }
    private WebElement productTable(By tableName)
    {
        WebElement table = driver.findElement(tableName);
        return table;
    }

    private List<WebElement> productListHomePage()
    {
        return productTable(productHomePageList).findElements(productHomePageListTagName);
    }

    public void addToCartButton()
    {
        driver.findElement(addToCartLink).click();
    }

    public void moreButton()
    {
        driver.findElement(moreLink).click();
    }

    public void continueShoppingButton()
    {
        driver.findElement(By.className("button-container")).findElement(continueShoppingLink).click();
    }

    public boolean checkPopUpMenuIsDisplayed()
    {
       return driver.findElement(getPopUpMenuClass).isDisplayed();
    }

    public void proceedToCheckoutButton()
    {
        driver.findElement(proceedToCheckoutLink).click();
    }

    public boolean checkProductExistsInBasket()
    {
        //System.out.println(productBasketTableData());
      return productDetails.containsKey(driver.findElement(productBasketProductID).findElement(By.className("product-name")).getText());

    }
    public void createProducts()
    {
        List<WebElement> productList = productTable(productHomePageList).findElements(productHomePageListTagName);
        for(WebElement element : productList) {
            products = new Products(element);
        }
    }

    public Map<String,String> productHomePageTableData()
    {
        List<WebElement> listOfProducts = productTable(productHomePageList).findElements(productHomePageListTagName);
        productDetails = new HashMap<>();
        for (WebElement element : listOfProducts)
        {
            productDetails.put(
                    element.findElement(By.className("product-name")).getText(),
                    element.findElement(By.className("right-block")).findElement(By.className("content_price")).getText()
            );
        }
        return productDetails;
    }

    public Map<String,String> productBasketTableData()
    {
        List<WebElement> productTRList = productTable(productBasketProductID).findElement(By.tagName("tbody")).findElements(basketTableRows);
        Map<String,String>  productDetails = new HashMap<>();
        for(WebElement element : productTRList)
        {
            productDetails.put(
                    element.findElement(By.className("cart_description")).findElement(By.className("product-name")).getText(),
                    element.findElement(By.className("cart-unit")).findElement(By.className("price")).getText());
        }
        System.out.println(productDetails.values());
        return productDetails;
    }

    public void increaseQuantityButton()
    {

    }

    public void quitDriver()
    {
        driver.quit();
    }

    private class Products {

        private String productClassID;
        private String productName;
        private String productPrice;
        private String productAddToCartURL;
        private WebElement productList;


        public Products(WebElement productList)
        {
           this.productList = productList;
           productName = productList.findElement(By.className("product-name")).getText();
           productPrice = productList.findElement(By.className("right-block")).findElement(By.className("content_price")).getText();
        }

        public String getProductName() {
            return productName;
        }

        public String getProductPrice()
        {
            return productPrice;
        }

        public WebElement getProductList()
        {
            return productList;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public void setProductPrice(String productPrice) {
            this.productPrice = productPrice;
        }

//        public void setProductList(WebElement productList) {
//            this.productList = productList;
//        }
    }

}

