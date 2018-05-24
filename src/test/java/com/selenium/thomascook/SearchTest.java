package com.selenium.thomascook;

import com.selenium.core.WebDriverTestBase;
import com.selenium.pages.thomascook.ResultsPage;
import com.selenium.pages.thomascook.SearchPage;
import org.testng.annotations.Test;

public class SearchTest extends WebDriverTestBase {
    String pageURL = "https://www.thomascook.com/";

    @Test
    public void searchTest() throws InterruptedException {
        driver.get(pageURL);
        driver.navigate().refresh();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterFromLocation();
        searchPage.enterToLocation();
        searchPage.clickSearch();

//        ResultsPage resultsPage = new ResultsPage(driver);

        Thread.sleep(5000);
    }
}
