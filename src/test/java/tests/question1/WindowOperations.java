package tests.question1;

import Week3SeleniumProject.pages.question1Pages.WindowsOperationPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowOperations extends BaseTest {

    @Test
    public void testClickWindowsOperation() {
        // visit the webpage
        driver.get(baseURL);

        // instantiate the WindowsOperations
        WindowsOperationPage windowsOperation = new WindowsOperationPage(driver);

        // Perform the windows operations
        windowsOperation.clickWindowsButton();

        // Verify URL
        URLVerification.verifyURL(driver, windowOperationsURL);
    }

  @Test
    public void testNewTab() {
        testClickWindowsOperation();

        // instantiate the WindowsOperations
        WindowsOperationPage windowsOperation = new WindowsOperationPage(driver);

        // Perform the new tab opeations
        windowsOperation.clickNewTab();

        // Verify the Title
      String currentTitle = driver.getTitle();
      System.out.println(currentTitle);
      String expectedTitle = "Home | automateNow";
      // Verify URL
        Assert.assertEquals(currentTitle, expectedTitle, "Wrong Title");
    }

//    @Test
    public void testReplaceWindow() throws InterruptedException {
        testClickWindowsOperation();
//
//        // instantiate the WindowsOperations
        WindowsOperationPage windowsOperation = new WindowsOperationPage(driver);

//        // Perform Replace Window
        windowsOperation.clickReplaceWindow();
//
        Thread.sleep(10000);

        // Verify URL

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.urlToBe("https://automatenow.io/"));
//
//        String currentURL = driver.getCurrentUrl();
//        System.out.println(currentURL);
////        String expectedURL = "https://automatenow.io/";
//
//        // Verify URL
//        Assert.assertEquals(currentURL, expectedURL, "Wrong url");
//
//        Thread.sleep(10000);

    }

}
