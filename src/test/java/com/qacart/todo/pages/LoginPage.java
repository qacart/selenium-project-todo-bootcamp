package com.qacart.todo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;
    private final By EMAIL_INPUT_LOCATOR = By.cssSelector("[data-testid=email]");
    private final By PASSWORD_INPUT_LOCATOR = By.cssSelector("[data-testid=password]");
    private final By SUBMIT_BUTTON_LOCATOR = By.cssSelector("[data-testid=submit]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        String email = "automation@example.com";
        WebElement emailInput = driver.findElement(EMAIL_INPUT_LOCATOR);
        emailInput.sendKeys(email);

        // Fill the password
        WebElement passwordInput = driver.findElement(PASSWORD_INPUT_LOCATOR);
        passwordInput.sendKeys("Test1234");

        // Click on the signup button
        WebElement submitButton = driver.findElement(SUBMIT_BUTTON_LOCATOR);
        submitButton.click();
    }

}
