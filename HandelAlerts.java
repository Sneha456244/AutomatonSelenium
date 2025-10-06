package Day08;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandelAlerts {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		
		//1) Normal Alert with Ok button
		
		/*driver.findElement(By.xpath("//button[contains(text(),'click the button to display an')]")).click();
		Thread.sleep(5000);
		
		//if we want to perform single action then want to close the modal
		//driver.switchTo().alert().accept();
		
		//Here we can't inspect so we use switchTo() method and main thing is accept()method
		//if we want to perform multiple actions like get the text So want frst'u store that variable and get that variable
		Alert myalert=driver.switchTo().alert();
		System.out.println(myalert.getText());
		myalert.accept();*/
		
		//2) Confirmation Alert- Ok - cancel button
		
		/*driver.findElement(By.xpath("//a[normalize-space()='Alert with OK & Cancel']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='click the button to display a confirm box']")).click();
		Thread.sleep(5000);
		
		driver.switchTo().alert().accept(); //This is for OK button (Close alert)
		//driver.switchTo().alert().dismiss(); //This is for Cancel button */
		
		//3)Prompt Alert-Input box
		driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']")).click();
		Thread.sleep(5000);
		
		Alert myalert=driver.switchTo().alert();
		myalert.sendKeys("Automation");
		myalert.accept();
		
	}

}
