package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PositiveTests {

    private WebDriver driver;
    @Test
    public void loginTest() {
        System.out.println("Stating Login Test...");

        //Open browser
        System.out.println("Open browser");
        driver = new EdgeDriver();

        driver.manage().window().maximize();

        // Open main page
        System.out.println("Go to main page");
        String url = "https://the-internet.herokuapp.com";
        driver.get(url);

        //Click on Form Authentication link
        System.out.println("Go to Login Page");
        WebElement formAuthLink = driver.findElement(By.xpath("//a[@href='/login']"));
        formAuthLink.click();

        //Verify if is the right url
        String actualPage = driver.getCurrentUrl();
        String expectedLoginPageUrl = "https://the-internet.herokuapp.com/login";
        Assert.assertTrue(expectedLoginPageUrl.matches(actualPage), "\nLogin page is not the right one!\n" + "Expected url: " + expectedLoginPageUrl + "\nActual page url: " + actualPage);

        //Enter username
        System.out.println("Enter username");
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        //Enter password
        System.out.println("Enter password");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

        sleep(3);

        //Login button is visible
        System.out.println("Verify if Login button is visible");
        WebElement loginButton = driver.findElement(By.xpath("//form[@id='login']/button"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        //Press login button
        System.out.println("Press login button");
        loginButton.click();

        //Verify if is the right url
        System.out.println("Verify if is the right url");
        String expectedAfterLoginPage = "https://the-internet.herokuapp.com/secure";
        String actualAfterLoginPage = driver.getCurrentUrl();
        Assert.assertTrue(expectedAfterLoginPage.matches(actualAfterLoginPage), "\nAfter login page is not the right one!\n" + "Expected url: " + expectedLoginPageUrl + "\nActual page url: " + actualPage);

        //Verify if successful message is displayed
        System.out.println("Verify if successful message is displayed");
        WebElement successMessage = driver.findElement(By.xpath("/html//div[@id='flash']"));
        String expectedMessage = "You logged into a secure area!";
        String actualMessage = successMessage.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage), "\nSuccess message not displayed!\n" + "Expected message: " + expectedMessage + "\nActual message: " + actualMessage);

        //Close browser
        System.out.println("Close browser");
        driver.quit();

    }

    private static void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
