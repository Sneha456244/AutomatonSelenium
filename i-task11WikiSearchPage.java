package task10;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class WikiSearchPage {

    WebDriver driver;

    public WikiSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "searchLanguage")
    WebElement languageDropdown;

    @FindBy(id = "searchInput")
    WebElement searchBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;

    // Print all dropdown options
    public void showAllLanguages() 
    {
        List<WebElement> options = languageDropdown.findElements(By.tagName("option"));
        System.out.println("\nLanguages available:");
        for (WebElement opt : options) 
        {
            System.out.println(opt.getText());
        }
    }

    // Select given language
    public void selectLanguage(String language) 
    {
        List<WebElement> options = languageDropdown.findElements(By.tagName("option"));
        for (WebElement opt : options) 
        {
            if (opt.getText().equalsIgnoreCase(language)) 
            {
                opt.click();
                System.out.println("Selected language: " + language);
                return;
            }
        }
        System.out.println("Language not found: " + language);
    }

    // Search for a word
    public void search(String text) 
    {
        searchBox.sendKeys(text);
        searchButton.click();
        System.out.println("Searched: " + text);
    }
}
