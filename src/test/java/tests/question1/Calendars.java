package tests.question1;

import Week3SeleniumProject.pages.question1Pages.CalendarsPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Calendars extends BaseTest {

    @Test
    public void testCalendars() {
        test = extent.createTest("Calendar Functionality", "Validate calendar selection and form submission");

        try {
            // Visit the webpage
            test.log(Status.INFO, "Navigating to the base URL");
            driver.get(baseURL);
            test.log(Status.PASS, "Webpage visited successfully");

            // Verify URL (commented out as per your original code)
            // URLVerification.verifyURL(driver, calendarsURL);
            // test.log(Status.PASS, "URL verified successfully");

            // Initialize the Calendar page
            CalendarsPage calendars = new CalendarsPage(driver);

            // Click on the Calendar page
            test.log(Status.INFO, "Clicking on the Calendars button");
            calendars.clickCalendarsButton();

            test.log(Status.INFO, "Opening the date picker");
            calendars.clickToOpenDatePicker();

            test.log(Status.INFO, "Selecting the year");
            calendars.selectYear("May 2024");

            test.log(Status.INFO, "Selecting the date");
            calendars.selectDate("15");

            // Verify the selected date
            String selectedDate = calendars.getSelectedDate();
            test.log(Status.INFO, "Verifying the selected date");
            Assert.assertEquals(selectedDate, "2024-05-15", "Selected date does not match");
            test.log(Status.PASS, "Selected date verified successfully");

            // Click on the submit button
            test.log(Status.INFO, "Clicking the submit button");
            calendars.clickSubmitButton();

            // Verify the success message
            String successMessage = calendars.getSuccessMessage();
            test.log(Status.INFO, "Verifying the success message");
            Assert.assertEquals(successMessage, "Your message has been sent", "Success message does not match");
            test.log(Status.PASS, "Success message verified successfully");

            // Verify the displayed date
            String verifyDate = calendars.verifiedDate();
            test.log(Status.INFO, "Verifying the displayed date");
            Assert.assertEquals(verifyDate, "2024-05-15", "Displayed date does not match");
            test.log(Status.PASS, "Displayed date verified successfully");

        } catch (AssertionError e) {
            test.log(Status.FAIL, "Assertion failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            test.log(Status.FAIL, "Test failed: " + e.getMessage());
            throw e;
        }
    }
}
