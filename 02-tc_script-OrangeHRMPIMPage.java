package tc_script02;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class OrangeHRMPIMPage {

    WebDriver driver;
    WebDriverWait wait;

    public OrangeHRMPIMPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement pimMenu;

    @FindBy(xpath = "//button[text()=' Add ']")
    private WebElement addBtn;

    @FindBy(xpath = "//h6[text()='Add Employee']")
    private WebElement addEmployeeHeader;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastName;

    @FindBy(xpath = "//label[text()='Employee Id']/following::input[1]")
    private WebElement empId;

    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement saveBtn;

    public void openPIM() {
        wait.until(ExpectedConditions.elementToBeClickable(pimMenu)).click();
    }

    public void clickAdd() {
        wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(addEmployeeHeader)); // 🔥 IMPORTANT
    }

    public void enterEmployeeDetails(String fName, String lName) {
        wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(fName);
        lastName.sendKeys(lName);
    }

    public String getEmployeeId() {
        return wait.until(ExpectedConditions.visibilityOf(empId))
                   .getAttribute("value");
    }

    public void saveEmployee() {
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
    }
}
