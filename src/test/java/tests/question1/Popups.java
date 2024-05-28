package tests.question1;

import Week3SeleniumProject.pages.question1Pages.PopupsPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import org.testng.annotations.Test;

public class Popups extends BaseTest {

    @Test
    public void testPopups() throws InterruptedException {
        // visit the webpage
        driver.get(baseURL);

        // Initialize the Popups page
        PopupsPage popups = new PopupsPage(driver);

        // clicking the popups button
        popups.clickPopupsButton();

        //clicking on alert popup
        popups.clickAlertPopup();

        // clicking on confirm popup
        popups.clickConfirmPopup();

        // clicking on prompt popup
        popups.clickPromptPopup();

        // Verify URL
        URLVerification.verifyURL(driver, popupsURL);
    }
}
