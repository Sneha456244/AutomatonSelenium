package task06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ShadowDomTest1 {

    WebDriver driver;
    ShadowDomPage1 page;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dev.automationtesting.in/shadow-dom");
        page = new ShadowDomPage1(driver);
    }

    @Test(priority = 1)
    public void verifySingleShadowDom() throws InterruptedException {
        page.handleSingleShadowDom();
    }

    @Test(priority = 2)
    public void verifyTwoNestedShadowDom() throws InterruptedException {
        page.handleTwoNestedShadowDom();
    }

    @Test(priority = 3)
    public void verifyThreeNestedShadowDom() throws InterruptedException {
        page.handleThreeNestedShadowDom();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
