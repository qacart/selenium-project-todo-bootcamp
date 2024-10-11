package com.qacart.todo.pages;

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

    public void load(WebDriver driver) {
        driver.get("https://todo.qacart.com/todo");
    }

    public WebElement getWelcomeMessage(WebDriver driver) {
        return driver.findElement(WELCOME_MESSAGE_LOCATOR);
    }

    public void clickOnPlusIcon(WebDriver driver) {
        driver.findElement(PLUS_ICON_LOCATOR).click();
    }

    public List<WebElement> getTodosTexts (WebDriver driver) {
        return driver.findElements(TODOS_TEXT_LOCATOR);
    }

    public void deleteTodo(WebDriver driver) {
        driver.findElement(DELETE_ICON_LOCATOR).click();
    }

    public WebElement getNoTodosMessage(WebDriver driver) {
        return driver.findElement(NO_TODOS_MESSAGE_LOCATOR);
    }

}
