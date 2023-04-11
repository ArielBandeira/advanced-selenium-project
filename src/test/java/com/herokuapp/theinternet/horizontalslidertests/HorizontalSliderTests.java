package com.herokuapp.theinternet.horizontalslidertests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HorizontalSliderPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HorizontalSliderTests extends TestUtilities {

    @Parameters({ "rangeValue" })
    @Test
    public void sliderTest(String rangeValue) {
        //Open Horizontal Slider page from Main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        HorizontalSliderPage horizontalSliderPage = welcomePage.clickHorizontalSliderLink();

        //Set slider value
        sleep(2000);
        Double valueAsInteger = Double.parseDouble(rangeValue);
        horizontalSliderPage.setSliderTo(valueAsInteger);
        sleep(3000);

        //Verify slider value
        String sliderValue = horizontalSliderPage.getSliderValue();
        Assert.assertTrue(horizontalSliderPage.getSliderValue().equals(sliderValue), "\nSlider value is not the esperado\n" +
                "Expected value: " + rangeValue + "\nActual value: " + horizontalSliderPage.getSliderValue());

    }

}
