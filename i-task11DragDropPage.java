package task10;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragDropPage {

    WebDriver driver;
    Actions action;

    public DragDropPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    // Locators
    @FindBy(id = "draggable")
    WebElement sourceBox;

    @FindBy(id = "droppable")
    WebElement targetBox;

    // Perform drag and drop
    public void dragAndDrop() {
        action.dragAndDrop(sourceBox, targetBox).perform();
        System.out.println("Dragged source element to target successfully.");
    }

    // Verify result
    public String getDropResult() {
        return targetBox.getText();
    }
}
