package task05;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ScrollPage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    // Constructor
    public ScrollPage(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
    }

    // Locators
    @FindBy(xpath = "//div[@class='ui-datatable-scrollable-body']")
    WebElement verticalScrollArea;

    @FindBy(xpath = "//div[contains(@class,'ui-datatable-scrollable-body')]")
    WebElement horizontalScrollArea;

    @FindBy(xpath = "//table[@role='grid']//tr[5]")
    WebElement fifthRow;

    @FindBy(xpath = "//table[@role='grid']//th[last()]")
    WebElement lastColumnHeader;

    // Actions

    // 1) Scroll vertically by pixels
    public void scrollVertically(int y) throws InterruptedException 
    {
        js.executeScript("arguments[0].scrollTop = arguments[0].scrollTop + " + y, verticalScrollArea);
        System.out.println("Scrolled vertically by " + y + " pixels");
        Thread.sleep(1000);
    }

    // 2) Scroll horizontally by pixels
    public void scrollHorizontally(int x) throws InterruptedException 
    {
        js.executeScript("arguments[0].scrollLeft = arguments[0].scrollLeft + " + x, horizontalScrollArea);
        System.out.println("Scrolled horizontally by " + x + " pixels");
        Thread.sleep(1000);
    }

    // 3) Scroll till specific row is visible
    public void scrollTillRowVisible() throws InterruptedException 
    {
        js.executeScript("arguments[0].scrollIntoView(true);", fifthRow);
        System.out.println("Scrolled till row 5 is visible");
        Thread.sleep(1000);
    }

    // 4) Scroll till last column is visible
    public void scrollTillLastColumnVisible() throws InterruptedException 
    {
        js.executeScript("arguments[0].scrollIntoView(true);", lastColumnHeader);
        System.out.println("Scrolled till last column header is visible");
        Thread.sleep(1000);
    }

    // 5) Scroll back to top and left
    public void scrollBackToStart() throws InterruptedException 
    {
        js.executeScript("arguments[0].scrollTop = 0; arguments[0].scrollLeft = 0;", verticalScrollArea);
        System.out.println("Scrolled back to top and left");
        Thread.sleep(1000);
    }
}

