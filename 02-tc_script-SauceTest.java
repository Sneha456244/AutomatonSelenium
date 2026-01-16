package tc_script02;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SauceTest {

    WebDriver driver;
    SaucePage page;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");

        page = new SaucePage(driver);
    }

    @Test
    public void TC_01_Verify_EndToEnd_Order_Flow() {

        page.login("standard_user", "secret_sauce");

        page.addProducts(2);

        page.openCart();

        page.clickCheckout();

        page.enterCheckoutDetails("Sneha", "QA", "600001");

        page.finishOrder();

        Assert.assertEquals(page.getSuccessMessage(),
                "Thank you for your order!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
