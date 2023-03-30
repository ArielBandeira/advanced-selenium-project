package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {

    String pageUrl = "https://the-internet.herokuapp.com";
    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");

    public WelcomePageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //Open page
    public void openPage() {
        log.info("Open page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    //Open login page
    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking on Form Authentication link on Welcome Page");
        click(formAuthenticationLinkLocator);
        return new LoginPage(driver, log);
    }

}
