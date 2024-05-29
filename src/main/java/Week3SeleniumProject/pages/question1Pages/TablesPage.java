package Week3SeleniumProject.pages.question1Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Week3SeleniumProject.util.AppConfig.clickElement;

public class TablesPage {
    private final WebDriver driver;
    private final By tablesButton = By.linkText("Tables");
    private final By buttonNext = By.id("tablepress-1_next");
    private final By searchInputButton = By.cssSelector("input[type='search']:first-of-type");

    public TablesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTablesButton() {
        clickElement(driver, tablesButton);
    }

    public boolean verifySearchedItem(String item, int tableIndex) {
        // Locate the table element
        WebElement table = driver.findElement(By.xpath("(//table)[" + tableIndex + "]"));

        // Search for the item within the table rows
        for (WebElement row : table.findElements(By.tagName("tr"))) {
            // Check each cell in the row for the item
            for (WebElement cell : row.findElements(By.tagName("td"))) {
                if (cell.getText().equals(item)) {
                    // Item found
                    return true;
                }
            }
        }
        // Item not found
        return false;
    }

    public void searchItemInTable() {
        WebElement searchInput = driver.findElement(searchInputButton);
        searchInput.sendKeys("Nigeria");
    }

    public void nextButton() {
        WebElement nextBtn = driver.findElement(buttonNext);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextBtn);
    }
}

