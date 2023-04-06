package com.herokuapp.theinternet.uploadtests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploaderPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTests extends TestUtilities {

    @Test
    public void imageUploadTest() {
        log.info("Starting Key imageUploadTest");
        //Open File Upload page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();
        FileUploaderPage uploaderPage = welcomePage.clickFileUploadLink();

        //Select file
        String fileName = "pedro_pascal_smiling.jpg";
        uploaderPage.selectFile(fileName);

        //Push upload button
        uploaderPage.pushUploadButton();


        //Get uploaded files name
        String fileNames = uploaderPage.getUploadedFilesName();

        //Verify selected file uploaded
        Assert.assertTrue(fileName.contains(fileNames),
                "\nSent file (" + fileName + ") is not the uploaded (" + fileNames + ")\n");

    }

}
