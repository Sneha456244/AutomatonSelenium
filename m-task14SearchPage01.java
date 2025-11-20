package task14;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class WikipediaPage {

    WebDriver driver;
    WebDriverWait wait;

    public WikipediaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    @FindBy(id = "searchInput")
    WebElement searchBox;

    @FindBy(css = ".suggestion-link")
    List<WebElement> suggestions;

    // Type text in search bar 
    public void typeText(String text) {
        searchBox.clear();
        searchBox.sendKeys(text);
    }

    // Get suggestion count safely 
    public int getSuggestionCount() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(suggestions));
            return suggestions.size();
        } catch (Exception e) {
            return 0;
        }
    }

    // Get suggestions text 
    public List<WebElement> getSuggestionElements() {
        return suggestions;
    }

    // Click first suggestion 
    public void clickFirstSuggestion() {
        wait.until(ExpectedConditions.elementToBeClickable(suggestions.get(0))).click();
    }
}
