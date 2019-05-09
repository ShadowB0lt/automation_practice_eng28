package com.spartaglobal.automationpractice_eng28.UnitTests;

import com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages.HomePage;
import com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages.RegistrationPage;
import com.spartaglobal.automationpractice_eng28.AutomationPractice.SeleniumConfig.SeleniumConfig;
import com.spartaglobal.automationpractice_eng28.AutomationPractice.SeleniumConfig.SeleniumHelpers;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumconfigTesting {

    private static WebDriver driver;
    private static HomePage homePage;
    private static SeleniumConfig selConf;


    @BeforeClass
    public static void setUp()
    {
        driver = new SeleniumConfig("chrome").getDriver();
        homePage = new HomePage(driver);
    }

    @Test
    public void test(){
        driver.navigate().to(homePage.homePageurl);
        SeleniumHelpers.hoverOverElement(driver, driver.findElement(By.className("first-in-line")));
    }

}
