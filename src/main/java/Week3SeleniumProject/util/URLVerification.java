package Week3SeleniumProject.util;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.WebDriverRunner.url;

public class URLVerification {
    public static void verifyURL(String expectedURL) {
        // Get the current URL
        String currentUrl = WebDriverRunner.url();
        // Assert that the current URL matches the expected URL
        Assert.assertEquals(currentUrl, expectedURL, "URLs do not match");
    }
}
