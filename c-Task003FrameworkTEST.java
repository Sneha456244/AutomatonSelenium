package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	@SuppressWarnings("deprecation")
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	@SuppressWarnings("deprecation")
	public String randomNumber()
	{
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	@SuppressWarnings("deprecation")
	public String randomAlphaNumberic()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		String generatedNumber=RandomStringUtils.randomNumeric(3);
		return (generatedString+"@"+generatedNumber);
	}

}
package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test
	public void verify_account_registration()
	{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com"); //randomly generated the email
		regpage.setTelephone(randomNumber());
		
		String password=randomAlphaNumberic();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}
	
}
