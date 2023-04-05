package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.Logger;

public class FileUploaderPage extends BasePageObject{

    private By chooseFileButtonLocator = By.id("file-upload");
    private By uploadButtonLocator = By.id("file-submit");
    private By uploadedFilesLocator = By.id("uploaded-files");
    public FileUploaderPage(WebDriver driver, Logger log) { super(driver, log); }

    //Select file
    public void selectFile(String filename) {
        log.info("Select file");
        driver.
    }

    //Push upload button
    public void pushUploadButton() {
        log.info("Click on upload button");
        find(uploadButtonLocator).click();
    }

    //Get uploaded files name
    public String getUploadedFilesName() {
        log.info("Get uploaded files name");
    }

}
