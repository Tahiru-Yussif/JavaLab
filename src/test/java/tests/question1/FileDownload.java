package tests.question1;

import Week3SeleniumProject.pages.question1Pages.FileDownloadPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class FileDownload extends BaseTest {
    private FileDownloadPage fileDownload;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        // Visit the webpage
        open(baseURL);

        // Instantiate the file download page
        fileDownload = new FileDownloadPage();

        // Clicking the file download button
        fileDownload.clickFileDownloadButton();
    }

        @Test
    public void testClickFileDownloadButton() {
        // Verify URL
        URLVerification.verifyURL(fileDownloadURL);
    }

    @Test
    public void testNormalFileDownload() {
        // Locate and click the download link
        fileDownload.clickNormalFileDownloadButton();
    }

        @Test
    public void testProtectedFileDownload() throws InterruptedException {
        // Perform File Download for protected file
        fileDownload.downloadLockedFile();
    }

    @AfterMethod
    @Override
    public void tearDown() {
        super.tearDown();
        closeWebDriver();
    }
}
