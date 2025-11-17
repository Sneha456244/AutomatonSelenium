package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 
    @FindBy(name="username")
    WebElement txtUsername;

    @FindBy(name="password")
    WebElement txtPassword;

    @FindBy(css="button[type='submit']")
    WebElement btnLogin;

    public void setUserName(String user) {
        txtUsername.clear();
        txtUsername.sendKeys(user);
    }

    public void setPassword(String pass) {
        txtPassword.clear();
        txtPassword.sendKeys(pass);
    }

    public void clickLogin() {
        btnLogin.click();
    }
}
