package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class AdminPage {
    WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Admin']") // adjust if locator different
    WebElement menuAdmin;

    @FindBy(xpath = "//a[text()='User Management']/following::a[text()='Users']")
    WebElement submenuUsers;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']") // search username field
    WebElement txtSearchUsername;

    @FindBy(xpath = "//button[@type='submit' and .//span[text()=' Search ']] | //button[@type='submit']")
    WebElement btnSearch;

    @FindBy(xpath = "//div[contains(@class,'oxd-table-body')]/div")
    WebElement searchResultRow;

    public void navigateToAdmin() throws InterruptedException {
        try {
            menuAdmin.click();
            Thread.sleep(500);
            submenuUsers.click();
            Thread.sleep(500);
        } catch (Exception e) {
            // ignore - sometimes admin area is directly accessible, proceed
        }
    }

    public void searchUser(String username) {
        try {
            txtSearchUsername.clear();
            txtSearchUsername.sendKeys(username);
            btnSearch.click();
        } catch (Exception e) {
            // fallback: attempt submit
            btnSearch.submit();
        }
    }

    public boolean isResultDisplayed() {
        try {
            return searchResultRow.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
