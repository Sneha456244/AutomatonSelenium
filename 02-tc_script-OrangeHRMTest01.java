package tc_script02;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeHRMTest01 {

    WebDriver driver;
    OrangeHRMPage01 page;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/");

        page = new OrangeHRMPage01(driver);
    }

    @Test(priority = 1)
    public void TC_UI_01_ValidLogin() {
        page.login("Admin", "admin123");
    }

    @Test(priority = 2)
    public void TC_UI_02_OpenTimeMenu() {
        page.searchAndClickTime("Time");
    }

    @Test(priority = 3)
    public void TC_UI_03_SelectEmployeeAndView() {
        page.selectEmployeeAndClickView("simple for tests muser 3456");
    }

    @Test(priority = 4)
    public void TC_UI_04_ClickPIM() {
        System.out.println("Expected: PIM menu should be clickable");
        page.clickPIM();
    }

    @Test(priority = 5)
    public void TC_UI_05_ClickAdd() {
        System.out.println("Expected: Add button should be clickable");
        page.clickAdd();
    }
    
    @Test(priority = 6)
    public void TC_UI_06_SetFirstName() {
        System.out.println("Expected: set First Name ");
        page.setFirstName();
    }
    
    @Test(priority = 7)
    public void TC_UI_07_SetMiddleName() {
        System.out.println("Expected: set Middle Name ");
        page.setMiddleName();
    }
    
    @Test(priority = 8)
    public void TC_UI_08_SetLastName() {
        System.out.println("Expected: set Last Name ");
        page.setLastName();
    }
    
    @Test(priority = 9)
    public void TC_UI_09_VerifyEmpID() {
        String empId = page.verifyEmpID();
        Assert.assertTrue(empId != null && !empId.isEmpty(),
                "Expected: Employee ID should be auto-generated");
        System.out.println("Employee ID: " + empId);
    }

    @Test(priority = 10)
    public void TC_UI_10_ClickSave() {
        System.out.println("Expected: Save button should be clickable");
        page.clickSave();
    }
    
    @Test(priority = 11)
    public void TC_UI_11_OpenRecruitment() {
        page.openRecruitment();
        String records = page.getRecordsFound();
        Assert.assertTrue(records.contains("Records Found"));
        System.out.println(records);
    }

    @Test(priority = 12)
    public void TC_UI_12_ViewFirstCandidate() {
        page.clickFirstEyeIcon();
        page.goBack();
    }

    @Test(priority = 13)
    public void TC_UI_13_DeleteSecondCandidate() {
        page.deleteSecondRecord();
    }
    
    @Test(priority = 14)
    public void TC_UI_14_ClickDirectory() {
        System.out.println("Expected: Directory menu should be clickable");
        page.clickDirectory();
    }
    
    @Test(priority = 15)
    public void TC_UI_15_ClickArrow() {
        System.out.println("Expected: Arrow button should be clickable");
        page.clickArrow();
    }
    
    @Test(priority = 16)
    public void TC_UI_16_GiveEmpName() {
        System.out.println("Expected: set Given Emp Name");
        page.giveEmpName();
    }
    
    @Test(priority = 17)
    public void TC_UI_17_ClickSearchBtn() {
        System.out.println("Expected: Search button should be clickable");
        page.clickSearchBtn();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
