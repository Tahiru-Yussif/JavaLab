package tests.question1;

import Week3SeleniumProject.pages.question1Pages.CalendarsPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.open;

public class Calendars extends BaseTest {

    @Test
    public void testCalendars() {
        test = extent.createTest("Calendar Functionality", "Validate calendar selection and form submission");

        try {
            // Visit the webpage
            test.log(Status.INFO, "Navigating to the base URL");
            open(baseURL);
            test.log(Status.PASS, "Webpage visited successfully");

            // Initialize the Calendar page
            CalendarsPage calendars = new CalendarsPage();

            // Click on the Calendar page
            test.log(Status.INFO, "Clicking on the Calendars button");
            calendars.clickCalendarsButton();

            // Verify URL
            URLVerification.verifyURL(calendarsURL);
            test.log(Status.PASS, "URL verified successfully");

            test.log(Status.INFO, "Opening the date picker");
            calendars.clickToOpenDatePicker();

            // Get current date and format it
            LocalDate targetDate = LocalDate.now();

            test.log(Status.INFO, "Selecting the year and month");
            calendars.selectDate(targetDate);

            // Verify the selected date
            String selectedDate = calendars.getSelectedDate();
            test.log(Status.INFO, "Verifying the selected date");
            Assert.assertTrue(selectedDate.contains(String.valueOf(targetDate.getDayOfMonth())));
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
            Assert.assertTrue(verifyDate.contains(String.valueOf(targetDate.getDayOfMonth())));
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
