package com.herokuapp.theinternet.loginPageTests;


import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestUtilities {

    @Parameters({ "username", "password", "errorMessage" })
    @Test
    public void negativeTest(String username, String password, String errorMessage) {
        log.info("Stating Negative Login Test...");

        //Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

        //Login with the wrong credentials
        loginPage.negativeLogin(username, password);

        //Verify if fail login message is displayed
        loginPage.waitForErrorMessage();
        String message = loginPage.getFailLoginMessageText();

        //Verification
        Assert.assertTrue(message.contains(errorMessage), "Error message does not contain expected message\n"
        + "Expected message: " + errorMessage + "Actual message: " + message);

    }

}
