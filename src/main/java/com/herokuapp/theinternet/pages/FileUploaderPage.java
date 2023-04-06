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
        log.info("Select file: " + filename + " from files folder");
        String filePath = System.getProperty("user.dir") + "//src//main//resources//files//" + filename;
        type(filePath, chooseFileButtonLocator);
        log.info("File selected");
    }

    //Push upload button
    public void pushUploadButton() {
        log.info("Click on upload button");
        click(uploadButtonLocator);
    }

    //Get uploaded files name
    public String getUploadedFilesName() {
        String names = find(uploadedFilesLocator).getText();
        log.info("Uploaded files names: " + names);
        return names;
    }

}
