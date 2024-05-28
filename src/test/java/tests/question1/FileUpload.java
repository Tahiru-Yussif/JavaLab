package tests.question1;

import Week3SeleniumProject.pages.question1Pages.FileUploadPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUpload extends BaseTest {

   @Test
   public void testFileUpload() {
       // visit the webpage
       driver.get(baseURL);

       // instantiate the fileUpload Page
       FileUploadPage fileUpload = new FileUploadPage(driver);

       // Performing file upload
       fileUpload.clickFileUploadButton();
       fileUpload.uploadedFile(filePath);
       fileUpload.clickFileUpload();

       // Verify successful file upload
       Assert.assertTrue(fileUpload.confirmSuccessMessage(), "Success message is not displayed");

       // Verify URL
       URLVerification.verifyURL(driver, fileUploadURL);
   }
}
