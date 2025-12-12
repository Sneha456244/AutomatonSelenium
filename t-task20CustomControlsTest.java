package task20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CustomControlsTest {

    WebDriver driver;
    CustomControlsPage page;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        page = new CustomControlsPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    // TESTS

    @Test(priority = 1)
    public void verifyDefaultState() {
        Assert.assertFalse(page.isMaleSelected(), "Male should NOT be selected by default!");
        Assert.assertFalse(page.isFemaleSelected(), "Female should NOT be selected by default!");
        Assert.assertFalse(page.isOtherSelected(), "Other should NOT be selected by default!");
    }

    @Test(priority = 2)
    public void verifyLabelsText() {
        Assert.assertEquals(page.getMaleLabel(), "Male");
        Assert.assertEquals(page.getFemaleLabel(), "Female");
        Assert.assertEquals(page.getOtherLabel(), "Other");
    }

    @Test(priority = 3)
    public void verifyMaleRadioButton() {
        page.selectMale();
        Assert.assertTrue(page.isMaleSelected(), "Male radio is not selected!");
        // Additional validation: Only one selected
        Assert.assertFalse(page.isFemaleSelected(), "Female should NOT be selected!");
        Assert.assertFalse(page.isOtherSelected(), "Other should NOT be selected!");
    }

    @Test(priority = 4)
    public void verifyFemaleRadioButton() {
        page.selectFemale();
        Assert.assertTrue(page.isFemaleSelected(), "Female radio is not selected!");
        Assert.assertFalse(page.isMaleSelected(), "Male should NOT be selected!");
        Assert.assertFalse(page.isOtherSelected(), "Other should NOT be selected!");
    }

    @Test(priority = 5)
    public void verifyOtherRadioButton() {
        page.selectOther();
        Assert.assertTrue(page.isOtherSelected(), "Other radio is not selected!");
        Assert.assertFalse(page.isMaleSelected(), "Male should NOT be selected!");
        Assert.assertFalse(page.isFemaleSelected(), "Female should NOT be selected!");
    }

    @Test(priority = 6)
    public void verifyRadioButtonsAreEnabled() {
        Assert.assertTrue(page.isMaleEnabled(), "Male radio is disabled!");
        Assert.assertTrue(page.isFemaleEnabled(), "Female radio is disabled!");
        Assert.assertTrue(page.isOtherEnabled(), "Other radio is disabled!");
    }

}
