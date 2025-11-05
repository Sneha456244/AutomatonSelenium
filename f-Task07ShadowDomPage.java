package task06;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShadowDomPage {

    WebDriver driver;

    // Constructor
    public ShadowDomPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for shadow host
    By shadowHost = By.cssSelector("book-app[apptitle='BOOKS']");

    // Method to enter text inside shadow DOM input
    public void enterTextInShadowInput(String text) throws InterruptedException {
        // Access shadow root
        SearchContext shadow = driver.findElement(shadowHost).getShadowRoot();

        Thread.sleep(1000);
        // Find input inside shadow root and type text
        WebElement input = shadow.findElement(By.cssSelector("#input"));
        input.sendKeys(text);
    }
}
