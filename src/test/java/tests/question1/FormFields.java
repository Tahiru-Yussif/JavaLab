package tests.question1;

import Week3SeleniumProject.pages.question1Pages.FormFieldPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class FormFields extends BaseTest {

    @Test
    public void testFormFields() throws InterruptedException {
// Create a test in the report
        test = extent.createTest("Form Fields Test", "Validate form field functionality");

        try {
            // Visit the webpage
            test.log(Status.INFO, "Navigating to base URL");
            open(baseURL);
            test.log(Status.PASS, "Webpage visited successfully");

            // Instantiate the formField page
            FormFieldPage formField = new FormFieldPage();
            test.log(Status.INFO, "FormFieldPage instantiated");

            // Navigating to the form field page
            test.log(Status.INFO, "Clicking Form Field button");
            formField.clickFormFieldButton();

            // Filling the name field
            test.log(Status.INFO, "Entering name");
            formField.enterName(name);

            // Checking the checkboxes
            test.log(Status.INFO, "Clicking checkboxes");
            formField.clickCheckbox();

            // Clicking radio button
            test.log(Status.INFO, "Clicking radio button");
            formField.clickRadioButton();

            // Selecting dropdown options
            test.log(Status.INFO, "Selecting dropdown options");
            formField.selectOption();

            // Filling the email field
            test.log(Status.INFO, "Entering email");
            formField.enterEmail(email);

            // Filling the text message box
            test.log(Status.INFO, "Entering message");
            formField.enterMessage(message);

            // Clicking submit button
            test.log(Status.INFO, "Clicking submit button");
            formField.clickSubmitButton();

            // Verify URL
            test.log(Status.INFO, "Verifying URL");
            URLVerification.verifyURL(formFieldURL);
            test.log(Status.PASS, "URL verified successfully");

        } catch (AssertionError e) {
            test.log(Status.FAIL, "Assertion failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            test.log(Status.FAIL, "Test failed: " + e.getMessage());
            throw e;
        }
    }
}
