package task13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class FilterTestTN {

    WebDriver driver;
    FilterPageTN filterPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?path=27&route=product/category"); 
        filterPage = new FilterPageTN(driver);
    }

    @Test(priority = 1)
    public void testNameAToZ() {
        filterPage.selectSortOption("Name (A - Z)");
        List<String> names = filterPage.getProductNames();
        System.out.println("UI Names: " + names);
        Assert.assertTrue(filterPage.verifyAscendingNames(names), "Names not sorted A→Z");
    }

    @Test(priority = 2)
    public void testNameZToA() {
        filterPage.selectSortOption("Name (Z - A)");
        List<String> names = filterPage.getProductNames();
        System.out.println("UI Names: " + names);
        Assert.assertTrue(filterPage.verifyDescendingNames(names), "Names not sorted Z→A");
    }

    @Test(priority = 3)
    public void testPriceLowToHigh() {
        filterPage.selectSortOption("Price (Low > High)");
        List<Double> prices = filterPage.getProductPrices();
        System.out.println("UI Prices: " + prices);
        Assert.assertTrue(filterPage.verifyPriceLowToHigh(prices), "Prices not sorted Low→High");
    }

    @Test(priority = 4)
    public void testPriceHighToLow() {
        filterPage.selectSortOption("Price (High > Low)");
        List<Double> prices = filterPage.getProductPrices();
        System.out.println("UI Prices: " + prices);
        Assert.assertTrue(filterPage.verifyPriceHighToLow(prices), "Prices not sorted High→Low");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
