package tests.question1;

import Week3SeleniumProject.pages.question1Pages.FormFieldPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import org.testng.annotations.Test;

public class FormFields extends BaseTest {

    @Test
    public void testFormFields() throws InterruptedException {

        // visit the webpage
        driver.get(baseURL);

        // instantiate the formField page
        FormFieldPage formField = new FormFieldPage(driver);
        // navigating to the form field page
        formField.clickFormFieldButton();
        // filling the name field
        formField.enterName(name);
        // checking the checkboxes
        formField.clickCheckbox();
        // clicking radio Button
        formField.clickRadioButton();
        // selecting dropdown options
        formField.selectOption();
        // filling the email field
        formField.enterEmail(email);
        // filling the text message box
        formField.enterMessage(message);
        // clicking submit button
        formField.clickSubmitButton();

        // Verify URL
        URLVerification.verifyURL(driver, formFieldURL);
    }
}
