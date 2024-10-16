package com.qacart.todo.pages;

import com.qacart.todo.utils.ConfigUtil;
import com.qacart.todo.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TodoPage {
    // Locators
    private final By WELCOME_MESSAGE_LOCATOR = By.cssSelector("[data-testid=welcome]");
    private final By PLUS_ICON_LOCATOR = By.cssSelector("[data-testid=add]");
    private final By TODOS_TEXT_LOCATOR = By.cssSelector("[data-testid=todo-text]");
    private final By DELETE_ICON_LOCATOR = By.cssSelector("[data-testid=delete]");
    private final By NO_TODOS_MESSAGE_LOCATOR = By.cssSelector("[data-testid=no-todos]");

    @Step
    public void load(WebDriver driver) {
        driver.get(ConfigUtil.getInstance().getBaseUrl() + "/todo");
    }

    @Step
    public WebElement getWelcomeMessage(WebDriver driver) {
        return WaitUtils.waitForElementToBeVisible(driver, WELCOME_MESSAGE_LOCATOR );
    }

    @Step
    public void clickOnPlusIcon(WebDriver driver) {
        WaitUtils.waitForElementToBeVisible(driver, PLUS_ICON_LOCATOR).click();
    }

    @Step
    public List<WebElement> getTodosTexts (WebDriver driver) {
        return WaitUtils.waitForElementsToBeVisible(driver, TODOS_TEXT_LOCATOR);
    }

    @Step
    public void deleteTodo(WebDriver driver) {
        WaitUtils.waitForElementToBeVisible(driver, DELETE_ICON_LOCATOR).click();
    }

    @Step
    public WebElement getNoTodosMessage(WebDriver driver) {
        return WaitUtils.waitForElementToBeVisible(driver, NO_TODOS_MESSAGE_LOCATOR);
    }

}
