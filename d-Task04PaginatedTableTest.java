package task04;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;

public class PaginatedTableTest {

    WebDriver driver;
    PaginatedTablePage tablePage;

    @BeforeClass
    public void setup() 
    {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.primefaces.org/showcase/ui/data/datatable/paginator.xhtml");
        tablePage = new PaginatedTablePage(driver);
    }

    @Test
    public void testSearchBMW() {
        System.out.println("Test 1: Search for BMW ");
        tablePage.searchAndLog("BMW");
    }

    @Test
    public void testSearchAudi() {
        System.out.println("Test 2: Search for Audi");
        tablePage.searchAndLog("Audi");
    }

    @Test
    public void testSearchMercedes() {
        System.out.println("Test 3: Search for Mercedes");
        tablePage.searchAndLog("Mercedes");
    }

    @Test
    public void testSearchToyota() {
        System.out.println("Test 4: Search for Toyota");
        tablePage.searchAndLog("Toyota");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
