package com.selenium.pages.gmail;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class GmailLoginPage {
    private String pageURL = "https://gmail.com";

    private WebDriver driver;

    public GmailLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step ("Logging in bla bla")
    public void login(String userEmail, String userPassword) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(pageURL);

        // entering user email into email field
        WebElement emailField = driver.findElement(By.id("identifierId"));
        emailField.sendKeys(userEmail);
        emailField.sendKeys(Keys.ENTER);

        // entering user password into password field, locating Next button and proceeding
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]//input[@name=\"password\"]"));
        passwordField.sendKeys(userPassword);
        WebElement nextButton = driver.findElement(By.id("passwordNext"));
        nextButton.click();
    }

}
