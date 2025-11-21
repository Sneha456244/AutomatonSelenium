package task15;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSortPage {


WebDriver driver;

// Sort dropdown
@FindBy(className = "product_sort_container")
WebElement sortDropdown;

// All products on page
@FindBy(className = "inventory_item")
List<WebElement> products;

public ProductSortPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
}

// Inner Product class to hold name and price
public class Product {
    public String name;
    public double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " : $" + price;
    }
}

// Get all products with their name and price
public List<Product> getAllProducts() {
    List<Product> productList = new ArrayList<>();
    for (WebElement item : products) {
        String name = item.findElement(By.className("inventory_item_name")).getText();
        double price = Double.parseDouble(
                item.findElement(By.className("inventory_item_price")).getText().replace("$", "")
        );
        productList.add(new Product(name, price));
    }
    return productList;
}

// Select sort option from dropdown
public void selectSortOption(String option) {
    sortDropdown.click();
    sortDropdown.findElement(By.xpath("//option[text()='" + option + "']")).click();
}


}
