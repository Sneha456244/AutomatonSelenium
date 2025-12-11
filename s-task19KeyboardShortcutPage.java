package task19;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class KeyboardShortcutPage {

    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    public KeyboardShortcutPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    WebElement fullName;

    @FindBy(id = "submit")
    WebElement submitBtn;

    @FindBy(id = "name")
    WebElement outputName;


    public void enterFullName(String name) {
        wait.until(ExpectedConditions.visibilityOf(fullName));
        fullName.clear();
        fullName.sendKeys(name);
    }

    public void pressTab() {
        actions.sendKeys(Keys.TAB).perform();
    }

    public void selectCopyPaste() {
        actions.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").sendKeys("v")
                .keyUp(Keys.CONTROL).perform();
    }

    public void submitUsingEnter() {
        // Move focus to submit button first
        submitBtn.sendKeys(Keys.ENTER);
    }

    public String getSubmittedName() {
        wait.until(ExpectedConditions.visibilityOf(outputName));
        return outputName.getText();
    }
}
