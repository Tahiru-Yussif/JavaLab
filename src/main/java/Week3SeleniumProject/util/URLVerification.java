package Week3SeleniumProject.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class URLVerification {
    public static void verifyURL(WebDriver driver, String expectedURL) {
        // Get the current URL
        String currentUrl = driver.getCurrentUrl();

        // Verify URL
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedURL));

        // Assert that the current URL matches the expected URL
        Assert.assertEquals(currentUrl, expectedURL, "URLs do not match");
    }
}
