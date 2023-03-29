package com.herokuapp.theinternet.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserDriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;

    public BrowserDriverFactory(String browser) {
        this.browser = browser.toLowerCase();
    }

    public WebDriver createDriver() {
        System.out.println("Create browser: " + browser);

        switch (browser) {
            case "Edge" -> driver.set(new EdgeDriver());
            case "chrome" -> driver.set(new ChromeDriver());
            default -> {
                System.out.println("Do not know how to start: " + browser + ", starting Edge.");
                driver.set(new EdgeDriver());
            }
        }

        return driver.get();
    }

}
