package Day09;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		//This applies only when the dropdown is implemented using the <select> tag in the HTML.
		
		WebElement drpSkillEle=driver.findElement(By.xpath("//select[@id='Skills']"));
		Select drpSkill=new Select(drpSkillEle);
		
		//Select option from the Drop down
		
		//drpSkill.selectByVisibleText("APIs");
		//drpSkill.selectByValue("APIs");
		//drpSkill.selectByIndex(4);
		
		//Capture option from the dropdown 
		List<WebElement>options=drpSkill.getOptions();
		System.out.println("Number of option in a dropdown :"+options.size());
		
		//printing the options
		/*for(int i=0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
		}*/
		
		//enhanced for loop
		for (WebElement op:options)
		{
			System.out.println(op.getText());
		}

	}

}
