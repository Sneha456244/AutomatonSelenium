package task10;

import org.openqa.selenium.*;
import org.testng.annotations.*;

public class WikiSearchTest {

    WebDriver driver;
    WikiSearchPage page;

    @BeforeClass
    public void setup() throws InterruptedException {
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");
        Thread.sleep(2000);
        page = new WikiSearchPage(driver);
    }

    @Test
    public void testDropdownAndSearch() throws InterruptedException {
        page.showAllLanguages();
        page.selectLanguage("English");
        Thread.sleep(2000);
        page.search("Selenium (software)");
        Thread.sleep(3000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
