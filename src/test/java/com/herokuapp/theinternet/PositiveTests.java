package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {

    private WebDriver driver;
    @Test
    public void loginTest() {
        System.out.println("Stating Login Test...");

        //Open browser
        System.out.println("Open browser");
        driver = new EdgeDriver();

        driver.manage().window().maximize();

        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);

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
        WebElement successMessage = driver.findElement(By.xpath("/html//div[@id='flash']"));
        String expectedMessage = "You logged into a secure area!";
        String actualMessage = successMessage.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage), "\nSuccess message not displayed!\n" + "Expected message: " + expectedMessage + "\nActual message: " + actualMessage);

    }

}
