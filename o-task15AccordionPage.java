package task16;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccordionPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "section1Heading")
    WebElement section1Header;

    @FindBy(id = "section1Content")
    WebElement section1Content;

    @FindBy(id = "section2Heading")
    WebElement section2Header;

    @FindBy(id = "section2Content")
    WebElement section2Content;

    @FindBy(id = "section3Heading")
    WebElement section3Header;

    @FindBy(id = "section3Content")
    WebElement section3Content;

    public AccordionPage(WebDriver driver) 
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    private void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    public void clickSection1() {
        scrollTo(section1Header);
        section1Header.click();
        wait.until(ExpectedConditions.visibilityOf(section1Content));
    }

    public void clickSection2() {
        scrollTo(section2Header);
        section2Header.click();
        wait.until(ExpectedConditions.visibilityOf(section2Content));
    }

    public void clickSection3() {
        scrollTo(section3Header);
        section3Header.click();
        wait.until(ExpectedConditions.visibilityOf(section3Content));
    }

    public boolean isSection1Expanded() {
        try {
            return section1Content.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSection2Expanded() {
        try {
            return section2Content.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSection3Expanded() {
        try {
            wait.until(ExpectedConditions.visibilityOf(section3Content));
            return section3Content.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void waitUntilSection1Collapsed() {
        wait.until(ExpectedConditions.invisibilityOf(section1Content));
    }
}
