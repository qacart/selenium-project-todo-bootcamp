package com.qacart.todo.base;

import com.qacart.todo.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    protected void setup() {
        driver = new DriverFactory().initializeDriver();
    }

    @AfterMethod
    protected void tearDown() {
        driver.quit();
    }
}
