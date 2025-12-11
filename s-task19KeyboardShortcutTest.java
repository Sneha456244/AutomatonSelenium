package task19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class KeyboardShortcutTest {

    WebDriver driver;
    KeyboardShortcutPage page;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        page = new KeyboardShortcutPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void verifyTabKeyMovesFocus() {
        page.enterFullName("Sneha");
        page.pressTab();

        String active = driver.switchTo().activeElement().getAttribute("id");
        Assert.assertEquals(active, "userEmail");
    }

    @Test
    public void verifyCtrlACopyPaste() {
        page.enterFullName("Sneha QA");
        page.selectCopyPaste();
        String value = driver.findElement(By.id("userName")).getAttribute("value");
        Assert.assertTrue(value.contains("Sneha QA"));
    }

    @Test
    public void verifyEnterSubmitsForm() {
        page.enterFullName("Sneha Enter Test");

        page.submitUsingEnter(); 

        String result = page.getSubmittedName();
        Assert.assertTrue(result.contains("Sneha Enter Test"), "Enter failed to submit!");
    }
}
