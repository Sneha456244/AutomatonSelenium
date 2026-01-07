package tc_script02;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMPage01 {

    WebDriver driver;
    WebDriverWait wait;

    // ===== Constructor =====
    public OrangeHRMPage01(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // ===== Locators =====
    @FindBy(name = "username")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement btnLogin;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchBox;

    @FindBy(xpath = "//span[normalize-space()='Time']")
    private WebElement timeMenu;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement empNameInput;

    @FindBy(xpath = "//div[@role='listbox']//div[@role='option']")
    private List<WebElement> empSuggestions;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement viewBtn;

    //PIM menu locator
    @FindBy(xpath = "//span[normalize-space()='PIM']")
    private WebElement clkPIM;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement clkAddBtn;
    
    @FindBy(xpath = "//input[@placeholder='First name']")
    private WebElement setFName;
    
    @FindBy(xpath = "//input[@placeholder='Middle name']")
    private WebElement setMName;
    
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement setLName;
    
    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    private WebElement verifyEmpID;
    
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement clkSave ;
    
    // Recruitment Page 
    @FindBy(xpath = "//span[normalize-space()='Recruitment']")
    private WebElement recruitmentMenu;
    
    @FindBy(xpath = "//div[contains(text(),'Records Found')]")
    private WebElement recordsFoundText;

    @FindBy(xpath = "(//i[contains(@class,'bi-eye')])[1]")
    private WebElement firstEyeIcon;

    @FindBy(xpath = "(//i[contains(@class,'bi-trash')])[2]")
    private WebElement secondDeleteIcon;

    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    private WebElement confirmDeleteBtn;
    
    @FindBy(xpath = "//a[@class='oxd-main-menu-item active']")
    private WebElement clkDirectory;
    
    @FindBy(xpath = "//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']")
    private WebElement giveEmpName;
    
    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement clkSearchBtn;
    
    @FindBy(xpath="//i[@class='oxd-icon bi-caret-up-fill']")
    private WebElement clkArrow;

    // Actions

    // Login method
    public void login(String username, String pwd) {
        wait.until(ExpectedConditions.visibilityOf(userName)).sendKeys(username);
        password.sendKeys(pwd);
        btnLogin.click();

        // Wait until dashboard loads
        wait.until(ExpectedConditions.visibilityOf(searchBox));
    }

    // Search and click Time menu
    public void searchAndClickTime(String menu) {
        wait.until(ExpectedConditions.visibilityOf(searchBox)).clear();
        searchBox.sendKeys(menu);
        wait.until(ExpectedConditions.elementToBeClickable(timeMenu)).click();
    }

    // Select employee and click View
    public void selectEmployeeAndClickView(String empName) {
        wait.until(ExpectedConditions.visibilityOf(empNameInput));
        empNameInput.clear();
        empNameInput.sendKeys(empName);

        wait.until(ExpectedConditions.visibilityOfAllElements(empSuggestions));

        for (WebElement option : empSuggestions) {
            if (option.getText().equalsIgnoreCase(empName)) {
                option.click();
                break;
            }
        }

        wait.until(ExpectedConditions.elementToBeClickable(viewBtn)).click();
    }

    // Click PIM
    public void clickPIM() {
        wait.until(ExpectedConditions.elementToBeClickable(clkPIM)).click();
    }

    // Click Add
    public void clickAdd() {
        wait.until(ExpectedConditions.elementToBeClickable(clkAddBtn)).click();
    }
    
    //Set First name
    public void setFirstName() {
    	wait.until(ExpectedConditions.visibilityOf(setFName));
        wait.until(ExpectedConditions.elementToBeClickable(setFName));
        setFName.sendKeys("Shaa");
    }
    
    //Set Middle name
    public void setMiddleName() {
    	wait.until(ExpectedConditions.visibilityOf(setMName));
        wait.until(ExpectedConditions.elementToBeClickable(setMName));
        setMName.sendKeys("QA");
    }
    
    //Set Last name
    public void setLastName() {
    	wait.until(ExpectedConditions.visibilityOf(setLName));
        wait.until(ExpectedConditions.elementToBeClickable(setLName));
        setLName.sendKeys("E");
    }
    
    //Verify EmpID
    public String verifyEmpID() {
        wait.until(ExpectedConditions.visibilityOf(verifyEmpID));
        return verifyEmpID.getAttribute("value");
    }
    
    // Click Add
    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(clkSave)).click();
    }
    
    public void openRecruitment() {
        wait.until(ExpectedConditions.elementToBeClickable(recruitmentMenu)).click();
    }

    public String getRecordsFound() {
        return wait.until(ExpectedConditions.visibilityOf(recordsFoundText)).getText();
    }

    public void clickFirstEyeIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(firstEyeIcon)).click();
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void deleteSecondRecord() {
        wait.until(ExpectedConditions.elementToBeClickable(secondDeleteIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteBtn)).click();
    }
    
    public void clickDirectory() {
        wait.until(ExpectedConditions.elementToBeClickable(clkDirectory)).click();
    }
    
  //Click Arrow
    public void clickArrow() {
    	wait.until(ExpectedConditions.visibilityOf(clkArrow));
        wait.until(ExpectedConditions.elementToBeClickable(clkArrow));
        clkArrow.click();
    }
    
    public void giveEmpName() {
        wait.until(ExpectedConditions.elementToBeClickable(giveEmpName));
        giveEmpName.sendKeys("A8DCo 4Ys 010Z");
    }
    
    //Click Search button
    public void clickSearchBtn() {
    	wait.until(ExpectedConditions.visibilityOf(clkSearchBtn));
        wait.until(ExpectedConditions.elementToBeClickable(clkSearchBtn));
        clkSearchBtn.click();
    }
    
}
