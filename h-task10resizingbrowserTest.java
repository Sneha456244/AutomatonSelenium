package task09;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class resizingbrowserTest {
    WebDriver driver;
    resizingbrowserPage practicePage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        practicePage = new resizingbrowserPage(driver);
    }

    @Test(priority = 1)
    public void verifyResponsiveness() throws InterruptedException {
        practicePage.openSite();
        practicePage.checkResponsiveness();
        System.out.println("Responsiveness test completed successfully.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

