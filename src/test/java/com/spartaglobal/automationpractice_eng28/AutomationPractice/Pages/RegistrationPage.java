package com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages;

import com.spartaglobal.automationpractice_eng28.AutomationPractice.KeyHandlers.KeyReader;
import com.spartaglobal.automationpractice_eng28.AutomationPractice.KeyHandlers.KeySender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    private static By regSubmit = By.id("submitAccount");
    private static String emailCreateId = "email_create";


    public RegistrationPage(WebDriver driver)
    {
        this.driver = driver;
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

    @Override
    public WebDriver getDriver()
    {
        return driver;
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

    public String getClickedTitle()
    {
        return "";
    }



}
