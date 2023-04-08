package com.herokuapp.theinternet.editortests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.EditorPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditorTests extends TestUtilities {

    @Test
    public void defaultEditorValueTest() {
        log.info("Starting defaultEditorValueTest");

        //Open Main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Scroll to bottom
        sleep(2000);
        welcomePage.scrollToBottom();
        sleep(2000);

        //Click on WYSIWYG Editor link
        EditorPage editorPage = welcomePage.clickWYSIWYGEditorLink();

        //Get default editor text
        String editorText = editorPage.getEditorText();

        //Verification that new page contains expected text in source
        String expectedText = "Your content goes here.";
        Assert.assertTrue(editorText.equals(expectedText), "\nEditor default text is not the correct\n" +
                "Expected: " + expectedText + "\nActual: " + editorText);

    }

}
