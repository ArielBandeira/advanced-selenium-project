package com.herokuapp.theinternet.keypressestests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressesPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressesTests extends TestUtilities {

    @Test
    public void pressKeyTest() {
        log.info("Starting Key pressKeyTest");

        //Open keyPressesPage
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        KeyPressesPage keyPressesPage = welcomePage.clickKeyPressesLink();

        //Push keyboard key
        keyPressesPage.pressKey(Keys.ENTER);

        //Get results text
        String result = keyPressesPage.getResultText();

        //Verify result text is expected
        Assert.assertTrue(result.equals("You entered: ENTER"),
                "\nResult is no the right one\nShould be: 'You entered: ENTER', but got: " + result);
    }

    @Test
    public void pressKeyWithActionTest() {
        log.info("Starting pressKeyWithActionTest");

        //Open keyPressesPage
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        KeyPressesPage keyPressesPage = welcomePage.clickKeyPressesLink();

        //Push keyboard key
        keyPressesPage.pressKeyWithActions(Keys.SPACE);

        //Get results text
        String result = keyPressesPage.getResultText();

        //Verify result text is expected
        Assert.assertTrue(result.equals("You entered: SPACE"),
                "\nResult is no the right one\nShould be: 'You entered: SPACE', but got: " + result);
    }

}
