package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Instant;
import java.util.List;

public class DeleteTodoTest extends BaseTest {



    @BeforeMethod
    void register_and_add_todo() {
        driver.get("https://todo.qacart.com/signup");

        // Fill the first name
        WebElement firstNameInput = driver.findElement(By.cssSelector("[data-testid=first-name]"));
        firstNameInput.sendKeys("Hatem");

        // Fill the last name
        WebElement lastNameInput = driver.findElement(By.cssSelector("[data-testid=last-name]"));
        lastNameInput.sendKeys("Hatamleh");

        // Fill the email
        long currentTimeStamp = Instant.now().toEpochMilli();
        String email = "auto_test" + currentTimeStamp + "@example.com";
        WebElement emailInput = driver.findElement(By.cssSelector("[data-testid=email]"));
        emailInput.sendKeys(email);

        // Fill the password
        WebElement passwordInput = driver.findElement(By.cssSelector("[data-testid=password]"));
        passwordInput.sendKeys("Test1234");

        // Fill the confirm password input
        WebElement confirmPasswordInput = driver.findElement(By.cssSelector("[data-testid=confirm-password]"));
        confirmPasswordInput.sendKeys("Test1234");

        // Click on the signup button
        WebElement submitButton = driver.findElement(By.cssSelector("[data-testid=submit]"));
        submitButton.click();

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

    @Test
    void should_be_able_to_delete_todo() {
        WebElement deleteIcon = driver.findElement(By.cssSelector("[data-testid=delete]"));
        deleteIcon.click();
        WebElement noTodosMessage = driver.findElement(By.cssSelector("[data-testid=no-todos]"));
        Assert.assertTrue(noTodosMessage.isDisplayed());

    }
}
