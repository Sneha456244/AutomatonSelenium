package task12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SwagLoginSessionPage {
    WebDriver driver;
    WebDriverWait wait;

    // 1️ Constructor
    public SwagLoginSessionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 2️ Locators
    @FindBy(id = "user-name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(id = "react-burger-menu-btn")
    WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutButton;

    // 3️ Actions
    public void setUsername(String uname) {
        usernameField.sendKeys(uname);
    }

    public void setPassword(String pwd) {
        passwordField.sendKeys(pwd);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean verifyLoginSuccess() {
        return driver.getCurrentUrl().contains("inventory");
    }

    public void clickLogout() {
        // FIX: First open the side menu
        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();

        // Now wait for logout link to appear
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
    }
}
