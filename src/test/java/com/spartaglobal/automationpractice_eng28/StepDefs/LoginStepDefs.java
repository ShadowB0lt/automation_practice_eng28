package com.spartaglobal.automationpractice_eng28.StepDefs;

import com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefs {

    private static LoginPage loginPage;
    private static WebDriver driver;

    private void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\VKapoor\\Documents\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
    }


    //Scenario: As a registered user, I can login
    @Given("I enter a valid email and password")
    public void given1(){
        setUp();
        loginPage.inputEmail("engineering.28.sstvw@gmail.com");
        loginPage.inputPassword("3NG_s8SSTVW");
    }


    @When("I click sign in")
    public void when1(){
        loginPage.clickLogInButton();
    }


    @Then("I am taken to the My Account page")
    public void then1(){
        String URL = "http://automationpractice.com/index.php?controller=my-account";
        Assert.assertEquals(loginPage.getCurrentURL(), URL);
    }


    // Scenario Outline: Inputting an invalid email generates an error

    @Given("I am on the login page")
    public void given2(){
        setUp();
    }

    @When("I input the necessary details with email {string}")
    public void when2(String email){
        loginPage.inputEmail()
        loginPage.inputPassword("hello")
    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }

}
