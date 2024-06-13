package Week3SeleniumProject.pages.question1Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class SlidersPage {
    private final SelenideElement slideButton = $(By.linkText("Sliders"));
    private final SelenideElement slider = $(By.id("slideMe"));
    private final SelenideElement sliderValue = $(By.cssSelector("span#value"));

    public void clickSlidersButton() {
        slideButton.click();
    }

    public void performSlider() {
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

        // Perform the action: click, hold, move by offset, and release
        Actions actions = actions();
        actions.clickAndHold(slider).moveByOffset(offset, 0).release().perform();
    }

    public String confirmSlideValue() {
        return sliderValue.text();
    }
}
