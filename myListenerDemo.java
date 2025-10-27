package TestNG04;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*1.Create a Testcase
2.Create a Listener
3.Create a xml file and include both Testcase and Listener*/


public class CreateTestCaseOrangeHRM 
{
	WebDriver driver;
	
	@BeforeClass
	
	void setup() throws InterruptedException 
	{
		
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
  @Test(priority=1)
  public void TestLogo() 
  {
	  boolean status=driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']")).isDisplayed();
	  Assert.assertEquals(status, true);
  }
  
  @Test(priority=2)
  public void TestAppURL()
  {
	  Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com");
  }
  
  @Test(priority=3, dependsOnMethods= {"TestAppURL"})
  public void testHomePageTitle()
  {
	  Assert.assertEquals(driver.getTitle(),"OrangeHRM");
  }
  
  @AfterClass
  void tearDown()
  {
	  driver.quit();
  }
}
