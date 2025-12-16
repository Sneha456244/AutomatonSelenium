package task21;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class EditableWebTablePage {

    WebDriver driver;
    WebDriverWait wait;

    public EditableWebTablePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //EDIT ICON (SVG) 
    @FindBy(css = "#edit-record-1")
    WebElement editButton;

    // FORM FIELDS 
    @FindBy(css = "input[placeholder='First Name']")
    WebElement firstName;

    @FindBy(css = "input[placeholder='Last Name']")
    WebElement lastName;

    @FindBy(css = "input[placeholder='name@example.com']")
    WebElement email;

    @FindBy(css = "input[placeholder='Age']")
    WebElement age;

    @FindBy(css = "input[placeholder='Salary']")
    WebElement salary;

    @FindBy(css = "input[placeholder='Department']")
    WebElement department;

    @FindBy(css = "#submit")
    WebElement submitButton;

    // TABLE CELLS 
    @FindBy(css = ".rt-tbody .rt-tr-group:nth-child(1) .rt-td:nth-child(1)")
    WebElement tableFirstName;

    @FindBy(css = ".rt-tbody .rt-tr-group:nth-child(1) .rt-td:nth-child(2)")
    WebElement tableLastName;

    @FindBy(css = ".rt-tbody .rt-tr-group:nth-child(1) .rt-td:nth-child(3)")
    WebElement tableAge;

    @FindBy(css = ".rt-tbody .rt-tr-group:nth-child(1) .rt-td:nth-child(4)")
    WebElement tableEmail;

    @FindBy(css = ".rt-tbody .rt-tr-group:nth-child(1) .rt-td:nth-child(5)")
    WebElement tableSalary;

    @FindBy(css = ".rt-tbody .rt-tr-group:nth-child(1) .rt-td:nth-child(6)")
    WebElement tableDepartment;

    // ACTION METHODS 

    public void clickEditUsingJS() {
        wait.until(ExpectedConditions.elementToBeClickable(editButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editButton);
    }

    public void waitForForm() {
        wait.until(ExpectedConditions.visibilityOf(firstName));
    }

    public void updateAllFields(String fn, String ln, String em, String ag, String sal, String dept) {
        firstName.clear(); firstName.sendKeys(fn);
        lastName.clear(); lastName.sendKeys(ln);
        email.clear(); email.sendKeys(em);
        age.clear(); age.sendKeys(ag);
        salary.clear(); salary.sendKeys(sal);
        department.clear(); department.sendKeys(dept);
    }

    public void submit() {
        submitButton.click();
    }

    // GETTERS 
    public String getFirstName() { return tableFirstName.getText(); }
    public String getLastName() { return tableLastName.getText(); }
    public String getAge() { return tableAge.getText(); }
    public String getEmail() { return tableEmail.getText(); }
    public String getSalary() { return tableSalary.getText(); }
    public String getDepartment() { return tableDepartment.getText(); }
}
