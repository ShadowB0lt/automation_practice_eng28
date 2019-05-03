package com.spartaglobal.automationpractice_eng28.AutomationPractice.KeyHandlers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public interface KeySender {

    public WebDriver getDriver();

    //Key Sender
    default void sendKeysTo(String input, String classid){
        getDriver().findElement(By.id(classid)).sendKeys(input);
    }

}
