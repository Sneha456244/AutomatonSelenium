package task21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TooltipTest {

    WebDriver driver;
    TooltipPage tooltipPage;

    @BeforeClass
    public void setup() 
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/tool-tips");
        tooltipPage = new TooltipPage(driver);
    }

    @Test
    public void validateTooltipVisibilityOnHoverAndDisappearanceOnMouseOut() 
    {
        // 1. Initially tooltip should be hidden
        Assert.assertFalse(tooltipPage.isTooltipVisible(), "Tooltip should be hidden initially");

        // 2. Hover on button -> tooltip appears
        tooltipPage.hoverOnButton();
        Assert.assertTrue(tooltipPage.isTooltipVisible(), "Tooltip should be visible on hover");
        Assert.assertEquals(tooltipPage.getTooltipText(), "You hovered over the Button", "Tooltip text should match");

        // 3. Mouse out -> tooltip disappears
        tooltipPage.moveMouseAway();
        tooltipPage.waitForTooltipInvisible();
        Assert.assertFalse(tooltipPage.isTooltipVisible(), "Tooltip should disappear on mouse out");

        // 4. Re-hover -> tooltip appears again
        tooltipPage.hoverOnButton();
        Assert.assertTrue(tooltipPage.isTooltipVisible(), "Tooltip should reappear on re-hover");
        Assert.assertEquals(tooltipPage.getTooltipText(), "You hovered over the Button", "Tooltip text should remain same after re-hover");
    }

    @AfterClass
    public void teardown() 
    {
        driver.quit();
    }
}
