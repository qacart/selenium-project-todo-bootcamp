package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Instant;
import java.util.List;

public class AddTodoTest extends BaseTest {

    @BeforeMethod
    void login() {
        driver.get("https://todo.qacart.com/login");
        String email = "automation@example.com";
        String password = "Test1234";
        LoginPage loginPage = new LoginPage();
        loginPage.login(driver, email, password);
    }

    @Test
    void should_be_able_to_add_todo() {

        TodoPage todoPage = new TodoPage();
        todoPage.clickOnPlusIcon(driver);

        String task = "Learn Selenium " + Instant.now().toEpochMilli();
        NewTodoPage newTodoPage = new NewTodoPage();
        newTodoPage.createNewTodo(driver , task);

        List<WebElement> todosText = todoPage.getTodosTexts(driver);
        String actualTodoText = todosText.getFirst().getText();
        Assert.assertEquals(actualTodoText , task);

    }
}
