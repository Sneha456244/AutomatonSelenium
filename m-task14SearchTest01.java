package task14;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class WikipediaTest {

    WebDriver driver;
    WikipediaPage wp;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");
        wp = new WikipediaPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // 1. Basic auto-suggest check
    @Test
    public void testAutoSuggestAppears() {
        wp.typeText("India");
        Assert.assertTrue(wp.getSuggestionCount() > 0, "Auto-suggest NOT appearing!");
    }

    // 2. Validate suggestions contain keyword
    @Test
    public void testSuggestionsContainKeyword() {
        wp.typeText("India");

        int count = wp.getSuggestionCount();
        Assert.assertTrue(count > 0, "No suggestions → Cannot validate!");

        boolean found = wp.getSuggestionElements()
                          .stream()
                          .anyMatch(e -> e.getText().toLowerCase().contains("india"));

        Assert.assertTrue(found, "Suggestions do NOT contain the keyword!");
    }

    // 3. Uppercase / lowercase test
    @Test
    public void testUppercaseSearch() {
        wp.typeText("INDIA");

        Assert.assertTrue(wp.getSuggestionCount() > 0,
                "Auto-suggest failed for capital letters!");
    }

    // 4. Minimum character search
    @Test
    public void testTwoLetterSuggest() {
        wp.typeText("in");

        Assert.assertTrue(wp.getSuggestionCount() > 0,
                "Two-letter auto-suggest NOT working!");
    }

    // 5. No suggestions for random text
    @Test
    public void testNoSuggestionsForRandomWords() {
        wp.typeText("zxqplmnxyz");

        Assert.assertTrue(wp.getSuggestionCount() == 0,
                "Unexpected suggestions for random text!");
    }

    // 6. Repeated search input
    @Test
    public void testRepeatedSearch() {
        wp.typeText("India");
        int first = wp.getSuggestionCount();

        wp.typeText("India");
        int second = wp.getSuggestionCount();

        Assert.assertEquals(first, second, "Repeated search gave different results!");
    }

    // 7. Click first suggestion
    @Test
    public void testClickSuggestion() {
        wp.typeText("India");

        Assert.assertTrue(wp.getSuggestionCount() > 0,
                "Cannot click → No suggestions available!");

        wp.clickFirstSuggestion();

        Assert.assertTrue(driver.getCurrentUrl().contains("wikipedia"),
                "Suggestion click did NOT redirect to article!");
    }
}
