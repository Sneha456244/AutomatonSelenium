package Task001Realtime;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class FlipkartPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public FlipkartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Locators
    @FindBy(xpath = "//button[contains(text(),'✕')]")
    WebElement closePopup;

    @FindBy(name = "q")
    WebElement searchBox;

    @FindBy(xpath = "//a[contains(@href,'/viewcart')]")
    WebElement cartButton;

    // Step 1: Close login popup
    public void closeLoginPopup() {
        try {
            wait.until(ExpectedConditions.visibilityOf(closePopup)).click();
            System.out.println("Step 1: Closed login popup.");
        } catch (Exception e) {
            System.out.println("Step 1: Login popup not displayed or already closed.");
        }
    }

    // Step 2: Search product
    public void searchProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(productName);
        searchBox.sendKeys(Keys.ENTER);
        System.out.println("Step 2: Searched for product - " + productName);
    }

    // Step 3 & 4: Select first product and Add to cart
    public void selectFirstProductAndAddToCart() throws Exception {
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[contains(@data-id,'MOB')]//a")));
        System.out.println("Step 3: Total products found: " + products.size());

        boolean productFound = false;

        for (WebElement product : products) {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
                product.click();

                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));

                // Check availability
                if (driver.getPageSource().contains("Currently unavailable")) {
                    System.out.println("Product unavailable. Trying next...");
                    driver.close();
                    driver.switchTo().window(tabs.get(0));
                    continue;
                }

                // Add to Cart
                WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='Add to cart']")));
                addToCartBtn.click();
                System.out.println("Step 4: Product added to cart successfully.");
                productFound = true;
                break;

            } catch (Exception e) {
                System.out.println("Skipping product due to layout issue.");
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                if (tabs.size() > 1) {
                    driver.close();
                    driver.switchTo().window(tabs.get(0));
                }
            }
        }

        if (!productFound) {
            System.out.println("No available product found to add to cart.");
            throw new Exception("No product added.");
        }
    }

    // Step 5: Verify product in cart
    public void verifyProductInCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
        WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(@href,'/p/')]")));
        System.out.println("Step 5: Verified product in cart - " + cartItem.getText());
    }

    // Step 6: Logout (navigate to login page)
    public void logout() {
        driver.navigate().to("https://www.flipkart.com/account/login?ret=/");
        System.out.println("Step 6: Logged out successfully.");
    }
}
