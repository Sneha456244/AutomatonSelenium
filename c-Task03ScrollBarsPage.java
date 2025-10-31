package Task03;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScrollBarsPage  {
	
	WebDriver driver;
	JavascriptExecutor js;
	
	//Constructor
	public ScrollBarsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.js = (JavascriptExecutor) driver;
	}
	
	//Locators
	@FindBy(xpath="//div[@class='ui-datatable-scrollable-body']")
	WebElement scrollableTable;
	
	@FindBy(xpath="//div[contains(@class,'ui-datatable-scrollable-body')]")
	WebElement horizontalScroll;
	
	//Actions
	// 1. Scroll entire page vertically by specific pixels
    public void scrollPageByPixel(int yOffset) 
{
        js.executeScript("window.scrollBy(0," + yOffset + ")");
        System.out.println("Scrolled page vertically by: " + yOffset + "px");
    }

    // 2. Scroll inside table vertically to bottom
    public void scrollTableToBottom() 
{
        js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", scrollableTable);
        System.out.println("Scrolled vertically inside DataTable till bottom.");
    }

    // 3. Scroll inside table vertically to top
    public void scrollTableToTop() 
{
        js.executeScript("arguments[0].scrollTop = 0", scrollableTable);
        System.out.println("Scrolled vertically inside DataTable back to top.");
    }

    // 4. Scroll horizontally to right
    public void scrollTableHorizontallyRight() 
{
        js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", horizontalScroll);
        System.out.println("Scrolled horizontally to the right inside DataTable.");
    }

    // 5. Scroll horizontally back to left
    public void scrollTableHorizontallyLeft() 
{
        js.executeScript("arguments[0].scrollLeft = 0", horizontalScroll);
        System.out.println("Scrolled horizontally back to the left inside DataTable.");
    }

    // 6. Scroll entire webpage to bottom
    public void scrollPageToBottom() 
{
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        System.out.println("Scrolled to bottom of the webpage.");
    }

    // 7. Scroll entire webpage to top
    public void scrollPageToTop() 
{
        js.executeScript("window.scrollTo(0, 0)");
        System.out.println("Scrolled back to top of the webpage.");
    }
}
	
	
	
	
	


