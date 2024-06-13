package Week3SeleniumProject.pages.question1Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.testng.Assert.assertTrue;

public class FileDownloadPage {
    private final SelenideElement fileDownloadButton = $(By.linkText("File Download"));
    private final SelenideElement normalFileDownloadBtn = $(byCssSelector("a.wpdm-download-link.download-on-click.btn.btn-primary"));
    private final SelenideElement protectedFileDownloadBtn = $(byCssSelector("a.wpdm-download-link.wpdm-download-locked.btn.btn-primary"));
    private final SelenideElement enterPasswordValue = $(byCssSelector("#password_6655f50f448ce_921"));
    private final SelenideElement setPassword = $(By.name("password"));
    private final SelenideElement submitButton = $(".wpdm_submit");

    public void clickFileDownloadButton() {
        fileDownloadButton.click();
    }

    public void clickNormalFileDownloadButton() {
        normalFileDownloadBtn.click();
        File downloadedFile = normalFileDownloadBtn.download();
        // Verify the file is downloaded
        assertTrue(downloadedFile.exists(), "File should exist after download");
        assertTrue(downloadedFile.length() > 0, "Downloaded file should not be empty");
    }

    public void downloadLockedFile() {
        String password = "automateNow";
        protectedFileDownloadBtn.click();
        switchTo().frame("wpdm-lock-frame");
        setPassword.setValue(password);
        submitButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void enterPasswordAndSubmit() {
        enterPasswordValue.val("automateNow").pressEnter();
    }

}
