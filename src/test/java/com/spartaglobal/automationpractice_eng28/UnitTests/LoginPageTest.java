package com.spartaglobal.automationpractice_eng28.UnitTests;

import static org.junit.Assert.assertTrue;

import com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages.HomePage;
import com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages.LoginPage;
import com.spartaglobal.automationpractice_eng28.AutomationPractice.SeleniumConfig.SeleniumConfig;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class LoginPageTest
{
    /**
     * Rigorous Test :-)
     */

    private static LoginPage loginPage;
    private static SeleniumConfig driver;

    @Before
    public void setUp(){
        driver = new SeleniumConfig("chrome");
        loginPage = new LoginPage(driver.getDriver());
        loginPage.goToLoginPage();
    }

    @Test
    public void testEmailInput() {
        loginPage.inputEmail("hello");
        String actual = loginPage.checkEmailISDisplayed();
        String email = "hello";
        Assert.assertEquals( actual, email);
    }

    @Test
    public void testEmailIsDisplayed(){
        loginPage.inputEmail("hello") ;
        String email = "hello";
        Assert.assertEquals(loginPage.checkEmailISDisplayed(), email);
    }

    @Test
    public void testPasswordInput()
    {
        loginPage.inputPassword("hello");
        String actual = loginPage.checkPasswordISDisplayedIs();
        String password = "hello";
        Assert.assertEquals( actual, password);
    }

    @Test
    public void testLoginButtonClick(){
        loginPage.inputEmail("engineering.28.sstvw@gmail.com");
        loginPage.inputPassword("3NG_s8SSTVW");
        loginPage.clickLogInButton();
        String URL = "http://automationpractice.com/index.php?controller=my-account";
        Assert.assertEquals(loginPage.getCurrentURL(), URL);
    }

    @Test
    public void testEmailErrorMessageIsDisplayed(){
        loginPage.inputEmail("hithere@hithere.hi.there");
        loginPage.inputPassword("hithere1");
        loginPage.clickLogInButton();
        Assert.assertEquals(loginPage.getEmailErrorMessage(), "Authentication failed.");
    }

    @Test
    public void testPasswordErrorMessageIsDisplayed(){
        loginPage.inputEmail("engineering.28.sstvw@gmail.com");
        loginPage.inputPassword("wrongpassword");
        loginPage.clickLogInButton();
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), "Authentication failed.");
    }

    @Test
    public void testEmail1ErrorMessageIsDisplayed(){
        loginPage.inputEmail("hithere@@hithere.hi.there");
        loginPage.inputPassword("hithere1");
        loginPage.clickLogInButton();
        Assert.assertEquals(loginPage.getEmailErrorMessage(), "Invalid email address.");
    }

    @Test
    public void testPassword1ErrorMessageIsDisplayed(){
        loginPage.inputEmail("engineering.28.sstvw@gmail.com");
        loginPage.inputPassword("hi");
        loginPage.clickLogInButton();
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), "Invalid password.");
    }

    @After
    public void quitDriver(){
        driver.quitDriver();
    }
}
