package com.spartaglobal.automationpractice_eng28.AutomationPractice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    private String loginPageURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private By emailField = By.id("email");
    private By passwordField = By.id("passwd");
    private By emailError = By.className("alert alert-danger");
    private By passwordError = By.className("alert alert-danger");
    private By loginButton = By.id("SubmitLogin");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private WebElement findElement(By element){
        return driver.findElement(element);
    }

    public LoginPage goToLoginPage(){
        driver.navigate().to(loginPageURL);
        return this;
    }

    public LoginPage inputEmail(String email){
        findElement(emailField).sendKeys(email);
        return this;
    }

    public String checkEmailISDisplayed(){
        return findElement(emailField).getAttribute("value");
    }

    public LoginPage inputPassword(String password){
        findElement(passwordField).sendKeys(password);
        return this;
    }

    public String checkPasswordISDisplayedIs(){
        return findElement(passwordField).getAttribute("value");
    }

    public String getEmailErrorMessage(){
        return findElement(emailError).getText();
    }

    public String getPasswordErrorMessage(){
        return findElement(passwordError).getText();
    }

    public void clickLogInButton(){
        findElement(loginButton).click();
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }
}
