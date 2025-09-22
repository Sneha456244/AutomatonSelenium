package day01;

//Manual Testcase*

//1) Launch browser (chrome)
//if need to launch in edge : WebDriver driver=new EdgeDriver();
//2) Open URL https://www.orangehrm.com/
//3) Validate title should be "Human Resources Management Software | HRMS | OrangeHRM"
//4) Close browser

//Code:
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestcase {

	public static void main(String[] args) {
		
		//1) Launch browser (chrome)
		
		//ChromeDriver driver=new ChromeDriver();
		WebDriver driver=new ChromeDriver();
		
		//2) Open URL https://www.orangehrm.com/
		
		driver.get("https://www.orangehrm.com/");
		
		//3) Validate title should be "Human Resources Management Software | HRMS | OrangeHRM"
		
		String act_title=driver.getTitle();
		
		if(act_title.equals("Human Resources Management Software | HRMS | OrangeHRM"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		//4) Close browser
		//driver.close();
		//driver.quit();
	}

}
