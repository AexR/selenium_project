package com.selenium.gmail;

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

public class GmailLoginTest {

    private String pageURL = "https://gmail.com";
    private String userEmail = "alexander.radey@gmail.com";
    private String userPassword = "spiv0chep0le2";
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        // System.setProperty("webdriver.chrome.driver", "c:\\DATA\\driver\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void loginTest() throws InterruptedException {
        driver.get(pageURL);
        Assert.assertTrue(driver.getTitle().contains("Gmail"));

        // entering user email into email field
        WebElement emailField = driver.findElement(By.id("identifierId"));
        emailField.sendKeys(userEmail);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        emailField.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        // entering user password into password field, locating Next button and proceeding
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]//input[@name=\"password\"]"));
        passwordField.sendKeys(userPassword);
        WebElement nextButton = driver.findElement(By.id("passwordNext"));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        nextButton.click();

        // waiting for gmail page to load (and show search string)
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement searchField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aso_search_form_anchor")));
        Assert.assertTrue(searchField.isDisplayed());
    }

    @Test(dependsOnMethods = {"loginTest"})
    public void checkForNewEmailsTest() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Inbox ("));
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}
