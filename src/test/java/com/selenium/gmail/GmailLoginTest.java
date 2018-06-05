package com.selenium.gmail;

import com.selenium.core.WebDriverTestBase;
import com.selenium.pages.gmail.GmailLoginPage;
import com.selenium.pages.gmail.GmailPage;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GmailLoginTest extends WebDriverTestBase {

    private String pageURL = "https://gmail.com";
    private String userEmail = "alexradua@gmail.com";
    private String userPassword = "BzNEj45swqMXoTtIAYyK";

    @Test
    @Step
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
