package task21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThirdPartyLoginTest {

    WebDriver driver;
    ThirdPartyLoginPage page;

    @BeforeMethod
    public void setup() 
    {
        System.out.println("[SETUP] Launching browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("[ACTION] Opening SauceDemo application");
        driver.get("https://www.saucedemo.com/");

        page = new ThirdPartyLoginPage(driver);
    }

    @Test
    public void validateThirdPartySocialLogin() 
    {

        System.out.println(" TEST START ");

        page.enterUsername("standard_user");
        page.enterPassword("secret_sauce");
        page.clickLogin();

        String parentWindow = page.getParentWindowId();

        page.clickTwitterLink();
        page.switchToChildWindow(parentWindow);

        Assert.assertTrue(
                page.validateThirdPartyURL(),
                "Third-party Twitter/X URL validation failed");

        Assert.assertTrue(
                page.validateSauceLabsAccount(),
                "SauceLabs account page not opened");

        page.returnToParentWindow(parentWindow);

        System.out.println(" TEST END ");
    }

    @AfterMethod
    public void tearDown() 
    {
        System.out.println("[TEARDOWN] Closing browser");
        if (driver != null) {
            driver.quit();
        }
    }
}
