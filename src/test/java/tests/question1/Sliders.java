package tests.question1;

import Week3SeleniumProject.pages.question1Pages.SlidersPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sliders extends BaseTest {

    @Test
    public void testSliders() throws InterruptedException {
        // visit the webpage
        driver.get(baseURL);

        // Instantiate the sliders page
        SlidersPage sliders = new SlidersPage(driver);

        // Perform sliders
        sliders.clickSlidersButton();
        sliders.performSlider();

        // Verify the slider value
        Assert.assertEquals(sliders.confirmSlideValue(), "50", "Slider value doesn't exist");

        // Verify URL
        URLVerification.verifyURL(driver, slidersURL);
    }
}
