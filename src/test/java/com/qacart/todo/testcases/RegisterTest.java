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
        driver.get("https://todo.qacart.com/signup");

        String firstName = "Hatem";
        String lastName = "Hatamleh";
        long currentTimeStamp = Instant.now().toEpochMilli();
        String email = "auto_test" + currentTimeStamp + "@example.com";
        String password = "Test1234";
        String confirmPassword = "Test1234";

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setConfirmPassword(confirmPassword);

        RegisterPage registerPage = new RegisterPage();
        registerPage.register(driver, user);

        // Assert the welcome message is displayed
        TodoPage todoPage = new TodoPage();
        WebElement welcomeMessage = todoPage.getWelcomeMessage(driver);
        Assert.assertTrue(welcomeMessage.isDisplayed());

    }
}
