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
        private final By firstIframeSubscribeButton = By.xpath("//span[text()='Subscribe']");
        private final By secondIframeDownloadButton = By.xpath("//span[text()='Downloads']");

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

        private boolean checkIframe(int iframeIndex, By elementLocator) {
            driver.switchTo().frame(iframeIndex);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
            boolean isDisplayed = element.isDisplayed();
            driver.switchTo().defaultContent();
            return isDisplayed;
        }

        public boolean isFirstIframeSubscribeButtonDisplayed() {
            return checkIframe(0, firstIframeSubscribeButton);
        }

        public boolean isSecondIframeDownloadButtonDisplayed() {
            return checkIframe(1, secondIframeDownloadButton);
        }
    }
