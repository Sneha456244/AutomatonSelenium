package Day09;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandelHiddenDropDown {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
        driver.manage().window().maximize();

        // Login
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        // 1️ Click on PIM
        driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
        
        // 2 Clicked on dropdown
        WebElement dropdown = driver.findElement(By.xpath(
        	    "//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[6]/div[1]/div[2]/div[1]/div[1]"
        	));
        	dropdown.click();
        	Thread.sleep(5000);
        	
        // 3 Select single option
        //driver.findElement(By.xpath("//span[normalize-space()='Financial Analyst']")).click();
        
        // 4 Count number of options
        List<WebElement> options=driver.findElements (By.xpath("//div[@role='listbox']//span"));

        System.out.println("Number of options:"+ options.size());
        Thread.sleep(5000);
        
        //Printing options
        for(WebElement op:options) {
        	System.out.println(op.getText());
        }


        }
}
