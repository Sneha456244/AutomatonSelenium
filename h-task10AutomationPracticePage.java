package task09;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AutomationPracticePage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    // Constructor
    public AutomationPracticePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    // Locators 

    @FindBy(xpath = "//input[@value='radio1']")
    WebElement clkRadiobtn;

    @FindBy(xpath = "//input[@id='autocomplete']")
    WebElement dynamicDropdown;

    @FindBy(xpath = "//select[@id='dropdown-class-example']")
    WebElement staticDropdown;

    @FindBy(xpath = "//input[@id='checkBoxOption1']")
    WebElement chkBox;

    @FindBy(xpath = "//button[@id='openwindow']")
    WebElement openWindow;

    // Alert elements
    @FindBy(xpath = "//input[@id='name']")
    WebElement txtName;

    @FindBy(xpath = "//input[@id='alertbtn']")
    WebElement alertbtn;

    @FindBy(xpath = "//input[@id='confirmbtn']")
    WebElement confirmbtn;

    // Web Table
    @FindBy(xpath = "//div[3]//div[1]//fieldset[1]")
    WebElement fndTxt;

    // Hide / Show Textbox
    @FindBy(xpath = "//input[@id='hide-textbox']")
    WebElement hideTxtbox;

    @FindBy(xpath = "//input[@id='show-textbox']")
    WebElement showTxtbox;

    @FindBy(xpath = "//input[@id='displayed-text']")
    WebElement displayedTextbox;

    // Calendar Link
    @FindBy(xpath = "//a[normalize-space()='Booking Calendar']")
    WebElement clkCalendar;

    // iFrame
    @FindBy(xpath = "//iframe[@id='courses-iframe']")
    WebElement iFrame;

    // Mouse Hover
    @FindBy(xpath = "//button[@id='mousehover']")
    WebElement mouseHoverBtn;

    @FindBy(xpath = "//a[normalize-space()='Top']")
    WebElement topLink;

    // Action Methods 

    // 1. Click Radio Button
    public void ClickRadioButton() {
        clkRadiobtn.click();
    }

    // 2. Dynamic Dropdown
    public void DynamicDropdown() {
        dynamicDropdown.sendKeys("India");
        dynamicDropdown.sendKeys(Keys.ARROW_DOWN);
        dynamicDropdown.sendKeys(Keys.ENTER);
    }

    // 3. Static Dropdown
    public void StaticDropdown() {
        staticDropdown.click();
        staticDropdown.sendKeys(Keys.ARROW_DOWN);
        staticDropdown.sendKeys(Keys.ENTER);
    }

    // 4. Select Checkbox
    public void SelectCheckBox() {
        chkBox.click();
        Assert.assertTrue(chkBox.isSelected(), "Checkbox not selected");
    }

    // 5. Switch Window and Close
    public void SwitchWindowAndClose() {
        String parent = driver.getWindowHandle();
        openWindow.click();

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        driver.close();
        driver.switchTo().window(parent);
    }

    // 6. Alert Handling
    public void Alert() {
        txtName.sendKeys("Automation");
        alertbtn.click();
        driver.switchTo().alert().accept();

        txtName.clear();
        txtName.sendKeys("Test");
        confirmbtn.click();
        driver.switchTo().alert().dismiss();
    }

    // 7. Validate Text in Web Table
    public void FindTextInWebTable() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='product']//tr/td[2]"));
        boolean found = false;

        for (WebElement cell : rows) {
            if (cell.getText().contains("WebServices / REST API Testing with SoapUI")) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found, "Specified course text not found in table");
    }

    // 8. Hide / Show Textbox Validation
    public void HideShowTextbox() {
        hideTxtbox.click();
        Assert.assertFalse(displayedTextbox.isDisplayed(), "Textbox should be hidden");

        showTxtbox.click();
        Assert.assertTrue(displayedTextbox.isDisplayed(), "Textbox should be visible");
    }

    // 9. Mouse Hover Action
    public void PerformMouseOver() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mouseHoverBtn);
        actions.moveToElement(mouseHoverBtn).perform();
        wait.until(ExpectedConditions.visibilityOf(topLink));
        Assert.assertTrue(topLink.isDisplayed(), "Mouse hover action not displayed");
    }

    // 10. Click Calendar Link (Only click & close)
    public void ClickCalendarAndClose() {
        String parent = driver.getWindowHandle();
        clkCalendar.click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        driver.close();
        driver.switchTo().window(parent);
    }

    // 11. Switch to iFrame and Validate
    public void SwitchToiFrameAndValidate() {
        WebElement iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);
        WebElement insideFrameElement = driver.findElement(By.tagName("body"));
        Assert.assertTrue(insideFrameElement.isDisplayed(), "iFrame content not visible!");
        driver.switchTo().defaultContent();
    }
}
