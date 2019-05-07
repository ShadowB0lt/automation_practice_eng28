package com.spartaglobal.automationpractice_eng28.UnitTests;

import com.spartaglobal.automationpractice_eng28.AutomationPractice.SeleniumConfig.SeleniumConfig;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class RegistrationPageTests
{
    private static WebDriver driver;

    @BeforeClass
    public static void setUp()
    {
        WebDriver driver = new SeleniumConfig("chrome").getDriver();
    }



    private String getTestEmail()
    {
        return "";
    }

}
