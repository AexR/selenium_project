package com.selenium.google;

import com.selenium.core.WebDriverTestBase;
import com.selenium.pages.GoogleResultPage;
import com.selenium.pages.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearchTest extends WebDriverTestBase {

    private String pageURL = "https://www.google.com.ua";
    private String searchString = "seleniumhq";

    @Test
    public void searchText() {

        driver.get(pageURL);

        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.search(searchString);

        GoogleResultPage googleResultPage = new GoogleResultPage(driver);
        WebElement firstResultUrlText = googleResultPage.getLink();

        Assert.assertTrue(firstResultUrlText.getText().contains(searchString),"was not found");
    }
}
