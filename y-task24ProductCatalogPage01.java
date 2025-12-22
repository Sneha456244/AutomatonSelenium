package task21;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductCatalogPage01 {

    WebDriver driver;
    WebDriverWait wait;

    public ProductCatalogPage01(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        System.out.println("[INFO] ProductCatalogPage initialized");
    }

    // LOCATORS 

    @FindBy(linkText = "Books")
    WebElement booksCategory;

    @FindBy(css = "div.page-title h1")
    WebElement pageHeading;

    @FindBy(css = "div.breadcrumb")
    WebElement breadcrumb;

    @FindBy(id = "products-orderby")
    WebElement sortDropdown;

    @FindBy(css = "div.item-box")
    List<WebElement> products;

    @FindBy(css = "div.item-box h2.product-title")
    List<WebElement> productNames;

    @FindBy(css = "div.item-box img")
    List<WebElement> productImages;

    @FindBy(css = "span.price.actual-price")
    List<WebElement> productPrices;

    // ACTION METHODS 

    public void clickBooksCategory() {
        System.out.println("[ACTION] Clicking Books category");
        wait.until(ExpectedConditions.elementToBeClickable(booksCategory)).click();
    }

    public void sortByPriceLowToHigh() {
        System.out.println("[ACTION] Sorting by Price: Low to High");
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Price: Low to High");

        // wait for page refresh
        wait.until(ExpectedConditions.visibilityOfAllElements(products));
    }

    // VALIDATION METHODS 

    public String getPageHeading() {
        String heading = pageHeading.getText();
        System.out.println("[CHECK] Page heading: " + heading);
        return heading;
    }

    public String getBreadcrumbText() {
        String crumb = breadcrumb.getText();
        System.out.println("[CHECK] Breadcrumb: " + crumb);
        return crumb;
    }

    public int getProductCount() {
        int count = products.size();
        System.out.println("[CHECK] Product count: " + count);
        return count;
    }

    public void printAllProductNames() {
        System.out.println("----- PRODUCT LIST -----");
        for (WebElement product : productNames) {
            System.out.println("Product: " + product.getText());
        }
    }

    public boolean areAllImagesDisplayed() {
        for (WebElement img : productImages) {
            if (!img.isDisplayed()) {
                System.out.println("[ERROR] Product image not displayed");
                return false;
            }
        }
        System.out.println("[CHECK] All images are displayed");
        return true;
    }

    public List<Double> getAllPrices() {

        List<Double> prices = new ArrayList<>();

        for (WebElement price : productPrices) {

            String priceText = price.getText()
                                    .replace("$", "")
                                    .trim();

            double value = Double.parseDouble(priceText);
            prices.add(value);

            System.out.println("[CHECK] Price value: " + value);
        }
        return prices;
    }

    public boolean arePricesSortedLowToHigh() {

        List<Double> prices = getAllPrices();

        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                System.out.println("[ERROR] Price sorting failed");
                return false;
            }
        }
        System.out.println("[CHECK] Prices sorted Low to High");
        return true;
    }
}
