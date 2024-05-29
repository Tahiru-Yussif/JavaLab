package Week3SeleniumProject.pages.question1Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static Week3SeleniumProject.util.AppConfig.clickElement;

public class FormFieldPage {
    private final WebDriver driver;
    private final By formFieldsButton = By.linkText("Form Fields");
    private final By enterName = By.name("name");
    private final By checkbox = By.name("fav_drink");
    private final By radioButtons = By.id("color1");
    private final By dropDown = By.id("siblings");

    private final By enterEmail = By.id("email");
    private final By enterMessage = By.id("message");
    private final By submitButton = By.id("submit-btn");

    public FormFieldPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFormFieldButton() {
        clickElement(driver, formFieldsButton);
    }

    public void enterName(String name) {
        WebElement NameInput = driver.findElement(enterName);
        NameInput.sendKeys(name);
    }

    public void clickCheckbox() {
        List<WebElement> checkboxes = driver.findElements(checkbox);
        for (WebElement checkbox :  checkboxes) {
            if (!checkbox.isSelected()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
            }
            assert checkbox.isSelected();
        }
    }

    public void clickRadioButton() {
        WebElement radioButton = driver.findElement(radioButtons);
            if (!radioButton.isSelected()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioButton);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);
            }
            assert radioButton.isSelected();
    }

    public void selectOption() throws InterruptedException {
        WebElement dropdown = driver.findElement(dropDown);
        Select opt1 = new Select(dropdown);
        opt1.selectByIndex(1);
        Thread.sleep(1000);
        opt1.selectByValue("no");
        Thread.sleep(1000);
        opt1.selectByVisibleText("Maybe");
    }

    public void enterEmail(String email) {
        WebElement EmailInput = driver.findElement(enterEmail);
        EmailInput.sendKeys(email);
    }

    public void enterMessage(String message) {
        WebElement MessageInput = driver.findElement(enterMessage);
        MessageInput.sendKeys(message);
    }

    public void clickSubmitButton() {
        WebElement buttonSubmit = driver.findElement(submitButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonSubmit);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonSubmit);
        // Switch to the alert and get the text
        Alert alert1 = driver.switchTo().alert();
        // Close the alert
        alert1.accept(); /// Pressing okay to confirm
    }


}
