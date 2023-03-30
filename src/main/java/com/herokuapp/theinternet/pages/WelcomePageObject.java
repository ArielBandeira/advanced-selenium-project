package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {

    private WebDriver driver;
    private Logger log;

    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    String pageUrl = "https://the-internet.herokuapp.com";
    public WelcomePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    //Open page
    public void openPage() {
        log.info("Open page: " + pageUrl);
        driver.get(pageUrl);
        log.info("Page opened!");
    }

    //Open login page
    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking on Form Authentication link on Welcome Page");
        driver.findElement(formAuthenticationLinkLocator).click();
        return new LoginPage(driver, log);
    }

}
