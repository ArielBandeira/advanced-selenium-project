package com.herokuapp.theinternet.dropdowntests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DropdownTests extends TestUtilities {

    @Parameters({ "optionSelected" })
    @Test
    public void selectOptionTest(Integer optionSelected) {
        //Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Click on Dropdown link
        DropdownPage dropdownPage = welcomePage.clickDropdownLink();

        //Select option 2
        dropdownPage.selectOption(optionSelected);

        //Verify if option 2 is selected
        String selectedOption = dropdownPage.getSelectedOption();
        Assert.assertTrue(selectedOption.equals("Option " + optionSelected), "Option selected is not the expected");

    }

}
