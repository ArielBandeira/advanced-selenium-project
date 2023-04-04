package com.herokuapp.theinternet.editortests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.EditorPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditorTests extends TestUtilities {

    @Test
    public void defaultEditorValueTest() {
        log.info("Starting defaultEditorValueTest");

        //Open Main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        //Click on WYSIWYG Editor link
        EditorPage editorPage = welcomePage.cliclickWYSIWYGEditorLink();

        //Get default editor text
        String editorText = editorPage.getEditorText();

        //Verification that new page contains expected text in source
        String expectedText = "Your content goes here.";
        Assert.assertTrue(editorText.equals(expectedText), "\nEditor default text is not the correct\n" +
                "Expected: " + expectedText + "\nActual: " + editorText);

    }

}
