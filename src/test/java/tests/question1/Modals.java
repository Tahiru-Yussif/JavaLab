package tests.question1;

import Week3SeleniumProject.pages.question1Pages.ModalsPage;
import Week3SeleniumProject.pages.question1Pages.TablesPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class Modals extends BaseTest {
    private ModalsPage modalPage;
    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        // Visit the webpage
        open(baseURL);

        // Instantiate the modal page
        modalPage = new ModalsPage();

        // Clicking the modals button
        modalPage.clickModalsButton();
    }
    @Test
    public void verifyUrl() {
        // Verify URL
        URLVerification.verifyURL(modalsURL);
    }

        @Test
    public void testClickSimpleModalButton() {
        // Clicking simpleModalForm button
        modalPage.clickSimpleModalButton();
    }

    @Test
    public void testClickFormModalButton() {
        // Clicking formModal button
        modalPage.clickFormModalButton();

    }
    @AfterMethod
    @Override
    public void tearDown() {
        super.tearDown();
        closeWebDriver();
    }
}
