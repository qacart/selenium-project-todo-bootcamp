package com.qacart.todo.base;

import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.utils.ScreenshotUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;


public class BaseTest {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return this.driver.get();
    }

    @BeforeMethod
    protected void setup() {
        this.driver.set(new DriverFactory().initializeDriver());
    }

    @AfterMethod
    protected void tearDown(ITestResult result) {
        ScreenshotUtils.takeScreenshot(getDriver(), result);
        getDriver().quit();
    }
}