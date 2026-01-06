package tc_script02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeHRMTest {

    WebDriver driver;
    OrangeHRMPage page;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        page = new OrangeHRMPage(driver);
    }
    
    //Testcase
    
    @Test(priority = 1)
    public void TC_UI_01_VerifyURL() {
        System.out.println("Expected: OrangeHRM application must display");
        Assert.assertTrue(driver.getCurrentUrl().contains("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    }

    @Test (priority = 2)
    public void TC_UI_02_VerifyLogo() {
        System.out.println("Expected: OrangeHRM logo must be displayed");
        Assert.assertTrue(
                page.isOrangeHRMDisplayed(),
                "❌ OrangeHRM logo is NOT displayed"
        );
    }
    
    @Test(priority = 3)
    public void TC_UI_03_ValidLogin() {
        System.out.println("Expected: User should login successfully");
        page.login("Admin", "admin123");
    }
    
    @Test(priority = 4)
    public void TC_UI_04_ClickAdminMenu() {
        System.out.println("Expected: Admin menu should be clickable");
        page.clickAdmin();
    }
    
    @Test(priority = 5)
    public void TC_UI_05_ClickJobDropdown() {
        System.out.println("Expected: Job dropdown should be clickable");
        page.clickJob();
    }
    
    @Test(priority = 6)
    public void TC_UI_06_ClickJobTitle() {
        System.out.println("Expected: JobTitle should be clickable");
        page.clickJobTitle();
    }
    
    

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
