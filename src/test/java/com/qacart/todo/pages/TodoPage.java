package com.qacart.todo.pages;

import org.openqa.selenium.By;

public class TodoPage {
    private By welcomeMessageLocator = By.cssSelector("[data-testid=welcome]");
    private By plusIconLocator = By.cssSelector("[data-testid=add]");
    private By todoTextLocator = By.cssSelector("[data-testid=todo-text]");
    private By deleteIconLocator = By.cssSelector("[data-testid=delete]");
    private By noTodosMessageLocator = By.cssSelector("[data-testid=no-todos]");

}
