package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

    String pageUrl = "https://the-internet.herokuapp.com";
    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    private By checkboxesLinkLocator = By.linkText("Checkboxes");
    private By dropdownLinkLocator = By.linkText("Dropdown");
    private By javaScriptAlertsLinkLocator = By.linkText("JavaScript Alerts");
    private By multipleWindowsLinkLocator = By.linkText("Multiple Windows");
    private By WYSIWYGEditorLinkLocator = By.linkText("WYSIWYG Editor");
    private By keyPressesLinkLocator = By.linkText("Key Presses");
    private By fileUploadLinkLocator = By.linkText("File Upload");
    private By dragAndDropLinkLocator = By.linkText("Drag and Drop");

    public WelcomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //Open page
    public void openPage() {
        log.info("Open page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    //Open login page
    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking on Form Authentication link on Welcome Page");
        click(formAuthenticationLinkLocator);
        return new LoginPage(driver, log);
    }

    //Open Checkboxes page
    public CheckboxesPage clickCheckboxesLink() {
        log.info("Clicking on Checkboxes link on Welcome Page");
        click(checkboxesLinkLocator);
        return new CheckboxesPage(driver, log);
    }

    //Open Dropdown page
    public DropdownPage clickDropdownLink() {
        log.info("Clicking on Dropdown link on Welcome Page");
        click(dropdownLinkLocator);
        return new DropdownPage(driver, log);
    }

    //Open JavaScriptAlerts page
    public JavaScriptAlertsPage clickJavaScriptAlertsLink() {
        log.info("Clicking on JavaScript Alerts link on Welcome Page");
        click(javaScriptAlertsLinkLocator);
        return new JavaScriptAlertsPage(driver, log);
    }

    //Open Multiple Windows page
    public WindowsPage clickMultipleWindowsLink() {
        log.info("Clicking on Multiple Windows link on Welcome Page");
        click(multipleWindowsLinkLocator);
        return new WindowsPage(driver, log);
    }

    //Open WYSIWYG Editor page
    public EditorPage clickWYSIWYGEditorLink() {
        log.info("Clicking on WYSIWYG Editor link on Welcome Page");
        click(WYSIWYGEditorLinkLocator);
        return new EditorPage(driver, log);
    }

    //Open Key Presses page
    public KeyPressesPage clickKeyPressesLink() {
        log.info("Clicking on Key Presses link on Welcome Page");
        click(keyPressesLinkLocator);
        return new KeyPressesPage(driver, log);
    }

    //Open File Upload page
    public FileUploaderPage clickFileUploadLink() {
        log.info("Clicking on File Upload link on Welcome Page");
        click(fileUploadLinkLocator);
        return new FileUploaderPage(driver, log);
    }

    //Open Drag and Drop page
    public DragAndDropPage clickDragAndDropLink() {
        log.info("Clicking on Drag and Drop link on Welcome Page");
        click(dragAndDropLinkLocator);
        return new DragAndDropPage(driver, log);
    }

}
