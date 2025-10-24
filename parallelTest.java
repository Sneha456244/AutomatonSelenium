package TestNG03;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class ParaTest {
	
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser"}) 
	
	void setup(String br)
	
	{
		switch(br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver();break;
		case "edge":driver=new EdgeDriver();break;
		case "firefox":driver=new FirefoxDriver();break;
		default:System.out.println("invalid");return;
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
  @Test(priority=1)
  public void TestLogo() 
  {
	  boolean status=driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']")).isDisplayed();
	  Assert.assertEquals(status, true);
  }
  
  @Test(priority=2)
  public void TestTitle()
  {
	  Assert.assertEquals(driver.getTitle(), "OrangeHRM");
  }
  
  @Test(priority=3)
  public void testURL()
  {
	  Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }
  
  @AfterClass
  void tearDown()
  {
	  driver.quit();
  }
}
