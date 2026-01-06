package tc_script02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrangeHRMPage {

    WebDriver driver;
    WebDriverWait wait;

    // ========= Constructor =========
    public OrangeHRMPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // ========= Locators =========
    @FindBy(xpath = "//img[@alt='company-branding']")
    private WebElement logo;

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement userName;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement btnLogin;

    @FindBy(xpath = "//a[@href='/web/index.php/admin/viewAdminModule']")
    private WebElement clkAdmin;
    
    @FindBy(xpath = "//span[normalize-space()='Job']")
    private WebElement jobDropdown;
    
    @FindBy(xpath = "//a[normalize-space()='Job Titles']")
    private WebElement jobTitle;

    // ========= Actions =========

    // Verify OrangeHRM logo
    public boolean isOrangeHRMDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(logo));
        return logo.isDisplayed();
    }

    // Enter username
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(userName));
        userName.clear();
        userName.sendKeys(username);
    }

    // Enter password
    public void enterPassword(String pwd) {
        wait.until(ExpectedConditions.visibilityOf(password));
        password.clear();
        password.sendKeys(pwd);
    }

    // Click Login button
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
        btnLogin.click();
    }

    // Complete login flow
    public void login(String username, String pwd) {
        enterUsername(username);
        enterPassword(pwd);
        clickLogin();
    }

    // Click Admin menu
    public void clickAdmin() {
        wait.until(ExpectedConditions.elementToBeClickable(clkAdmin));
        clkAdmin.click(); 
     }
        
    // Click Job dropdown
    public void clickJob() {
        wait.until(ExpectedConditions.elementToBeClickable(jobDropdown));
        jobDropdown.click();
    }
    
    // Click JobTitle
    public void clickJobTitle() {
        wait.until(ExpectedConditions.visibilityOf(jobTitle));
        wait.until(ExpectedConditions.elementToBeClickable(jobTitle));
        jobTitle.click();
    }
    
    
}
