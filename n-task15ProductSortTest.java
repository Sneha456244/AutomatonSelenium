package task15;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductSortTest {


WebDriver driver;
ProductSortPage productPage;

@BeforeClass
public void setup() {
    driver = new ChromeDriver(); 
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://www.saucedemo.com/");

    // Login steps
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();

    productPage = new ProductSortPage(driver);
}

// Combined test: Sort + Keyword filter
@Test
public void sortAndFilterByKeywords() {
    System.out.println("=== Sort: Name (A to Z) + Filter by Keywords: 'Sauce' and 'Bike' ===");
    productPage.selectSortOption("Name (A to Z)");
    List<ProductSortPage.Product> products = productPage.getAllProducts();

    List<ProductSortPage.Product> filtered = products.stream()
            .filter(p -> p.name.contains("Sauce") || p.name.contains("Bike"))
            .collect(Collectors.toList());

    filtered.forEach(System.out::println);
}

// Combined test: Sort + Price range filter
@Test
public void sortAndFilterByPriceRange() {
    System.out.println("=== Sort: Price (low to high) + Filter by Price: $15 to $25 ===");
    productPage.selectSortOption("Price (low to high)");
    List<ProductSortPage.Product> products = productPage.getAllProducts();

    List<ProductSortPage.Product> filtered = products.stream()
            .filter(p -> p.price >= 15 && p.price <= 25)
            .collect(Collectors.toList());

    filtered.forEach(System.out::println);
}

// Existing separate sort tests
@Test
public void sortByNameAZ() {
    System.out.println("=== Sort: Name (A to Z) ===");
    productPage.selectSortOption("Name (A to Z)");
    List<ProductSortPage.Product> products = productPage.getAllProducts();
    products.forEach(System.out::println);
}

@Test
public void sortByPriceHighLow() {
    System.out.println("=== Sort: Price (high to low) ===");
    productPage.selectSortOption("Price (high to low)");
    List<ProductSortPage.Product> products = productPage.getAllProducts();
    products.forEach(System.out::println);
}

@AfterClass
public void tearDown() {
    driver.quit();
}


}
