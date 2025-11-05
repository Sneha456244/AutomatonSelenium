package task06;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class ShadowDomPage1 {

    WebDriver driver;

    public ShadowDomPage1(WebDriver driver) {
        this.driver = driver;
    }

    // Handle single shadow DOM
    public void handleSingleShadowDom() throws InterruptedException {
        SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
        Thread.sleep(1000);
        shadow0.findElement(By.cssSelector("#shadow-element")).click();
        System.out.println("Clicked element inside single shadow DOM.");
    }

    // Handle two nested shadow DOMs
    public void handleTwoNestedShadowDom() throws InterruptedException {
        SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
        Thread.sleep(1000);
        shadow1.findElement(By.cssSelector("#nested-shadow-element")).click();
        System.out.println("Clicked element inside 2 nested shadow DOMs.");
    }

    // Handle three - multi nested shadow DOMs
    public void handleThreeNestedShadowDom() throws InterruptedException {
        SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow2 = shadow1.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
        Thread.sleep(1000);
        shadow2.findElement(By.cssSelector("#multi-nested-shadow-element")).click();
        System.out.println("Clicked element inside 3 nested shadow DOMs.");
    }
}
