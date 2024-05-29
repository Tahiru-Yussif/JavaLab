package Week3SeleniumProject.pages.question1Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Week3SeleniumProject.util.AppConfig.clickElement;

public class FileUploadPage {

    private final WebDriver driver;
    private final By fileUploadButton = By.linkText("File Upload");
    private final By uploadBtn = By.id("upload-btn");
    private final By uploadFile = By.id("file-upload");
    private final By successMessage = By.cssSelector(".wpcf7-response-output");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFileUploadButton() {
        clickElement(driver, fileUploadButton);
    }

    public void uploadedFile(String filePath) {
        WebElement chooseFile = driver.findElement(uploadFile);
        chooseFile.sendKeys(filePath);
    }

    public void clickFileUpload() {
        WebElement uploadButton = driver.findElement(uploadBtn);
        uploadButton.click();
    }

    public boolean confirmSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMgt = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return successMgt.isDisplayed();
    }
}
