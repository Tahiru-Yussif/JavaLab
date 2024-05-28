package Week3SeleniumProject.pages.question1Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IframesPage {
    private final WebDriver driver;
    private final By iframesButton = By.linkText("Iframes");

    public IframesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickIframesButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement buttonIframe = wait.until(ExpectedConditions.visibilityOfElementLocated(iframesButton));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonIframe);

        // Wait for the element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(buttonIframe));

        // Use JavaScript to click the button
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonIframe);
    }

    public void switchToFirstIframe() {
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
        loginButton.click();
    }

    public void loginInFirstIframe() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement subscribeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Subscribe']")));
        System.out.println(subscribeButton.getText());
    }
}
