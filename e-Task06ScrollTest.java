package task05;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TC002_ScrollTest {

    WebDriver driver;
    ScrollPage sp;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://showcase.primefaces.org/ui/data/datatable/scroll.xhtml");
        sp = new ScrollPage(driver);
    }

    @Test
    public void testVerticalScroll() throws InterruptedException {
        sp.scrollVertically(500);
        sp.scrollVertically(1000);
    }

    @Test
    public void testHorizontalScroll() throws InterruptedException {
    	sp.scrollHorizontally(300);
    	sp.scrollHorizontally(600);
    }

    @Test
    public void testScrollTillRowAndColumnVisible() throws InterruptedException {
    	sp.scrollTillRowVisible();
    	sp.scrollTillLastColumnVisible();
    }

    @Test
    public void testScrollBackToStart() throws InterruptedException {
    	sp.scrollBackToStart();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
