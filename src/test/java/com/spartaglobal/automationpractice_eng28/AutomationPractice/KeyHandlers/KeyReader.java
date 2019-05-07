package com.spartaglobal.automationpractice_eng28.AutomationPractice.KeyHandlers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public interface KeyReader {

    public WebDriver getDriver();

    //Key Sender
    default String readKeys(String input, String classid){
        return getDriver().findElement(By.id(classid)).getAttribute("value");
    }
}
