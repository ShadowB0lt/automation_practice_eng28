package com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages;

import com.spartaglobal.automationpractice_eng28.AutomationPractice.KeyHandlers.KeyReader;
import com.spartaglobal.automationpractice_eng28.AutomationPractice.KeyHandlers.KeySender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * KeyReader and KeySender provide access to the sendKeys and readKeys methods
 */
public class RegistrationPage implements KeyReader, KeySender
{
    private WebDriver driver;

    private static String baseUrl = "";

    private static By mrButton = By.id("id_gender1");
    private static By mrsButton = By.id("id_gender2");


    public RegistrationPage(WebDriver driver)
    {
        this.driver = driver;
    }

    /**
     * The base url navigates to the 'sign in' page
     */
    public void navigateToPage()
    {

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
