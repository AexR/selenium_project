package com.selenium.w3schools;

import com.selenium.core.WebDriverTestBase;
import com.selenium.pages.w3schools.TryItPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TryItTest extends WebDriverTestBase {
    private String pageURL = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm";
    private String expectedDemoText = "You pressed K!";

    @Test
    public void myTest() {
        driver.get(pageURL);
        TryItPage tryItPage = new TryItPage(driver);
        tryItPage.clickButtonUsingJS();
        tryItPage.clickOkButton();
        Assert.assertEquals(tryItPage.getDemoText(), expectedDemoText);
    }

    @Test
    public void myTest2() {
            driver.get(pageURL);
            TryItPage tryItPage = new TryItPage(driver);
            tryItPage.clickButtonUsingSelenium();
            tryItPage.clickOkButton();
            Assert.assertEquals(tryItPage.getDemoText(), expectedDemoText);

    }
}
