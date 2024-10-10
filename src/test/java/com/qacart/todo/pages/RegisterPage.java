package com.qacart.todo.pages;

import org.openqa.selenium.By;

public class RegisterPage {
    private By firstNameLocator = By.cssSelector("[data-testid=first-name]");
    private By lastNameLocator = By.cssSelector("[data-testid=last-name]");
    private By emailInputLocator = By.cssSelector("[data-testid=email]");
    private By passwordInputLocator = By.cssSelector("[data-testid=password]");
    private By confirmPasswordLocator = By.cssSelector("[data-testid=confirm-password]");
    private By submitButtonLocator = By.cssSelector("[data-testid=submit]");

}
