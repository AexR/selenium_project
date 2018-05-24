package com.selenium.pages.thomascook;

import com.selenium.core.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultsPage extends Page {

    public List<String> resultsList;
    private String packageLocationLocatorXPath = "//*[@id=\"content-container\"]/search-results-page//p[@class=\"PackageHeader-destination\"]";

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getPackageLocationsList() {
        List<WebElement> locations = driver.findElements(By.xpath(packageLocationLocatorXPath));
        for (WebElement i : locations
                ) {
            resultsList.add(i.getText());
        }
        return resultsList;
    }
}
