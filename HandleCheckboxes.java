package Day08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		//1)Select specific Checkbox
		//driver.findElement(By.xpath("//input[@id='checkbox1']")).click();
		
		//2)Select all checkbox 
		/*List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(int i=0;i<checkboxes.size();i++)
		{
			checkboxes.get(i).click();
		}*/
		
		//3)Select last two checkboxes
		//total no of checkboxes - how many checkboxes want to select=Starting index
		//3-2=1 *index starts with 0
		
		/*List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(int i=1;i<checkboxes.size();i++) 
		{
			checkboxes.get(i).click();
		}*/
		
		//4)Select first 2 checkboxes
		
		/*List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		//for(int i=0;i<=1;i++)
		for(int i=0;i<2;i++) 
		{
			checkboxes.get(i).click();
		}*/
		
		//5)Unselected checkboxe if they are selected
		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

		// Select first 2 checkboxes
		for (int i = 0; i < 2; i++) {
		    checkboxes.get(i).click();
		}

		Thread.sleep(3000);

		// Deselect all selected checkboxes
		for (WebElement checkbox : checkboxes) 
		{
		    if (checkbox.isSelected())
		    {
		        checkbox.click();
		    }
		}


		
		
	}		
}
