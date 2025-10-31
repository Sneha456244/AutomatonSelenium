package Task03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class ScrollBarsTest {

    WebDriver driver;
    ScrollBarsPage scrollPage;

    @BeforeClass
    public void setup() 
    {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://showcase.primefaces.org/ui/data/datatable/scroll.xhtml");
        driver.manage().window().maximize();

        scrollPage = new ScrollBarsPage(driver);
    }

    @Test
    public void scrollPageByPixelsTest() throws InterruptedException 
    {
        scrollPage.scrollPageByPixel(500);
        Thread.sleep(1500);
    }

    @Test
    public void scrollTableVerticalTest() throws InterruptedException 
    {
        scrollPage.scrollTableToBottom();
        Thread.sleep(1500);
        scrollPage.scrollTableToTop();
        Thread.sleep(1500);
    }

    @Test
    public void scrollTableHorizontalTest() throws InterruptedException 
    {
        scrollPage.scrollTableHorizontallyRight();
        Thread.sleep(1500);
        scrollPage.scrollTableHorizontallyLeft();
        Thread.sleep(1500);
    }

    @Test
    public void scrollFullPageTest() throws InterruptedException 
    {
        scrollPage.scrollPageToBottom();
        Thread.sleep(1500);
        scrollPage.scrollPageToTop();
        Thread.sleep(1500);
    }

    @AfterClass
    public void tearDown() 
    {
        driver.quit();
    }
}

