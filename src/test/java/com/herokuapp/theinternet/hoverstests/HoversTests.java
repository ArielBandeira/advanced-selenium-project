package com.herokuapp.theinternet.hoverstests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HoversPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HoversTests extends TestUtilities {

    //User one profile test
    @Parameters({ "profile" })
    @Test
    public void userOneProfileTest(String profile) {
        //Open Hovers page from main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        HoversPage hoversPage = welcomePage.clickHoversLink();

        //Open user profile n
        hoversPage.openUserProfile(profile);
        sleep(2000);

        //Verify if the correct profile was opened
        Integer userId = Integer.valueOf(profile);
        Assert.assertTrue(hoversPage.getCurrentUrl().contains("/users/" + userId),
                "\nUrl opened is not the correct one\nUrl opened: " + hoversPage.getCurrentUrl() +
                        "\nUrl esperada: https://the-internet.herokuapp.com/users/" + userId);

    }

}
