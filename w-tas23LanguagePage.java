package task21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LanguagePage {

    WebDriver driver;
    
    // Constructor
    
    public LanguagePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Language Selectors
    
    @FindBy(id = "js-link-box-en")
    private WebElement englishLanguage;

    @FindBy(id = "js-link-box-es")
    private WebElement spanishLanguage;

    @FindBy(id = "js-link-box-de")
    private WebElement germanLanguage;

    //Page Elements

    @FindBy(tagName = "html")
    private WebElement htmlTag;

    @FindBy(tagName = "body")
    private WebElement bodyTag;

    // ==========================
    // Actions
    // ==========================

    public void openWikipedia() {
        driver.get("https://www.wikipedia.org/");
    }

    public void clickEnglish() {
        englishLanguage.click();
    }

    public void clickSpanish() {
        spanishLanguage.click();
    }

    public void clickGerman() {
        germanLanguage.click();
    }

    // Validations

    public String getHtmlLang() {
        return htmlTag.getAttribute("lang");
    }

    public boolean isBodyLoaded() {
        return bodyTag.isDisplayed();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
