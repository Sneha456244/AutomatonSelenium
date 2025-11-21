package task15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ChatBotTest {

    WebDriver driver;
    ChatBotPage page;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://deepai.org/chat");

        page = new ChatBotPage(driver);
    }

    @Test
    public void validatePage() {
        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());
        Assert.assertTrue(driver.getTitle().contains("AI Chat"));
    }

    @Test
    public void sendHiMessage() {
        page.sendMessage("hi");
        System.out.println("Message Sent: hi");
    }

    @Test
    public void captureBotResponse() {
        page.sendMessage("hi");
        String botReply = page.getLastBotResponse();
        System.out.println("Bot Response: " + botReply);

        Assert.assertNotNull(botReply);
    }

    @Test
    public void sendMultipleMessages() throws InterruptedException {
        String[] messages = {"Hello", "How are you?", "Tell me a joke"};
        for (String msg : messages) {
            page.sendMessage(msg);
            System.out.println("Message Sent: " + msg);
            String botReply = page.getLastBotResponse();
            System.out.println("Bot Response: " + botReply);
            Assert.assertNotNull(botReply);
            Thread.sleep(1000); 
        }
    }

    @Test
    public void validateBotResponseContainsKeyword() {
        page.sendMessage("Tell me about AI");
        String botReply = page.getLastBotResponse();
        System.out.println("Bot Response: " + botReply);

        Assert.assertTrue(botReply.toLowerCase().contains("ai") || botReply.toLowerCase().contains("artificial"),
                "Bot response does not contain expected keyword!");
    }

    @Test
    public void sendEmptyMessage() {
        page.sendMessage("");  // no message sent
        System.out.println("Empty message test passed (no error thrown)");
        // No assertion on bot response, because bot does not reply to empty input
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
