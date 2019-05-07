package com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CheckoutPageFirstHalf {

    private WebDriver driver;
    private String checkoutPageURL = "http://automationpractice.com/index.php?controller=order&step=1";
    private By billingAndDeliveryButton = By.id("addressesAreEquals");
    private By addNewAddressButton = By.linkText("Add a new address");
    private By saveNewAddressButton = By.id("submitAddress");
    private By deliveryAddressesElements = By.id("id_address_delivery");
    private By billingAddressesElements = By.id("id_address_invoice");
    private By shippingPageButton = By.name("processAddress");
    private By termsAndConditionsButton = By.linkText("(Read the Terms of Service)");
    private By termsAndConditions = By.xpath("//*[@id=\"order\"]/div[2]/div");// FIX LATER
    private By updateBillingAddressButton = By.linkText("Update");
    private By deliveryAndBillingAddressInformation = By.cssSelector("li[class^='address']");


    private List<String> deliveryAddressesList;
    private List<String> billingAddressesList;
    private List<String> billingAddressDetailsList;
    private List<String> deliveryAddressDetailsList;

    public CheckoutPageFirstHalf(WebDriver driver) {
        this.driver = driver;
        }

    public WebElement findElement(By element){
        return driver.findElement(element);}

    public List<WebElement> findElements(By element){
        return driver.findElements(element);}

    public void goToCheckOutPage(){
        driver.navigate().to(checkoutPageURL);
    }

    public CheckoutPageFirstHalf togglebillingAndDeliveryButtonDropDownBox(){
        findElement(billingAndDeliveryButton).click();
        return this;
    }

    //Scenario: add new address

    public CheckoutPageFirstHalf clickAddNewAddress(){
        findElement(addNewAddressButton).click();
        return this;
    }

    //INSERT METHODS FOR FILLING OUT FORM

    public CheckoutPageFirstHalf clickSaveAddressButton(){
        findElement(saveNewAddressButton).click();
        return this;
    }

    private List<String> getDeliveryAddressesElements() {

        ArrayList<String> deliveryAddresses = new ArrayList<>();
        WebElement dropdown = driver.findElement(deliveryAddressesElements);
        List<WebElement> deliveryOptions = dropdown.findElements(By.tagName("option"));
        Iterator<WebElement> it = deliveryOptions.iterator();
        while (it.hasNext()) {
            deliveryAddresses.add(it.next().getText().trim());
        }
        deliveryAddressesList = deliveryAddresses;
        return deliveryAddressesList;
    }

    public boolean checkDeliveryAddress(String address){
        getDeliveryAddressesElements();
        return deliveryAddressesList.contains(address);
    }

    private List<String> getBillingAddressesElements() {

        ArrayList<String> billingAddresses = new ArrayList<>();
        WebElement dropdown = driver.findElement(billingAddressesElements);
        List<WebElement> billingOptions = dropdown.findElements(By.tagName("option"));
        Iterator<WebElement> it = billingOptions.iterator();
        while (it.hasNext()) {
            billingAddresses.add(it.next().getText().trim());
        }
        billingAddressesList = billingAddresses;
        return billingAddressesList;
    }

    public boolean checkBillingAddress(String address){
        getBillingAddressesElements();
        return billingAddressesList.contains(address);
    }

//SCENARIO: check terms and conditions

    public CheckoutPageFirstHalf getToShippingPage(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(shippingPageButton).click();
        return this;
    }

    public CheckoutPageFirstHalf clickViewTAndCbutton(){
        driver.findElement(termsAndConditionsButton).click();
        return this;
    }

    public Object getWindow(){
        Set<String> windowHandles = driver.getWindowHandles();
        Object [] windowHandlesArray = windowHandles.toArray();
        return windowHandlesArray[0];
        }


    public boolean isTermsAndConditionsDisplayed(){
        driver.switchTo().frame("CDwindow-E2EEF4B378C93C5F81265DD6A45BDCDA");
        return driver.findElement(By.id("cms")).isDisplayed();
    }

 //SCENARIO: UPDATE BILLING ADDRESS

    public CheckoutPageFirstHalf clickUpdateBillingAddressButton(){
        List<WebElement> updateAddressesButtons = driver.findElements(updateBillingAddressButton);
        updateAddressesButtons.get(1).click();
        return this;
    }
 //insert methods to change the billing address

    private List<String> getUpdatedBillingAddressesDetails() {

        int countAllWebElements = 0;
        ArrayList<String> updatedAddresses = new ArrayList<>();
        ArrayList<String> updatedBillingAddresses = new ArrayList<>();
        for (WebElement billingElement : driver.findElements(deliveryAndBillingAddressInformation)) {
            updatedAddresses.add(billingElement.getText());
        }
        while (countAllWebElements < updatedAddresses.size()){
            updatedAddresses.remove("Update");
            countAllWebElements++;
            }
        int yourBillingAddressIndex = updatedAddresses.indexOf("YOUR BILLING ADDRESS");
        for(int billingAddresIndex = yourBillingAddressIndex; billingAddresIndex<updatedAddresses.size(); billingAddresIndex++){
            updatedBillingAddresses.add(updatedAddresses.get(billingAddresIndex));
            }
        billingAddressDetailsList = updatedBillingAddresses;
        return billingAddressDetailsList;
    }

    public boolean checkBillingAddressDetail(String addressDetail){
        getUpdatedBillingAddressesDetails();
        return billingAddressDetailsList.contains(addressDetail);
    }

    //SCENARIO: UPDATE DELIVERY ADDRESS

    public CheckoutPageFirstHalf clickUpdateDeliveryAddressButton(){
        List<WebElement> updateAddressesButtons = driver.findElements(updateBillingAddressButton);
        updateAddressesButtons.get(0).click();
        return this;
    }
    //insert methods to change the delivery address

    private List<String> getUpdatedDeliveryAddressesDetails() {

        int countAllWebElements = 0;
        ArrayList<String> updatedAddresses = new ArrayList<>();
        ArrayList<String> updatedDeliveryAddresses = new ArrayList<>();
        for (WebElement deliveryElement : driver.findElements(deliveryAndBillingAddressInformation)) {
            updatedAddresses.add(deliveryElement.getText());
        }
        while (countAllWebElements < updatedAddresses.size()){
            updatedAddresses.remove("Update");
            countAllWebElements++;
        }
        int yourDeliveryAddressIndex = updatedAddresses.indexOf("YOUR DELIVERY ADDRESS");
        for(int deliveryAddresIndex = yourDeliveryAddressIndex; deliveryAddresIndex < updatedAddresses.indexOf("YOUR BILLING ADDRESS"); deliveryAddresIndex++){
            updatedDeliveryAddresses.add(updatedAddresses.get(deliveryAddresIndex));
        }
        deliveryAddressDetailsList = updatedDeliveryAddresses;
        return deliveryAddressDetailsList;
    }

    public boolean checkDeliveryAddressDetail(String addressDetail){
        getUpdatedDeliveryAddressesDetails();
        return deliveryAddressDetailsList.contains(addressDetail);
    }


















//temporary methods to get to the address page
     public CheckoutPageFirstHalf step1(){
        driver.findElement(By.id("header_logo")).click();
        return this;
     }

    public CheckoutPageFirstHalf step2(){
        driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]")).click();
        return this;
    }

    public CheckoutPageFirstHalf step3(){
        driver.findElement(By.linkText("Proceed to checkout")).click();
        return this;
    }

    public CheckoutPageFirstHalf step4() {
        driver.findElement(By.linkText("Proceed to checkout")).click();
        return this;
    }

    public CheckoutPageFirstHalf step5(){
        driver.findElement(By.id("email")).sendKeys("engineering.28.sstvw@gmail.com");
        return this;
    }

    public CheckoutPageFirstHalf step6(){
        driver.findElement(By.id("passwd")).sendKeys("3NG_s8SSTVW");
        return this;
    }

    public CheckoutPageFirstHalf step7(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("SubmitLogin")).click();
        return this;
    }


}
