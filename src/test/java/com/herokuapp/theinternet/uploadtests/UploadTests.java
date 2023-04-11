package com.herokuapp.theinternet.uploadtests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploaderPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTests extends TestUtilities {

    @Test(dataProvider = "files")
    public void fileUploadTest(int no, String fileName) {
        //Open File Upload page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        FileUploaderPage uploaderPage = welcomePage.clickFileUploadLink();

        //Select file
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
