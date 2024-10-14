package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.models.Todo;
import com.qacart.todo.models.User;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.RegisterPage;
import com.qacart.todo.pages.TodoPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Instant;

@Feature("Todo Features")
public class DeleteTodoTest extends BaseTest {

    TodoPage todoPage;

    @BeforeMethod
    void register_and_add_todo() {
        long currentTimeStamp = Instant.now().toEpochMilli();
        String email = "auto_test" + currentTimeStamp + "@example.com";

        User user = User
                .builder()
                .setFirstName("Hatem")
                .setLastName("Hatamleh")
                .setEmail(email)
                .setPassword("Test1234")
                .setConfirmPassword("Test1234")
                .build();

        RegisterPage registerPage = new RegisterPage();
        registerPage.load(getDriver());
        registerPage.register(getDriver(), user);

        todoPage = new TodoPage();
        todoPage.clickOnPlusIcon(getDriver());

        String taskName = "Learn Selenium " + Instant.now().toEpochMilli();

        NewTodoPage newTodoPage = new NewTodoPage();
        Todo todo = new Todo();
        todo.setName(taskName);
        newTodoPage.createNewTodo(getDriver(), todo);
    }

    @Story("Delete Todo Functionality")
    @Description("To make sure tha users can delete a todo any time")
    @Test(description = "Should be able to delete a Todo")
    void should_be_able_to_delete_todo() {
        todoPage.deleteTodo(getDriver());
        WebElement noTodosMessage = todoPage.getNoTodosMessage(getDriver());
        Assert.assertTrue(noTodosMessage.isDisplayed());
    }
}
