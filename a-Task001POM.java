package Task001Realtime;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FlipkartTest {

    WebDriver driver;
    FlipkartPage flipkart;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        flipkart = new FlipkartPage(driver);
        System.out.println("Flipkart Automation Test Started");
    }

    @Test(priority = 1)
    void testFlipkartFlow() throws Exception {
        flipkart.closeLoginPopup();
        flipkart.searchProduct("iPhone 15");
        flipkart.selectFirstProductAndAddToCart();
        flipkart.verifyProductInCart();
        flipkart.logout();
        Assert.assertTrue(true, "Flipkart Test Completed Successfully");
    }

    @AfterClass
    void tearDown() {
        driver.quit();
        System.out.println("Flipkart Automation Test Completed");
    }
}
