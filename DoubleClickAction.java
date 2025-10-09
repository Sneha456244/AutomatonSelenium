package Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick");

        // Switch to iframe using WebElement
        WebElement iframe = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(iframe);

        // Locate the button
        WebElement button = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));

        // Perform double-click
        Actions act = new Actions(driver);
        act.doubleClick(button).perform();

        // Optional: wait a few seconds to see result
        Thread.sleep(2000); 

        // Print the text inside <p id="demo">
        WebElement demoText = driver.findElement(By.id("demo"));
        System.out.println("After double-click: " + demoText.getText());

        //driver.quit();
    }
}
