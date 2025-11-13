package task12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    WebDriver driver;

    // 1. Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 2. Locators
    @FindBy(name = "search")
    WebElement searchBox;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    WebElement searchButton;

    @FindBy(xpath = "//h4/a")
    WebElement firstResult;

    @FindBy(xpath = "//p[contains(text(),'There is no product')]")
    WebElement noResultsMsg;

    // 3. Action Methods
    public void enterSearchKeyword(String keyword) {
        searchBox.clear();
        searchBox.sendKeys(keyword);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean isResultDisplayed() {
        try {
            return firstResult.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNoResultDisplayed() {
        try {
            return noResultsMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

