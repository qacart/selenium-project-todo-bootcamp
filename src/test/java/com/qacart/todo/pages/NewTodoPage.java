package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.models.Todo;
import com.qacart.todo.utils.ConfigUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NewTodoPage extends BasePage {
    private final By NEW_TASK_INPUT_LOCATOR = By.cssSelector("[data-testid=new-todo]");
    private final By SUBMIT_NEW_TASK_LOCATOR = By.cssSelector("[data-testid=submit-newTask]");

    public NewTodoPage(WebDriver driver) {
        super(driver);
    }

    @Step
    @Override
    public void load() {
        driver.get(ConfigUtil.getInstance().getBaseUrl() + "todo/new");
    }

    @Step
    public void createNewTodo(Todo todo) {
        driver.findElement(NEW_TASK_INPUT_LOCATOR).sendKeys(todo.getName());
        driver.findElement(SUBMIT_NEW_TASK_LOCATOR).click();
    }

}
