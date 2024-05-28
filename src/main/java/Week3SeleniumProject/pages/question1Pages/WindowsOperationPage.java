package Week3SeleniumProject.pages.question1Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WindowsOperationPage {
    private final WebDriver driver;
    private final By windowsButton = By.linkText("Window Operations");

    public WindowsOperationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickWindowsButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement windowsOperation = wait.until(ExpectedConditions.visibilityOfElementLocated(windowsButton));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", windowsOperation);

        // Wait for the element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(windowsOperation));

        // Use JavaScript to click the button
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", windowsOperation);
    }

    public void clickNewTab() {
        WebElement newTabButton = driver.findElement(By.cssSelector("button.custom_btn.btn_hover:first-of-type"));
        newTabButton.click();

        // Get the current window handle
        String originalWindow = driver.getWindowHandle();
//        driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));

        // Switch to the new tab
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public void clickReplaceWindow() {
        WebElement replaceTabButton = driver.findElement(By.cssSelector("button.custom_btn.btn_hover:nth-of-type(1)"));
        replaceTabButton.click();
        // Get the current window handle
        String originalWindow = driver.getWindowHandle();

        // Switch to the new tab
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        driver.get("https://automatenow.io/");
        System.out.println(driver.getCurrentUrl());
    }

}
