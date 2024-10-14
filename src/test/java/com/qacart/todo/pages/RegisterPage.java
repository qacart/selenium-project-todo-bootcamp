package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.models.User;
import com.qacart.todo.utils.ConfigUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegisterPage extends BasePage {

    private final By FIRST_NAME_LOCATOR = By.cssSelector("[data-testid=first-name]");
    private final By LAST_NAME_LOCATOR = By.cssSelector("[data-testid=last-name]");
    private final By EMAIL_INPUT_LOCATOR = By.cssSelector("[data-testid=email]");
    private final By PASSWORD_INPUT_LOCATOR = By.cssSelector("[data-testid=password]");
    private final By CONFIRM_PASSWORD_LOCATOR = By.cssSelector("[data-testid=confirm-password]");
    private final By SUBMIT_BUTTON_LOCATOR = By.cssSelector("[data-testid=submit]");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step
    @Override
    public void load() {
        driver.get(ConfigUtil.getInstance().getBaseUrl() + "/signup");
    }

    @Step
    public void register(User user) {
        driver.findElement(FIRST_NAME_LOCATOR).sendKeys(user.getFirstName());
        driver.findElement(LAST_NAME_LOCATOR).sendKeys(user.getLastName());
        driver.findElement(EMAIL_INPUT_LOCATOR).sendKeys(user.getEmail());
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(user.getPassword());
        driver.findElement(CONFIRM_PASSWORD_LOCATOR).sendKeys(user.getConfirmPassword());
        driver.findElement(SUBMIT_BUTTON_LOCATOR).click();
    }

}
