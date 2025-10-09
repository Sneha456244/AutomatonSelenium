package Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		WebElement switchTo=driver.findElement(By.xpath("//a[normalize-space()='SwitchTo']"));
		WebElement alerts=driver.findElement(By.xpath("//a[normalize-space()='Alerts']"));
		
		Actions act=new Actions(driver); //Action is Pre-defined Class provided in selenium and calling the object 'driver'
		
		//* here first Create an action using bulid() then Complete an action using perform()
		//act.moveToElement(switchTo).moveToElement(alerts).click().build().perform();
		
		//* here directly complete the action using perform() perform has ability to create as well
		act.moveToElement(switchTo).moveToElement(alerts).perform();
		
		
		

	}

}
