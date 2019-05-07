package com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages;

import com.spartaglobal.automationpractice_eng28.AutomationPractice.KeyHandlers.KeyReader;
import com.spartaglobal.automationpractice_eng28.AutomationPractice.KeyHandlers.KeySender;
import org.openqa.selenium.WebDriver;


/**
 * KeyReader and KeySender provide access to the sendKeys and readKeys methods
 */
public class RegistrationPage implements KeyReader, KeySender
{
    private WebDriver driver;

    public RegistrationPage(WebDriver driver)
    {
        this.driver = driver;
    }


    @Override
    public WebDriver getDriver()
    {
        return driver;
    }



}
