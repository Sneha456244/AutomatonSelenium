package task21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductCatalogTest01 {

    WebDriver driver;
    ProductCatalogPage01 catalogPage;

    @BeforeMethod
    public void setUp() {

        System.out.println("[ACTION] Opening application");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/");

        System.out.println("===== BEFORE METHOD =====");

        catalogPage = new ProductCatalogPage01(driver);
    }

    @Test
    public void validateProductCatalogFiltering() {

        System.out.println("----- TEST START -----");

        catalogPage.clickBooksCategory();

        Assert.assertEquals(
                catalogPage.getPageHeading(),
                "Books",
                "Page heading mismatch"
        );

        Assert.assertTrue(
                catalogPage.getBreadcrumbText().contains("BOOKS"),
                "Breadcrumb validation failed"
        );

        Assert.assertTrue(
                catalogPage.getProductCount() > 0,
                "No products displayed"
        );

        catalogPage.printAllProductNames();

        Assert.assertTrue(
                catalogPage.areAllImagesDisplayed(),
                "Some product images are missing"
        );

        catalogPage.sortByPriceLowToHigh();

        Assert.assertTrue(
                catalogPage.arePricesSortedLowToHigh(),
                "Price sorting failed"
        );

        System.out.println("----- TEST PASSED -----");
    }

    @AfterMethod
    public void tearDown() {

        System.out.println("===== TEARDOWN =====");

        if (driver != null) {
            driver.quit();
        }
    }
}
