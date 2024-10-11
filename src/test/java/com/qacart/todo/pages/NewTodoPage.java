package com.qacart.todo.pages;

import com.qacart.todo.models.Todo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NewTodoPage {
    private final By NEW_TASK_INPUT_LOCATOR = By.cssSelector("[data-testid=new-todo]");
    private final By SUBMIT_NEW_TASK_LOCATOR = By.cssSelector("[data-testid=submit-newTask]");

    public void load(WebDriver driver) {
        driver.get("https://todo.qacart.com/todo/new");
    }

    public void createNewTodo(WebDriver driver, Todo todo) {
        driver.findElement(NEW_TASK_INPUT_LOCATOR).sendKeys(todo.getName());
        driver.findElement(SUBMIT_NEW_TASK_LOCATOR).click();
    }

}
