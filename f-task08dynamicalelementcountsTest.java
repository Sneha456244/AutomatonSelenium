package task07;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SwagLabsTest {

    WebDriver driver;
    SwagLabsPage page;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        page = new SwagLabsPage(driver);
    }

    @Test
    public void testAddThreeProductsAndVerifyCartCount() 
    {
        page.navigateToHome();

        // Login steps 
        page.setUsername("standard_user");
        page.setPassword("secret_sauce");
        page.clickLoginButton();

        int beforeAdd = page.getCartCount();
        System.out.println("Cart count before adding: " + beforeAdd);

        page.clickProductAddToCart(0);
        System.out.println("Cart count after 1st product: " + page.getCartCount());

        page.clickProductAddToCart(1);
        System.out.println("Cart count after 2nd product: " + page.getCartCount());

        page.clickProductAddToCart(2);
        System.out.println("Cart count after 3rd product: " + page.getCartCount());

        int totalCount = page.getCartCount();
        System.out.println("Total products in cart at end: " + totalCount);

        Assert.assertEquals(totalCount, 3, "Cart count mismatch!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
