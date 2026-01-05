package test01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class scriptPage {

    WebDriver driver;

    // Username field
    @FindBy(id = "user-name")
    private WebElement username;

    // Password field
    @FindBy(id = "password")
    private WebElement password;

    // Login button
    @FindBy(id = "login-button")
    private WebElement login;

    // Error message
    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMsg;

    // Products page title
    @FindBy(className = "title")
    private WebElement productsTitle;

    // Constructor
    public scriptPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void enterUsername(String user) {
        username.clear();
        username.sendKeys(user);
    }

    public void enterPassword(String pass) {
        password.clear();
        password.sendKeys(pass);
    }

    public void clickLogin() {
        login.click();
    }

    public String getErrorMessage() {
        return errorMsg.getText();
    }

    public String getProductsTitle() {
        return productsTitle.getText();
    }
}
