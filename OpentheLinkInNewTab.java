package Day11half;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpentheLinkInNewTab {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        // Locate Register link
        WebElement regLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));

        // Open link in new tab using CTRL + Click
        Actions act = new Actions(driver);
        act.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();

        // Wait for new tab to open
        Thread.sleep(2000);

        // Get all window handles
        List<String> ids = new ArrayList<>(driver.getWindowHandles());

        // Switch to Registration tab
        driver.switchTo().window(ids.get(1));
        driver.findElement(By.id("FirstName")).sendKeys("Yash");

        // Switch back to Home page
        driver.switchTo().window(ids.get(0));
        driver.findElement(By.id("small-searchterms")).sendKeys("mac");

        // Optional: close browser
        // driver.quit();
    }
}

