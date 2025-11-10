package task09;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class resizingbrowserPage {
    WebDriver driver;

    // Constructor
    public resizingbrowserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Elements to check after resizing
    @FindBy(xpath = "//a[@id='nava']")
    WebElement logo;

    @FindBy(xpath = "//a[text()='Home ']")
    WebElement homeLink;

    @FindBy(xpath = "//a[text()='Contact']")
    WebElement contactLink;

    @FindBy(xpath = "//a[text()='About us']")
    WebElement aboutLink;

    // Open the website
    public void openSite() {
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
    }

    // Check responsiveness by resizing browser window
    public void checkResponsiveness() throws InterruptedException {
        Dimension originalSize = driver.manage().window().getSize();
        System.out.println("Original size: " + originalSize);

        // Resize to tablet
        driver.manage().window().setSize(new Dimension(768, 1024));
        Thread.sleep(2000);
        validateLayout("Tablet");

        // Resize to mobile
        driver.manage().window().setSize(new Dimension(375, 667));
        Thread.sleep(2000);
        validateLayout("Mobile");

        // Back to desktop
        driver.manage().window().maximize();
        Thread.sleep(2000);
        validateLayout("Desktop");
    }

    // Validate layout visibility after resizing
    private void validateLayout(String viewType) {
        System.out.println("Checking layout in " + viewType + " view...");

        try {
            if (logo.isDisplayed() && homeLink.isDisplayed() && contactLink.isDisplayed() && aboutLink.isDisplayed()) {
                System.out.println("All main elements are visible in " + viewType + " view.");
            } else {
                System.out.println("Some elements are not visible in " + viewType + " view.");
            }
        } catch (Exception e) {
            System.out.println("Error validating layout in " + viewType + " view: " + e.getMessage());
        }
    }
}

