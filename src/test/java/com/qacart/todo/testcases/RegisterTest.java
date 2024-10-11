package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.models.User;
import com.qacart.todo.pages.RegisterPage;
import com.qacart.todo.pages.TodoPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Instant;

public class RegisterTest extends BaseTest {

    @Test
    void should_be_able_to_register() {

        long currentTimeStamp = Instant.now().toEpochMilli();
        String email = "auto_test" + currentTimeStamp + "@example.com";

        User user = User
                .builder()
                .setFirstName("Hatem")
                .setLastName("Hatamleh")
                .setEmail(email)
                .setPassword("Test1234")
                .setConfirmPassword("Test1234")
                .build();

        RegisterPage registerPage = new RegisterPage();
        registerPage.load(driver);
        registerPage.register(driver, user);

        // Assert the welcome message is displayed
        TodoPage todoPage = new TodoPage();
        WebElement welcomeMessage = todoPage.getWelcomeMessage(driver);
        Assert.assertTrue(welcomeMessage.isDisplayed());

    }
}
