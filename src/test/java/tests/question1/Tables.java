package tests.question1;

import Week3SeleniumProject.pages.question1Pages.TablesPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class Tables extends BaseTest {
    private TablesPage tables;
    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        // Visit the webpage
        open(baseURL);

        // Instantiate the Tables page
        tables = new TablesPage();

        // Click on the tables button
        tables.clickTablesButton();
    }

    @Test(description = "Testing Tables")
    public void testTables() {
        // Verify URL
        URLVerification.verifyURL(tablesURL);

        // Check if the item is displayed in the table
        boolean itemFound = tables.verifySearchedItem("Laptop", 1);
        Assert.assertTrue(itemFound, "Item should be found in the table.");
    }

    @Test(description = "Testing Search Item in Table")
    public void testSearchItemInTable() {
        // Perform search
        tables.searchItemInTable("Nigeria");

        // Check if the item is displayed in the table
        boolean itemFound = tables.verifySearchedItem("Nigeria", 2);
        Assert.assertTrue(itemFound, "Item should be found in the table.");
    }

    @Test(description = "Testing Navigation and Search Item in Table")
    public void testNavigateAndSearchItem() {
        // Perform navigation
        tables.clickNextButton();

        // Perform search
        tables.searchItemInTable("Nigeria");

        // Check if the item is displayed in the table
        boolean itemFound = tables.verifySearchedItem("Nigeria", 2);
        Assert.assertTrue(itemFound, "Item should be found in the table.");
    }
    @AfterMethod
    @Override
    public void tearDown() {
        super.tearDown();
        closeWebDriver();
    }
}
