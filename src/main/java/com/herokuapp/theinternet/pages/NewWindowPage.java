package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class NewWindowPage extends BasePageObject {

    public NewWindowPage(WebDriver driver, Logger log){ super(driver, log); }

    public String getTitleOfNewWindow() {
        String pageTitle = getCurrentPageTitle();
        return pageTitle;
    }

}
