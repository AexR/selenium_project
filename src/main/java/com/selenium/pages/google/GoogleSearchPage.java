package com.selenium.pages.google;

import com.selenium.core.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage extends Page {

    By searchLocator = By.id("lst-ib");
    By searchButtonLocator = By.xpath("//*[@id=\"tsf\"]//input[@name=\"btnK\"]");
    WebElement searchField;

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public void search(String searchText) throws InterruptedException {
        searchField = driver.findElement(searchLocator);
        Thread.sleep(2000);
        searchField.sendKeys(searchText);
        Thread.sleep(2000);
        searchField.submit();
    }
}
