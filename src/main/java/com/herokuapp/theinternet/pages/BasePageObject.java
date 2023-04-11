package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Listeners({ com.herokuapp.theinternet.base.TestListener.class })
public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    //Open page with given URL
    protected void openUrl(String url) {
        driver.get(url);
    }

    //Find element using given locator
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    //Find all elements using locator
    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    //Click on element with given locator when its visible
    protected void click(By locator) {
        waitForVisibilityOf(locator, Duration.ofSeconds(5));
        find(locator).click();
    }

    //Type given text into element with given locator
    protected void type(String text, By locator) {
        waitForVisibilityOf(locator, Duration.ofSeconds(5));
        find(locator).sendKeys(text);
    }

    //Read page url
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    //Read current page title
    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    //Get source of current page
    public String getCurrentPageSource() {
        return driver.getPageSource();
    }

    //Wait for specific ExpectedCondition for the given amount of time in seconds
    private void waitFor(ExpectedCondition<WebElement> condition, Duration timeOut) {
        timeOut = timeOut != null ? timeOut : Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(condition);
    }

    //Wait for given number of seconds for element with given locator to be visible on page
    protected void waitForVisibilityOf(By locator, Duration... timeOut) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOut.length > 0 ? timeOut[0] : null));
                break;
            } catch (StaleElementReferenceException e) {}
            attempts++;
        }
    }

    //Wait for alert ot be visible then switch to it
    protected Alert switchToAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    public void switchToWindowWithTitle(String expectedTitle) {
        //Switching to new window
        String firstWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowsIterator = allWindows.iterator();

        while (windowsIterator.hasNext()) {
            String windowHandle = windowsIterator.next().toString();
            if (!windowHandle.equals(firstWindow)) {
                driver.switchTo().window(windowHandle);
                if (getCurrentPageTitle().equals(expectedTitle)) {
                    break;
                }
            }
        }

    }

    //Switching to iframe using its locator
    protected void switchToFrame(By frameLocator) {
        driver.switchTo().frame(find(frameLocator));
    }

    //Press key on locator
    protected void pressKey(By locator, Keys key) {
        find(locator).sendKeys(key);
    }

    public void pressKeyWithActions(Keys key) {
        log.info("Pressing " + key.name() + " using Actions class");
        Actions action = new Actions(driver);
        action.sendKeys(key).perform();
    }

    public void scrollToBottom() {
        log.info("Scrolling to bottom of the page");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    //Drag 'from' element to 'to' element
    protected void performDragAndDrop(By from, By to) {
        // Actions action = new Actions(driver);
        // action.dragAndDrop(find(from), find(to)).build().perform();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(
                "function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                        + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
                        + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                        + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n"
                        + "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                        + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                        + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                        + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n"
                        + "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                        + "var dragStartEvent =createEvent('dragstart');\n"
                        + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
                        + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                        + "var dragEndEvent = createEvent('dragend');\n"
                        + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                        + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                        + "simulateHTML5DragAndDrop(source,destination);",
                find(from), find(to));
    }

    //Hover over element
    protected void hoverOverElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

}
