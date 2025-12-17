package task21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TooltipTest01 {

    WebDriver driver;
    TooltipPage01 tooltipPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/howto/howto_css_tooltip.asp");

        tooltipPage = new TooltipPage01(driver);
    }

    @Test
    public void validateTooltipVisibilityOnHoverAndDisappearanceOnMouseOut() 
    {

        // Hover
        tooltipPage.hoverOnTooltip();
        Assert.assertTrue(
                tooltipPage.isTooltipVisible(),
                "Tooltip should be visible on hover"
        );

        // Validate tooltip text
        Assert.assertFalse(
                tooltipPage.getTooltipText().isEmpty(),
                "Tooltip text should not be empty"
        );

        // Mouse out
        tooltipPage.mouseOut();
        Assert.assertFalse(
                tooltipPage.isTooltipVisible(),
                "Tooltip should disappear on mouse out"
        );

        // Re-hover validation
        tooltipPage.hoverOnTooltip();
        Assert.assertTrue(
                tooltipPage.isTooltipVisible(),
                "Tooltip should reappear on re-hover"
        );
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
