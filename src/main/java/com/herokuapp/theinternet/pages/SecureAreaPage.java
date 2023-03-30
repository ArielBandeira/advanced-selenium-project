package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject {

    private WebDriver driver;
    private Logger log;

    public SecureAreaPage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

}
