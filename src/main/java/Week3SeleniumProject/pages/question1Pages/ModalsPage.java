package Week3SeleniumProject.pages.question1Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Week3SeleniumProject.util.AppConfig.clickElement;

public class ModalsPage{
    private final WebDriver driver;
    private final By modalsButton = By.linkText("Modals");
    private final By simpleModal = By.id("simpleModal");
    private final By formModal = By.id("formModal");
    private final By formName = By.id("g1051-name");
    private final By formEmail = By.id("g1051-email");
    private final By formMessage = By.id("contact-form-comment-g1051-message");
    private final By submit = By.cssSelector("button[type='submit']");

    public ModalsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickModalsButton() {
        clickElement(driver, modalsButton);
    }

    public void clickSimpleModalButton() {
        WebElement simpleModalButton = driver.findElement(simpleModal);
        simpleModalButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modalContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#popmake-1318:nth-of-type(1)")));
        // Verify modal Container is displayed
        Assert.assertTrue(modalContainer.isDisplayed(), "Modal is not displayed");
    }

    public void clickFormModalButton() {
        WebElement formModalButton = driver.findElement(formModal);
        formModalButton.click();
        WebElement name = driver.findElement(formName);
        name.sendKeys("Hamid");
        WebElement email = driver.findElement(formEmail);
        email.sendKeys("deo@gmail.com");
        WebElement message = driver.findElement(formMessage);
        message.sendKeys("Welcome Home");
        WebElement submitButton = driver.findElement(submit);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
    }

    public WebElement confirmModalContainer () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#popmake-674:nth-of-type(1)")));
    }
}
