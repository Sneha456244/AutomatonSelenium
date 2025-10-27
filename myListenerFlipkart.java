package TestNG04AF;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Flipkart
{
	WebDriver driver;

	@BeforeClass
	void setup() throws InterruptedException 
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void TestLogo() 
	{
		boolean status = driver.findElement(By.xpath("//img[@title='Flipkart']")).isDisplayed();
		Assert.assertEquals(status, true, " Flipkart logo not displayed!");
	}

	@Test(priority = 2)
	public void TestAppURL() 
	{
		// Verifying current URL
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.flipkat.com/");
	}

	@Test(priority = 3, dependsOnMethods = { "TestAppURL" })
	public void testHomePageTitle() 
	{
		// Checking Flipkart page title
		Assert.assertTrue(driver.getTitle().contains("Flipkart"), "Flipkart");
	}

	@AfterClass
	void tearDown() 
	{
		driver.quit();
	}
}

