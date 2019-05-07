package com.spartaglobal.automationpractice_eng28.StepDefs;

import com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages.LoginPage;
import com.spartaglobal.automationpractice_eng28.AutomationPractice.SeleniumConfig.SeleniumConfig;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.PublicKey;

public class LoginStepDefs {

    private static LoginPage loginPage;
    private static SeleniumConfig driver;

    @Before
    public void setUp(){
        driver = new SeleniumConfig("chrome");
        loginPage = new LoginPage(driver.getDriver());
        loginPage.goToLoginPage();
    }


    //Scenario: As a registered user, I can login


    @Given("I enter a valid email and password")
    public void I_enter_a_valid_email_and_password(){
        loginPage.inputEmail("engineering.28.sstvw@gmail.com");
        loginPage.inputPassword("3NG_s8SSTVW");
    }

    @When("I click sign in")
    public void I_click_sign_in(){
        loginPage.clickLogInButton();
    }

    @Then("I am taken to the My Account page")
    public void I_am_taken_to_the_My_Account_page(){
        String URL = "http://automationpractice.com/index.php?controller=my-account";
        Assert.assertEquals(loginPage.getCurrentURL(), URL);
    }


    // Scenario Outline: Inputting an invalid email generates an error


    @Given("I am on the login page")
    public void I_am_on_the_login_page(){
    }

    @When("I input the necessary details with email {string}")
    public void I_input_the_necessary_details_with_email(String email){
        loginPage.inputEmail(email);
        loginPage.inputPassword("randomPassword1");
        loginPage.clickLogInButton();
    }

    @Then("I get the corresponding email error {string}")
    public void I_get_the_corresponding_email_error(String error){
        String errorMessage = loginPage.getEmailErrorMessage();
        Assert.assertEquals(errorMessage, error);
    }


    // Scenario Outline: Inputting an invalid password generates an error


    @When("I input the correct email with an invalid password {string}")
    public void I_input_the_correct_email_with_an_invalid_password(String password){
        loginPage.inputEmail("engineering.28.sstvw@gmail.com");
        loginPage.inputPassword(password);
        loginPage.clickLogInButton();
    }

    @Then("I get the corresponding password error {string}")
    public void I_get_the_corresponding_password_error(String error){
        String errorMessage = loginPage.getPasswordErrorMessage();
        Assert.assertEquals(errorMessage, error);
    }


    // Scenario: Inputting a password but not an email address


    @When("I input a password but no email")
    public void I_input_a_password_but_no_email(){
        loginPage.inputPassword("randomPassowrd1");
        loginPage.clickLogInButton();
    }


    @Then("I receive an email error message")
    public void I_receive_an_email_error_message(){
        String error = loginPage.getEmailErrorMessage();
        Assert.assertEquals(error, "An email address required.");
    }


    // Scenario: Inputting an email but not a password


    @When("I input an email but no password")
    public void I_input_an_email_but_no_password(){
        loginPage.inputEmail("test@test.com");
        loginPage.clickLogInButton();
    }

    @Then("I receive a password error message")
    public void I_receive_a_password_error_message(){
        String error = loginPage.getPasswordErrorMessage();
        Assert.assertEquals(error, "Password is required.");
    }

    @After
    public void quitDriver(){
        driver.quitDriver();
    }
}
