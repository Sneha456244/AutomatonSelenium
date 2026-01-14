package tc_script02;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class OrangeHRMLoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public OrangeHRMLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginBtn;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement dashboardSearch;

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();
        wait.until(ExpectedConditions.visibilityOf(dashboardSearch));
    }
}

