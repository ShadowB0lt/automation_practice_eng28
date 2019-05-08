package com.spartaglobal.automationpractice_eng28.UnitTests;

import com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages.RegistrationPage;
import com.spartaglobal.automationpractice_eng28.AutomationPractice.SeleniumConfig.SeleniumConfig;
import org.junit.*;
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

    @Before
    public void resetPage() throws InterruptedException
    {
        regPage.navigateToPage();
        Thread.sleep(2000);
    }


    @Test
    public void testNavigation()
    {
        regPage.navigateToPage();

        String testString = driver.findElement(By.id("noSlide")).getText();
        Assert.assertTrue(testString.contains("CREATE"));
    }

    @Test
    public void testKeySend()
    {
        String testString = "myname";
        String testClass = "firstname";
        regPage.sendKeysTo(testString, "firstname");
        Assert.assertEquals(regPage.readKeys(testClass),testString);

    }

    @Test
    public void testCheckButton()
    {
        regPage.selectMrButton();
        regPage.getClickedTitle();
    }

    @Test
    public void testSubmit()
    {
        regPage.clickRegister();
        String errorList = driver.findElement(By.className("alert-danger")).getText();
        Assert.assertTrue(errorList.contains("is required"));
    }

    @Test
    public void testNameError()
    {
        regPage.sendKeysTo("hi42\t", "customer_firstname");
        Assert.assertTrue(regPage.getCustNameCss().contains("241, 51"));
    }

    @Test
    public void testFormCompletion()
    {
        regPage.completeForm();
        regPage.clickRegister();
        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));
    }

//    @AfterClass
//    public static void tearDown()
//    {
//        driver.quit();
//    }


}
