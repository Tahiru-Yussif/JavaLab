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
    public void testFirstIframe() throws InterruptedException {
        // calling the testClickIframeButton method
        testClickIframeButton();

        // Instantiate the IframePage
        IframesPage iframe = new IframesPage(driver);

        Thread.sleep(5000);

        // perform test on the first Iframe
        iframe.switchToFirstIframe();
        iframe.loginInFirstIframe();

        Thread.sleep(5000);
//        Assert.assertTrue(true, "String message");
    }
}
