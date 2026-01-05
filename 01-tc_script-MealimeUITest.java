package tc_script01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class MealimeUITest {

    WebDriver driver;
    MealimeUIPage page;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        page = new MealimeUIPage(driver);

        // Open application
        page.openApplication();
    }

    // Test Case
    @Test(priority = 1)
    public void TC_UI_01_VerifyURL() {
        System.out.println("Expected: Mealime application must display");
        Assert.assertTrue(driver.getCurrentUrl().contains("my.mealime.com"));
    }

    @Test(priority = 2)
    public void TC_UI_02_VerifyLogo() {
        System.out.println("Expected: Mealime logo must be displayed");
        Assert.assertTrue(page.isGetStartedDisplayed());
    }

    @Test(priority = 3)
    public void TC_UI_03_VerifyTabsOnLandingPage() {
        System.out.println("Expected: Get Started, Sign In, Already have account tabs must display");
        Assert.assertTrue(page.isGetStartedDisplayed());
        Assert.assertTrue(page.isSignInDisplayed());
        Assert.assertTrue(page.isAlreadyAccountDisplayed());
    }

    @Test(priority = 4)
    public void TC_UI_04_VerifyGetStartedTabClickable() {
        System.out.println("Expected: Get Started tab must be displayed and clickable");
        Assert.assertTrue(page.isGetStartedDisplayed());
        page.clickGetStarted(); // Navigate to Diet page
    }

    @Test(priority = 5)
    public void TC_UI_05_VerifySignInTabClickable() {
        System.out.println("Expected: Sign In tab must be displayed and clickable");
        Assert.assertTrue(page.isSignInDisplayed());
    }

    @Test(priority = 6)
    public void TC_UI_06_VerifyAlreadyAccountTabClickable() {
        System.out.println("Expected: Already have an account tab must be displayed and clickable");
        Assert.assertTrue(page.isAlreadyAccountDisplayed());
    }

    // ===== Diet Page Tests =====
    @Test(priority = 7)
    public void TC_UI_07_VerifyDietPageDisplayed() {
        System.out.println("Expected: User should navigate to Diet page");
        Assert.assertTrue(page.isDietPageDisplayed());
    }

    @Test(priority = 8)
    public void TC_UI_08_VerifyClassicTab() {
        System.out.println("Expected: Classic tab must be displayed");
        Assert.assertTrue(page.isClassicDisplayed());
    }

    @Test(priority = 9)
    public void TC_UI_09_VerifyLowCarbTab() {
        System.out.println("Expected: Low Carb tab must be displayed");
        Assert.assertTrue(page.isLowCarbDisplayed());
    }

    @Test(priority = 10)
    public void TC_UI_10_VerifyKetoTab() {
        System.out.println("Expected: Keto tab must be displayed");
        Assert.assertTrue(page.isKetoDisplayed());
    }

    @Test(priority = 11)
    public void TC_UI_11_VerifyFlexitarianTab() {
        System.out.println("Expected: Flexitarian tab must be displayed");
        Assert.assertTrue(page.isFlexitarianDisplayed());
    }

    @Test(priority = 12)
    public void TC_UI_12_VerifyPaleoTab() {
        System.out.println("Expected: Paleo tab must be displayed");
        Assert.assertTrue(page.isPaleoDisplayed());
    }

    @Test(priority = 13)
    public void TC_UI_13_VerifyVegetarianTab() {
        System.out.println("Expected: Vegetarian tab must be displayed");
        Assert.assertTrue(page.isVegetarianDisplayed());
    }

    @Test(priority = 14)
    public void TC_UI_14_VerifyPescetarianTab() {
        System.out.println("Expected: Pescetarian tab must be displayed");
        Assert.assertTrue(page.isPescetarianDisplayed());
    }

    @Test(priority = 15)
    public void TC_UI_15_VerifyVeganTab() {
        System.out.println("Expected: Vegan tab must be displayed");
        Assert.assertTrue(page.isVeganDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
