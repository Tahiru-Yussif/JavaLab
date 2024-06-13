package tests.question1;

import Week3SeleniumProject.pages.question1Pages.SlidersPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class Sliders extends BaseTest {

    @Test
    public void testSliders() throws InterruptedException {
        // External Test Report
        this.test = this.extent.createTest("Slider functionality", "To validate slider functionality");

        // visit the webpage
        this.test.log(Status.INFO, "Navigating to Google website");
        open(baseURL);
        this.test.log(Status.PASS, "Webpage visited successfully");

        // Instantiate the sliders page
        SlidersPage sliders = new SlidersPage();

        // Perform sliders
        sliders.clickSlidersButton();
        sliders.performSlider();
        this.test.log(Status.PASS, "Slider functionality worked successfully");

        // Verify the slider value
        Assert.assertEquals(sliders.confirmSlideValue(), "50", "Slider value doesn't exist");
        this.test.log(Status.PASS, "The slider value verified successfully");

        // Verify URL
        URLVerification.verifyURL(slidersURL);
        this.test.log(Status.PASS, "URL verified successfully");
    }
}
