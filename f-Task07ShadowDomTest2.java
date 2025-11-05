package task06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ShadowDomTest2 {

    WebDriver driver;
    ShadowDomPage2 page;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        page = new ShadowDomPage2(driver);
    }

    @Test(priority = 1)
    public void testShadowVisibility() throws InterruptedException {
        page.validateShadowElementVisibility();
    }

    @Test(priority = 2)
    public void testShadowAttributeChange() throws InterruptedException {
        page.validateAttributeChange();
    }

    @Test(priority = 3)
    public void testShadowTooltip() throws InterruptedException {
        page.validateTooltipInShadowDom();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
