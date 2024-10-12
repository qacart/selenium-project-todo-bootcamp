package com.qacart.todo.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class DriverFactory {
    String browserName = System.getProperty("browserName", "Chrome");

    public WebDriver initializeDriver() {
        WebDriver driver;
        switch (browserName.toUpperCase()) {
            case "CHROME" -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
            }
            case "FIREFOX" -> {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                driver = new FirefoxDriver(options);
            }
            default -> throw new IllegalArgumentException("Browser is not supported");
        }
        driver.manage().window().maximize();
        return driver;
    }
}
