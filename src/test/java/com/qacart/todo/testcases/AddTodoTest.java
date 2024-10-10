package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import org.openqa.selenium.By;
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

        // Fill the email
        String email = "automation@example.com";
        WebElement emailInput = driver.findElement(By.cssSelector("[data-testid=email]"));
        emailInput.sendKeys(email);

        // Fill the password
        WebElement passwordInput = driver.findElement(By.cssSelector("[data-testid=password]"));
        passwordInput.sendKeys("Test1234");

        // Click on the signup button
        WebElement submitButton = driver.findElement(By.cssSelector("[data-testid=submit]"));
        submitButton.click();
    }

    @Test
    void should_be_able_to_add_todo() {
        WebElement plusIcon = driver.findElement(By.cssSelector("[data-testid=add]"));
        plusIcon.click();

        String task = "Learn Selenium " + Instant.now().toEpochMilli();

        WebElement newTodoInput = driver.findElement(By.cssSelector("[data-testid=new-todo]"));
        newTodoInput.sendKeys(task);

        WebElement newTodoSubmit = driver.findElement(By.cssSelector("[data-testid=submit-newTask]"));
        newTodoSubmit.click();

        List<WebElement> todosText = driver.findElements(By.cssSelector("[data-testid=todo-text]"));
        String actualTodoText = todosText.getFirst().getText();
        Assert.assertEquals(actualTodoText , task);

    }
}
