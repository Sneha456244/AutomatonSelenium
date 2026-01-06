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
    
    @Test(priority = 7)
    public void TC_UI_07_ClickAdd() {
        System.out.println("Expected: Add should be clickable");
        page.clickAdd();
    }
    
    @Test(priority = 8)
    public void TC_UI_08_SetJobTitle() {
        System.out.println("Expected: set JobTitle ");
        page.setJobTitle();
    }
    
    @Test(priority = 9)
    public void TC_UI_09_ClickSave() {
        System.out.println("Expected: Save button should be clickable");
        page.clickSave();
    }
    
    @Test(priority = 10)
    public void TC_UI_10_ClickEditIcon() {
        System.out.println("Expected: Edit icon should be clickable and job title updated");
        page.clickEditIcon();
        page.UpdatedJobTitle();
        page.clickSave();
    }
    
    @Test(priority = 11)
    public void TC_UI_11_ClickLeaveMenu() {
        System.out.println("Expected: Leave menu should be clickable");
        page.clickLeave();
    }
    
    @Test(priority = 12)
    public void TC_UI_12_ClickApply() {
        System.out.println("Expected: Apply tag should be clickable");
        page.clickApply();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
