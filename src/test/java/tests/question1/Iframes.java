package tests.question1;

import Week3SeleniumProject.pages.question1Pages.IframesPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Iframes extends BaseTest {

    @Test
    public void testClickIframeButton() {
        // visit the webpage
        driver.get(baseURL);

        // Instantiate the IframePage
        IframesPage iframe = new IframesPage(driver);

        // Perform Iframe
        iframe.clickIframesButton();

        // Verify URL
        URLVerification.verifyURL(driver, iframeURL);
    }

    @Test
    public void testFirstIframe() {
        // calling the testClickIframeButton method
        testClickIframeButton();

        // Instantiate the IframePage
        IframesPage iframes = new IframesPage(driver);

        // verify that the subscribe button display on the first iframe
        boolean isDisplayed = iframes.isFirstIframeSubscribeButtonDisplayed();
        Assert.assertTrue(isDisplayed, "The text name isn't found");
    }

    @Test
    public void testSecondIframe() {
        // calling the testClickIframeButton method
        testClickIframeButton();

        // Instantiate the IframePage
        IframesPage iframes = new IframesPage(driver);

        // verify that the subscribe button display on the first iframe
        boolean isDisplayed = iframes.isSecondIframeDownloadButtonDisplayed();
        Assert.assertTrue(isDisplayed, "The text name isn't found");
    }
}
