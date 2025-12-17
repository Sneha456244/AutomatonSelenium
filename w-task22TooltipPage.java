package task21;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TooltipPage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor js;

    // Button with tooltip
    By buttonLocator = By.id("toolTipButton");
    By tooltipLocator = By.cssSelector(".tooltip-inner");

    public TooltipPage(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    public WebElement getButton() 
    {
        return driver.findElement(buttonLocator);
    }

    public void scrollIntoView(WebElement element) 
    {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void hoverOnButton() 
    {
        WebElement button = getButton();
        scrollIntoView(button);
        actions.moveToElement(button).pause(Duration.ofMillis(500)).perform();
    }

    public void moveMouseAway() 
    {
        actions.moveByOffset(200, 0).perform();
    }

    public boolean isTooltipVisible() 
    {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(tooltipLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getTooltipText() 
    {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(tooltipLocator)).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public void waitForTooltipInvisible() 
    {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(tooltipLocator));
    }
}
