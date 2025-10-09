package Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAction {

    public static void main(String[] args) throws InterruptedException {

        
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        driver.manage().window().maximize();

        // 1. Wait for iframe to load
        Thread.sleep(5000);

        // 2. Switch to iframe
        WebElement iframe = driver.findElement(By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//iframe[@class='demo-frame']"));
        driver.switchTo().frame(iframe);

        // 3. Locate draggable image and target (Trash bin)
        WebElement source = driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
        WebElement trash = driver.findElement(By.id("trash")); 

        // 4. Perform drag-and-drop
        Actions act = new Actions(driver);
        act.dragAndDrop(source, trash).perform();

        // 7. Wait to see result
        Thread.sleep(3000);

        // 8. Close browser
        //driver.quit();
    }
}
