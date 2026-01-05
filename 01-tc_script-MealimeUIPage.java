package tc_script01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MealimeUIPage {

    WebDriver driver;

    public MealimeUIPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//button[normalize-space()='Get Started']")
    private WebElement getStartedBtn;

    @FindBy(xpath = "//button[normalize-space()='Sign in']")
    private WebElement signInTab;

    @FindBy(xpath = "//button[contains(text(),'Already have an account')]")
    private WebElement alreadyAccountTab;

    // Diet Page 
    @FindBy(xpath = "//*[contains(text(),'Pick your diet')]")
    private WebElement dietTitle;

    @FindBy(xpath = "//button[normalize-space()='Classic']")
    private WebElement classicTab;

    @FindBy(xpath = "//button[contains(text(),'Low Carb')]")
    private WebElement lowCarbTab;

    @FindBy(xpath = "//button[normalize-space()='Keto']")
    private WebElement ketoTab;

    @FindBy(xpath = "//button[normalize-space()='Flexitarian']")
    private WebElement flexitarianTab;

    @FindBy(xpath = "//button[normalize-space()='Paleo']")
    private WebElement paleoTab;

    @FindBy(xpath = "//button[normalize-space()='Vegetarian']")
    private WebElement vegetarianTab;

    @FindBy(xpath = "//button[normalize-space()='Pescetarian']")
    private WebElement pescetarianTab;

    @FindBy(xpath = "//button[normalize-space()='Vegan']")
    private WebElement veganTab;

    // Actions 
    public void openApplication() {
        driver.get("https://my.mealime.com/");
    }

    // Landing Page Methods
    public void clickGetStarted() { getStartedBtn.click(); }
    public boolean isGetStartedDisplayed() { return getStartedBtn.isDisplayed() && getStartedBtn.isEnabled(); }
    public boolean isSignInDisplayed() { return signInTab.isDisplayed() && signInTab.isEnabled(); }
    public boolean isAlreadyAccountDisplayed() { return alreadyAccountTab.isDisplayed() && alreadyAccountTab.isEnabled(); }

    // Diet Page Methods
    public boolean isDietPageDisplayed() { return dietTitle.isDisplayed(); }
    public boolean isClassicDisplayed() { return classicTab.isDisplayed() && classicTab.isEnabled(); }
    public boolean isLowCarbDisplayed() { return lowCarbTab.isDisplayed() && lowCarbTab.isEnabled(); }
    public boolean isKetoDisplayed() { return ketoTab.isDisplayed() && ketoTab.isEnabled(); }
    public boolean isFlexitarianDisplayed() { return flexitarianTab.isDisplayed() && flexitarianTab.isEnabled(); }
    public boolean isPaleoDisplayed() { return paleoTab.isDisplayed() && paleoTab.isEnabled(); }
    public boolean isVegetarianDisplayed() { return vegetarianTab.isDisplayed() && vegetarianTab.isEnabled(); }
    public boolean isPescetarianDisplayed() { return pescetarianTab.isDisplayed() && pescetarianTab.isEnabled(); }
    public boolean isVeganDisplayed() { return veganTab.isDisplayed() && veganTab.isEnabled(); }
}
