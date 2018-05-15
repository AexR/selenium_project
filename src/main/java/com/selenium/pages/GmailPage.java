package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPage {

    WebDriver driver;

    public GmailPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean searchFieldLoaded() {
        // waiting for gmail page to load (and show search string)
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement searchField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aso_search_form_anchor")));
        return searchField.isDisplayed();
    }
}
