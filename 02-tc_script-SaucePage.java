package tc_script02;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SaucePage {

    WebDriver driver;
    WebDriverWait wait;

    public SaucePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // Login 
    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    // Products
    @FindBy(className = "inventory_item")
    List<WebElement> products;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    // Cart 
    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    // Checkout Step One 
    @FindBy(className = "title")
    WebElement checkoutTitle;

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement continueBtn;

    // Finish 
    @FindBy(id = "finish")
    WebElement finishBtn;

    @FindBy(className = "complete-header")
    WebElement successMsg;

    // ACTIONS 

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();
        wait.until(ExpectedConditions.urlContains("inventory"));
    }

    public void addProducts(int count) {
        wait.until(ExpectedConditions.visibilityOfAllElements(products));
        for (int i = 0; i < count; i++) {
            products.get(i).findElement(By.tagName("button")).click();
        }
    }

    public void openCart() {
        cartIcon.click();
        wait.until(ExpectedConditions.urlContains("cart"));
    }

    public void clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));

        // Reliable click (handles overlay issues)
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutBtn);

        // wait for checkout page identity
        wait.until(ExpectedConditions.textToBePresentInElement(checkoutTitle,
                "Checkout: Your Information"));
    }

    public void enterCheckoutDetails(String fName, String lName, String zip) {
        wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(fName);
        lastName.sendKeys(lName);
        postalCode.sendKeys(zip);
        continueBtn.click();
        wait.until(ExpectedConditions.urlContains("checkout-step-two"));
    }

    public void finishOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(finishBtn)).click();
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOf(successMsg)).getText();
    }
}
