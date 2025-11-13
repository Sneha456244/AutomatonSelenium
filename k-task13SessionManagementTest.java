package task12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SessionManagementTest {

    WebDriver driver;
    SessionManagementPage sessionPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        sessionPage = new SessionManagementPage(driver);
    }

    @Test
    public void verifySessionPersistenceAfterReload() {
        // Step 1: Login
        sessionPage.setUsername("student");
        sessionPage.setPassword("Password123");
        sessionPage.clickLogin();
        Assert.assertTrue(sessionPage.isUserLoggedIn(), "Login failed");

        // Step 2: Refresh page
        driver.navigate().refresh();
        Assert.assertTrue(sessionPage.isUserLoggedIn());
        System.out.println("Session not persistent after refresh");

        // Step 3: Logout
        sessionPage.clickLogout();
        Assert.assertTrue(sessionPage.isOnLoginPage());
        System.out.println("Logout failed or session not cleared");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
