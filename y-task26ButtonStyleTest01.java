package task21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ButtonStyleTest01 {

    WebDriver driver;
    ButtonStylePage01 page;

    @BeforeMethod
    public void setup() 
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        page = new ButtonStylePage01(driver);
        System.out.println("TEST START ");
    }

    @Test
    public void verifyButtonColorAndStyleBeforeAndAfterClick() 
    {

        // BEFORE CLICK 
        Assert.assertTrue(page.isButtonDisplayed(), "Login button not displayed");
        Assert.assertTrue(page.isButtonEnabled(), "Login button not enabled");

        System.out.println("[CHECK] Background color: " + page.getBackgroundColor());
        System.out.println("[CHECK] Text color: " + page.getTextColor());
        System.out.println("[CHECK] Border radius: " + page.getBorderRadius());
        System.out.println("[CHECK] Font size: " + page.getFontSize());
        System.out.println("[CHECK] Font weight: " + page.getFontWeight());
        System.out.println("[CHECK] Cursor type: " + page.getCursorType());
        System.out.println("[CHECK] Button class attribute: " + page.getButtonClass());

        // CLICK 
        page.login("standard_user", "secret_sauce");

        // AFTER CLICK
        Assert.assertTrue(
                page.isInventoryPageDisplayed(),
                "Inventory page not displayed after login"
        );

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "URL did not change after login"
        );
    }

    @AfterMethod
    public void tearDown() 
    {
        System.out.println("[TEARDOWN] Closing browser");
        driver.quit();
    }
}
