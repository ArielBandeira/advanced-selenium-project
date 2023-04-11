package com.herokuapp.theinternet.alertstests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AlertsTests extends TestUtilities {


    //JS Alert test
    @Test
    public void jsAlertTest() {
        //Adding Soft Assert
        SoftAssert softAssert = new SoftAssert();

        //Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on JavaScript Alerts link on Main Page
        JavaScriptAlertsPage javaScriptAlertsPage = welcomePage.clickJavaScriptAlertsLink();

        // Click JS Alert button
        javaScriptAlertsPage.openJSAlert();

        // Get alert text
        String alertMessage = javaScriptAlertsPage.getAlertText();

        //Click OK
        javaScriptAlertsPage.clickOkOnAlert();

        //Get result text
        String resultText = javaScriptAlertsPage.getResultText();

        //Verify if alert text is the expected
        String expectedAlertMessage = "I am a JS Alert";
        softAssert.assertTrue(alertMessage.equals(expectedAlertMessage), "\nAlert message is not the right one.\n" +
                "Expected: " + expectedAlertMessage + "\nActual Message: " + alertMessage + "\n");

        //Verify if the result text is the expected
        String expectedResultText = "You successfully clicked an alert";
        softAssert.assertTrue(resultText.equals(expectedResultText), "\nExpected result is not correct\n" +
                "Expected: " + expectedResultText + "\nActual: " + resultText + "\n");

        softAssert.assertAll();
    }

    //JS Accept test
    @Test
    public void jsAcceptTest() {
        //Adding Soft Assert
        SoftAssert softAssert = new SoftAssert();

        //Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on JavaScript Alerts link on Main Page
        JavaScriptAlertsPage javaScriptAlertsPage = welcomePage.clickJavaScriptAlertsLink();

        // Click JS Confirm button
        javaScriptAlertsPage.openJSConfirm();

        // Get alert text
        String alertText = javaScriptAlertsPage.getAlertText();

        //Click OK
        javaScriptAlertsPage.clickOkOnAlert();

        //Get result text
        String resultText = javaScriptAlertsPage.getResultText();

        //Verify if alert text is the expected
        String expectedAlertText = "I am a JS Confirm";
        softAssert.assertTrue(alertText.equals(expectedAlertText), "\nAlert text text is not the right one\n" +
                "Expected: " + expectedAlertText + "\nActual: " + alertText + "\n");

        //Verify if the result text is the expected
        String expectedResultText = "You clicked: Ok";
        softAssert.assertTrue(resultText.equals(expectedResultText), "\nResult text is not the right one\n" +
                "Expected: " + expectedResultText + "\nActual: " + resultText + "\n");

        softAssert.assertAll();

    }

    //JS Dismiss test
    @Test
    public void jsDismissTest() {
        //Adding Soft Assert
        SoftAssert softAssert = new SoftAssert();

        //Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on JavaScript Alerts link on Main Page
        JavaScriptAlertsPage javaScriptAlertsPage = welcomePage.clickJavaScriptAlertsLink();

        // Click JS Confirm button
        javaScriptAlertsPage.openJSConfirm();

        // Get alert text
        String alertText = javaScriptAlertsPage.getAlertText();

        //Click 'Cancel'
        javaScriptAlertsPage.clickCancelOnAlert();

        //Get result text
        String resultText = javaScriptAlertsPage.getResultText();

        //Verify if alert text is the expected
        String expectedAlertText = "I am a JS Confirm";
        softAssert.assertTrue(alertText.equals(expectedAlertText), "\nAlert text text is not the right one\n" +
                "Expected: " + expectedAlertText + "\nActual: " + alertText + "\n");

        //Verify if the result text is the expected
        String expectedResultText = "You clicked: Cancel";
        softAssert.assertTrue(resultText.equals(expectedResultText), "\nResult text is not the right one\n" +
                "Expected: " + expectedResultText + "\nActual: " + resultText + "\n");

        softAssert.assertAll();

    }

    //JS Prompt test
    @Test
    public void jsPromptTest() {
        //Adding Soft Assert
        SoftAssert softAssert = new SoftAssert();


        //Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on JavaScript Alerts link on Main Page
        JavaScriptAlertsPage javaScriptAlertsPage = welcomePage.clickJavaScriptAlertsLink();

        // Click JS Prompt button
        javaScriptAlertsPage.openJSPrompt();

        // Get alert text
        String alertText = javaScriptAlertsPage.getAlertText();

        //Type text and click OK
        String enteredText = "Hello, it's a me Mario!";
        javaScriptAlertsPage.typeTextIntoAlert(enteredText);

        //Get result text
        String resultText = javaScriptAlertsPage.getResultText();

        //Verify if alert text is the expected
        String expectedAlertText = "I am a JS prompt";
        softAssert.assertTrue(alertText.equals(expectedAlertText), "\nAlert text text is not the right one\n" +
                "Expected: " + expectedAlertText + "\nActual: " + alertText + "\n");

        //Verify if the result text is the expected
        String expectedResultText = "You entered: " + enteredText;
        softAssert.assertTrue(resultText.equals(expectedResultText), "\nResult text is not the right one\n" +
                "Expected: " + expectedResultText + "\nActual: " + resultText + "\n");

        softAssert.assertAll();

    }

}
