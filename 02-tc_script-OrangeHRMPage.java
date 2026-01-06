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

    // Constructor
    public OrangeHRMPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Locators 
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
    
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement clkAdd;
    
    @FindBy(xpath = "//label[text()='Job Title']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    private WebElement setJobTitle;
    
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement clkSave;
    
    @FindBy(xpath = "(//button[@type='button'])[8]")
    private WebElement clkEditIcon;
    
    @FindBy(xpath = "//label[text()='Job Title']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    private WebElement UpdatedJobTitle;
    
    @FindBy(xpath = "//a[@class='oxd-main-menu-item active']")
    private WebElement clkLeave;
    
    @FindBy(xpath = "//li[@class='oxd-topbar-body-nav-tab --visited']")
    private WebElement clkApply;
    
    // Actions

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
    	wait.until(ExpectedConditions.visibilityOf(clkAdmin));
        wait.until(ExpectedConditions.elementToBeClickable(clkAdmin));
        clkAdmin.click(); 
     }
        
    // Click Job dropdown
    public void clickJob() {
    	wait.until(ExpectedConditions.visibilityOf(jobDropdown));
        wait.until(ExpectedConditions.elementToBeClickable(jobDropdown));
        jobDropdown.click();
    }
    
    // Click JobTitle
    public void clickJobTitle() {
        wait.until(ExpectedConditions.visibilityOf(jobTitle));
        wait.until(ExpectedConditions.elementToBeClickable(jobTitle));
        jobTitle.click();
    }
    
    //Click ADD button
    public void clickAdd() {
    	wait.until(ExpectedConditions.visibilityOf(clkAdd));
        wait.until(ExpectedConditions.elementToBeClickable(clkAdd));
        clkAdd.click();
    }
    
    //Set JobTitle
    public void setJobTitle() {
    	wait.until(ExpectedConditions.visibilityOf(setJobTitle));
        wait.until(ExpectedConditions.elementToBeClickable(setJobTitle));
        setJobTitle.sendKeys("QA");
    }
    
    //Click ADD button
    public void clickSave() {
    	wait.until(ExpectedConditions.visibilityOf(clkSave));
        wait.until(ExpectedConditions.elementToBeClickable(clkSave));
        clkSave.click();
    }
    
    //Click Edit Icon 
    public void clickEditIcon() {
    	wait.until(ExpectedConditions.visibilityOf(clkEditIcon));
        wait.until(ExpectedConditions.elementToBeClickable(clkEditIcon));
        clkEditIcon.click();
    }
    
    //Set JobTitle
    public void UpdatedJobTitle() {
    	wait.until(ExpectedConditions.visibilityOf(UpdatedJobTitle));
        wait.until(ExpectedConditions.elementToBeClickable(UpdatedJobTitle));
        UpdatedJobTitle.sendKeys("QA001");
    }
    
    // Click Leave menu
    public void clickLeave() {
    	wait.until(ExpectedConditions.visibilityOf(clkLeave));
        wait.until(ExpectedConditions.elementToBeClickable(clkLeave));
        clkLeave.click(); 
     }
    
    // Click Apply button
    public void clickApply() {
    	wait.until(ExpectedConditions.visibilityOf(clkApply));
        wait.until(ExpectedConditions.elementToBeClickable(clkApply));
        clkApply.click(); 
     }
}
