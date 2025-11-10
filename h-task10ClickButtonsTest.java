package task09;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ClickButtonsTest {

    WebDriver driver;
    ClickButtonsPage clickPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://webdriveruniversity.com/Click-Buttons/index.html");
        clickPage = new ClickButtonsPage(driver);
    }

    @Test(priority = 1)
    public void verifyButton1Alert() throws InterruptedException {
        String expected = "Congratulations! Well done for successfully using the click() method!";
        String actual = clickPage.clickButton1();
        Assert.assertEquals(actual.trim(), expected);
    }

    @Test(priority = 2)
    public void verifyButton2Alert() throws InterruptedException {
        String expected = "It’s that Easy!! Well I think it is..... We can use JavaScript code if all else fails! Remember always try to use the WebDriver Library method(s) first such as WebElement.click(). (The Selenium development team have spent allot of time developing WebDriver functions etc).";
        String actual = clickPage.clickButton2();
        Assert.assertEquals(actual.trim(), expected);
    }

    @Test(priority = 3)
    public void verifyButton3Alert() throws InterruptedException {
        String expected = "Well done! the Action Move & Click can become very useful! Advanced user interactions (API) has been developed to enable you to perform more complex interactions such as: Drag & Drop Hover & Click Click & Hold....";
        String actual = clickPage.clickButton3();
        Assert.assertEquals(actual.trim(), expected);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
