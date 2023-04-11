package com.herokuapp.theinternet.loginPageTests;


import com.herokuapp.theinternet.base.CsvDataProviders;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class NegativeLoginTests extends TestUtilities {

    @Test( dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class )
    public void negativeLoginTest(Map<String, String> testData) {
        SoftAssert softAssert = new SoftAssert();

        //Data variables
        String no = testData.get("no");
        String username = testData.get("username");
        String password = testData.get("password");
        String expectedErrorMessage = testData.get("expectedMessage");
        String description = testData.get("description");

        log.info("Stating negativeLoginTest #" + no + " for [" + description + "]");

        //Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

        //Login with the wrong credentials
        loginPage.executingLogin(username, password);

        //Verify if fail login message is displayed
        loginPage.waitForErrorMessage();
        String message = loginPage.getFailLoginMessageText();

        //Verification
        softAssert.assertTrue(message.contains(expectedErrorMessage), "Error message does not contain expected message\n"
        + "Expected message: " + expectedErrorMessage + "Actual message: " + message);

    }

}
