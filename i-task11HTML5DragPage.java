package task10;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HTML5DragPage {

    WebDriver driver;
    Actions action;

    public HTML5DragPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    @FindBy(id = "column-a")
    WebElement boxA;

    @FindBy(id = "column-b")
    WebElement boxB;

    public void performDragAndDrop() {
        action.clickAndHold(boxA)
              .moveToElement(boxB)
              .release()
              .build()
              .perform();
        System.out.println("Dragged Box A into Box B position.");
    }

    public String getBoxAText() {
        return boxA.getText();
    }

    public String getBoxBText() {
        return boxB.getText();
    }
}

