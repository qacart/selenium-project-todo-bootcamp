package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTest extends BaseTest {

    @Test
    void should_be_able_to_login() {
        driver.get("https://todo.qacart.com/login");

        // Fill the email
        String email = "automation@example.com";
        String password = "Test1234";
        LoginPage loginPage = new LoginPage();
        loginPage.login(driver, email, password);

        // Assert the welcome message is displayed
        TodoPage todoPage = new TodoPage();
        WebElement welcomeMessage = todoPage.getWelcomeMessage(driver);
        Assert.assertTrue(welcomeMessage.isDisplayed());

    }
}
