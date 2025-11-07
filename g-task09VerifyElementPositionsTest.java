package task08;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class VerifyElementPositionsTest {

    WebDriver driver;
    VerifyElementPositionsPage page;

    @BeforeClass
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
        Thread.sleep(3000);
        page = new VerifyElementPositionsPage(driver);
        System.out.println("Step 1: Navigated to Demoblaze home page.");
    }

    @Test(priority = 1)
    public void testVerifyElementPositions() throws InterruptedException {
        page.verifyLogoPosition();
        page.verifyFirstProductPosition();
        Point productPoint = page.getProductPosition();
        page.verifyFooterPosition();
        page.verifyNextButtonPosition(productPoint);
        Point logoPoint = page.getLogoPosition();
        page.verifyLogoAfterScroll(logoPoint);
    }

    @Test(priority = 2)
    public void testCarouselNavigation() throws InterruptedException {
        System.out.println("\n--- Testing Next/Previous Buttons ---");
        page.clickNext();
        Thread.sleep(2000);
        page.clickPrevious();
        Thread.sleep(2000);
        System.out.println("Carousel navigation verified.");
    }

    @Test(priority = 3)
    public void testCategoryChange() throws InterruptedException {
        System.out.println("\n--- Testing Category Selection ---");
        page.clickCategory("phones");
        Thread.sleep(2000);
        page.clickCategory("laptops");
        Thread.sleep(2000);
        page.clickCategory("monitors");
        Thread.sleep(2000);
        System.out.println("Category navigation successful.");
    }

    @Test(priority = 4)
    public void testContactForm() throws InterruptedException {
        System.out.println("\n--- Testing Contact Form ---");
        page.openAndFillContactForm("Sneha", "sneha@test.com", "This is a test message from automation.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("Browser closed.");
    }
}
