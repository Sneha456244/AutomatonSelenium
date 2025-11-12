package task11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;

public class TableSortTest01 {

    WebDriver driver;
    TableSortPage01 page;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://datatables.net/examples/basic_init/table_sorting.html");
        page = new TableSortPage01(driver);
    }

    @Test(priority = 1)
    public void verifyAscendingOrder() throws InterruptedException {
        page.clickNameHeader(); // Sort ascending
        Thread.sleep(2000);

        List<String> namesAsc = page.getNames();
        System.out.println("Ascending Order: " + namesAsc);

        Assert.assertTrue(page.isSortedAscending(namesAsc), "Table is not sorted in ascending order.");
    }

    @Test(priority = 2)
    public void verifyDescendingOrder() throws InterruptedException {
        page.clickNameHeader(); // Sort descending
        Thread.sleep(2000);

        List<String> namesDesc = page.getNames();
        System.out.println("Descending Order: " + namesDesc);

        Assert.assertTrue(page.isSortedDescending(namesDesc), "Table is not sorted in descending order.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
