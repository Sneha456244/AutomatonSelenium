package task21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonStylePage01 {

    WebDriver driver;

    public ButtonStylePage01(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        System.out.println("[INFO] ButtonStylePage initialized");
    }

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "inventory_container")
    private WebElement inventoryContainer;

    // Style Validations 
    public boolean isButtonDisplayed() 
    {
        return loginButton.isDisplayed();
    }

    public boolean isButtonEnabled() 
    {
        return loginButton.isEnabled();
    }

    public String getBackgroundColor() 
    {
        return loginButton.getCssValue("background-color");
    }

    public String getTextColor() 
    {
        return loginButton.getCssValue("color");
    }

    public String getBorderRadius() 
    {
        return loginButton.getCssValue("border-radius");
    }

    public String getFontSize() 
    {
        return loginButton.getCssValue("font-size");
    }

    public String getFontWeight() 
    {
        return loginButton.getCssValue("font-weight");
    }

    public String getCursorType() 
    {
        return loginButton.getCssValue("cursor");
    }

    public String getButtonClass() 
    {
        return loginButton.getAttribute("class");
    }

    // Actions
    public void login(String user, String pass) 
    {
        System.out.println("[ACTION] Entering login credentials");
        username.sendKeys(user);
        password.sendKeys(pass);

        System.out.println("[ACTION] Clicking login button");
        loginButton.click();
    }

    // Post Login Validation 
    public boolean isInventoryPageDisplayed() 
    {
        return inventoryContainer.isDisplayed();
    }
}
