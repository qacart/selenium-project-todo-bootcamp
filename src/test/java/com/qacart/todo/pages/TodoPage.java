package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TodoPage extends BasePage {
    // Locators
    private final By WELCOME_MESSAGE_LOCATOR = By.cssSelector("[data-testid=welcome]");
    private final By PLUS_ICON_LOCATOR = By.cssSelector("[data-testid=add]");
    private final By TODOS_TEXT_LOCATOR = By.cssSelector("[data-testid=todo-text]");
    private final By DELETE_ICON_LOCATOR = By.cssSelector("[data-testid=delete]");
    private final By NO_TODOS_MESSAGE_LOCATOR = By.cssSelector("[data-testid=no-todos]");

    public TodoPage(WebDriver driver) {
        super(driver);
    }

    @Step
    @Override
    public void load() {
        driver.get(ConfigUtil.getInstance().getBaseUrl() + "/todo");
    }

    @Step
    public WebElement getWelcomeMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(WELCOME_MESSAGE_LOCATOR));
    }

    @Step
    public void clickOnPlusIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PLUS_ICON_LOCATOR)).click();
    }

    @Step
    public List<WebElement> getTodosTexts () {
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(TODOS_TEXT_LOCATOR));
    }

    @Step
    public void deleteTodo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DELETE_ICON_LOCATOR)).click();
    }

    @Step
    public WebElement getNoTodosMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(NO_TODOS_MESSAGE_LOCATOR));
    }

}
