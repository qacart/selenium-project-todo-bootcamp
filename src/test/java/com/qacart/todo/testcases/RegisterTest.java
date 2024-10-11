package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Instant;

public class RegisterTest extends BaseTest {

    @Test
    void should_be_able_to_register() {
        driver.get("https://todo.qacart.com/signup");

        RegisterPage registerPage = new RegisterPage();
        registerPage.register(driver);

        // Assert the welcome message is displayed
        WebElement welcomeMessage = driver.findElement(By.cssSelector("[data-testid=welcome]"));
        Assert.assertTrue(welcomeMessage.isDisplayed());

    }
}
