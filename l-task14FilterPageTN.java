package task13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterPageTN {

    WebDriver driver;

    // 1. Constructor
    public FilterPageTN(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 2. Locators
    @FindBy(id = "input-sort")
    WebElement sortDropdown;  

    @FindBy(css = ".product-thumb h4 a")
    List<WebElement> productNameLinks;

    @FindBy(css = ".product-thumb .price")
    List<WebElement> productPriceElements;

    // 3. Action Methods
    public void selectSortOption(String visibleText) {
        Select select = new Select(sortDropdown);
        select.selectByVisibleText(visibleText);
        System.out.println("Selected sort option: " + visibleText);
    }

    public List<String> getProductNames() {
        List<String> names = new ArrayList<>();
        for (WebElement e : productNameLinks) {
            names.add(e.getText().trim());
        }
        return names;
    }

    public List<Double> getProductPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement e : productPriceElements) {
            String txt = e.getText().split("\n")[0].replace("$","").trim();
            prices.add(Double.parseDouble(txt));
        }
        return prices;
    }

    public boolean verifyAscendingNames(List<String> names) {
        List<String> sorted = new ArrayList<>(names);
        Collections.sort(sorted);
        return sorted.equals(names);
    }

    public boolean verifyDescendingNames(List<String> names) {
        List<String> sorted = new ArrayList<>(names);
        Collections.sort(sorted, Collections.reverseOrder());
        return sorted.equals(names);
    }

    public boolean verifyPriceLowToHigh(List<Double> prices) {
        List<Double> sorted = new ArrayList<>(prices);
        Collections.sort(sorted);
        return sorted.equals(prices);
    }

    public boolean verifyPriceHighToLow(List<Double> prices) {
        List<Double> sorted = new ArrayList<>(prices);
        Collections.sort(sorted, Collections.reverseOrder());
        return sorted.equals(prices);
    }
}

