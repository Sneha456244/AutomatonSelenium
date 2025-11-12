package task11;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import java.util.*;

public class TableSortPage01 {

    WebDriver driver;

    // 1. Constructor
    public TableSortPage01(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 2. Locators
    @FindBy(xpath = "//table[@id='example']/thead/tr/th[1]")
    WebElement nameHeader;

    @FindBy(xpath = "//table[@id='example']/tbody/tr/td[1]")
    List<WebElement> nameCells;

    // 3. Action Methods

    // Click on Name header to sort
    public void clickNameHeader() {
        nameHeader.click();
    }

    // Get all names from the first column
    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (WebElement e : nameCells) {
            names.add(e.getText().trim());
        }
        return names;
    }

    // Verify ascending order
    public boolean isSortedAscending(List<String> list) {
        List<String> sorted = new ArrayList<>(list);
        Collections.sort(sorted);
        return list.equals(sorted);
    }

    // Verify descending order
    public boolean isSortedDescending(List<String> list) {
        List<String> sorted = new ArrayList<>(list);
        Collections.sort(sorted, Collections.reverseOrder());
        return list.equals(sorted);
    }
}

