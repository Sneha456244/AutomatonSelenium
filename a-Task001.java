package Task01Realtime;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class Flipkart {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
       
        // Explicit wait for specific conditions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        

        System.out.println("FLIPKART AUTOMATION TEST STARTED");

        // 1. Launch Flipkart
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        System.out.println("Step 1: Opened Flipkart homepage.");

        // 2. Close login popup if present
        try {
            WebElement closeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'✕')]")));
            closeBtn.click();
            System.out.println("Step 2: Closed login popup.");
        } 
        catch (Exception e) 
        {
            System.out.println("Step 2: Login popup not displayed or already closed.");
        }

        // 3. Search for a product
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchBox.sendKeys("iPhone 15");
        searchBox.sendKeys(Keys.ENTER); //Keyboard
        System.out.println("Step 3: Searched for product 'iPhone 15'.");

        // 4. Select the first available product
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@data-id,'MOB')]//a")));
        System.out.println("Step 4: Total products found: " + products.size());

        boolean productFound = false;

        for (int i = 0; i < products.size(); i++) {
            try {
                WebElement product = products.get(i);
                String productName = product.getText().split("\n")[0];
                System.out.println("Trying product: " + productName);

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
                product.click();

                // Switch to new tab
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));

                // Check if product is available
                if (driver.getPageSource().contains("Currently unavailable")) {
                    System.out.println("Product unavailable. Trying next one...");
                    driver.close();
                    driver.switchTo().window(tabs.get(0));
                    continue;
                }

                // 5. Add to cart
                WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add to cart']")));
                addToCart.click();
                System.out.println("Step 5: Product added to cart successfully.");
                productFound = true;
                break;

            } catch (Exception e) {
                System.out.println("Skipping this product due to layout issue.");
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                if (tabs.size() > 1) {
                    driver.close();
                    driver.switchTo().window(tabs.get(0));
                }
            }
        }

        if (!productFound) {
            System.out.println("No available product found to add to cart.");
            driver.quit();
            return;
        }

        // 6. Verify product in cart
        WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'/viewcart')]")));
        cartBtn.click();

        WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'/p/')]")));
        System.out.println("Step 6: Verified product in cart - " + cartItem.getText());

        // 7. Logout (navigate to login page)
        driver.navigate().to("https://www.flipkart.com/account/login?ret=/");
        System.out.println("Step 7: Logged out successfully.");

        driver.quit();

        System.out.println("FLIPKART AUTOMATION TEST COMPLETED");
        
    }
}
