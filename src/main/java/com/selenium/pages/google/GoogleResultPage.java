package com.selenium.pages.google;

import com.selenium.core.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleResultPage extends Page {
    By firstLinkLocator = By.xpath("//*[@id=\"rso\"]/div/div/div[1]//cite");
    By navigationBar = By.xpath("//*[@id=\"navcnt\"]");

    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLink() {
        WebElement link = driver.findElement(firstLinkLocator);
        return link;
    }

    public String getTitle() {
        wait.until(ExpectedConditions.elementToBeClickable(navigationBar));
        return driver.getTitle();
    }
}
