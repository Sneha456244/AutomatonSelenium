package task11;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.*;

public class TableSortPage {

    WebDriver driver;

    // 1. Constructor
    public TableSortPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 2. Locators
    @FindBy(xpath = "//table[@id='customers']/tbody/tr/td[1]")
    List<WebElement> companyColumn;

    // 3. Action Methods

    // Get all company names from the first column
    public List<String> getAllCompanies() {
        List<String> companyList = new ArrayList<>();
        for (WebElement c : companyColumn) {
            companyList.add(c.getText().trim());
        }
        return companyList;
    }

    // Check if the list is sorted in ascending order
    public boolean isSortedAscending(List<String> list) {
        List<String> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        return sortedList.equals(list);
    }

    // Check if the list is sorted in descending order
    public boolean isSortedDescending(List<String> list) {
        List<String> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList, Collections.reverseOrder());
        return sortedList.equals(list);
    }

    // Print the list with a label
    public void printList(String message, List<String> list) {
        System.out.println("\n" + message);
        for (String s : list) {
            System.out.println(" - " + s);
        }
    }
}
