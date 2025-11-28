package task18;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AlertTest {

    WebDriver driver;
    AlertPage alertPage;

    @BeforeClass
    public void setUp() 
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        System.out.println("Browser Launched Successfully");

        alertPage = new AlertPage(driver);
    }

    @Test(priority = 1)
    public void handleSimpleAlert() 
    {

        alertPage.clickJSAlert();

        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        System.out.println("Alert Message: " + alertMsg);

        Assert.assertEquals(alertMsg, "I am a JS Alert",
                "FAIL: Simple Alert text mismatch");

        alert.accept();
        System.out.println("Alert Accepted Successfully");

        Assert.assertTrue(alertPage.getResultText().contains("You successfully clicked an alert"));
        System.out.println("PASS: Validation after Accepting Alert");
    }

    @Test(priority = 2)
    public void handleConfirmationAlert() 
    {

        alertPage.clickJSConfirm();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println("Confirm Alert Accepted");

        Assert.assertTrue(alertPage.getResultText().contains("You clicked: Ok"));
        System.out.println("PASS: Result message matched After Accept");
    }

    @Test(priority = 3)
    public void handleDismissAlert() 
    {

        alertPage.clickJSConfirm();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        System.out.println("Confirm Alert Dismissed");

        Assert.assertTrue(alertPage.getResultText().contains("You clicked: Cancel"));
        System.out.println("PASS: Result message matched After Dismiss");
    }

    @Test(priority = 4)
    public void handlePromptAlert() 
    {

        alertPage.clickJSPrompt();

        Alert alert = driver.switchTo().alert();
        String input = "Sneha";
        alert.sendKeys(input);
        System.out.println("Entered text in Prompt: " + input);

        alert.accept();

        Assert.assertTrue(alertPage.getResultText().contains(input));
        System.out.println("PASS: Prompt input displayed correctly");
    }

    @AfterClass
    public void tearDown() 
    {
        driver.quit();
        System.out.println("Browser Closed Successfully");
    }
}
