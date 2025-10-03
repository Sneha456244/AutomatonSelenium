package Day05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxesDemo {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.manage().window().maximize();
		
		//Self - Selects the current node
		String text=driver.findElement(By.xpath("//a[normalize-space()='Avantel Ltd.']/self::a")).getText();
		System.out.println("Self: "+text); 
		
		//Parent - Select the parent of the current node(always one)
		text=driver.findElement(By.xpath("//a[normalize-space()='Avantel Ltd.']/parent::td")).getText();
		System.out.println("Parent: "+text); 
		
		//Child - Selects all children of the current node (one or more)
		List<WebElement> childs = driver.findElements(By.xpath("//a[normalize-space()='Avantel Ltd.']/ancestor::tr/child::td"));
		System.out.println("Number of child elements: " + childs.size());
		
		//Ancestor - Selects all ancestors (parent, grandparents, etc.)
		text=driver.findElement(By.xpath("//a[normalize-space()='Avantel Ltd.']/ancestor::tr")).getText();
		System.out.println("ancestor: "+text); 
		
		//Descendant - Selects all descendants (Children,grandchildren,etc.)of the current node
		List<WebElement> descendants = driver.findElements(By.xpath("//a[normalize-space()='Avantel Ltd.']/ancestor::tr/descendant::*"));
		System.out.println("Number of descendant nodes: " + descendants.size());
		
		//Following - Selects everything in the document after the closing tag of the current node
		List<WebElement>followingnodes= driver.findElements(By.xpath("//a[normalize-space()='Avantel Ltd.']/ancestor::tr/following::tr"));
		System.out.println("Number of following nodes: " + followingnodes.size());
		
		//Preceding - Selects all nodes that appear before the current node in the document 
		List<WebElement>precedings= driver.findElements(By.xpath("//a[normalize-space()='Avantel Ltd.']/ancestor::tr/preceding::tr"));
		System.out.println("Number of preceding nodes: " + precedings.size());
		
		//Following-sibling : selects all siblings after the current node
		List<WebElement>followingsiblings= driver.findElements(By.xpath("//a[normalize-space()='Avantel Ltd.']/ancestor::tr/following-sibling::tr"));
		System.out.println("Number of following Siblings: " + followingsiblings.size());
		
		//preceding-sibling : selects all siblings after the current node
		List<WebElement>precedingsiblings= driver.findElements(By.xpath("//a[normalize-space()='Avantel Ltd.']/ancestor::tr/preceding-sibling::tr"));
		System.out.println("Number of preceding siblings: " + precedingsiblings.size());
		
		driver.quit();
		
	}

}
