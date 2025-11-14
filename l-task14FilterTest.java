package task13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class FilterTest {

    WebDriver driver;
    FilterPage fp;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        fp = new FilterPage(driver);
        fp.login("standard_user", "secret_sauce");
    }

    @Test(priority = 1)
    public void verifyNameSortingAToZ() {
        System.out.println("\nTEST 1: NAME (A to Z)");

        fp.selectFilter("Name (A to Z)");
        List<String> names = fp.getProductNames();

        System.out.println("UI Product Names: " + names);

        boolean result = fp.isSortedAscending(names);
        System.out.println("Sorting Result: " + (result ? "PASS" : "FAIL"));

        Assert.assertTrue(result, "Products NOT sorted A to Z");
    }

    @Test(priority = 2)
    public void verifyNameSortingZToA() {
        System.out.println("\nTEST 2: NAME (Z to A) ");

        fp.selectFilter("Name (Z to A)");
        List<String> names = fp.getProductNames();

        System.out.println("UI Product Names: " + names);

        boolean result = fp.isSortedDescending(names);
        System.out.println("Sorting Result: " + (result ? "PASS" : "FAIL"));

        Assert.assertTrue(result, "Products NOT sorted Z to A");
    }

    @Test(priority = 3)
    public void verifyPriceSortingLowToHigh() {
        System.out.println("\nTEST 3: PRICE (Low to High) ");

        fp.selectFilter("Price (low to high)");
        List<Double> prices = fp.getProductPrices();

        System.out.println("UI Product Prices: " + prices);

        boolean result = fp.isPricesLowToHigh(prices);
        System.out.println("Sorting Result: " + (result ? "PASS" : "FAIL"));

        Assert.assertTrue(result, "Prices NOT sorted Low to High");
    }

    @Test(priority = 4)
    public void verifyPriceSortingHighToLow() {
        System.out.println("\n TEST 4: PRICE (High to Low) ");

        fp.selectFilter("Price (high to low)");
        List<Double> prices = fp.getProductPrices();

        System.out.println("UI Product Prices: " + prices);

        boolean result = fp.isPricesHighToLow(prices);
        System.out.println("Sorting Result: " + (result ? "PASS" : "FAIL"));

        Assert.assertTrue(result, "Prices NOT sorted High to Low");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
