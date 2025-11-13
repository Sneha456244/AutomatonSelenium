package task12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwagLoginSessionTest {

    WebDriver driver;
    SwagLoginSessionPage page;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        page = new SwagLoginSessionPage(driver);
    }

    @Test
    public void verifySessionPersistenceAndLogout() {
        // Step 1: Login
        page.setUsername("standard_user");
        page.setPassword("secret_sauce");
        page.clickLogin();

        // Step 2: Verify successful login
        Assert.assertTrue(page.verifyLoginSuccess(), "Login failed — user not redirected to inventory page.");

        // Step 3: Refresh page (to check session persistence)
        driver.navigate().refresh();

        // Step 4: Check if session is still active after reload
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory"), "Session not persisted after refresh.");

        // Step 5: Logout
        page.clickLogout();

        // Step 6: Verify logout success
        String logoutUrl = driver.getCurrentUrl();
        Assert.assertTrue(logoutUrl.contains("saucedemo.com"), "Logout failed or user still on inventory page.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
