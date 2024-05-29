    package Week3SeleniumProject.pages.question1Pages;

    import org.openqa.selenium.By;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.time.Duration;

    import static Week3SeleniumProject.util.AppConfig.clickElement;

    public class IframesPage {
        private final WebDriver driver;
        private final By iframesButton = By.linkText("Iframes");
        private final By firstIframeSubscribeButton = By.xpath("//span[text()='Subscribe']");
        private final By secondIframeDownloadButton = By.xpath("//span[text()='Downloads']");

        public IframesPage(WebDriver driver) {
            this.driver = driver;
        }

        public void clickIframesButton() {
            clickElement(driver, iframesButton);
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
