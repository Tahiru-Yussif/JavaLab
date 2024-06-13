package Week3SeleniumProject.pages.question1Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Set;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class WindowsOperationPage {
    private final SelenideElement windowsButton = $(By.linkText("Window Operations"));
    private final SelenideElement newTabButton = $(By.cssSelector("button.custom_btn.btn_hover:first-of-type"));
    private final SelenideElement replaceTabButton = $(By.xpath("(//button[contains(@class, 'custom_btn') and contains(@class, 'btn_hover')])[2]"));

    public void clickWindowsButton() {
        windowsButton.click();
    }

    public void clickNewTab() {
        newTabButton.click();

        // Get the current window handle
        String originalWindow = getWebDriver().getWindowHandle();

        // Wait until a new tab is opened and switch to it
        Set<String> windowHandles = getWebDriver().getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                switchTo().window(handle);
                break;
            }
        }
    }

    public void clickReplaceWindow() {
        replaceTabButton.click();

        // Get the current window handle
        String originalWindow = getWebDriver().getWindowHandle();

        // Wait until a new window is opened and switch to it
        Set<String> windowHandles = getWebDriver().getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                switchTo().window(handle);
                break;
            }
        }

        // Navigate to the new URL in the new window
//        open("https://automatenow.io/");
        System.out.println(getWebDriver().getCurrentUrl());
    }

}
