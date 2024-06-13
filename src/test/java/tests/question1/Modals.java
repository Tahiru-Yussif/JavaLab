package tests.question1;

import Week3SeleniumProject.pages.question1Pages.ModalsPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Epic("Modals Feature")
@Feature("Modal Interaction Tests")
public class Modals extends BaseTest {
    private ModalsPage modalPage;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        Allure.step("Navigating to base URL");
        open(baseURL);
        Allure.step("Webpage visited successfully");

        modalPage = new ModalsPage();
        Allure.step("Clicking the modals button");
        modalPage.clickModalsButton();
    }

    @Test(priority = 1, description = "Verify the URL for the Modals page")
    @Severity(SeverityLevel.CRITICAL)
    @Story("URL Verification for Modals Page")
    public void verifyUrl() {
        Allure.step("Verifying URL for the modals page");
        URLVerification.verifyURL(modalsURL);
        Allure.step("URL verified successfully");
    }

    @Test(priority = 2, description = "Test clicking the simple modal button")
    @Severity(SeverityLevel.NORMAL)
    @Story("Simple Modal Button Click")
    public void testClickSimpleModalButton() {
        Allure.step("Clicking simple modal button");
        modalPage.clickSimpleModalButton();
        Allure.step("Simple modal button clicked");
    }

    @Test(priority = 3, description = "Test clicking the form modal button")
    @Severity(SeverityLevel.NORMAL)
    @Story("Form Modal Button Click")
    public void testClickFormModalButton() {
        Allure.step("Clicking form modal button");
        modalPage.clickFormModalButton();
        Allure.step("Form modal button clicked");
    }

    @AfterMethod
    @Override
    public void tearDown() {
        super.tearDown();
        closeWebDriver();
        Allure.step("Closed the web driver");
    }
}
