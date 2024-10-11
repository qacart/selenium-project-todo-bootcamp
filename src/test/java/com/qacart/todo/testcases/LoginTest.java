package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.models.User;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtil;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTest extends BaseTest {

    @Test
    void should_be_able_to_login() {

        User user = User
                .builder()
                .setEmail(ConfigUtil.getInstance().getEmail())
                .setPassword(ConfigUtil.getInstance().getPassword())
                .build();

        LoginPage loginPage = new LoginPage();
        loginPage.load(driver);
        loginPage.login(driver, user);

        // Assert the welcome message is displayed
        TodoPage todoPage = new TodoPage();
        WebElement welcomeMessage = todoPage.getWelcomeMessage(driver);
        Assert.assertTrue(welcomeMessage.isDisplayed());

    }
}
