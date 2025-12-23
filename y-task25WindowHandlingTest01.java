package task21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandlingTest01 {

    WebDriver driver;
    WindowHandlingPage01 windowPage;

    @BeforeMethod
    public void setUp() {
        System.out.println("BEFORE METHOD");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("[ACTION] Opening application");
        driver.get("https://demo.nopcommerce.com/");

        windowPage = new WindowHandlingPage01(driver);
    }

    @Test
    public void validateWindowHandling() {

        System.out.println("TEST START");

        // Store parent window
        windowPage.storeParentWindow();

        // Validate initial window count
        Assert.assertEquals(windowPage.getWindowCount(), 1,
                "More than one window present initially");

        // Click link that opens new window
        windowPage.clickSocialLink();

        // Validate new window opened
        Assert.assertEquals(windowPage.getWindowCount(), 2,
                "Child window did not open");

        // Switch to child
        windowPage.switchToChildWindow();

        // Validate child window details
        windowPage.validateChildWindowLoaded();

        // Scroll child window
        windowPage.scrollChildWindow();

        // Validate heading visibility
        Assert.assertTrue(windowPage.isHeadingDisplayed(),
                "Heading not visible in child window");

        // Close child window
        windowPage.closeChildWindow();

        // Switch back to parent
        windowPage.switchBackToParent();

        // Validate parent window count
        Assert.assertEquals(windowPage.getWindowCount(), 1,
                "Child window not closed properly");

        // Validate parent page is usable
        Assert.assertTrue(windowPage.isParentPageActive(),
                "Parent page not active after returning");

        System.out.println("TEST END");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("TEARDOWN");
        driver.quit();
    }
}
