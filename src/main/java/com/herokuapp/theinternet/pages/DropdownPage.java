package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePageObject {
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver, Logger log) { super(driver, log); }

    //Select option
    public void selectOption(Integer i) {
        log.info("Select option: " + i + " from dropdown");
        WebElement dropdownElement = find(dropdown);
        Select dropdown = new Select(dropdownElement);
        String optionToString = i.toString();
        dropdown.selectByValue(optionToString);
    }

    //Return selected option
    public String getSelectedOption() {
        log.info("Return selected option");
        WebElement dropdownElement = find(dropdown);
        Select dropdown = new Select(dropdownElement);
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        log.info(selectedOption + " is selected in dropdown");
        return selectedOption;
    }

}
