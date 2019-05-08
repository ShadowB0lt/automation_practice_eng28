package com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages;

import com.spartaglobal.automationpractice_eng28.AutomationPractice.KeyHandlers.KeyReader;
import com.spartaglobal.automationpractice_eng28.AutomationPractice.KeyHandlers.KeySender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;


/**
 * KeyReader and KeySender provide access to the sendKeys and readKeys methods
 */
public class RegistrationPage implements KeyReader, KeySender
{
    private WebDriver driver;

    private static String baseUrl = "http://automationpractice.com/index.php?controller=authentication";

    private static By mrButton = By.id("id_gender1");
    private static By mrsButton = By.id("id_gender2");
    private static By emailCreate = By.id("email_create");
    private static By emailSubmit = By.id("SubmitCreate");
    private static By errorList = By.className("alert-danger");

    private static By regSubmit = By.id("submitAccount");
    private static By custFirstNm = By.id("customer_firstname");
    private static By custFirstNmErr = By.cssSelector(".form-group.form-error input");
    private static By custFirstNmOk = By.cssSelector(".form-group.form-ok input");
    private static String emailCreateId = "email_create";


    public RegistrationPage(WebDriver driver)
    {
        this.driver = driver;
    }

    @Override
    public WebDriver getDriver()
    {
        return driver;
    }

    /**
     * The base url navigates to the 'sign in' page. NavigateToPage moves
     * through this page to the registration form.
     */
    public void navigateToPage()
    {
        driver.navigate().to(baseUrl);
        sendKeysTo(getTestEmail(), emailCreateId);
        driver.findElement(emailSubmit).click();
    }

    public String getCustNameCss()
    {
        return driver.findElement(custFirstNm).getCssValue("color");
    }

    private String getTestEmail()
    {
        Random random = new Random();
        String emailBase = "test";
        String emailFinish = "@test.com";
        return emailBase + random.nextInt(14000000) + emailFinish;
    }

    public void clickRegister()
    {
        driver.findElement(regSubmit).click();
    }

    public RegistrationPage selectMrButton()
    {
        driver.findElement(mrButton).click();
        return this;
    }

    public RegistrationPage selectMrsButton()
    {
        driver.findElement(mrsButton).click();
        return this;
    }

    public boolean isMrSelected()
    {
        List<WebElement> myElements = driver.findElements(By.name("id_gender"));
        return myElements.get(0).isSelected();
    }

    public boolean isMrsSelected()
    {
        List<WebElement> myElements = driver.findElements(By.name("id_gender"));
        return myElements.get(1).isSelected();
    }
    
    public void completeForm()
    {
        sendKeysTo("EngTwentyEight", "customer_firstname");
        sendKeysTo("Class", "customer_lastname");
        sendKeysTo("Engineering28", "passwd");
        sendKeysTo("54 Avenue", "address1");
        sendKeysTo("LA", "city");
        sendKeysTo("90211", "postcode");
        sendKeysTo("07777555123", "phone_mobile");
        selectState("California");
    }

    public void selectState(String state)
    {
        Select stateSelector = new Select(driver.findElement(By.id("id_state")));
        stateSelector.selectByVisibleText(state);
    }

    public void clearField(String fieldId)
    {
        driver.findElement(By.id(fieldId)).clear();
    }

    public String getErrorList()
    {
        return driver.findElement(errorList).getText();
    }


}
