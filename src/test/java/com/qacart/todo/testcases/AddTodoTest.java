package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.models.Todo;
import com.qacart.todo.models.User;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Instant;
import java.util.List;

@Feature("Todo Features")
public class AddTodoTest extends BaseTest {

    @BeforeMethod
    void login() {
        User user = User
                .builder()
                .setEmail(ConfigUtil.getInstance().getEmail())
                .setPassword(ConfigUtil.getInstance().getPassword())
                .build();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.load();
        loginPage.login(user);
    }

    @Story("Add Todo Functionality")
    @Description("To make sure tha users can create a new todo")
    @Test(description = "Should be able to add a todo to the application")
    void should_be_able_to_add_todo() {

        TodoPage todoPage = new TodoPage(getDriver());
        todoPage.clickOnPlusIcon();

        String taskName = "Learn Selenium " + Instant.now().toEpochMilli();
        Todo todo = new Todo();
        todo.setName(taskName);
        NewTodoPage newTodoPage = new NewTodoPage(getDriver());
        newTodoPage.createNewTodo(todo);

        List<WebElement> todosText = todoPage.getTodosTexts();
        String actualTodoText = todosText.getFirst().getText();
        Assert.assertEquals(actualTodoText , taskName);

    }
}
