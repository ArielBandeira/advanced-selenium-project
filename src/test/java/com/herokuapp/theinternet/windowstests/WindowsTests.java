package com.herokuapp.theinternet.windowstests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.pages.WindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsTests extends TestUtilities {

    @Test
    public void newWindowTests() {
        log.info("Starting newWindowsTests");

        //Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Click on 'Multiple Windows' link
        WindowsPage windowsPage = welcomePage.clickMultipleWindowsLink();

        //Click on 'Click Here' link to open new tab
        windowsPage.openNewTab();

        //Find and switch to new window page
        NewWindowPage newWindowPage = windowsPage.switchToNewWindowPage();

        String pageSource = newWindowPage.getCurrentPageSource();

        //Verify if the text on new windows is the correct one
        String getPageTitle = newWindowPage.getCurrentPageTitle();
        Assert.assertTrue(pageSource.contains(getPageTitle), "Text on new page is not the right one");
    }
}
