package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowsPage extends BasePageObject {

    private By linkLocator = By.linkText("Click Here");

    public WindowsPage(WebDriver driver, Logger log){ super(driver, log); }

    //Click on 'Click Here' link
    public void openNewTab() {
        log.info("Clicking on 'Click Here' link");
        click(linkLocator);
    }

    //Switch to new window named 'New Window'
    public NewWindowPage switchToNewWindowPage() {
        log.info("Looking for 'New Window' page");
        switchToWindowWithTitle("New Window");
        return new NewWindowPage(driver, log);
    }

}
