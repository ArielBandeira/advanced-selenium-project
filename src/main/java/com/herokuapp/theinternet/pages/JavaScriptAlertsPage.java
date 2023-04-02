package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage extends BasePageObject {

    private By clickForJSAlertButtonLocator = By.xpath("//button[text()='Click for JS Alert']");
    private By clickForJSConfirmButtonLocator = By.xpath("//button[text()='Click for JS Confirm']");
    private By clickForJSPromptButtonLocator = By.xpath("//button[text()='Click for JS Prompt']");
    private By resultTextLocator = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver, Logger log) { super(driver, log); }

    //Clicking on 'Click for JS Alert'
    public void openJSAlert() {
        log.info("Clicking on 'Click for JS Alert'");
        click(clickForJSAlertButtonLocator);
    }

    //Clicking on 'Click for JS Confirm'
    public void openJSConfirm() {
        log.info("Clicking on 'Click for JS Confirm'");
        click(clickForJSConfirmButtonLocator);
    }

    //Clicking on 'Click for JS Prompt'
    public void openJSPrompt() {
        log.info("Clicking on 'Click for JS Prompt'");
        click(clickForJSPromptButtonLocator);
    }

    //Get alert message
    public String getAlertText() {
       log.info("Switch to alert and get alert message");
       Alert alert = switchToAlert();
       String alertText = alert.getText();
       log.info("Alert says: " + alertText);
       return alertText;
   }

    //Press 'OK' on alert
    public void clickOkOnAlert() {
        log.info("Clicking 'OK' using Alert 'Accept'");
        Alert alert = switchToAlert();
        alert.accept();
    }

    //Press 'Cancel' on alert
    public void clickCancelOnAlert() {
        log.info("Clicking 'Cancel' using Alert 'Dismiss'");
        Alert alert = switchToAlert();
        alert.dismiss();
    }

    //Type text into alert and press 'OK'
    public void typeTextIntoAlert(String text) {
        log.info("Typing text into alert and pressing OK");
        Alert alert = switchToAlert();
        alert.sendKeys(text);
        alert.accept();
    }

    //Get result text
    public String getResultText() {
        String result = find(resultTextLocator).getText();
        log.info("Result text: " + result);
        return result;
    }

}
