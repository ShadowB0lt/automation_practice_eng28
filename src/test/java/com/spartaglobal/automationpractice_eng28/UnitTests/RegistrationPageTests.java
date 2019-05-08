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

    public void testSubmit()
    {
        regPage.clickRegister();

    }

    @AfterClass
    public static void tearDown()
    {
        driver.quit();
    }


}
