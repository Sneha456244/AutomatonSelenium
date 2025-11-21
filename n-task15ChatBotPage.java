package task15;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class ChatBotPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//textarea[@id='persistentChatbox']")
    WebElement inputBox;

    @FindBy(xpath = "//button[@id='chatSubmitButton']")
    WebElement sendButton;

    public ChatBotPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void sendMessage(String msg) {
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        inputBox.clear();

        if (!msg.isEmpty()) {
            inputBox.sendKeys(msg);
            wait.until(ExpectedConditions.elementToBeClickable(sendButton));
            sendButton.click();
        } else {
            System.out.println("Empty message: skipping send");
        }
    }

    public String getLastBotResponse() {
        By lastMessage = By.xpath("(//div[contains(@class,'outputBox')]//p)[last()]");

        WebElement msgElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(lastMessage)
        );
        return msgElement.getText();
    }
}
