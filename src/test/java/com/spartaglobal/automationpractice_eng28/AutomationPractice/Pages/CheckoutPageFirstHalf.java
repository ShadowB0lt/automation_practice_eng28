package com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages;

import com.spartaglobal.automationpractice_eng28.AutomationPractice.KeyHandlers.KeySender;
import com.spartaglobal.automationpractice_eng28.AutomationPractice.SeleniumConfig.SeleniumConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class CheckoutPageFirstHalf implements KeySender {

    private WebDriver driver;
    private String homePageURL = "http://automationpractice.com/index.php";
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
    private By deliveryAddressDropDown = By.id("id_address_delivery");
    private By stateDropDownBox = By.id("id_state");
    private By payByCheckButton = By.className("cheque");
    private By checkPayment = By.className("page-subheading");
    private By termsAndConditionsTickBox = By.id("cgv");
    private By paymentPageButton = By.name("processCarrier");
    private By confirmOrderButton = By.xpath("//*[@id=\"cart_navigation\"]/button/span");
    private By checkOrderConfirmation = By.className("alert");
    private By bankWirePaymentButton = By.className("bankwire");
    private By bankWireOrderConfirmation = By.className("cheque-indent");
    private By commentBox = By.tagName("textarea");
    private By termsAndConditionErrorMessage = By.className("fancybox-error");

    private List<String> deliveryAddressesList;
    private List<String> billingAddressesList;
    private List<String> billingAddressDetailsList;
    private List<String> deliveryAddressDetailsList;
    private List<String> deliveryAddressesDropDownList;

    public CheckoutPageFirstHalf(WebDriver driver) {
        this.driver = driver;
        }

    public WebElement findElement(By element){
        return driver.findElement(element);}

    public List<WebElement> findElements(By element){
        return driver.findElements(element);}

    public void goToHomePage(){
        driver.navigate().to(homePageURL);
    }

    public String generateRandomAddress(String candidateChars, int length){
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++){
            stringBuilder.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
        }
        return stringBuilder.toString();
    }

    public void deleteKeys(By element){
        driver.findElement(element).clear();
    }

    public CheckoutPageFirstHalf toggleBillingAndDeliveryButtonDropDownBox(){
        findElement(billingAndDeliveryButton).click();
        return this;
    }

    public boolean checkToggleButton(){
        return findElement(billingAndDeliveryButton).isSelected();
    }

    //Scenario: add new address

    public CheckoutPageFirstHalf clickAddNewAddress(){
        findElement(addNewAddressButton).click();
        return this;
    }

    public CheckoutPageFirstHalf selectStateFromDropDown(String state){
        Select stateDropdown = new Select(driver.findElement(stateDropDownBox));
        stateDropdown.selectByVisibleText(state);
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
        System.out.println(driver.findElement(By.tagName("iframe")).getText());
        driver.get("http://automationpractice.com/index.php?controller=order");

        driver.switchTo().frame("fancybox-inner");

        return driver.findElement(By.className("fancybox-inner")).isDisplayed();
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

    //Choose a different delivery address

    private List<String> getDeliveryAddresses(){
        List<String> deliveryAddresses = new ArrayList<>();
        WebElement dropdown = driver.findElement(deliveryAddressDropDown);

        List<WebElement> deliveryAddressOptions = dropdown.findElements(By.tagName("option"));
        Iterator<WebElement> it = deliveryAddressOptions.iterator();
        while (it.hasNext()) {
            deliveryAddresses.add(it.next().getText().trim());
            deliveryAddressesDropDownList = deliveryAddresses;
        }
        return deliveryAddressesDropDownList;
    }

    public void selectDeliveryAddress(String addressName) {
        //Create list of continents from getContinentElementsAsStringList
        getDeliveryAddresses();
        if (deliveryAddressesDropDownList.contains(addressName)) {
            // You need to create a Select object but call the individual element that contains
            // If you check the drop down
            Select deliveryAddressOptions = new Select(driver.findElement(deliveryAddressDropDown));
            deliveryAddressOptions.selectByVisibleText(addressName);
        } else if (!deliveryAddressesDropDownList.contains(addressName)) {
            System.out.println("Please select one of the below options");

            for (String deliveryAddress : deliveryAddressesDropDownList) {
                System.out.println(deliveryAddress);
            }
        }
    }

    public boolean checkAddressValueIsSelected(String deliveryAddress){
        boolean selectedCorrectly;

        Select deliveryAddressOptions = new Select(driver.findElement(deliveryAddressDropDown));
        selectedCorrectly = deliveryAddressOptions.getFirstSelectedOption().getText().trim().equals(deliveryAddress);

        return selectedCorrectly;
    }

    //Scenario: I would like to pay by check

    public CheckoutPageFirstHalf clickAcceptTermsAndConditions(){
        driver.findElement(termsAndConditionsTickBox).click();
        return this;
    }

    public CheckoutPageFirstHalf getToPaymentPage(){
        driver.findElement(paymentPageButton).click();
        return this;
    }

    public CheckoutPageFirstHalf clickOnPayByCheckButton(){
        driver.findElement(payByCheckButton).click();
        return this;
    }

    public String checkPayByCheckButton(){
        return driver.findElement(checkPayment).getText().trim();
    }

    public CheckoutPageFirstHalf clickConfirmOrderButton(){
        driver.findElement(confirmOrderButton).click();
        return this;
    }

    public String getConfirmationOfOrder(){
        return driver.findElement(checkOrderConfirmation).getText();
    }

    //Scenario: I would like to pay by bankwire

    public CheckoutPageFirstHalf clickPayByBankWire(){
        driver.findElement(bankWirePaymentButton).click();
        return this;
    }

    public String confirmationOrderMessage(){
        return driver.findElement(bankWireOrderConfirmation).getText();


    }

    //Scenario: I would like to add a comment to the order

    public CheckoutPageFirstHalf inputComment(String comment){
        driver.findElement(commentBox).sendKeys(comment);
        return this;
    }

    public String checkCommentIsOnThePage(){
        return driver.findElement(commentBox).getAttribute("value");
    }

    //Scenario: I would like to continue with my purchase without accepting the terms and conditions

    public String errorMessage(){
        return driver.findElement(termsAndConditionErrorMessage).getText();

    }

    private Actions actionOnWebElement(){
        return new Actions(driver);
    }

    public void moveToElement(By byFinder){
        actionOnWebElement().moveToElement(driver.findElement(byFinder));
    }

    private void addProduct() {

        WebElement element = driver.findElement(By.className("left-block"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        WebElement subElement = driver.findElement(By.linkText("Add to cart"));
        subElement.click();
    }

























//temporary methods to get to the address page





    public CheckoutPageFirstHalf navigateToCheckout(){
        driver.navigate().to(homePageURL);
        addProduct();
        driver.findElement(By.linkText("Proceed to checkout")).click();
        driver.findElement(By.linkText("Proceed to checkout")).click();
        driver.findElement(By.id("email")).sendKeys("engineering.28.sstvw@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("3NG_s8SSTVW");
        driver.findElement(By.id("SubmitLogin")).click();
        return this;
    }

    @Override
    public WebDriver getDriver() {
        return this.driver;
    }

    @Override
    public void sendKeysTo(String input, String classid) {
        findElement(By.id(classid)).sendKeys(input);
    }


}
