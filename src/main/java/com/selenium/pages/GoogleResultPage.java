package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleResultPage {
    By firstLinkLocator = By.xpath("//*[@id=\"rso\"]/div/div/div[1]//cite");
    private WebDriver driver;

    public GoogleResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLink () {
        WebElement link = driver.findElement(firstLinkLocator);
        return link;
    }
}
