package com.herokuapp.theinternet.checkboxespagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTests extends TestUtilities {

    @Test
    public void selectingTwoCheckboxesTest() {
        log.info("Starting selectingTwoCheckboxesTest");

        //Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Click on checkboxes link
        CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();

        //Select all checkboxes
        checkboxesPage.selectAllCheckboxes();

        //Verify if all checkboxes are checked
        Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(), "\nNot all checkboxes are checked");

    }

}
