package task04;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class PaginatedTablePage {

    WebDriver driver;
    WebDriverWait wait;
 //constructor   
    public PaginatedTablePage(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
//Locators
    @FindBy(xpath = "//table[@role='grid']/tbody/tr")
    List<WebElement> tableRows;

    @FindBy(xpath = "//button[@aria-label='Next Page']")
    WebElement nextButton;

    @FindBy(xpath = "//button[@aria-label='Previous Page']")
    WebElement prevButton;

 //Action
    
    public void searchAndLog(String searchText) 
    {
        int page = 1;
        boolean found = false;

        while (true) 
        {
            System.out.println("Checking Page: " + page);

            wait.until(ExpectedConditions.visibilityOfAllElements(tableRows));

            for (WebElement row : tableRows) 
            {
                if (row.getText().contains(searchText)) 
                {
                    System.out.println("Found '" + searchText + "' on Page: " + page);
                    found = true;
                    break;
                }
            }

            if (found) break;

            // check if "Next" button is disabled
            if (!nextButton.isEnabled() || nextButton.getAttribute("class").contains("ui-state-disabled")) 
            {
                System.out.println("Reached last page. '" + searchText + "' not found.");
                break;
            }

            try 
            {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
                wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
                Thread.sleep(1000);
                page++;
            } 
            catch (Exception e) 
            {
                System.out.println("Cannot click next button: " + e.getMessage());
                break;
            }
        }
    }
}
