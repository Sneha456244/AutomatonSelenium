package Day11half;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/?utm_source=chatgpt.com");
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		
		//min Slider
		WebElement min_slider=driver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
		
		System.out.println("Defalut Location of the min_slider"+min_slider.getLocation()); //(59min(x), 256(y))
		act.dragAndDropBy(min_slider, 100, 256).perform();
		System.out.println("Location of the min_slider after moving"+min_slider.getLocation());//(158, 256)
		
		//max Slider
		WebElement max_slider=driver.findElement(By.xpath("//div[@id='slider-range']//span[2]"));
		
		System.out.println("Defalut Location of the max_slider"+max_slider.getLocation()); //(613max(x), 256(y))
		act.dragAndDropBy(max_slider, -70, 256).perform();
		System.out.println("Location of the max_slider after moving"+max_slider.getLocation()); //(541, 256)
	}

}
