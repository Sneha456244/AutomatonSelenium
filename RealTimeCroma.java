package RealTime;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Croma {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.croma.com/");
        driver.manage().window().maximize();
        
        // Logo
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Logo']"));
        if (logo.isDisplayed()) {
            System.out.println("Croma logo is visible on the page!");
        } else {
            System.out.println("Logo not found!");
        }
        
        // Search
        WebElement search = driver.findElement(By.xpath("//input[@id='searchV2']"));
        search.sendKeys("Laptops");
        
        // Using Actions method (Keyboard)
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        
        System.out.println("Page title(After search): " + driver.getTitle());
        
        // Click on FILTER
        driver.findElement(By.xpath("//div[@class='all-filters']")).click();
        
        // Get all div elements
        List<WebElement> categoriesDetailsList = driver.findElements(
                By.xpath("//div[@id='panel0bh-content']//div[@class='MuiAccordionDetails-root mobile-filter-collapse-container']")
        );

        System.out.println("Total categories detail divs: " + categoriesDetailsList.size());

        for (WebElement details : categoriesDetailsList) {
            System.out.println(details.getText());
        }
        
        Thread.sleep(3000);
        
        // Get all checkboxes
        List<WebElement> checkboxes = driver.findElements(By.className("check"));
        System.out.println("Total checkboxes found: " + checkboxes.size());
        
        // Click "All Filters"
        driver.findElement(By.xpath("//h3[normalize-space()='All Filters']")).click();
        
        Thread.sleep(3000);
        
        // Close the filter panel
        driver.findElement(By.xpath("(//span[@class='icon icon-close'])[3]")).click();
        System.out.println("Filter panel closed successfully");
        
        Thread.sleep(3000);

        // Click on the specific product
        driver.findElement(By.xpath("//img[@title='Apple MacBook Air (13.3 inch, M1, 8GB, 256GB, macOS Big Sur, Gold)']")).click();

        Thread.sleep(3000);
        
     // After opening the product page or search results
        Thread.sleep(3000);

        WebElement userAccount = driver.findElement(By.xpath("//a[contains(@class,'user-link')]"));
 
        actions.moveToElement(userAccount).click().perform();
        System.out.println("Clicked on User Account using mouse action");

        // Wait a bit for dropdown or navigation (if needed)
        Thread.sleep(2000);

        WebElement loginActive = driver.findElement(By.xpath("//span[@data-testid='login-active']"));
        
        actions.moveToElement(loginActive).click().perform();

        System.out.println("Clicked on loginActive element using mouse action");
        
        driver.quit();

         
        

    }
}

