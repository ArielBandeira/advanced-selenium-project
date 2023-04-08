package com.herokuapp.theinternet.loginPageTests;


import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestUtilities {

    @Test
    public void loginTest() {
        log.info("Stating Login Test...");

        //Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

        //Execute login
        log.info("Execute login");
        SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");

        //Verifications
        //New page url is the expected
        Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

        //Logout button is visible
        Assert.assertTrue(secureAreaPage.logoutButtonVisible(), "Logout button is not visible");

        //Successful login message
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "\nActual success message dos not contain expected success message\nExpected message: "
                        + expectedSuccessMessage + "\nActual message: " + actualSuccessMessage + "\n");

    }

}
