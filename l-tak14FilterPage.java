package task13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterPage {

    WebDriver driver;

    // 1. Constructor
    public FilterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 2. Locators
    @FindBy(id = "user-name")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    @FindBy(className = "product_sort_container")
    WebElement filterDropdown;

    @FindBy(className = "inventory_item_name")
    List<WebElement> productNames;

    @FindBy(className = "inventory_item_price")
    List<WebElement> productPrices;

    // 3. Action Methods
    public void login(String user, String pass) {
        usernameInput.sendKeys(user);
        passwordInput.sendKeys(pass);
        loginBtn.click();
    }

    public void selectFilter(String option) {
        Select s = new Select(filterDropdown);
        s.selectByVisibleText(option);
    }

    public List<String> getProductNames() {
        List<String> list = new ArrayList<>();
        for (WebElement e : productNames) {
            list.add(e.getText());
        }
        return list;
    }

    public List<Double> getProductPrices() {
        List<Double> list = new ArrayList<>();
        for (WebElement e : productPrices) {
            list.add(Double.parseDouble(e.getText().replace("$", "")));
        }
        return list;
    }

    // Validate sorting of Names A->Z
    public boolean isSortedAscending(List<String> list) {
        List<String> sorted = new ArrayList<>(list);
        Collections.sort(sorted);
        return sorted.equals(list);
    }

    // Validate sorting of Names Z->A
    public boolean isSortedDescending(List<String> list) {
        List<String> sorted = new ArrayList<>(list);
        Collections.sort(sorted, Collections.reverseOrder());
        return sorted.equals(list);
    }

    // Validate sorting Low to High
    public boolean isPricesLowToHigh(List<Double> list) {
        List<Double> sorted = new ArrayList<>(list);
        Collections.sort(sorted);
        return sorted.equals(list);
    }

    // Validate sorting High to Low
    public boolean isPricesHighToLow(List<Double> list) {
        List<Double> sorted = new ArrayList<>(list);
        Collections.sort(sorted, Collections.reverseOrder());
        return sorted.equals(list);
    }
}

