package Week3SeleniumProject.pages.question1Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalendarsPage {
    private final WebDriver driver;
    private final By calendarsButton = By.linkText("Calendars");
    private final By selectDate = By.id("g1065-selectorenteradate");
    private final By getDateTitle = By.cssSelector(".ui-datepicker-title");
    private final By submitButton = By.cssSelector(".pushbutton-wide");
    private final By next = By.cssSelector(".ui-datepicker-next ui-corner-all");
    private final By successMessage = By.id("contact-form-success-header");
    private final By verifyDate = By.cssSelector(".field-value");
    private final String dateSelect = "//a[text()='15']";

    public CalendarsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCalendarsButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement buttonCalendar = wait.until(ExpectedConditions.visibilityOfElementLocated(calendarsButton));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonCalendar);

        // Wait for the element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(buttonCalendar));

        // Use JavaScript to click the button
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonCalendar);
    }

    public void clickToOpenDatePicker() {
        WebElement dateSelect = driver.findElement(selectDate);
        dateSelect.click();
    }

    public void selectYear(String Year) {
        while (!driver.findElement(getDateTitle).getText().contains(Year)) {
            driver.findElement(next).click();
        }
    }

    public void selectDate(String day) {
        By dateLocator = By.xpath(dateSelect);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(dateLocator));
        dateElement.click();
    }

    public String getSelectedDate() {
        return driver.findElement(selectDate).getAttribute("value");
    }

    public void clickSubmitButton() {
        WebElement submit = driver.findElement(submitButton);
        submit.click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public String verifiedDate() {
        return driver.findElement(verifyDate).getText();
    }
}

