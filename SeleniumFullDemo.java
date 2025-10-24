package Demo1;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class SeleniumFullDemo {
    public static void main(String[] args) throws Exception {

    	//Browser Launch & Setup: Opens Chrome, maximizes, sets implicit wait.
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open practice website
        driver.get("https://www.letskodeit.com/practice");
        System.out.println("Selenium Demo Started");

        // 1. Locators: Demonstrates [id, name, className].
        WebElement nameBox = driver.findElement(By.id("name"));
        nameBox.sendKeys("Sneha - Locator by ID");

        driver.findElement(By.name("enter-name")).clear();
        driver.findElement(By.name("enter-name")).sendKeys("Locator by Name");

        WebElement alertBtn = driver.findElement(By.className("btn-style"));
        alertBtn.click();

        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert appeared on letskodeit site, skipping");
        }
        System.out.println("Locators demo done");

        // 2. CSS SELECTOR [CSS/XPath: Alternative ways to locate elements.]
        driver.findElement(By.cssSelector("input#name")).sendKeys("Sneha via CSS");
        driver.findElement(By.cssSelector("input[name='enter-name']")).clear();
        System.out.println("CSS selector demo done");

        // 3. XPATH
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("XPath Example");
        System.out.println("XPath demo done");

        // 4. XPATH AXES [Uses child axis (safe with try-catch).]
        try {
            WebElement nameBoxChild = driver.findElement(By.xpath("//form[@id='displayed-text']/child::input[@id='name']"));
            nameBoxChild.sendKeys("Using child axis");
            System.out.println("XPath Axes demo done");
        } catch (NoSuchElementException e) {
            System.out.println("XPath Axes element not found, skipping");
        }

        // 5. WebDriver Methods: Get title, URL, navigation.
        System.out.println("Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();
        System.out.println("WebDriver methods demo done");

        // 6. Explicit Waits : waits for element visibility.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alertbtn")));
        System.out.println("Waits demo done");

        // 7. Checkbox : Selects and verifies checkbox.
        WebElement bmw = driver.findElement(By.id("bmwcheck"));
        bmw.click();
        System.out.println("BMW Checkbox selected: " + bmw.isSelected());
        System.out.println("Checkbox demo done");

        // 8. Alerts (stable website) : Switches to alert, reads text, accepts it.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        alert.accept();
        System.out.println("Alert demo done");

        // Go back to practice page
        driver.get("https://www.letskodeit.com/practice");

        // 9. IFrames : Switch to iframe, get body text, return to main content.
        try {
            driver.switchTo().frame("courses-iframe");
            WebElement iframeBody = driver.findElement(By.tagName("body"));
            System.out.println("Iframe body text: " + iframeBody.getText().substring(0, Math.min(50, iframeBody.getText().length())) + "...");
            driver.switchTo().defaultContent();
            System.out.println("IFrame demo done");
        } catch (NoSuchFrameException | NoSuchElementException e) {
            System.out.println("Iframe element not found, skipping");
        }

        // 10. Dropdown: Select option by visible text.
        Select dropdown = new Select(driver.findElement(By.id("carselect")));
        dropdown.selectByVisibleText("Honda");
        System.out.println("Dropdown demo done");

        // 11. Auto Suggest Dropdown: Select from dynamic suggestion list.
        driver.findElement(By.id("autosuggest")).sendKeys("Ind");
        Thread.sleep(2000);
        List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/div"));
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }
        }
        System.out.println("Auto Suggest Dropdown demo done");

        // 12. Static Web Table: Read rows and print content.
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='product']/tbody/tr"));
        System.out.println("Total rows: " + rows.size());
        for (WebElement row : rows) {
            System.out.println(row.getText());
        }
        System.out.println("Web Table demo done");

        // 13. Mouse Actions: Hover on element.
        Actions act = new Actions(driver);
        WebElement openTab = driver.findElement(By.id("opentab"));
        act.moveToElement(openTab).perform();
        System.out.println("Mouse Actions demo done");

        // 14. Keyboard Actions: Press Ctrl+A.
        act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        System.out.println("Keyboard Actions demo done");

        // 15. JavaScript Executor / Scrolling: Scroll down using JS.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        System.out.println("JavaScript scroll demo done");

        // 16. Screenshot and auto-open: Capture and auto-open screenshot in default viewer.
        String projectPath = System.getProperty("user.dir");
        String screenshotPath = projectPath + "\\src\\test\\java\\SeleniumDemo.png";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File(screenshotPath));

        try {
            java.awt.Desktop.getDesktop().open(new File(screenshotPath));
            System.out.println("Screenshot opened successfully");
        } catch (Exception e) {
            System.out.println("Could not open screenshot automatically: " + e.getMessage());
        }

        System.out.println("Selenium Demo Completed Successfully");
        driver.quit();
    }
}
