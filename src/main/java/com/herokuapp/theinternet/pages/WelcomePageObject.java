package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {

    String pageUrl = "https://the-internet.herokuapp.com";
    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    private By checkboxesLinkLocator = By.linkText("Checkboxes");

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

    //Open Checkboxes page
    public CheckboxesPage clickCheckboxesLink() {
        log.info("Clicking on Checkboxes link on Welcome Page");
        click(checkboxesLinkLocator);
        return new CheckboxesPage(driver, log);
    }

}
