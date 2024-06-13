    package Week3SeleniumProject.pages.question1Pages;

    import com.codeborne.selenide.Condition;
    import com.codeborne.selenide.SelenideElement;
    import org.openqa.selenium.By;
    import static com.codeborne.selenide.Selenide.$;
    import static com.codeborne.selenide.Selenide.switchTo;

    public class IframesPage {
        private final SelenideElement iframesButton = $(By.linkText("Iframes"));
        private final By firstIframeSubscribeButton = By.xpath("//span[text()='Subscribe']");
        private final By secondIframeDownloadButton = By.xpath("//span[text()='Downloads']");

        public void clickIframesButton() {
            iframesButton.click();
        }

        private boolean checkIframe(int iframeIndex, By elementLocator) {
            switchTo().frame(iframeIndex);
            SelenideElement element = $(elementLocator);
            boolean isDisplayed = element.shouldBe(Condition.visible).is(Condition.enabled);
            switchTo().defaultContent();
            return isDisplayed;
        }

        public boolean isFirstIframeSubscribeButtonDisplayed() {
            return checkIframe(0, firstIframeSubscribeButton);
        }

        public boolean isSecondIframeDownloadButtonDisplayed() {
            return checkIframe(1, secondIframeDownloadButton);
        }
    }
