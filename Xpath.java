package Day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {

	public XpathDemo() {
		
	}

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		
		//Xpath with Single attribute
		//driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
		
		//Xpath with Multiple attribute
		//driver.findElement(By.xpath("//input[@id='username'][@name='username']")).sendKeys("student");
		
		//Xpath with 'and' 'or' operators
		//driver.findElement(By.xpath("//input[@id='username'and @name='username']")).sendKeys("student");
		
		//driver.findElement(By.xpath("//input[@id='username'or @name='xyz']")).sendKeys("student");
		
		//Xpath with text() - inner text 
		/*boolean displaystatus=driver.findElement(By.xpath("//h2[normalize-space()='Test login']")).isDisplayed();
		System.out.println(displaystatus);
		
		String value=driver.findElement(By.xpath("//h2[normalize-space()='Test login']")).getText();
		System.out.println(value);*/
		
		//Xpath with Contains()
		//driver.findElement(By.xpath("//input[contains(@id,'username')]")).sendKeys("student");
		
		//Xpath with Starts-with()
		//driver.findElement(By.xpath("//input[starts-with(@id,'user')]")).sendKeys("student");
		
		//chained Xpath
		boolean status=driver.findElement(By.xpath("//div[@id='site-title']/a/img")).isDisplayed();
		System.out.println(status);
	
	}

}
