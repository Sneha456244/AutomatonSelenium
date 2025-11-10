package task09;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickButtonsPage {

    WebDriver driver;

    @FindBy(xpath = "//span[@id='button1']")
    WebElement button1;

    @FindBy(xpath = "//span[@id='button2']")
    WebElement button2;

    @FindBy(xpath = "//span[@id='button3']")
    WebElement button3;

    @FindBy(xpath = "//div[@id='myModalClick']//div[@class='modal-body']")
    WebElement modal1Text;

    @FindBy(xpath = "//div[@id='myModalClick']//button[text()='Close']")
    WebElement modal1Close;

    @FindBy(xpath = "//div[@id='myModalJSClick']//div[@class='modal-body']")
    WebElement modal2Text;

    @FindBy(xpath = "//div[@id='myModalJSClick']//button[text()='Close']")
    WebElement modal2Close;

    @FindBy(xpath = "//div[@id='myModalMoveClick']//div[@class='modal-body']")
    WebElement modal3Text;

    @FindBy(xpath = "//div[@id='myModalMoveClick']//button[text()='Close']")
    WebElement modal3Close;

    // Constructor
    public ClickButtonsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String clickButton1() throws InterruptedException {
        button1.click();
        Thread.sleep(1000);
        String text = modal1Text.getText();
        modal1Close.click();
        return text;
    }

    public String clickButton2() throws InterruptedException {
        button2.click();
        Thread.sleep(1000);
        String text = modal2Text.getText();
        modal2Close.click();
        return text;
    }

    public String clickButton3() throws InterruptedException {
        button3.click();
        Thread.sleep(1000);
        String text = modal3Text.getText();
        modal3Close.click();
        return text;
    }
}
