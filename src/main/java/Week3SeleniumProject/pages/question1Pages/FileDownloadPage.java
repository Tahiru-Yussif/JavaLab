package Week3SeleniumProject.pages.question1Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class FileDownloadPage {
    private final WebDriver driver;
    private final By tablesButton = By.linkText("File Download");
    private final By normalFileDownloadBtn = By.cssSelector("a.wpdm-download-link.download-on-click.btn.btn-primary");
    private final By protectedFileDownloadBtn = By.cssSelector("a.wpdm-download-link.wpdm-download-locked.btn.btn-primary");
    private final By enterPasswordValue = By.cssSelector("#password_6655f50f448ce_921");

    public FileDownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFileDownloadButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement buttonFileDownload = wait.until(ExpectedConditions.visibilityOfElementLocated(tablesButton));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonFileDownload);

        // Wait for the element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(buttonFileDownload));

        // Use JavaScript to click the button
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonFileDownload);
    }

    public ChromeOptions performNormalDownload() {
        String downloadFilePath = "/path/to/download/directory";
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadFilePath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        return options;

    }

    public void clickNormalFileDownloadButton () {
        WebElement downloadLink = driver.findElement(normalFileDownloadBtn);
        downloadLink.click();
    }

    public void clickProtectedFileDownloadButton () {
        WebElement downloadLink = driver.findElement(protectedFileDownloadBtn);
//        downloadLink.click();
//        driver.switchTo().frame(4);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", downloadLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", downloadLink);
    }

    public void enterPasswordAndSubmit() {
        WebElement enterPassword = driver.findElement(enterPasswordValue);
        enterPassword.sendKeys("automateNow");
    }
}
