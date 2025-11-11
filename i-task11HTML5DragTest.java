package task10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class HTML5DragTest {

    WebDriver driver;
    HTML5DragPage page;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        page = new HTML5DragPage(driver);
    }

    @Test
    public void testDragAndDropHTML5() throws InterruptedException {
        String beforeA = page.getBoxAText();
        String beforeB = page.getBoxBText();

        page.performDragAndDrop();
        Thread.sleep(2000);

        String afterA = page.getBoxAText();
        String afterB = page.getBoxBText();

        System.out.println("Before: A=" + beforeA + ", B=" + beforeB);
        System.out.println("After: A=" + afterA + ", B=" + afterB);

        Assert.assertNotEquals(beforeA, afterA, "Boxes did not swap correctly!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

