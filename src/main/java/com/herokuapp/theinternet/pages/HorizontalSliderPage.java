package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HorizontalSliderPage extends BasePageObject {

    private By sliderValueLocator = By.tagName("input");
    private By sliderRangeValueLocator = By.id("range");

    public HorizontalSliderPage(WebDriver driver, Logger log) { super(driver, log); }

    //Set slider to vale
    public void setSliderTo(Double value) {
/*        log.info("Set slider to " + value);
        int width = find(sliderValueLocator).getSize().getWidth();
        double percent = value / 5;
        int xOffSet = (int) (width * percent);
        Actions action = new Actions(driver);
        action.dragAndDropBy(find(sliderValueLocator), (xOffSet), 0).perform();*/

        int steps = (int) (value / 0.5);

        pressKey(sliderValueLocator, Keys.ENTER);
        for (int i = 0; i < steps; i++) {
            pressKey(sliderValueLocator, Keys.ARROW_RIGHT);
        }

    }

    //Get slider value
    public String getSliderValue() {
        String value = find(sliderRangeValueLocator).getText();
        log.info("Slider contains the following value: " + value);
        return value;
    }

}
