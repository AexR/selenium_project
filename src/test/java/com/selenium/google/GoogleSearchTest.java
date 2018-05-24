package com.selenium.google;

import com.selenium.core.WebDriverTestBase;
import com.selenium.pages.google.GoogleResultPage;
import com.selenium.pages.google.GoogleSearchPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends WebDriverTestBase {

    private String pageURL = "https://www.google.com.ua";
    private String searchString = "seleniumhq";
    private String resultPageTitle = "seleniumhq - Пошук Google";

    @Test
    public void searchText() throws InterruptedException {

        driver.get(pageURL);

        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.search(searchString);

        GoogleResultPage googleResultPage = new GoogleResultPage(driver);
        WebElement firstResultUrlText = googleResultPage.getLink();

        Assert.assertTrue(firstResultUrlText.getText().contains(searchString), "was not found");
    }

    @Test(dependsOnMethods = {"searchText"})
    public void titleUpdated() {
        GoogleResultPage googleResultPage = new GoogleResultPage(driver);
        Assert.assertTrue(googleResultPage.getTitle().contains(resultPageTitle));
    }
}
