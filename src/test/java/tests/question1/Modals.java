package tests.question1;

import Week3SeleniumProject.pages.question1Pages.ModalsPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Modals extends BaseTest {

    @Test
    public void testClickModalsButton() {
        // Visit the webpage
        driver.get(baseURL);

        // Instantiate the modalPage
        ModalsPage modalPage = new ModalsPage(driver);

        // Clicking the modals button
        modalPage.clickModalsButton();

        // Verify URL (if needed)
        URLVerification.verifyURL(driver, modalsURL);
    }

    @Test
    public void testClickSimpleModalButton() throws InterruptedException {
        // Ensure the modals page is loaded
        testClickModalsButton();

        // Instantiate the modalPage
        ModalsPage modalPage = new ModalsPage(driver);

        // Clicking simpleModalForm button
        modalPage.clickSimpleModalButton();
    }

    @Test
    public void testClickFormModalButton() {
        // Ensure the modals page is loaded
        testClickModalsButton();

        // Instantiate the modalPage
        ModalsPage modalPage = new ModalsPage(driver);

        // Clicking formModal button
        modalPage.clickFormModalButton();

        // Verify modal Container is displayed
        WebElement modalContainer = modalPage.confirmModalContainer();
        Assert.assertTrue(modalContainer.isDisplayed(), "Modal is not displayed");
    }
}
