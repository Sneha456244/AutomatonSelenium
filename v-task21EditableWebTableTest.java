package task21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class EditableWebTableTest {

    WebDriver driver;
    EditableWebTablePage page;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");

        page = new EditableWebTablePage(driver);
        System.out.println("Browser Setup Completed");
    }

    @Test(priority = 1)
    public void verifyEditIconOpensForm() {
        System.out.println("TEST STARTED: Verify Edit Icon");

        page.clickEditUsingJS();
        page.waitForForm();

        System.out.println("Edit form opened successfully");
        Assert.assertTrue(true);
    }

    @Test(priority = 2)
    public void verifyUpdateAllFields() {
        System.out.println("TEST STARTED: Update All Fields");

        page.updateAllFields(
                "Sneha",
                "Automation",
                "sneha@test.com",
                "28",
                "90000",
                "QA"
        );

        System.out.println("All fields updated");
        page.submit();
        System.out.println("Form submitted");
    }

    @Test(priority = 3)
    public void verifyUpdatedTableValues() {
        System.out.println("TEST STARTED: Validate Updated Table Data");

        Assert.assertEquals(page.getFirstName(), "Sneha");
        Assert.assertEquals(page.getLastName(), "Automation");
        Assert.assertEquals(page.getEmail(), "sneha@test.com");
        Assert.assertEquals(page.getAge(), "28");
        Assert.assertEquals(page.getSalary(), "90000");
        Assert.assertEquals(page.getDepartment(), "QA");

        System.out.println("All table validations passed");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("Browser Closed");
    }
}
