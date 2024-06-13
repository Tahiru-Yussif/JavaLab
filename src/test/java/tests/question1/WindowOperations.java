package tests.question1;

import Week3SeleniumProject.pages.question1Pages.WindowsOperationPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class WindowOperations extends BaseTest {

    private WindowsOperationPage windowsOperation;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        // Visit the webpage
        open(baseURL);

        // Instantiate the windows page
        windowsOperation = new WindowsOperationPage();

        // Click on the windows button
        windowsOperation.clickWindowsButton();
    }

    @Test
    public void verifyUrl() {
        // Verify URL
        URLVerification.verifyURL(windowOperationsURL);
    }

    @Test
    public void testNewTab() {

        // Perform the new tab opeations
        windowsOperation.clickNewTab();

        // Verify the Title
        String currentTitle = title();
        System.out.println(currentTitle);
        String expectedTitle = "Home | automateNow";
        // Verify URL
        Assert.assertEquals(currentTitle, expectedTitle, "Wrong Title");
    }

    @Test
    public void testReplaceWindow() throws InterruptedException {

       // Perform Replace Window
        windowsOperation.clickReplaceWindow();

        String currentURL = url();
        System.out.println(currentURL);
        String expectedURL = "https://automatenow.io/";

        // Verify URL
        Assert.assertEquals(currentURL, expectedURL, "Wrong url");
    }

    @AfterMethod
    @Override
    public void tearDown() {
        super.tearDown();
        closeWebDriver();
    }
}
