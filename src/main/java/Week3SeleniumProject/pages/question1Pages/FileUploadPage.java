package Week3SeleniumProject.pages.question1Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class FileUploadPage {

    private final SelenideElement fileUploadButton = $(By.linkText("File Upload"));
    private final SelenideElement uploadBtn = $(byId("upload-btn"));
    private final SelenideElement uploadFile = $(byId("file-upload"));
    private final SelenideElement successMessage = $(By.cssSelector(".wpcf7-response-output"));

    public void clickFileUploadButton() {
        fileUploadButton.click();
    }

    public void uploadedFile(String filePath) {
        uploadFile.uploadFile(new File(filePath));
    }

    public void clickFileUpload() {
        uploadBtn.click();
    }

    public boolean confirmSuccessMessage() {
      return successMessage.isDisplayed();
    }
}
