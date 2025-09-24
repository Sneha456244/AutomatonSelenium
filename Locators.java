package day02;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
		//1) Launch browser (chrome)
		
				//ChromeDriver driver=new ChromeDriver();
				WebDriver driver=new ChromeDriver();
				
		
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		
		//id 
		driver.findElement(By.id("username")).sendKeys("student");
		
		//name
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		
		//linktext & partialLinkText
		//driver.findElement(By.linkText("Log out")).click();
		//driver.findElement(By.partialLinkText("Log ou")).click();
		
		//classname
		//List<WebElement> headerLinks=driver.findElements(By.className("menu-primary-items"));
		//System.out.println("total number of header links:"+headerLinks.size());
		
		//tagname
		//List<WebElement> headerLinks=driver.findElements(By.tagName("a"));
		//System.out.println("total number of header links:"+headerLinks.size());
		
		//for img 
		List<WebElement> images=driver.findElements(By.tagName("img"));
		System.out.println("total number of images:"+images.size());
	}

}
