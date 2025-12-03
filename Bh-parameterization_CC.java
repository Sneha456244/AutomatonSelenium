package StepDef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class test_Demo {
	
	static WebDriver driver;
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("https://www.saucedemo.com/");
	}

	//@When("User enters valid username and password")
	//public void user_enters_valid_username_and_password() 
	
	@When("User enters valid {string} and {string}")
	public void user_enters_valid_and(String string, String string2)
	
	{
	   
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
	}

	@And("Clicks on Login Button")
	public void clicks_on_login_button() {
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
	}

	@Then("User is navigated to Home Page")
	public void user_is_navigated_to_home_page() {
	    Assert.assertTrue(driver.findElements(By.xpath("//div[@class='app_logo']")).size()>0,"User is navigated to Home Page");
	}

	@And("Close the browser")
	public void close_the_browser() {
	    driver.quit();
	}


		
}
