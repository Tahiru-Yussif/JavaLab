package tests.question1;

import Week3SeleniumProject.pages.question1Pages.TablesPage;
import Week3SeleniumProject.util.URLVerification;
import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tables extends BaseTest {

    @Test(description = "Testing Tables")
    public void testTables() {
        // visit the webpage
        driver.get(baseURL);

        // instantiate the Tables page
        TablesPage tables = new TablesPage(driver);

        // Perform tables
        tables.clickTablesButton();

        // Check if the item is displayed in the table
        boolean itemFound = tables.verifySearchedItem("Laptop", 1);

        // Assert that the item is found in the table
        Assert.assertTrue(itemFound, "Item should be found in the table.");

        // Verify URL
        URLVerification.verifyURL(driver, tablesURL);
    }

    @Test
    public void testSearchItemInTable() {
        // Calling the testTables method
        testTables();

        // instantiate the Tables page
        TablesPage tables = new TablesPage(driver);

        // Perform search
        tables.searchItemInTable();

        // Check if the item is displayed in the table
        boolean itemFound = tables.verifySearchedItem("Nigeria", 2);

        // Assert that the item is found in the table
        Assert.assertTrue(itemFound, "Item should be found in the table.");

    }

    @Test
    public void testNavigateAndSearchItem() {

        // calling the testTables method
        testTables();

        // instantiate the Tables page
        TablesPage tables = new TablesPage(driver);

        // perform navigation
        tables.nextButton();

        // perform search
        testSearchItemInTable();
    }
}
