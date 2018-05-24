package com.selenium.core;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;
import static org.openqa.selenium.remote.BrowserType.IE;

@Listeners(TestListener.class)

public class WebDriverTestBase {

    protected WebDriver driver;
    protected String browser = System.getProperty("browser");

    @BeforeClass
    public void setup() {
//        switch (browser.toLowerCase()) {
//            case CHROME:
//                ChromeDriverManager.getInstance().setup();
//                driver = new ChromeDriver();
//                break;
//            case FIREFOX:
//                FirefoxDriverManager.getInstance().setup();
//                driver = new FirefoxDriver();
//                break;
//            case IE:
//                InternetExplorerDriverManager.getInstance().setup();
//                driver = new InternetExplorerDriver();
//                break;
//        }
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}
