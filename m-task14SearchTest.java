package task14;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class FlipkartTest {

    WebDriver driver;
    FlipkartPage fp;

    @BeforeMethod
    public void setup() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        fp = new FlipkartPage(driver);
        Thread.sleep(2000);
        fp.closeLoginPopupIfPresent();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    //  Test Cases 

    @Test
    public void testAutoSuggestSearch() {
        fp.typeSearch("iphone");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));

        wait.until(driver ->
                fp.autoSuggestions.size() > 0
        );

        Assert.assertTrue(fp.getSuggestionCount() > 0,
                "Auto-suggestions are not displayed");
    }


    @Test
    public void testMultipleSearches() throws Exception {
        fp.typeSearch("laptop");
        fp.clickSearchButton();
        Thread.sleep(2000);

        fp.typeSearch("watch");
        fp.clickSearchButton();
        Thread.sleep(2000);

        Assert.assertTrue(driver.getTitle().toLowerCase().contains("watch"));
    }

    @Test
    public void testClearAndSearchAnotherProduct() throws Exception {
        fp.typeSearch("camera");
        fp.clickSearchButton();
        Thread.sleep(2000);

        fp.typeSearch("shoes");
        fp.clickSearchButton();
        Thread.sleep(2000);

        Assert.assertTrue(driver.getTitle().toLowerCase().contains("shoes"));
    }

    @Test
    public void testSearchBoxDisplayed() {
        Assert.assertTrue(fp.searchBox.isDisplayed());
    }

    @Test
    public void testTypingInput() {
        fp.typeSearch("camera");
        Assert.assertEquals(fp.searchBox.getAttribute("value"), "camera");
    }

    @Test
    public void testNoSuggestionsForRandomText() throws Exception {
        fp.typeSearch("%%%%%%%@@@@@@");
        Thread.sleep(2000);
        Assert.assertTrue(fp.getSuggestionCount() == 0 || fp.getSuggestionCount() < 2);
    }

    @Test
    public void testRepeatedSearch() throws Exception {
        fp.typeSearch("shoes");
        fp.clickSearchButton();
        Thread.sleep(2000);
        String firstTitle = driver.getTitle().toLowerCase();

        fp.typeSearch("shoes");
        fp.clickSearchButton();
        Thread.sleep(2000);
        String secondTitle = driver.getTitle().toLowerCase();

        Assert.assertTrue(firstTitle.contains("shoes"));
        Assert.assertTrue(secondTitle.contains("shoes"));
    }

    @Test
    public void testUppercaseSearch() throws Exception {
        fp.typeSearch("LAPTOP");
        fp.clickSearchButton();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("laptop"));
    }

    @Test
    public void testSpecialCharacterSearch() throws Exception {
        fp.typeSearch("@#$%^&*");
        fp.clickSearchButton();
        Thread.sleep(2000);

        String result = fp.getResultHeader().toLowerCase();

        Assert.assertTrue(
            result.contains("no results") ||
            result.contains("did not match") ||
            driver.getTitle().contains("Flipkart")
        );
    }
}
