package Task0002;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class CromaPage01 {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public CromaPage01(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Locators
    @FindBy(id = "searchV2")
    WebElement searchBox;

    @FindBy(id = "panel0bh-header")
    WebElement brandPanel;

    @FindBy(xpath = "//div[@id='panel0bh-content']//span[@class='check']")
    List<WebElement> brandCheckboxes;

    @FindBy(xpath = "//div[@id='panel1']//div[@id='panel1bh-header']")
    WebElement featurePanel;

    @FindBy(xpath = "//div[@id='panel1bh-content']//span[@class='check']")
    List<WebElement> featureCheckboxes;

    @FindBy(xpath = "//span[@class='clear-all']")
    WebElement clearAllBtn;

    @FindBy(xpath = "//a[@data-testid='cart-icon']")
    WebElement cartIcon;

    @FindBy(xpath = "//h2[normalize-space()='Your Cart']")
    WebElement cartHeader;

    // Step 1: Search for Product
    public void searchProduct(String product) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(product, Keys.ENTER);
        Thread.sleep(3000);
        System.out.println("Step 1: Searched for product - " + product);
    }

    // Step 2: Select Brand filters
    public void selectBrandFilters() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(brandPanel)).click();
        Thread.sleep(2000);
        for (int i = 0; i < 3 && i < brandCheckboxes.size(); i++) {
            brandCheckboxes.get(i).click();
            Thread.sleep(500);
        }
        System.out.println("Step 2: Selected first 3 Brand filters.");
    }

    // Step 3: Select Feature filters
    public void selectFeatureFilters() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(featurePanel)).click();
        Thread.sleep(2000);
        for (int i = 0; i < 4 && i < featureCheckboxes.size(); i++) {
            featureCheckboxes.get(i).click();
            Thread.sleep(500);
        }
        System.out.println("Step 3: Selected first 4 Feature filters.");
    }

    // Step 4: Clear all filters
    public void clearAllFilters() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(clearAllBtn)).click();
        Thread.sleep(2000);
        System.out.println("Step 4: Cleared all applied filters.");
    }

    // Step 5: Open Cart
    public void openCart() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
        Thread.sleep(2000);
        System.out.println("Step 5: Opened Cart page.");
    }

    // Step 6: Verify Cart Page
    public void verifyCartPage() {
        wait.until(ExpectedConditions.visibilityOf(cartHeader));
        if (cartHeader.isDisplayed()) {
            System.out.println("Step 6: Verified Cart page successfully.");
        } else {
            System.out.println("Step 6: Cart page verification failed.");
        }
    }
}
