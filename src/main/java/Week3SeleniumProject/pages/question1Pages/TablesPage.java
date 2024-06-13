package Week3SeleniumProject.pages.question1Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TablesPage {
    private final SelenideElement tablesButton = $(By.linkText("Tables"));
    private final SelenideElement buttonNext = $(byId("tablepress-1_next"));
    private final SelenideElement searchInputButton = $(By.cssSelector("input[type='search']:nth-of-type(1)"));

    public void clickTablesButton() {
        tablesButton.click();
    }

    public boolean verifySearchedItem(String item, int tableIndex) {
        // Locate the table element
        SelenideElement table = $$(byXpath("(//table)[" + tableIndex + "]")).first();

        // Search for the item within the table rows
        ElementsCollection rows = table.$$(byTagName("tr"));
        for (SelenideElement row : rows) {
            // Check each cell in the row for the item
            ElementsCollection cells = row.$$(byTagName("td"));
            for (SelenideElement cell : cells) {
                if (cell.getText().equals(item)) {
                    // Item found
                    return true;
                }
            }
        }
        // Item not found
        return false;
    }

    public void searchItemInTable(String query) {
        searchInputButton.shouldBe(visible).shouldBe(enabled).val(query).pressEnter();
    }

    public void clickNextButton() {
        buttonNext.click();
    }
}

