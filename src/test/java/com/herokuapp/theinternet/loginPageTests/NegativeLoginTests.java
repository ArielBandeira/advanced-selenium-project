package com.herokuapp.theinternet.loginPageTests;

import com.herokuapp.theinternet.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLoginTests extends BaseTest {

    @Test
    @Parameters({ "username", "password", "errorMessage" })
    public void negativeTest(String username, String password, String errorMessage) {
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
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys(username);

        //Enter password
        System.out.println("Enter password");
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);

        //Press login button
        System.out.println("Press login button");
        WebElement loginButton = driver.findElement(By.xpath("//form[@id='login']/button"));
        loginButton.click();

        //Verify if successful message is displayed
        System.out.println("Verify if right error message is displayed");
        String actualErrorMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualErrorMessage.contains(errorMessage), "Error message is not the same as the expected\nExpected: " + errorMessage + "\nActual :" + actualErrorMessage);

    }

}