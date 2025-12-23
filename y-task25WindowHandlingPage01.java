package task21;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowHandlingPage01 {

    WebDriver driver;
    String parentWindowId;

    // LOCATORS 

    @FindBy(tagName = "body")
    WebElement pageBody;

    @FindBy(linkText = "Facebook")
    WebElement facebookLink;

    @FindBy(tagName = "h1")
    WebElement pageHeading;

    // CONSTRUCTOR 

    public WindowHandlingPage01(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        System.out.println("[INFO] WindowHandlingPage initialized");
    }

    // ACTION METHODS

    public void storeParentWindow() 
    {
        parentWindowId = driver.getWindowHandle();
        System.out.println("[INFO] Parent Window ID stored: " + parentWindowId);
    }

    public String getParentWindowId() 
    {
        return parentWindowId;
    }

    public void clickSocialLink() 
    {
        System.out.println("[ACTION] Clicking Facebook link");
        facebookLink.click();
    }

    public int getWindowCount() 
    {
        int count = driver.getWindowHandles().size();
        System.out.println("[CHECK] Current window count: " + count);
        return count;
    }

    public void switchToChildWindow() 
    {
        Set<String> windows = driver.getWindowHandles();

        for (String win : windows) 
        {
            if (!win.equals(parentWindowId)) 
            {
                driver.switchTo().window(win);
                System.out.println("[ACTION] Switched to child window");
                break;
            }
        }
    }

    public void validateChildWindowLoaded() 
    {
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();

        System.out.println("[CHECK] Child window title: " + title);
        System.out.println("[CHECK] Child window URL: " + url);

        if (!url.startsWith("https")) 
        {
            throw new AssertionError("Child window is not secure (HTTPS)");
        }
    }

    public void scrollChildWindow() 
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        System.out.println("[ACTION] Scrolled child window");
    }

    public boolean isHeadingDisplayed() 
    {
        boolean status = pageHeading.isDisplayed();
        System.out.println("[CHECK] Heading displayed in child window: " + status);
        return status;
    }

    public void closeChildWindow() 
    {
        System.out.println("[ACTION] Closing child window");
        driver.close();
    }

    public void switchBackToParent() 
    {
        driver.switchTo().window(parentWindowId);
        System.out.println("[ACTION] Switched back to parent window");
    }

    public boolean isParentPageActive() 
    {
        boolean status = pageBody.isDisplayed();
        System.out.println("[CHECK] Parent page active: " + status);
        return status;
    }
}
