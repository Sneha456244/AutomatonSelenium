package task12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SessionManagementPage {

    WebDriver driver;

    // 1️ Constructor
    public SessionManagementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 2️ Locators
    @FindBy(id = "username")
    WebElement txtUsername;

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(id = "submit")
    WebElement btnLogin;

    @FindBy(xpath = "//a[text()='Log out']")
    WebElement btnLogout;

    @FindBy(className = "post-title")
    WebElement lblSuccessMessage;

    // 3️ Action Methods
    public void setUsername(String username) {
        txtUsername.clear();
        txtUsername.sendKeys(username);
    }

    public void setPassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public void clickLogout() {
        btnLogout.click();
    }

    public boolean isUserLoggedIn() {
        return btnLogout.isDisplayed();
    }

    public boolean isOnLoginPage() {
        return btnLogin.isDisplayed();
    }

    public String getSuccessMessage() {
        return lblSuccessMessage.getText();
    }
}

