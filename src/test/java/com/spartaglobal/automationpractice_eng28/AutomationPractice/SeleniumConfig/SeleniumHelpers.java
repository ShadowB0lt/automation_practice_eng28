package com.spartaglobal.automationpractice_eng28.AutomationPractice.SeleniumConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeleniumHelpers {

    public static void hoverOverElement(WebDriver driver, WebElement webElement) {
        Actions actionDriver = new Actions(driver);
        actionDriver.moveToElement(webElement).build().perform();
    }



}