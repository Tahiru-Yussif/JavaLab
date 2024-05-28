package tests.question1;

import Week3SeleniumProject.pages.question1Pages.CalendarsPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Calendars extends BaseTest {

    @Test
    public void testCalendars() {
        // visit the webpage
        driver.get(baseURL);

//         Verify URL
//        URLVerification.verifyURL(driver, calendarsURL);

        // Initialize the Calendar page
        CalendarsPage calendars = new CalendarsPage(driver);

        // clicking on the Calendar page
        calendars.clickCalendarsButton();
        calendars.clickToOpenDatePicker();
        calendars.selectYear("May 2024");
        calendars.selectDate("15");

        // Verify the selected date
        String selectedDate = calendars.getSelectedDate();
        Assert.assertEquals(selectedDate, "2024-05-15", "Selected date does not match");

        // click on the submit button
        calendars.clickSubmitButton();

        // verifying the success message
        String successMessage = calendars.getSuccessMessage();
        Assert.assertEquals(successMessage, "Your message has been sent", "Selected date does not match");
        String verifyDate = calendars.verifiedDate();
        Assert.assertEquals(verifyDate, "2024-05-15", "Selected date does not match");
    }
}
