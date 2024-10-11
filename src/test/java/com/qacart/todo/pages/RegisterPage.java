package com.qacart.todo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegisterPage {
    // Locators
    private final By FIRST_NAME_LOCATOR = By.cssSelector("[data-testid=first-name]");
    private final By LAST_NAME_LOCATOR = By.cssSelector("[data-testid=last-name]");
    private final By EMAIL_INPUT_LOCATOR = By.cssSelector("[data-testid=email]");
    private final By PASSWORD_INPUT_LOCATOR = By.cssSelector("[data-testid=password]");
    private final By CONFIRM_PASSWORD_LOCATOR = By.cssSelector("[data-testid=confirm-password]");
    private final By SUBMIT_BUTTON_LOCATOR = By.cssSelector("[data-testid=submit]");


    // Methods
    public void register(WebDriver driver, String firstName, String lastName, String email, String password, String confirmPassword) {
        driver.findElement(FIRST_NAME_LOCATOR).sendKeys(firstName);
        driver.findElement(LAST_NAME_LOCATOR).sendKeys(lastName);
        driver.findElement(EMAIL_INPUT_LOCATOR).sendKeys(email);
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(password);
        driver.findElement(CONFIRM_PASSWORD_LOCATOR).sendKeys(confirmPassword);
        driver.findElement(SUBMIT_BUTTON_LOCATOR).click();
    }

}
