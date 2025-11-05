package task06;

import org.openqa.selenium.*;
import org.testng.Assert;

public class ShadowDomPage2 {

    WebDriver driver;

    public ShadowDomPage2(WebDriver driver) {
        this.driver = driver;
    }

    // 1. Validate visibility of Shadow DOM element
    public void validateShadowElementVisibility() throws InterruptedException {
        driver.get("https://books-pwakit.appspot.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement host = driver.findElement(By.cssSelector("book-app"));
        SearchContext shadowRoot = host.getShadowRoot();

        WebElement toolbar = shadowRoot.findElement(By.cssSelector("app-header"));
        Assert.assertTrue(toolbar.isDisplayed(), "Toolbar should be visible inside shadow DOM");
        System.out.println("Shadow DOM visibility verified.");
    }

    // 2. Validate attribute change in Shadow DOM (search input)
    public void validateAttributeChange() throws InterruptedException {
        driver.get("https://books-pwakit.appspot.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement host = driver.findElement(By.cssSelector("book-app"));
        SearchContext shadowRoot = host.getShadowRoot();

        WebElement input = shadowRoot.findElement(By.cssSelector("input#input"));
        input.sendKeys("selenium");
        Thread.sleep(1000);

        String value = input.getAttribute("value");
        Assert.assertEquals(value, "selenium", "Input value should reflect entered text");
        System.out.println("Shadow DOM attribute change verified.");
    }

    // 3. Validate tooltip or hover text (via aria-label)
    public void validateTooltipInShadowDom() throws InterruptedException {
        driver.get("https://books-pwakit.appspot.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement host = driver.findElement(By.cssSelector("book-app"));
        SearchContext shadowRoot = host.getShadowRoot();

        WebElement searchBox = shadowRoot.findElement(By.cssSelector("input#input"));
        String ariaLabel = searchBox.getAttribute("aria-label");

        Assert.assertTrue(ariaLabel != null && ariaLabel.contains("Search"),
                "Tooltip/aria-label should contain 'Search'");
        System.out.println("Shadow DOM tooltip (aria-label text) verified.");
    }
}
