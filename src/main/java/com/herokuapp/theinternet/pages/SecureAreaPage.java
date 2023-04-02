package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SecureAreaPage extends BasePageObject {

    String pageUrl = "https://the-internet.herokuapp.com/secure";
    private By logoutButton = By.xpath("//a[@href='/logout']");
    private By successMessage = By.id("flash");
    public SecureAreaPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //Compare actual url with expected url
    public String getPageUrl() {
        log.info("Verify if page url is the correct one");
        return pageUrl;
    }

    //Verify if logout button is displayed
    public boolean logoutButtonVisible() {
        log.info("Verify if logout button is displayed");
        return find(logoutButton).isDisplayed();
    }

    //Compare actual message with expected success message
    public String getSuccessMessageText() {
        log.info("Return success message");
        return find(successMessage).getText();
    }

}
