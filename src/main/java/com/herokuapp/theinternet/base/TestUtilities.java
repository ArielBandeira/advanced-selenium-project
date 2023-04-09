package com.herokuapp.theinternet.base;

import org.testng.annotations.DataProvider;

public class TestUtilities extends BaseTest {

    //Static sleep
    protected void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name="files")
    protected static Object[][] files() {
        return new Object[][] {
            {1,"pedro_pascal_smiling.jpg"},
            {2,"pedro_pascal_as_old_lady.jpg"},
            {3,"pedro_pascal_eating_toast.jpg"}
        };
    }

}
