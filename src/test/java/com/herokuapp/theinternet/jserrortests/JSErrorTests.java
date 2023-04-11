package com.herokuapp.theinternet.jserrortests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JSErrorPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class JSErrorTests extends TestUtilities {

    @Test
    public void jsErrorTest() {
        SoftAssert softAssert = new SoftAssert();

        //Open jsErrorPage from Welcome Page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        JSErrorPage jsErrorPage = welcomePage.clickJSErrorLink();

        //Get Logs
        List<LogEntry> logs = getBrowserLogs();

        //Verify if there are no JavaScript error in console
        for (LogEntry logEntry : logs) {
            if (logEntry.getLevel().toString().equals("SEVERE")) {
                softAssert.fail("Severe error: " + logEntry.getMessage());
            }
        }
        softAssert.assertAll();

    }

}
