package task09;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class AutomationPracticeTest {

    WebDriver driver;
    AutomationPracticePage practicePage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://codenboxautomationlab.com/practice/");
        practicePage = new AutomationPracticePage(driver);
    }

    @Test(priority = 1)
    public void verifyRadioButton() {
        practicePage.ClickRadioButton();
    }

    @Test(priority = 2)
    public void verifyDynamicDropdown() {
        practicePage.DynamicDropdown();
    }

    @Test(priority = 3)
    public void verifyStaticDropdown() {
        practicePage.StaticDropdown();
    }

    @Test(priority = 4)
    public void verifyCheckbox() {
        practicePage.SelectCheckBox();
    }

    @Test(priority = 5)
    public void verifyWindowSwitch() {
        practicePage.SwitchWindowAndClose();
    }

    @Test(priority = 6)
    public void verifyAlertActions() {
        practicePage.Alert();
    }

    @Test(priority = 7)
    public void verifyWebTableText() {
        practicePage.FindTextInWebTable();
    }

    @Test(priority = 8)
    public void verifyHideShowTextbox() {
        practicePage.HideShowTextbox();
    }

    @Test(priority = 9)
    public void verifyMouseOver() {
        practicePage.PerformMouseOver();
    }

    @Test(priority = 10)
    public void verifyIframe() {
        practicePage.SwitchToiFrameAndValidate();
    }

    @Test(priority = 11)
    public void verifyCalendarLink() {
        practicePage.ClickCalendarAndClose();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
