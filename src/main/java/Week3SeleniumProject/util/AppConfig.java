package Week3SeleniumProject.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class AppConfig {
    private static final String CONFIG_FILE = "config.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = AppConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getBaseURL() {
        return properties.getProperty("baseURL");
    }

    public static String getFormFieldURL() {
        return properties.getProperty("formFieldURL");
    }

    public static String getPopupsURL() {
        return properties.getProperty("popupsURL");
    }

    public static String getModalsURL() {
        return properties.getProperty("modalsURL");
    }

    public static String getCalendarsURL() {
        return properties.getProperty("calendarsURL");
    }

    public static String getFileUploadURL() {
        return properties.getProperty("fileUploadURL");
    }

    public static String getIframeURL() {
        return properties.getProperty("iframeURL");
    }

    public static String getSlidersURL() {
        return properties.getProperty("slidersURL");
    }

    public static String getWindowsOperationURL() {
        return properties.getProperty("windowOperationsURL");
    }

    public static String getTablesURL() {
        return properties.getProperty("tablesURL");
    }

    public static String getFileDownloadURL() {
        return properties.getProperty("fileDownloadURL");
    }

    public static String getName() {
        return properties.getProperty("name");
    }

    public static String getEmail() {
        return properties.getProperty("email");
    }

    public static String getMessage() {
        return properties.getProperty("message");
    }

    public static String getFileUploadPath() {
        return properties.getProperty("fileUploadPath");
    }

    // for scroll in the webpage

    public static void clickElement(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        // Wait for the element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(element));

        // Use JavaScript to click the button
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
