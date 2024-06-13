package Week3SeleniumProject.pages.question1Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class FormFieldPage {
    //    private final WebDriver driver;
    private final SelenideElement formFieldsButton = $(By.linkText("Form Fields"));
    private final SelenideElement enterName = $(byName("name"));
    private final ElementsCollection checkboxes = $$(byName("fav_drink"));
    private final SelenideElement radioButton = $(byId("color1"));
    private final SelenideElement dropDown = $(byId("siblings"));
    private final SelenideElement enterEmail = $(byId("email"));
    private final SelenideElement enterMessage = $(byId("message"));
    private final SelenideElement submitButton = $(byId("submit-btn"));


    public void clickFormFieldButton() {
        formFieldsButton.click();
    }

    public void enterName(String name) {
        enterName.val(name).shouldHave(value(name));
    }

    public void clickCheckbox() {
        for (SelenideElement checkbox : checkboxes) {
            checkbox.shouldNotBe(checked).click();
            checkbox.shouldBe(checked);
        }
    }

    public void clickRadioButton() {
        if (!radioButton.isSelected()) {
            radioButton.click();
        }
        radioButton.shouldBe(selected);
    }

    public void selectOption() throws InterruptedException {
        // selecting by Index
        dropDown.selectOption(1);
        Thread.sleep(1000);
        // selecting by name
        dropDown.selectOption("Yes");
        dropDown.getSelectedOption().shouldHave(text("Yes"));
        // selecting by value name
        dropDown.selectOptionByValue("no");
        dropDown.getSelectedOption().shouldHave(value("no"));
    }

    public void enterEmail(String email) {
        enterEmail.val(email).shouldHave(value(email));
    }

    public void enterMessage(String message) {
        enterMessage.val(message).shouldHave(value(message));
    }

    public void clickSubmitButton() {
        submitButton.click();
//    // Switch to the alert and get the text
        Alert alert = switchTo().alert();
        String confirmText = alert.getText();
        Assert.assertEquals(confirmText, "Message received!");
        System.out.println(alert.getText());
        alert.accept(); /// Pressing okay to confirm
    }


}
