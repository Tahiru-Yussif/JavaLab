package Week3SeleniumProject.pages.question1Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class CalendarsPage {
    private final SelenideElement calendarsButton = $(By.linkText("Calendars"));
    private final SelenideElement selectDate = $(byId("g1065-selectorenteradate"));
    private final SelenideElement getDateTitle = $(byCssSelector(".ui-datepicker-title"));
    private final SelenideElement submitButton = $(byCssSelector(".pushbutton-wide"));
    private final SelenideElement next = $(byCssSelector(".ui-datepicker-next.ui-corner-all"));
    private final SelenideElement successMessage = $(byId("contact-form-success-header"));
    private final SelenideElement verifyDate = $(byCssSelector(".field-value"));

    public void clickCalendarsButton() {
        calendarsButton.click();
    }

    public void clickToOpenDatePicker() {
        selectDate.click();
    }

    public void selectYearAndMonth(LocalDate targetDate) {
        DateTimeFormatter yearMonthFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        String targetYearMonth = targetDate.format(yearMonthFormatter);

        while (!getDateTitle.getText().contains(targetYearMonth)) {
            next.click();
        }
    }

    public void selectDate(LocalDate targetDate) {
        selectYearAndMonth(targetDate);
        $(byXpath("//a[text()='" + targetDate.getDayOfMonth() + "']")).click();
    }

    public String getSelectedDate() {
        return selectDate.getValue();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.text();
    }

    public String verifiedDate() {
        return verifyDate.text();
    }
}
