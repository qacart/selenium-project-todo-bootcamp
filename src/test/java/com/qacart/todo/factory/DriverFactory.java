package com.qacart.todo.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverFactory {
    String browserName = System.getProperty("browserName" , "Chrome");

    public WebDriver initializeDriver() {
        WebDriver driver;
        if(browserName.equalsIgnoreCase("CHROME")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            return driver;
        } else if (browserName.equalsIgnoreCase("FIREFOX")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            return driver;
        } else {
            throw new IllegalArgumentException("Browser is not supported");
        }


    }
}
