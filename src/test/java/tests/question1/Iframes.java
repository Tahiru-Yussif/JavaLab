package tests.question1;

import Week3SeleniumProject.pages.question1Pages.IframesPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class Iframes extends BaseTest {
    private IframesPage iframe;
    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        // Visit the webpage
        open(baseURL);

        // Instantiate the iframe page
        iframe = new IframesPage();

        // Click on the iframe button
        iframe.clickIframesButton();
    }
    @Test
    public void verifyUrl() {
        // Verify URL
        URLVerification.verifyURL(iframeURL);
    }

    @Test
    public void testFirstIframe() {
        // verify that the subscribe button display on the first iframe
        boolean isDisplayed = iframe.isFirstIframeSubscribeButtonDisplayed();
        Assert.assertTrue(isDisplayed, "The text name isn't found");
    }

    @Test
    public void testSecondIframe() {
    // verify that the subscribe button display on the first iframe
        boolean isDisplayed = iframe.isSecondIframeDownloadButtonDisplayed();
        Assert.assertTrue(isDisplayed, "The text name isn't found");
    }
    @AfterMethod
    @Override
    public void tearDown() {
        super.tearDown();
        closeWebDriver();
    }
}
