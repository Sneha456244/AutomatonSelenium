package task11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;

public class TableSortTest {

    WebDriver driver;
    TableSortPage tablePage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        tablePage = new TableSortPage(driver);
    }

    @Test(priority = 1)
    public void verifyCompanyColumnSortedAscending() {
        List<String> companies = tablePage.getAllCompanies();

        tablePage.printList("Original Order of Companies:", companies);

        boolean sortedAsc = tablePage.isSortedAscending(companies);
        System.out.println("\nAscending Sort Check Result: " + sortedAsc);

        List<String> sortedCopy = new java.util.ArrayList<>(companies);
        java.util.Collections.sort(sortedCopy);
        tablePage.printList("Expected Ascending Order:", sortedCopy);

        Assert.assertTrue(sortedAsc, "Company names are not sorted ascending");
    }

    @Test(priority = 2)
    public void verifyCompanyColumnSortedDescending() {
        List<String> companies = tablePage.getAllCompanies();

        tablePage.printList("Original Order of Companies:", companies);

        boolean sortedDesc = tablePage.isSortedDescending(companies);
        System.out.println("\nDescending Sort Check Result: " + sortedDesc);

        List<String> sortedCopy = new java.util.ArrayList<>(companies);
        java.util.Collections.sort(sortedCopy, java.util.Collections.reverseOrder());
        tablePage.printList("Expected Descending Order:", sortedCopy);

        Assert.assertFalse(sortedDesc, "Company names are unexpectedly sorted in descending order!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
