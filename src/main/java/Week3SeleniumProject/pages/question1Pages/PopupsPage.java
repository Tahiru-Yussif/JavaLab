package Week3SeleniumProject.pages.question1Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class PopupsPage {
    private final SelenideElement popupsButton = $(By.linkText("Popups"));
    private final SelenideElement alert = $(byId("alert"));
    private final SelenideElement confirm = $(byId("confirm"));
    private final SelenideElement confirmResponse = $(byId("confirmResult"));
    private final SelenideElement prompt = $(byId("prompt"));
    private final SelenideElement promptResult = $(byId("promptResult"));

    public void clickPopupsButton() {
        popupsButton.click();
    }

    public void clickAlertPopup() {
        // Find and click on the alert button
        alert.click();
        // Switch to the alert and get the text
        Alert alert = switchTo().alert();
        // Close the alert
        alert.accept(); /// Pressing okay to confirm
    }

    public void clickConfirmPopup() {
        // Find and click on the alert button
        confirm.click();
        // Switch to the alert and get the text
        Alert alert = switchTo().alert();

        /// Pressing okay to confirm
        alert.accept();
        SelenideElement confirmResult = confirmResponse;
        String confirmExpectedText = "OK it is!";
        String confirmActualText = confirmResult.getText();
        confirmResult.shouldBe(Condition.visible);
        Assert.assertEquals(confirmActualText, confirmExpectedText);
    }

    public void clickPromptPopup() {
        prompt.click();
        // Switch to the alert and get the text
        Alert alert = switchTo().alert();
        alert.sendKeys("Welcome to Prompt Alert");
        alert.accept();
        promptResult.shouldBe(Condition.visible);
    }
}
