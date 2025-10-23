package TestNG03;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo2 
{

    WebDriver driver;

    @BeforeClass
    void setup() 
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "dp")
    void testLogin(String username, String pwd) throws InterruptedException 
    {
        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        Thread.sleep(2000);

        // Check if login succeeded
        if(driver.findElements(By.xpath("//a[normalize-space()='Log out']")).size() > 0)
        {
            boolean status = driver.findElement(By.xpath("//a[normalize-space()='Log out']")).isDisplayed();
            if(status)
            {
                driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click();
                Assert.assertTrue(true, "Login successful for: " + username);
            }
            else
            {
                Assert.fail("Login failed for: " + username);
            }
        }
        else
        {
            // Fail test if login unsuccessful
            Assert.fail("Login failed for: " + username);
        }

        Thread.sleep(3000);
    }

    @AfterClass
    void tearDown() 
    {
        driver.quit();
    }

    @DataProvider(name = "dp")
    Object[][] loginData() 
    {
        Object data[][] = 
        {
                {"student", "Password123"},   //valid credential
                {"wronguser", "wrongpass"},
                {"student", "wrongpass"},
                {"wronguser", "Password123"}
        };
        return data;
    }
}
