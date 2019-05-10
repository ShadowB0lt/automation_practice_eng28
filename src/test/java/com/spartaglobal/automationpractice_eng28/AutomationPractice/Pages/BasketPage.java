package com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    private By IncreaseQuantityButtonPath = By.xpath("//*[@id=\"cart_quantity_up_1_1_0_0\"]");
    private By decreaseQuantityButtonPath = By.xpath("//*[@id=\"cart_quantity_down_1_1_0_0\"]");
    private By productHomePageList = By.id("homefeatured");
    private By productHomePageListTagName = By.tagName("li");
    private By productBasketProductID = By.id("cart_summary");
    private By basketTableRows = By.tagName("tr");
    private By basketProductQuantityBox = By.xpath("//*[@id=\"product_1_1_0_0\"]/td[5]/input[2]");
    private By basketProductQuantityBoxClassName = By.name("quantity_1_1_0_0");
    private By summaryProductQuantityID = By.id("summary_products_quantity");


    //Map for holding product table from home page
    private Map<String,String> productHomepageDetails;
    private Map<String,String> productBasketDetails;
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
        return productHomepageDetails.containsKey(driver.findElement(productBasketProductID).findElement(By.className("product-name")).getText());
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
        productHomepageDetails = new HashMap<>();
        for (WebElement element : listOfProducts)
        {
            productHomepageDetails.put(
                    element.findElement(By.className("product-name")).getText(),
                    element.findElement(By.className("right-block")).findElement(By.className("content_price")).getText()
            );
        }
        return productHomepageDetails;
    }

    public Map<String,String> productBasketTableData()
    {
        List<WebElement> productTRList = productTable(productBasketProductID).findElements(basketTableRows);
        productBasketDetails = new HashMap<>();
        for(WebElement element : productTRList)
        {
            productBasketDetails.put(
                    element.findElement(By.className("product-name")).getText(),
                    element.findElement(By.className("cart_unit")).findElement(By.className("price")).getText());
        }
        return productBasketDetails;
    }

    public void increaseQuantityButton()
    {
        driver.findElement(IncreaseQuantityButtonPath).click();
        driver.navigate().refresh();
    }

    public void decreaseQuantityButton()
    {
        driver.findElement(decreaseQuantityButtonPath).click();
        driver.navigate().refresh();
    }

    public String getQuantityOfProduct()
    {

        return driver.findElement(basketProductQuantityBox).getAttribute("value");
    }

    public void inputSpecifiedQuantity(int inputValue)
    {
        driver.findElement(basketProductQuantityBoxClassName).clear();
        driver.findElement(basketProductQuantityBoxClassName).sendKeys(Integer.toString(inputValue));
    }

    public String getQuantitySummary()
    {
       String summary =  driver.findElement(summaryProductQuantityID).getText();
       String[] tokens = summary.split(" ");
       return tokens[0];

    }

    public boolean checkIfCheckedOutOfBasketPage()
    {
        if(driver.getCurrentUrl().contains("http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0"
        )|| driver.getCurrentUrl().contains("http://automationpractice.com/index.php?controller=order&step=1"))
        {
            return true;
        }
        else
        {
            return false;
        }
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

    }
}

