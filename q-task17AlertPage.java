package task18;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {

    WebDriver driver;

    // Locators using @FindBy
    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    WebElement jsAlertButton;

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    WebElement jsConfirmButton;

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    WebElement jsPromptButton;

    @FindBy(id = "result")
    WebElement resultMessage;

    // Constructor
    public AlertPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickJSAlert() {
        jsAlertButton.click();
        System.out.println("Clicked JS Alert Button");
    }

    public void clickJSConfirm() {
        jsConfirmButton.click();
        System.out.println("Clicked JS Confirm Button");
    }

    public void clickJSPrompt() {
        jsPromptButton.click();
        System.out.println("Clicked JS Prompt Button");
    }

    public String getResultText() {
        String result = resultMessage.getText();
        System.out.println("UI Result Text: " + result);
        return result;
    }
}
