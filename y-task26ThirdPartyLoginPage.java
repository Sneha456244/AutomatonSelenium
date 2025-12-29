package task21;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThirdPartyLoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public ThirdPartyLoginPage(WebDriver driver) 
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        System.out.println("[INFO] ThirdPartyLoginPage initialized");
    }

    // LOCATORS 

    @FindBy(id = "user-name")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(css = "a[href*='twitter'], a[href*='x.com']")
    WebElement twitterLink;

    // ACTION METHODS 

    public void enterUsername(String username) 
    {
        System.out.println("[ACTION] Entering username");
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) 
    {
        System.out.println("[ACTION] Entering password");
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLogin() 
    {
        System.out.println("[ACTION] Clicking Login button");
        loginButton.click();
    }

    public String getParentWindowId() 
    {
        String parent = driver.getWindowHandle();
        System.out.println("[INFO] Parent window ID: " + parent);
        return parent;
    }

    public void clickTwitterLink() 
    {
        System.out.println("[ACTION] Clicking Twitter/X third-party link");
        wait.until(ExpectedConditions.elementToBeClickable(twitterLink));
        twitterLink.click();
    }

    public void switchToChildWindow(String parentWindow) 
    {
        Set<String> windows = driver.getWindowHandles();
        System.out.println("[INFO] Total windows opened: " + windows.size());

        for (String win : windows) 
        {
            if (!win.equals(parentWindow)) 
            {
                driver.switchTo().window(win);
                System.out.println("[ACTION] Switched to child window");
                break;
            }
        }
    }

    // VALIDATIONS 

    public boolean validateThirdPartyURL() 
    {
        String url = driver.getCurrentUrl();
        System.out.println("[CHECK] Third-party URL: " + url);

        boolean isValid =
                url.contains("twitter.com") ||
                url.contains("x.com");

        System.out.println("[CHECK] Is valid Twitter/X URL: " + isValid);
        return isValid;
    }

    public boolean validateSauceLabsAccount() 
    {
        String url = driver.getCurrentUrl();
        System.out.println("[CHECK] Account page URL contains 'saucelabs': " + url);
        return url.toLowerCase().contains("saucelabs");
    }

    public void returnToParentWindow(String parentWindow) 
    {
        driver.close();
        driver.switchTo().window(parentWindow);
        System.out.println("[ACTION] Closed child window and returned to parent");
    }
}
