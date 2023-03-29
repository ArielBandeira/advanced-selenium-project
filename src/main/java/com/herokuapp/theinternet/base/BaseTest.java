package com.herokuapp.theinternet.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    @BeforeMethod( alwaysRun = true )
    public void setUp() {
        //Open browser
        System.out.println("Open browser");
        driver = new EdgeDriver();

        driver.manage().window().maximize();
    }

    @AfterMethod( alwaysRun = true )
    public void tearDown() {
        System.out.println("Close browser");
        driver.quit();
    }

}
