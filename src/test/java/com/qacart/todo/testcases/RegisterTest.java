package com.qacart.todo.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTest {

    @Test
    void should_be_able_to_register() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://todo.qacart.com/signup");

        // Fill the first name
        WebElement firstNameInput = driver.findElement(By.cssSelector("[data-testid=first-name]"));
        firstNameInput.sendKeys("Hatem");

        // Fill the last name
        WebElement lastNameInput = driver.findElement(By.cssSelector("[data-testid=last-name]"));
        lastNameInput.sendKeys("Hatamleh");

        // Fill the email
        WebElement emailInput = driver.findElement(By.cssSelector("[data-testid=email]"));
        emailInput.sendKeys("auto_test3@example.com");

        // Fill the password
        WebElement passwordInput = driver.findElement(By.cssSelector("[data-testid=password]"));
        passwordInput.sendKeys("Test1234");

        // Fill the confirm password input
        WebElement confirmPasswordInput = driver.findElement(By.cssSelector("[data-testid=confirm-password]"));
        confirmPasswordInput.sendKeys("Test1234");

        // Click on the signup button
        WebElement submitButton = driver.findElement(By.cssSelector("[data-testid=submit]"));
        submitButton.click();

        // Assert the welcome message is displayed
        WebElement welcomeMessage = driver.findElement(By.cssSelector("[data-testid=welcome]"));
        Assert.assertTrue(welcomeMessage.isDisplayed());

        driver.quit();


    }
}
