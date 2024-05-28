package Week3SeleniumProject.pages.question1Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SlidersPage {
    private final WebDriver driver;
    private final By slideButton = By.linkText("Sliders");

    public SlidersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSlidersButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement buttonSliders = wait.until(ExpectedConditions.visibilityOfElementLocated(slideButton));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonSliders);

        // Wait for the element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(buttonSliders));

        // Use JavaScript to click the button
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonSliders);
    }

    public void performSlider() {
        WebElement slider = driver.findElement(By.id("slideMe"));

        // Get the width of the slider
        int sliderWidth = slider.getSize().width;

        // Assuming the slider range is from 0 to 100
        int sliderMin = Integer.parseInt(slider.getAttribute("min"));
        int sliderMax = Integer.parseInt(slider.getAttribute("max"));

        // The current value and target value
        int currentValue = Integer.parseInt(slider.getAttribute("value"));
        int targetValue = 25;

        // Calculate the offset
        int offset = (int) ((sliderWidth * (targetValue - currentValue)) / (sliderMax - sliderMin));

        // Create an Actions object
        Actions actions = new Actions(driver);

        // Perform the action: click, hold, move by offset, and release
        actions.clickAndHold(slider).moveByOffset(offset, 0).release().perform();

}

public String confirmSlideValue () {
        WebElement slideValue = driver.findElement(By.cssSelector("span#value"));
        return slideValue.getText();
}
}
