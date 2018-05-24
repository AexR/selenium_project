package com.selenium.pages.w3schools;

import com.selenium.core.Page;
import org.openqa.selenium.*;

public class TryItPage extends Page {
    String demoTextID = "demo";
    String frameName = "iframeResult";
    String buttonLocatorXPath = "/html/body/button";
    String buttonLocatorCSS = "body > button";

    public TryItPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonUsingJS() {
        driver.switchTo().frame(frameName);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"" + buttonLocatorCSS + "\").click()");
    }

    public void clickButtonUsingSelenium() {
        driver.switchTo().frame(frameName);
        By buttonLocator = new By.ByXPath(buttonLocatorXPath);
        WebElement button = driver.findElement(buttonLocator);
        button.click();
    }

    public void clickOkButton() {
        driver.switchTo().alert().accept();
    }

    public String getDemoText() {
        By demoTextLocator = new By.ById(demoTextID);
        WebElement demoText = driver.findElement(demoTextLocator);
        return demoText.getText();
    }


}
