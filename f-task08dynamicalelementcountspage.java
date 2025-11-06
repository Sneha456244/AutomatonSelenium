package task07;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

/*
The user clicks on “Add to cart” buttons for multiple products.
The system updates the cart count shown on the screen.
The test verifies that the cart count is increased correctly after each click.
 */

public class SwagLabsPage {

    WebDriver driver;

    // Constructor
    public SwagLabsPage(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators 
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement txtUsername;

    @FindBy(xpath = "//input[@id='password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement btnLogin;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cartIcon;

    // Actions
    public void navigateToHome() 
    {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    public void setUsername(String username) 
    {
        txtUsername.sendKeys(username);
    }

    public void setPassword(String password) 
    {
        txtPassword.sendKeys(password);
    }

    public void clickLoginButton() 
    {
        btnLogin.click();
    }

    public int getCartCount() 
    {
        String countText = cartIcon.getText();
        return countText.isEmpty() ? 0 : Integer.parseInt(countText);
    }

    public void clickProductAddToCart(int index) 
    {
        List<WebElement> addButtons = driver.findElements(By.xpath("//button[text()='Add to cart']"));
        if (addButtons.size() > index) 
        {
            addButtons.get(index).click();
        }
    }
}
