package Demo1;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.*;

public class SeleniumFlipkartDemo {

    public static void main(String[] args) throws Exception {

        // 1. Launch Chrome browser
        WebDriver driver = new ChromeDriver(); // WebDriver variable controlling Chrome
        driver.manage().window().maximize(); // maximize browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // implicit wait
        System.out.println("Selenium Flipkart Demo Started");

        // 2. Open Flipkart website
        driver.get("https://www.flipkart.com/");

        // 3. Close login popup if displayed
        try {
            WebElement closeBtn = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z")); // WebElement for popup
            closeBtn.click(); // click to close
            System.out.println("Login popup closed");
        } catch (NoSuchElementException e) {
            System.out.println("Login popup not displayed, skipping");
        }

        // 4. Search box using locators
        WebElement searchBox = driver.findElement(By.name("q")); // search box element
        searchBox.sendKeys("Laptop"); // enter text

        // 5. Auto-suggest dropdown
        Thread.sleep(2000); // wait for suggestions
        List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@class='_1MRYA1']/li")); // list of suggestions
        for (WebElement option : suggestions) {
            if (option.getText().toLowerCase().contains("dell")) {
                option.click(); // select option
                break;
            }
        }
        System.out.println("Auto-suggest selected");

        // 6. Press ENTER to go to search results
        searchBox.sendKeys(Keys.ENTER);

        // 7. WebDriver methods
        System.out.println("Title: " + driver.getTitle()); // get page title
        System.out.println("Current URL: " + driver.getCurrentUrl()); // get current URL
        driver.navigate().refresh(); // refresh page
        driver.navigate().back(); // navigate back
        driver.navigate().forward(); // navigate forward
        System.out.println("WebDriver methods demo done");

        // 8. Checkbox / Filter example (Brand Dell)
        try {
            WebElement brandDell = driver.findElement(By.xpath("//div[text()='Dell']/preceding-sibling::div")); // checkbox element
            brandDell.click(); // select brand
            System.out.println("Brand filter (Dell) selected");
        } catch (NoSuchElementException e) {
            System.out.println("Brand filter not found");
        }

        // 9. Mouse actions (hover on Electronics menu)
        Actions act = new Actions(driver); // Actions variable for mouse/keyboard
        try {
            WebElement electronicsMenu = driver.findElement(By.xpath("//span[text()='Electronics']")); // menu element
            act.moveToElement(electronicsMenu).perform(); // hover
            System.out.println("Mouse hover demo done");
        } catch (NoSuchElementException e) {
            System.out.println("Electronics menu not found, skipping");
        }

        // 10. Keyboard actions (Ctrl + A in search box)
        searchBox = driver.findElement(By.name("q"));
        act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform(); // select all text
        System.out.println("Keyboard actions demo done");

        // 11. Scroll using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver; // JS executor variable
        js.executeScript("window.scrollBy(0,1000)"); // scroll down
        System.out.println("Scrolled down using JavaScript");

        // 12. Screenshot
        String projectPath = System.getProperty("user.dir"); // get project path
        String screenshotPath = projectPath + "\\FlipkartDemo.png"; // file path
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // capture screenshot
        FileHandler.copy(src, new File(screenshotPath)); // save file
        System.out.println("Screenshot saved at: " + screenshotPath);

        // 13. Web table / product list (top 5 products)
        List<WebElement> productCards = driver.findElements(By.cssSelector("div._1AtVbE")); // list of product cards
        System.out.println("Top 5 products:");
        int count = 0;
        for (WebElement card : productCards) {
            try {
                WebElement title = card.findElement(By.cssSelector("div._4rR01T")); // product title element
                System.out.println(title.getText());
                count++;
                if (count >= 5) break;
            } catch (NoSuchElementException e) {
                // skip if no product title
            }
        }

        // 14. Quit browser
        driver.quit(); // close all windows
        System.out.println("Selenium Flipkart Demo Completed Successfully");
    }
}
