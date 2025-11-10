package task09;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ResponsivenessTest {

    WebDriver driver;
    ResponsivenessPage responsivePage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        responsivePage = new ResponsivenessPage(driver);
    }

    @Test(priority = 1)
    public void verifyResponsiveLayout() throws InterruptedException {
        responsivePage.openWebsite();
        responsivePage.resizeToTablet();
        responsivePage.resizeToMobile();
        responsivePage.resizeToFullScreen();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("Browser closed successfully.");
    }
}

