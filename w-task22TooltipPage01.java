package task21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TooltipPage01 {

    WebDriver driver;
    Actions actions;

    public TooltipPage01(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    // Tooltip trigger element
    @FindBy(xpath = "//div[@class='tooltip'][1]")
    WebElement tooltipBox;

    // Tooltip text
    @FindBy(xpath = "//div[@class='tooltip'][1]/span")
    WebElement tooltipText;

    // Hover on tooltip
    public void hoverOnTooltip() {
        actions.moveToElement(tooltipBox).perform();
    }

    // Mouse out
    public void mouseOut() {
        actions.moveByOffset(300, 0).perform();
    }

    // Check tooltip visibility
    public boolean isTooltipVisible() {
        return tooltipText.isDisplayed();
    }

    // Get tooltip text
    public String getTooltipText() {
        return tooltipText.getText();
    }
}
