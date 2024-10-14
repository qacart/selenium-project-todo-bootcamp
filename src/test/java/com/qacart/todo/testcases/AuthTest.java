package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.models.User;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.RegisterPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Instant;


@Feature("Auth Features")
public class AuthTest extends BaseTest {

    @Story("Login Functionality")
    @Description("Login test case to make sure that any user can login any time")
    @Test(description = "Should be able to login using valid email and password")
    void should_be_able_to_login() {

        User user = User
                .builder()
                .setEmail(ConfigUtil.getInstance().getEmail())
                .setPassword(ConfigUtil.getInstance().getPassword())
                .build();

        LoginPage loginPage = new LoginPage();
        loginPage.load(driver.get());
        loginPage.login(driver.get(), user);

        // Assert the welcome message is displayed
        TodoPage todoPage = new TodoPage();
        WebElement welcomeMessage = todoPage.getWelcomeMessage(driver.get());
        Assert.assertTrue(welcomeMessage.isDisplayed());
    }

    @Story("Register Functionality")
    @Description("Register test case to make sure that any user can create an account any time")
    @Test(description = "Should be able to create an account")
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
        registerPage.load(getDriver());
        registerPage.register(getDriver(), user);

        // Assert the welcome message is displayed
        TodoPage todoPage = new TodoPage();
        WebElement welcomeMessage = todoPage.getWelcomeMessage(getDriver());
        Assert.assertTrue(welcomeMessage.isDisplayed());

    }
}
