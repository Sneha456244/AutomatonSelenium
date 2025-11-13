package task12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest {
    WebDriver driver;
    SearchPage searchPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        searchPage = new SearchPage(driver);
    }

    @Test(priority = 1)
    public void verifyValidProductSearch() {
        searchPage.enterSearchKeyword("iPhone");
        searchPage.clickSearchButton();
        Assert.assertTrue(searchPage.isResultDisplayed());
        System.out.println("Product not found in search results");
    }

    @Test(priority = 2)
    public void verifyInvalidProductSearch() {
        searchPage.enterSearchKeyword("XYZProduct123");
        searchPage.clickSearchButton();
        Assert.assertTrue(searchPage.isNoResultDisplayed());
        System.out.println("No result message not displayed");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
