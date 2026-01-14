package tc_script02;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddEmployeeTest {

    WebDriver driver;
    OrangeHRMLoginPage loginPage;
    OrangeHRMPIMPage pimPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/");

        loginPage = new OrangeHRMLoginPage(driver);
        pimPage = new OrangeHRMPIMPage(driver);
    }

    @Test
    public void TC_AddEmployee_VerifyEmpID() {

        // Step 1: Login
        loginPage.login("Admin", "admin123");

        // Step 2: Open PIM
        pimPage.openPIM();

        // Step 3: Click Add
        pimPage.clickAdd();

        // Step 4: Enter employee details
        pimPage.enterEmployeeDetails("Sneha", "QA");

        // Step 5: Verify Employee ID
        String empId = pimPage.getEmployeeId();
        Assert.assertNotNull(empId);
        Assert.assertFalse(empId.isEmpty());
        System.out.println("Generated Employee ID: " + empId);

        // Step 6: Save
        pimPage.saveEmployee();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
