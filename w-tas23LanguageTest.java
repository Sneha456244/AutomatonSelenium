package task21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LanguageTest {

    WebDriver driver;
    LanguagePage languagePage;

    @BeforeClass
    public void setup() {
        System.out.println("TEST SUITE STARTED");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        languagePage = new LanguagePage(driver);

        System.out.println("Browser launched and setup completed");
    }

    @Test(priority = 1)
    public void validateEnglishLanguageUI() {

        System.out.println("TEST STARTED: Validate English Language UI");

        languagePage.openWikipedia();
        System.out.println("Opened Wikipedia homepage");

        languagePage.clickEnglish();
        System.out.println("Clicked on English language");

        System.out.println("Current URL: " + languagePage.getCurrentUrl());
        Assert.assertTrue(
                languagePage.getCurrentUrl().contains("en.wikipedia.org"),
                "English URL not loaded"
        );

        System.out.println("HTML lang attribute: " + languagePage.getHtmlLang());
        Assert.assertEquals(
                languagePage.getHtmlLang(),
                "en",
                "HTML lang mismatch for English"
        );

        System.out.println("Page Title: " + languagePage.getPageTitle());
        Assert.assertTrue(
                languagePage.getPageTitle().contains("Wikipedia"),
                "English page title incorrect"
        );

        Assert.assertTrue(
                languagePage.isBodyLoaded(),
                "English page body not loaded"
        );
        System.out.println("English page body loaded successfully");

        System.out.println("TEST PASSED: English Language UI");
    }

    @Test(priority = 2)
    public void validateSpanishLanguageUI() {

        System.out.println("TEST STARTED: Validate Spanish Language UI");

        languagePage.openWikipedia();
        System.out.println("Opened Wikipedia homepage");

        languagePage.clickSpanish();
        System.out.println("Clicked on Spanish language");

        System.out.println("Current URL: " + languagePage.getCurrentUrl());
        Assert.assertTrue(
                languagePage.getCurrentUrl().contains("es.wikipedia.org"),
                "Spanish URL not loaded"
        );

        System.out.println("HTML lang attribute: " + languagePage.getHtmlLang());
        Assert.assertEquals(
                languagePage.getHtmlLang(),
                "es",
                "HTML lang mismatch for Spanish"
        );

        System.out.println("Page Title: " + languagePage.getPageTitle());
        Assert.assertTrue(
                languagePage.getPageTitle().contains("Wikipedia"),
                "Spanish page title incorrect"
        );

        Assert.assertTrue(
                languagePage.isBodyLoaded(),
                "Spanish page body not loaded"
        );
        System.out.println("Spanish page body loaded successfully");

        System.out.println("TEST PASSED: Spanish Language UI");
    }

    @Test(priority = 3)
    public void validateGermanLanguageUI() {

        System.out.println("TEST STARTED: Validate German Language UI");

        languagePage.openWikipedia();
        System.out.println("Opened Wikipedia homepage");

        languagePage.clickGerman();
        System.out.println("Clicked on German language");

        System.out.println("Current URL: " + languagePage.getCurrentUrl());
        Assert.assertTrue(
                languagePage.getCurrentUrl().contains("de.wikipedia.org"),
                "German URL not loaded"
        );

        System.out.println("HTML lang attribute: " + languagePage.getHtmlLang());
        Assert.assertEquals(
                languagePage.getHtmlLang(),
                "de",
                "HTML lang mismatch for German"
        );

        System.out.println("Page Title: " + languagePage.getPageTitle());
        Assert.assertTrue(
                languagePage.getPageTitle().contains("Wikipedia"),
                "German page title incorrect"
        );

        Assert.assertTrue(
                languagePage.isBodyLoaded(),
                "German page body not loaded"
        );
        System.out.println("German page body loaded successfully");

        System.out.println("TEST PASSED: German Language UI");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Closing browser");
        driver.quit();
        System.out.println("TEST SUITE COMPLETED");
    }
}
