package task16;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AccordionTest {

    WebDriver driver;
    AccordionPage accordion;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/accordian");

        accordion = new AccordionPage(driver);
    }

    @Test(priority = 1)
    public void verifySection1Expand() {
        accordion.clickSection1();
        Assert.assertTrue(accordion.isSection1Expanded(),
                "Section 1 should expand but did not.");
    }

    @Test(priority = 2)
    public void verifyAutoCollapse() {
        accordion.clickSection1();
        Assert.assertTrue(accordion.isSection1Expanded(),
                "Section 1 should be expanded first.");

        accordion.clickSection2();
        accordion.waitUntilSection1Collapsed();

        Assert.assertFalse(accordion.isSection1Expanded(),
                "Section 1 should collapse when Section 2 expands.");

        Assert.assertTrue(accordion.isSection2Expanded(),
                "Section 2 should expand.");
    }

    @Test(priority = 3)
    public void verifySectionDoesNotCollapseOnSecondClick() {
        accordion.clickSection2();
        boolean first = accordion.isSection2Expanded();

        accordion.clickSection2();  // second click
        boolean second = accordion.isSection2Expanded();

        Assert.assertTrue(first && second,
                "Section 2 should stay open on a second click.");
    }

    @Test(priority = 4)
    public void verifySection3ContentLoads() {
        accordion.clickSection3();
        Assert.assertTrue(accordion.isSection3Expanded(),
                "Section 3 should show content.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
