package Day12;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInZoomOut {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Zoom out to 50%
        js.executeScript("document.body.style.zoom='50%'");
        System.out.println("Zoomed out to 50%");
        Thread.sleep(5000);

        // Zoom in to 180%
        js.executeScript("document.body.style.zoom='180%'");
        System.out.println("Zoomed in to 180%");
        Thread.sleep(5000);

        // Reset to 100%
        js.executeScript("document.body.style.zoom='100%'");
        System.out.println("Zoom reset to 100%");
        Thread.sleep(3000);

        //driver.quit();
    }
}
