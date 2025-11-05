package task06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ShadowDomTest {

    WebDriver driver;
    ShadowDomPage shadowPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://books-pwakit.appspot.com/");
        shadowPage = new ShadowDomPage(driver);
    }

    @Test
    public void verifyShadowDomInput() throws InterruptedException {
        shadowPage.enterTextInShadowInput("WELCOME");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
