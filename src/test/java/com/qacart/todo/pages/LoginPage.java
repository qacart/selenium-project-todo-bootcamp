package com.qacart.todo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final By EMAIL_INPUT_LOCATOR = By.cssSelector("[data-testid=email]");
    private final By PASSWORD_INPUT_LOCATOR = By.cssSelector("[data-testid=password]");
    private final By SUBMIT_BUTTON_LOCATOR = By.cssSelector("[data-testid=submit]");


    public void login(WebDriver driver) {
        String email = "automation@example.com";
        driver.findElement(EMAIL_INPUT_LOCATOR).sendKeys(email);
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys("Test1234");
        driver.findElement(SUBMIT_BUTTON_LOCATOR).click();
    }

}
