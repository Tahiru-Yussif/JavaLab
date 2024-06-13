package tests.question1;

import Week3SeleniumProject.pages.question1Pages.TablesPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Epic("Tables Feature")
@Feature("Tables Interaction Tests")
public class Tables extends BaseTest {
    private TablesPage tables;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        Allure.step("Navigating to base URL");
        open(baseURL);
        Allure.step("Webpage visited successfully");

        tables = new TablesPage();
        Allure.step("Clicking the tables button");
        tables.clickTablesButton();
    }

    @Test(priority = 1, description = "Testing Tables")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Verify URL and check if item is displayed in the table")
    public void testTables() {
        Allure.step("Verifying URL for the tables page");
        URLVerification.verifyURL(tablesURL);
        Allure.step("URL verified successfully");

        Allure.step("Checking if the item is displayed in the table");
        boolean itemFound = tables.verifySearchedItem("Laptop", 1);
        Assert.assertTrue(itemFound, "Item should be found in the table.");
        Allure.step("Item 'Laptop' found in the table");
    }

    @Test(priority = 2, description = "Testing Search Item in Table")
    @Severity(SeverityLevel.NORMAL)
    @Story("Perform search and verify item in the table")
    public void testSearchItemInTable() {
        Allure.step("Performing search for 'Nigeria' in the table");
        tables.searchItemInTable("Nigeria");

        Allure.step("Checking if the item 'Nigeria' is displayed in the table");
        boolean itemFound = tables.verifySearchedItem("Nigeria", 2);
        Assert.assertTrue(itemFound, "Item should be found in the table.");
        Allure.step("Item 'Nigeria' found in the table");
    }

    @Test(priority = 3, description = "Testing Navigation and Search Item in Table")
    @Severity(SeverityLevel.NORMAL)
    @Story("Navigate and perform search to verify item in the table")
    public void testNavigateAndSearchItem() {
        Allure.step("Clicking next button to navigate");
        tables.clickNextButton();

        Allure.step("Performing search for 'Nigeria' in the table");
        tables.searchItemInTable("Nigeria");

        Allure.step("Checking if the item 'Nigeria' is displayed in the table");
        boolean itemFound = tables.verifySearchedItem("Nigeria", 2);
        Assert.assertTrue(itemFound, "Item should be found in the table.");
        Allure.step("Item 'Nigeria' found in the table");
    }

    @AfterMethod
    @Override
    public void tearDown() {
        super.tearDown();
        closeWebDriver();
        Allure.step("Closed the web driver");
    }
}
