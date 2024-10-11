package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTest extends BaseTest {

    @Test
    void should_be_able_to_login() {
        driver.get("https://todo.qacart.com/login");

        // Fill the email
        LoginPage loginPage = new LoginPage();
        loginPage.login(driver);

        // Assert the welcome message is displayed
        WebElement welcomeMessage = driver.findElement(By.cssSelector("[data-testid=welcome]"));
        Assert.assertTrue(welcomeMessage.isDisplayed());

    }
}
