package task09;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ResponsivenessPage {

    WebDriver driver;

    // Constructor
    public ResponsivenessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to open the website
    public void openWebsite() {
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
        System.out.println("Website opened in full screen.");
    }

    // Resize to tablet view
    public void resizeToTablet() throws InterruptedException {
        driver.manage().window().setSize(new Dimension(1024, 768));
        Thread.sleep(2000);
        System.out.println("Resized to Tablet view: " + driver.manage().window().getSize());
    }

    // Resize to mobile view
    public void resizeToMobile() throws InterruptedException {
        driver.manage().window().setSize(new Dimension(480, 800));
        Thread.sleep(2000);
        System.out.println("Resized to Mobile view: " + driver.manage().window().getSize());
    }

    // Resize back to full screen
    public void resizeToFullScreen() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(2000);
        System.out.println("Resized back to Fullscreen: " + driver.manage().window().getSize());
    }
}
