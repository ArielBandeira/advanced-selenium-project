package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HoversPage extends BasePageObject {

    private  By avatarLocator = By.xpath("//div[@class='figure']");
    private By profilesLinkLocator = By.xpath("//a[contains(text(), 'View profile')]");

    public HoversPage(WebDriver driver, Logger log) { super(driver, log); }

    public void openUserProfile(String profile) {
        //Changing profile option to Integer
        Integer userId = Integer.valueOf(profile);

        //Locating all avatars pictures
        List<WebElement> avatars = findAll(avatarLocator);

        //Getting the selected avatar
        // (and subtracting one from it to get the index from the right one)
        WebElement specifiedUserAvatar = avatars.get(userId - 1);

        //Hovering the mouse over the selected avatar
        hoverOverElement(specifiedUserAvatar);

        //Getting all 'View profile' links
        List<WebElement> allProfilesLinks = findAll(profilesLinkLocator);

        //Getting the selected avatar 'View profile' link
        // (and subtracting one from it to get the index from the right one)
        WebElement profileLink = allProfilesLinks.get(userId - 1);
        profileLink.click();
    }

}
