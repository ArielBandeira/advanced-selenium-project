package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserDriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;
    private Logger log;

    public BrowserDriverFactory(String browser, Logger log) {
        this.browser = browser;
        this.log = log;
    }

    public WebDriver createDriver() {
        //Create driver
        log.info("Create browser: " + browser);

        switch (browser) {
            case "Edge" -> driver.set(new EdgeDriver());
            case "chrome" -> driver.set(new ChromeDriver());
            default -> {
                log.info("Do not know how to start: " + browser + ", starting Edge.");
                driver.set(new EdgeDriver());
            }
        }

        return driver.get();
    }

}
