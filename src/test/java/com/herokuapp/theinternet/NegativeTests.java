package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeTests {

    private WebDriver driver;
    @BeforeMethod
    public void setUp() {
        //Open browser
        System.out.println("Open browser");
        driver = new EdgeDriver();

        driver.manage().window().maximize();
    }

    @Test
    public void negativeTest() {
        //Open main page
        System.out.println("Go to main page");
        String url = "https://the-internet.herokuapp.com";
        driver.get(url);

        //Click on Form Authentication link
        System.out.println("Go to Login Page");
        WebElement formAuthLink = driver.findElement(By.linkText("Form Authentication"));
        formAuthLink.click();

        //Enter username
        System.out.println("Enter username");
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        //Enter password
        System.out.println("Enter password");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

        //Press login button
        System.out.println("Press login button");
        WebElement loginButton = driver.findElement(By.xpath("//form[@id='login']/button"));
        loginButton.click();

        //Verify if successful message is displayed
        System.out.println("Verify if successful message is displayed");


        //Close browser
        tearDown();
    }


    //Close browser
    @AfterMethod
    private void tearDown() {
        System.out.println("Close browser");
        driver.quit();
    }
}
