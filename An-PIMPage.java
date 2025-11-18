package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class PIMPage extends BasePage {

    public PIMPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[text()='PIM']")
    WebElement menuPIM;

    @FindBy(xpath="//button[normalize-space()='Add' or contains(.,'Add')]")
    WebElement btnAdd;

    @FindBy(name="firstName")
    WebElement txtFirstName;

    @FindBy(name="lastName")
    WebElement txtLastName;

    @FindBy(xpath="//button[@type='submit']")
    WebElement btnSave;

    public void openPIM() {
        safeClick(menuPIM, "PIM Menu");
    }

    public void addEmployee(String fName, String lName) {
        safeClick(btnAdd, "Add Employee");
        safeType(txtFirstName, fName, "First Name");
        safeType(txtLastName, lName, "Last Name");
        safeClick(btnSave, "Save Employee");
    }
}
