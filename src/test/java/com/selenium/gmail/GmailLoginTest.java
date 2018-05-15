package com.selenium.gmail;

import com.selenium.core.WebDriverTestBase;
import com.selenium.pages.GmailLoginPage;
import com.selenium.pages.GmailPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GmailLoginTest extends WebDriverTestBase {

    private String pageURL = "https://gmail.com";
    private String userEmail = "my@gmail.com";
    private String userPassword = "W3lcome";

    @Test
    public void loginTest() throws InterruptedException {

        GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);
        gmailLoginPage.login(userEmail, userPassword);

        GmailPage gmailPage = new GmailPage(driver);
        Assert.assertTrue(gmailPage.searchFieldLoaded());
    }

    @Test(dependsOnMethods = {"loginTest"})
    public void checkForNewEmailsTest() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Inbox ("));
    }

}
