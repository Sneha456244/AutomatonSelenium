package Day09;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoostrapDropDown {

    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://codepen.io/WebIntricate/pen/Pxzpro");
        driver.manage().window().maximize();
        
        // Switch to the CodePen preview iframe
        WebElement iframe = driver.findElement(By.id("result")); 
        driver.switchTo().frame(iframe);

        // Click the dropdown button
        driver.findElement(By.xpath("//button[.//span[contains(@class,'dropdown-text')]]")).click();
        
        // 1) Select Single option
        WebElement option1 = driver.findElement(By.xpath("//input[@class='option justone' and @value='Option 1 ']"));
        if(!option1.isSelected()) {
            option1.click();
        }
        
        // 2) Capture all options
        List<WebElement> allOptions = driver.findElements(By.xpath("//input[@class='option justone']"));
        
        // Get size of dropdown options
        System.out.println("Total options in dropdown: " + allOptions.size());
        
        // 3) Print all option values
        System.out.println("Dropdown options:");
        for(WebElement option : allOptions) {
            System.out.println(option.getAttribute("value").trim());
        }
        
        // Optional: select all options dynamically
        // for(WebElement option : allOptions) {
        //     if(!option.isSelected()) {
        //         option.click();
        //     }
        // }
    }
}
