package com.herokuapp.theinternet.loginPageTests;


import com.herokuapp.theinternet.base.CsvDataProviders;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class PositiveLoginTests extends TestUtilities {

    @Test( dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class )
    public void positiveLoginTest(Map<String, String> testData) {
        SoftAssert softAssert = new SoftAssert();

        //Data variables
        String no = testData.get("no");
        String username = testData.get("username");
        String password = testData.get("password");
        String expectedErrorMessage = testData.get("expectedMessage");
        String description = testData.get("description");

        log.info("Stating positiveLoginTest #" + no + " for [" + description + "]");

        //Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        takeScreenshot("WelcomePage opened");

        //Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
        takeScreenshot("LoginPage opened");

        //Execute login
        log.info("Execute login");
        SecureAreaPage secureAreaPage = loginPage.executingLogin(username, password);
        takeScreenshot("SecureAreaPage opened");

        //Verifications
        //New page url is the expected
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = secureAreaPage.getPageUrl();

        softAssert.assertEquals(actualUrl, expectedUrl);
        log.info("\nActual: " + actualUrl + "\nExpected: " + expectedUrl + "\n");

        //Logout button is visible
        softAssert.assertTrue(secureAreaPage.logoutButtonVisible(), "Logout button is not visible");

        //Successful login message
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
        softAssert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "\nActual success message dos not contain expected success message\nExpected message: "
                        + expectedSuccessMessage + "\nActual message: " + actualSuccessMessage + "\n");

    }

}
