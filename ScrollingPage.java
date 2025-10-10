package Day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1) Scroll down page by pixel number
        js.executeScript("window.scrollBy(0,1500)");
        System.out.println("Afer scrolling Y Offset: "+js.executeScript("return window.pageYOffset;")); // 1500 approx.

        Thread.sleep(2000);

        // 2) Scroll the page till element is visible
        WebElement ele = driver.findElement(By.xpath("//strong[normalize-space()='Community poll']"));
        js.executeScript("arguments[0].scrollIntoView();", ele);
        System.out.println("Scroll the page till 'Community poll' element is visible"+js.executeScript("return window.pageYOffset;"));

        Thread.sleep(2000);

        // 3) Scroll page till end of the page
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        System.out.println("Scroll page till end of the page"+ js.executeScript("return window.pageYOffset;"));

        Thread.sleep(2000);

        // 4) Scroll up to initial position
        js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
        //js.executeScript("window.scrollTo(0, 0)");
        //System.out.println("Scrolled back to top of page.");

        Thread.sleep(2000);

        driver.quit();
    }
}
