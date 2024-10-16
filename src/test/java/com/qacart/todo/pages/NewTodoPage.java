package com.qacart.todo.pages;

import com.qacart.todo.models.Todo;
import com.qacart.todo.utils.ConfigUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NewTodoPage {
    private final By NEW_TASK_INPUT_LOCATOR = By.cssSelector("[data-testid=new-todo]");
    private final By SUBMIT_NEW_TASK_LOCATOR = By.cssSelector("[data-testid=submit-newTask]");

    @Step
    public void load(WebDriver driver) {
        driver.get(ConfigUtil.getInstance().getBaseUrl() + "todo/new");
    }

    @Step
    public void createNewTodo(WebDriver driver, Todo todo) {
        driver.findElement(NEW_TASK_INPUT_LOCATOR).sendKeys(todo.getName());
        driver.findElement(SUBMIT_NEW_TASK_LOCATOR).click();
    }

}
