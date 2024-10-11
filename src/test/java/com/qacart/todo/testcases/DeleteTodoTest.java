package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.RegisterPage;
import com.qacart.todo.pages.TodoPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Instant;

public class DeleteTodoTest extends BaseTest {

    TodoPage todoPage;

    @BeforeMethod
    void register_and_add_todo() {
        driver.get("https://todo.qacart.com/signup");

        String firstName = "Hatem";
        String lastName = "Hatamleh";
        long currentTimeStamp = Instant.now().toEpochMilli();
        String email = "auto_test" + currentTimeStamp + "@example.com";
        String password = "Test1234";
        String confirmPassword = "Test1234";

        RegisterPage registerPage = new RegisterPage();
        registerPage.register(driver, firstName, lastName, email, password, confirmPassword);

        todoPage = new TodoPage();
        todoPage.clickOnPlusIcon(driver);

        String task = "Learn Selenium " + Instant.now().toEpochMilli();

        NewTodoPage newTodoPage = new NewTodoPage();
        newTodoPage.createNewTodo(driver, task);
    }

    @Test
    void should_be_able_to_delete_todo() {
        todoPage.deleteTodo(driver);
        WebElement noTodosMessage = todoPage.getNoTodosMessage(driver);
        Assert.assertTrue(noTodosMessage.isDisplayed());
    }
}
