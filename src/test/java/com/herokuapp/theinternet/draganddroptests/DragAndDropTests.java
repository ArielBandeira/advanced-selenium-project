package com.herokuapp.theinternet.draganddroptests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DragAndDropPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestUtilities {
    @Test
    public void dragAToBTest() {
        //Open Drag and Drop page from Main Page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        DragAndDropPage dragAndDropPage = welcomePage.clickDragAndDropLink();
        sleep(2000);
        //Drag box A and drop it on box B
        dragAndDropPage.dragAtoB();
        sleep(2000);
        //Verify if correct headers in correct boxes
        String columnAText = dragAndDropPage.getColumnAText();
        Assert.assertTrue(columnAText.equals("B"), "Column A header should be B, but it is: " + columnAText);

        String columnBText = dragAndDropPage.getColumnBText();
        Assert.assertTrue(columnBText.equals("A"), "Column A header should be B, but it is: " + columnBText);
    }
}
