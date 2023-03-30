package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {

    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By logInButtonLocator = By.tagName("button");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public SecureAreaPage logIn(String username, String password) {
        log.info("Executing login with username [" + username + "] and password [" + password + "]");

        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(logInButtonLocator).click();

        return new SecureAreaPage(driver, log);
    }

}