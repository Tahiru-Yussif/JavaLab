package Week3SeleniumProject.pages.question1Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Week3SeleniumProject.util.AppConfig.clickElement;

public class PopupsPage {
    private final WebDriver driver;
    private final By popupsButton = By.linkText("Popups");
    private final By alert = By.id("alert");
    private final By confirm = By.id("confirm");
    private final By prompt = By.id("prompt");


    public PopupsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPopupsButton() {
        clickElement(driver, popupsButton);
    }

    public void clickAlertPopup() {
        // Find and click on the alert button
        WebElement alertButton = driver.findElement(alert);
        alertButton.click();
        // Switch to the alert and get the text
        Alert alert = driver.switchTo().alert();
        // Close the alert
        alert.accept(); /// Pressing okay to confirm

    }

    public void clickConfirmPopup() {
        // Find and click on the alert button
        WebElement confirmButton = driver.findElement(confirm);
        confirmButton.click();
        // Switch to the alert and get the text
        Alert alert = driver.switchTo().alert();

        /// Pressing okay to confirm
//        alert.accept();
//        WebElement confirmResult = driver.findElement(By.id("confirmResult"));
//        String confirmExpectedText = "OK it is!";
//        String confirmActualText = confirmResult.getText();
//        Assert.assertTrue(confirmResult.isDisplayed(), "The element with id 'confirmResult' is not displayed");
//        Assert.assertEquals(confirmActualText, confirmExpectedText, "The text in the element is not as expected");

        /// Pressing cancel to cancel
        alert.dismiss();
        WebElement cancelResult = driver.findElement(By.id("confirmResult"));
        String cancelExpectedText = "Cancel it is!";
        String cancelActualText = cancelResult.getText();
        Assert.assertTrue(cancelResult.isDisplayed(), "The element with id 'confirmResult' is not displayed");
        Assert.assertEquals(cancelActualText, cancelExpectedText, "The text in the element is not as expected");
    }

    public void clickPromptPopup() throws InterruptedException {
        WebElement promptButton = driver.findElement(prompt);
        promptButton.click();
        // Switch to the alert and get the text
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Welcome to Prompt Alert");
        Thread.sleep(2000);
        alert.accept();
    }
}
