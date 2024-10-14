package com.qacart.todo.pages;

import com.qacart.todo.models.User;
import com.qacart.todo.utils.ConfigUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final By EMAIL_INPUT_LOCATOR = By.cssSelector("[data-testid=email]");
    private final By PASSWORD_INPUT_LOCATOR = By.cssSelector("[data-testid=password]");
    private final By SUBMIT_BUTTON_LOCATOR = By.cssSelector("[data-testid=submit]");


    @Step
    public void load(WebDriver driver) {
        driver.get(ConfigUtil.getInstance().getBaseUrl() + "/login");
    }

    @Step
    public void login(WebDriver driver, User user) {
        driver.findElement(EMAIL_INPUT_LOCATOR).sendKeys(user.getEmail());
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(user.getPassword());
        driver.findElement(SUBMIT_BUTTON_LOCATOR).click();
    }

}
