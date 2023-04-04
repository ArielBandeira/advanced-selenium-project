package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditorPage extends BasePageObject{

    private By editorTextLocator = By.id("tinymce");

    public EditorPage(WebDriver driver, Logger log) { super(driver, log); }

    //Get editor text
    public String getEditorText() {
        log.info("Get editor text");
        String editorText = find(editorTextLocator).getText();
        log.info("Text says: " + editorText);
        return editorText;
    }

}
