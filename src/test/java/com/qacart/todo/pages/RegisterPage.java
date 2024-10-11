package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Instant;

public class RegisterPage extends BasePage {
    // Locators
    private final By FIRST_NAME_LOCATOR = By.cssSelector("[data-testid=first-name]");
    private final By LAST_NAME_LOCATOR = By.cssSelector("[data-testid=last-name]");
    private final By EMAIL_INPUT_LOCATOR = By.cssSelector("[data-testid=email]");
    private final By PASSWORD_INPUT_LOCATOR = By.cssSelector("[data-testid=password]");
    private final By CONFIRM_PASSWORD_LOCATOR = By.cssSelector("[data-testid=confirm-password]");
    private final By SUBMIT_BUTTON_LOCATOR = By.cssSelector("[data-testid=submit]");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }


    // Methods
    public void register() {
        // Fill the first name
        WebElement firstNameInput = driver.findElement(FIRST_NAME_LOCATOR);
        firstNameInput.sendKeys("Hatem");

        // Fill the last name
        WebElement lastNameInput = driver.findElement(LAST_NAME_LOCATOR);
        lastNameInput.sendKeys("Hatamleh");

        // Fill the email
        long currentTimeStamp = Instant.now().toEpochMilli();
        String email = "auto_test" + currentTimeStamp + "@example.com";
        WebElement emailInput = driver.findElement(EMAIL_INPUT_LOCATOR);
        emailInput.sendKeys(email);

        // Fill the password
        WebElement passwordInput = driver.findElement(PASSWORD_INPUT_LOCATOR);
        passwordInput.sendKeys("Test1234");

        // Fill the confirm password input
        WebElement confirmPasswordInput = driver.findElement(CONFIRM_PASSWORD_LOCATOR);
        confirmPasswordInput.sendKeys("Test1234");

        // Click on the signup button
        WebElement submitButton = driver.findElement(SUBMIT_BUTTON_LOCATOR);
        submitButton.click();
    }

}
