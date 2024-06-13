package tests.question1;

import Week3SeleniumProject.pages.question1Pages.FileUploadPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class FileUpload extends BaseTest {

    @Test
    public void testFileUpload() {
        // Create a test in the report
        test = extent.createTest("File Upload Test", "Validate file upload functionality");

        try {
            // Visit the webpage
            test.log(Status.INFO, "Navigating to base URL");
            open(baseURL);
            test.log(Status.PASS, "Webpage visited successfully");

            // Instantiate the file upload page
            FileUploadPage fileUpload = new FileUploadPage();

            // Perform file upload
            test.log(Status.INFO, "Clicking file upload button");
            fileUpload.clickFileUploadButton();

            test.log(Status.INFO, "Uploading file");
            fileUpload.uploadedFile(filePath);

            sleep(2000);

            test.log(Status.INFO, "Clicking file upload submit button");
            fileUpload.clickFileUpload();

            sleep(2000);

            // Verify successful file upload
            boolean isSuccessMessageDisplayed = fileUpload.confirmSuccessMessage();
            Assert.assertTrue(isSuccessMessageDisplayed, "Success message is not displayed");
            test.log(Status.PASS, "File uploaded successfully and success message displayed");

            // Verify URL
            test.log(Status.INFO, "Verifying URL");
            URLVerification.verifyURL(fileUploadURL);
            test.log(Status.PASS, "URL verified successfully");

        } catch (AssertionError e) {
            test.log(Status.FAIL, "Assertion failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            test.log(Status.FAIL, "Test failed: " + e.getMessage());
            throw e;
        }
    }
}
