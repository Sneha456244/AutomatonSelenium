package Day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//**if we get "ElementInterceptException" then we go with js**
public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		//if we directly call the ChromeDriver don't need to do upcasting 
		//ChromeDriver driver=new ChromeDriver();
		
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		WebElement inputbox=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		
		
		//**Passing the text into inputbox -> alternate of sendKeys()**
		JavascriptExecutor js=(JavascriptExecutor)driver; //here we do Upcasting 
		
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].setAttribute('value','yash')",inputbox);
		
		
		//clicking on element -> alternate of click()
		WebElement radiobutton=driver.findElement(By.xpath("//input[@id='checkbox1']"));
		js.executeScript("arguments[0].click()",radiobutton);

	}

}
