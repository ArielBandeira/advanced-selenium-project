package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPage extends BasePageObject {

    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By logInButtonLocator = By.tagName("button");

    private By failLoginMessage = By.id("flash");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public SecureAreaPage logIn(String username, String password) {
        log.info("Executing login with username [" + username + "] and password [" + password + "]");

        type(username, usernameLocator);
        type(password, passwordLocator);
        click(logInButtonLocator);

        return new SecureAreaPage(driver, log);
    }

    public void negativeLogin(String username, String password) {
        log.info("Executing login with username [" + username + "] and password [" + password + "]");

        type(username, usernameLocator);
        type(password, passwordLocator);
        click(logInButtonLocator);
    }

    public void waitForErrorMessage() {
        waitForVisibilityOf(failLoginMessage, Duration.ofSeconds(5));
    }

    public String getFailLoginMessageText() {
        log.info("Return error login message");
        return find(failLoginMessage).getText();
    }

}
