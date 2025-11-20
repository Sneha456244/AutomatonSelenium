package task14;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartPage {

    WebDriver driver;

    // Constructor
    public FlipkartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(name = "q")
    public WebElement searchBox;

    @FindBy(css = "button[type='submit']")
    WebElement searchBtn;

    @FindBy(xpath = "//div[contains(@class,'YGcVZO')]//li")
    List<WebElement> autoSuggestions;

    @FindBy(css = "span._10Ermr")
    WebElement resultHeader;

    @FindBy(css = "body")
    WebElement body;

    @FindBy(css = "._2KpZ6l._2doB4z")
    List<WebElement> loginPopupClose;

    // Actions

    public void closeLoginPopupIfPresent() {
        try {
            if (loginPopupClose.size() > 0) {
                loginPopupClose.get(0).click();
            }
        } catch (Exception e) {}
    }

    public void typeSearch(String text) {
        searchBox.clear();
        searchBox.sendKeys(text);
    }

    public void clickSearchButton() {
        searchBtn.click();
    }

    public int getSuggestionCount() {
        return autoSuggestions.size();
    }

    public String getFirstSuggestionText() {
        if (autoSuggestions.size() > 0)
            return autoSuggestions.get(0).getText();
        return "";
    }

    public void clickFirstSuggestion() {
        if (autoSuggestions.size() > 0)
            autoSuggestions.get(0).click();
    }

    public String getResultHeader() {
        try {
            return resultHeader.getText();
        } catch (Exception e) {
            return "";
        }
    }
}
