package com.selenium.pages.thomascook;

import com.selenium.core.Page;
import org.openqa.selenium.*;

public class SearchPage extends Page {

    String fromFieldContainerLocatorXPath = "//*[@id=\"SearchbarForm-originContainer\"]/div/div/div/tc-typeahead/div/div[2]";
    String fromFieldLocatorXPath = "//*[@id=\"SearchbarForm-origin\"]";

    String toFieldContainerLocatorXPath = "//*[@id=\"SearchbarForm-destinationContainer\"]/div/div/div/tc-typeahead/div/div[2]";
    String toFieldLocatorXPath = "//*[@id=\"SearchbarForm-goingTo\"]";
    String fromSearchString = "London Luton";
    String toSearchString = "Coral Bay, Cyprus";

    String searchButtonLocatorXPath = "SearchbarForm-submitBtn";

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void enterFromLocation() throws InterruptedException {
        WebElement fromFieldContainer = driver.findElement(By.xpath(fromFieldContainerLocatorXPath));
        fromFieldContainer.click();
        WebElement fromField = driver.findElement(By.xpath(fromFieldLocatorXPath));
        fromField.sendKeys(fromSearchString);
        Thread.sleep(2000);
        fromField.sendKeys(Keys.DOWN);
        fromField.sendKeys(Keys.ENTER);
    }

    public void enterToLocation() throws InterruptedException {
        WebElement fromFieldContainer = driver.findElement(By.xpath(toFieldContainerLocatorXPath));
        fromFieldContainer.click();
        WebElement fromField = driver.findElement(By.xpath(toFieldLocatorXPath));
        fromField.sendKeys(toSearchString);
        Thread.sleep(2000);
        fromField.sendKeys(Keys.DOWN);
        fromField.sendKeys(Keys.ENTER);
    }

    public void clickSearch(){
        WebElement searchButton = driver.findElement(By.id(searchButtonLocatorXPath));
        searchButton.click();
    }


}
