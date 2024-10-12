package com.qacart.todo.base;

import com.qacart.todo.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
    protected void tearDown() {
        getDriver().quit();
    }
}
