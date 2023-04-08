package com.herokuapp.theinternet.alertstests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTests extends TestUtilities {


    //JS Alert test
    @Test
    public void jsAlertTest() {
        log.info("Starting jsAlertTest");

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
        Assert.assertTrue(alertMessage.contains(expectedAlertMessage), "\nAlert message is not the right one.\n" +
                "Expected: " + expectedAlertMessage + "\nActual Message: " + alertMessage);

        //Verify if the result text is the expected
        String expectedResultText = "You successfully clicked an alert";
        Assert.assertTrue(resultText.contains(expectedResultText), "\nExpected result is not correct\n" +
                "Expected: " + expectedResultText + "\nActual: " + resultText);
    }

    //JS Accept test
    @Test
    public void jsAcceptTest() {
        log.info("Starting jsAcceptTest");

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
        Assert.assertTrue(alertText.contains(expectedAlertText), "\nAlert text text is not the right one\n" +
                "Expected: " + expectedAlertText + "Actual: " + alertText);

        //Verify if the result text is the expected
        String expectedResultText = "You clicked: Ok";
        Assert.assertTrue(resultText.contains(expectedResultText), "\nResult text is not the right one\n" +
                "Expected: " + expectedResultText + "\nActual: " + resultText);

    }

    //JS Dismiss test
    @Test
    public void jsDismissTest() {
        log.info("Starting jsDismissTest");
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
        Assert.assertTrue(alertText.contains(expectedAlertText), "\nAlert text text is not the right one\n" +
                "Expected: " + expectedAlertText + "Actual: " + alertText);

        //Verify if the result text is the expected
        String expectedResultText = "You clicked: Cancel";
        Assert.assertTrue(resultText.contains(expectedResultText), "\nResult text is not the right one\n" +
                "Expected: " + expectedResultText + "\nActual: " + resultText);

    }

    //JS Prompt test
    @Test
    public void jsPromptTest() {
        log.info("Starting jsPromptTest");

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
        Assert.assertTrue(alertText.contains(expectedAlertText), "\nAlert text text is not the right one\n" +
                "Expected: " + expectedAlertText + "\nActual: " + alertText);

        //Verify if the result text is the expected
        String expectedResultText = "You entered: " + enteredText;
        Assert.assertTrue(resultText.contains(expectedResultText), "\nResult text is not the right one\n" +
                "Expected: " + expectedResultText + "\nActual: " + resultText);

    }

}
