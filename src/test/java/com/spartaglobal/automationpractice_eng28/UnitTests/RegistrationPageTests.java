package com.spartaglobal.automationpractice_eng28.UnitTests;

import com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages.RegistrationPage;
import com.spartaglobal.automationpractice_eng28.AutomationPractice.SeleniumConfig.SeleniumConfig;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageTests
{
    private static WebDriver driver;
    private static RegistrationPage regPage;


    @BeforeClass
    public static void setUp()
    {
        driver = new SeleniumConfig("chrome").getDriver();
        regPage = new RegistrationPage(driver);
    }

    @Test
    public void testNavigation()
    {
        regPage.navigateToPage();

        String testString = driver.findElement(By.id("noSlide")).getText();
        Assert.assertTrue(testString.contains("CREATE"));
    }

    @AfterClass
    public static void tearDown()
    {
        driver.quit();
    }






}
