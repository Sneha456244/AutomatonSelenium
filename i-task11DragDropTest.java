package task10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DragDropTest {

    WebDriver driver;
    DragDropPage page;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/droppable");
        page = new DragDropPage(driver);
    }

    @Test
    public void testDragAndDrop() throws InterruptedException {
        page.dragAndDrop();
        Thread.sleep(2000); 
        String result = page.getDropResult();
        System.out.println("Drop result text: " + result);
        Assert.assertTrue(result.contains("Dropped!"), "Drop action failed!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
