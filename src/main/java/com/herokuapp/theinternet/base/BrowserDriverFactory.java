package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

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
            case "Firefox" -> driver.set(new FirefoxDriver());
            case "Edge" -> driver.set(new EdgeDriver());
            case "Chrome" -> driver.set(new ChromeDriver());
            default -> {
                log.info("Do not know how to start: " + browser + ", starting Firefox.");
                driver.set(new FirefoxDriver());
            }
        }

        return driver.get();
    }

    public WebDriver createFirefoxWithProfile(String profile) {
        log.info("Starting firefox driver with profile: " + profile);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("user-data-dir=src/main/resources/Profiles");

        System.setProperty("webdriver.firefox.driver", "src/main/resources/geckodriver.exe");
        driver.set(new FirefoxDriver(firefoxOptions));
        return driver.get();
    }

    public WebDriver createFirefoxWithMobileEmulator(String deviceName) {
        log.info("Starting driver with " + deviceName + " emulation");
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", deviceName);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        //firefoxOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        System.setProperty("webdriver.firefox.driver", "src/main/resources/geckodriver.exe");
        driver.set(new FirefoxDriver(firefoxOptions));
        return driver.get();
    }

}
