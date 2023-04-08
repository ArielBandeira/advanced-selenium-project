package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePageObject {

    private By columnA = By.id("column-a");
    private By columnB = By.id("column-b");

    public DragAndDropPage(WebDriver driver, Logger log) { super(driver, log); }

    //Drag box A and drop to box B
    public void dragAtoB() {
        log.info("Drag box A and drop to box B");
        performDragAndDrop(columnA, columnB);
    }

    //Get Column A text
    public String getColumnAText() {
        String text = find(columnA).getText();
        log.info("Column A text: " + text);
        return text;
    }

    //Get Column B text
    public String getColumnBText() {
        String text = find(columnB).getText();
        log.info("Column B text: " + text);
        return text;
    }

}
