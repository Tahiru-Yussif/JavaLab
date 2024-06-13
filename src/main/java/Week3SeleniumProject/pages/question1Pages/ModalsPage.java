package Week3SeleniumProject.pages.question1Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class ModalsPage {
    private final SelenideElement modalsButton = $(By.linkText("Modals"));
    private final SelenideElement simpleModal = $(byId("simpleModal"));
    private final SelenideElement modalContainer = $(byId("popmake-1318"));
    private final SelenideElement formModal = $(byId("formModal"));
    private final SelenideElement formName = $(byId("g1051-name"));
    private final SelenideElement formEmail = $(byId("g1051-email"));
    private final SelenideElement formMessage = $(byId("contact-form-comment-g1051-message"));
    private final SelenideElement submit = $(byCssSelector(".pushbutton-wide"));

    public void clickModalsButton() {
        modalsButton.click();
    }

    public void clickSimpleModalButton() {
        simpleModal.click();
        // Verify modal Container is displayed
        modalContainer.shouldBe(Condition.visible);
    }

    public void clickFormModalButton() {
        formModal.click();
        formName.val("Hamid");
        formEmail.val("deo@gmail.com");
        formMessage.sendKeys("Welcome Home");
        submit.click();
    }
}
