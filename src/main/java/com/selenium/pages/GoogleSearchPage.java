package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

    private WebDriver driver;
    By searchLocator = By.id("lst-ib");
    WebElement searchField;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String searchText) {
        searchField = driver.findElement(searchLocator);
        searchField.sendKeys(searchText);
        searchField.submit();
    }
}
