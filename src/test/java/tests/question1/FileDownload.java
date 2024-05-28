package tests.question1;

import Week3SeleniumProject.pages.question1Pages.FileDownloadPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FileDownload extends BaseTest {


    @Test
    public void testClickFileDownloadButton() {
        // visit the webpage
        driver.get(baseURL);

        // Initialize the File Download page
        FileDownloadPage fileDownload = new FileDownloadPage(driver);

        // clicking the file download page
        fileDownload.clickFileDownloadButton();

        // Verify URL
        URLVerification.verifyURL(driver, fileDownloadURL);
    }


    @Test
    public void testNormalFileDownload() {
        // Initialize the File Download page
        FileDownloadPage fileDownload = new FileDownloadPage(driver);
//
        // Set up Chrome options to handle file downloads
        ChromeOptions options = fileDownload.performNormalDownload();

        // Initialize WebDriver with the specified options
        driver = new ChromeDriver(options);

        // calling the testClickFileDownloadButton method
        testClickFileDownloadButton();

        // Locate and click the download link
        fileDownload.clickNormalFileDownloadButton();

        // Quit the WebDriver after tests are done
//        driver.quit();
    }


    @Test
    public void testProtectedFileDownload() throws InterruptedException {
        // Initialize the File Download page
        FileDownloadPage fileDownload = new FileDownloadPage(driver);
//
        // Set up Chrome options to handle file downloads
        ChromeOptions options = fileDownload.performNormalDownload();

        // Initialize WebDriver with the specified options
        driver = new ChromeDriver(options);

        // calling the testClickFileDownloadButton method
        testClickFileDownloadButton();


        // Perform File Download for protected file
        fileDownload.clickProtectedFileDownloadButton();

        Thread.sleep(10000);
        // enter password and submit
        fileDownload.enterPasswordAndSubmit();
    }
}
