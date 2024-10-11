package com.qacart.todo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NewTodoPage {
    private final By NEW_TASK_INPUT_LOCATOR = By.cssSelector("[data-testid=new-todo]");
    private final By SUBMIT_NEW_TASK_LOCATOR = By.cssSelector("[data-testid=submit-newTask]");

    public void createNewTodo(WebDriver driver, String task) {
        driver.findElement(NEW_TASK_INPUT_LOCATOR).sendKeys(task);
        driver.findElement(SUBMIT_NEW_TASK_LOCATOR).click();
    }

}
