package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.RegisterPage;
import com.qacart.todo.pages.TodoPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    void should_be_able_to_register() {
        driver.get("https://todo.qacart.com/signup");

        RegisterPage registerPage = new RegisterPage();
        registerPage.register(driver);

        // Assert the welcome message is displayed
        TodoPage todoPage = new TodoPage();
        WebElement welcomeMessage = todoPage.getWelcomeMessage(driver);
        Assert.assertTrue(welcomeMessage.isDisplayed());

    }
}
