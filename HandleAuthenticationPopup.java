package Day08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAuthenticationPopup {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		//driver.get("http://the-internet.herokuapp.com/basic_auth");
		
		//syntax
		//http://username:password@the-internet.herokuapp.com/basic_auth
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		/*this is the simplest way to handle authenticated pop up , switching command will not work
		  wait command will not work so we have to inject the username and password along with the URL*/

	}

}
