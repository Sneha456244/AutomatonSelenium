package task08;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyElementPositionsPage {

    WebDriver driver;

    // Constructor
    public VerifyElementPositionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // LOCATORS
    @FindBy(id = "nava")
    WebElement logo;

    @FindBy(xpath = "(//div[@id='tbodyid']//div[@class='card-block'])[1]")
    WebElement firstProduct;

    @FindBy(id = "fotcont")
    WebElement footer;

    @FindBy(id = "next2")
    WebElement nextButton;

    @FindBy(id = "prev2")
    WebElement prevButton;

    @FindBy(xpath = "//a[text()='Contact']")
    WebElement contactButton;

    @FindBy(id = "carouselExampleIndicators")
    WebElement carousel;

    @FindBy(xpath = "//a[text()='Phones']")
    WebElement phonesCategory;

    @FindBy(xpath = "//a[text()='Laptops']")
    WebElement laptopsCategory;

    @FindBy(xpath = "//a[text()='Monitors']")
    WebElement monitorsCategory;

    @FindBy(id = "recipient-name")
    WebElement contactName;

    @FindBy(id = "recipient-email")
    WebElement contactEmail;

    @FindBy(id = "message-text")
    WebElement contactMessage;

    @FindBy(xpath = "//button[text()='Send message']")
    WebElement sendMsgBtn;

    // ACTIONS

    // Verify Logo position
    public void verifyLogoPosition() {
        Point logoPoint = logo.getLocation();
        System.out.println("\n[1] Logo position -> X: " + logoPoint.getX() + ", Y: " + logoPoint.getY());

        if (logoPoint.getX() < 50 && logoPoint.getY() < 150)
            System.out.println("Logo is correctly placed at the top-left corner.");
        else
            System.out.println("Logo position is incorrect.");
    }

    public Point getLogoPosition() {
        return logo.getLocation();
    }

    // Verify first product position
    public void verifyFirstProductPosition() {
        Point productPoint = firstProduct.getLocation();
        System.out.println("\n[2] First product position -> X: " + productPoint.getX() + ", Y: " + productPoint.getY());

        if (productPoint.getY() > 200 && productPoint.getY() < 900)
            System.out.println("Product card is in the expected middle area of the page.");
        else
            System.out.println("Product card position seems off.");
    }

    public Point getProductPosition() {
        return firstProduct.getLocation();
    }

    // Verify footer
    public void verifyFooterPosition() {
        Point footerPoint = footer.getLocation();
        System.out.println("\n[3] Footer position -> X: " + footerPoint.getX() + ", Y: " + footerPoint.getY());

        if (footerPoint.getY() > 800)
            System.out.println("Footer is correctly placed near the bottom of the page.");
        else
            System.out.println("Footer position is incorrect.");
    }

    // Verify next button position
    public void verifyNextButtonPosition(Point productPoint) {
        Point nextPoint = nextButton.getLocation();
        System.out.println("\n[4] Next button position -> X: " + nextPoint.getX() + ", Y: " + nextPoint.getY());

        if (nextPoint.getY() > productPoint.getY())
            System.out.println("Next button is correctly placed below product list.");
        else
            System.out.println("Next button placement incorrect.");
    }

    // Scroll check for fixed logo
    public void verifyLogoAfterScroll(Point logoPointBefore) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);
        Point logoAfterScroll = logo.getLocation();
        System.out.println("\n[5] Logo position after scroll -> X: " + logoAfterScroll.getX() + ", Y: " + logoAfterScroll.getY());

        if (logoPointBefore.getY() == logoAfterScroll.getY())
            System.out.println("Logo remains fixed after scrolling.");
        else
            System.out.println("Logo moved after scrolling (unexpected).");
    }

    // Carousel next/previous
    public void clickNext() {
        nextButton.click();
        System.out.println("Clicked Next button.");
    }

    public void clickPrevious() {
        prevButton.click();
        System.out.println("Clicked Previous button.");
    }

    // Category selection
    public void clickCategory(String category) {
        switch (category.toLowerCase()) {
            case "phones":
                phonesCategory.click();
                System.out.println("Phones category selected.");
                break;
            case "laptops":
                laptopsCategory.click();
                System.out.println("Laptops category selected.");
                break;
            case "monitors":
                monitorsCategory.click();
                System.out.println("Monitors category selected.");
                break;
            default:
                System.out.println("Invalid category: " + category);
        }
    }

    // Contact form interaction
    public void openAndFillContactForm(String name, String email, String message) throws InterruptedException {
        contactButton.click();
        Thread.sleep(1000);
        contactName.sendKeys(name);
        contactEmail.sendKeys(email);
        contactMessage.sendKeys(message);
        sendMsgBtn.click();
        System.out.println("Contact form submitted successfully.");
    }
}
