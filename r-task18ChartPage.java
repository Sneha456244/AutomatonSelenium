package task18;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChartPage {

    WebDriver driver;

    @FindBy(xpath = "//iframe[@id='demo']")
    WebElement chartIframe;

    // Example: First data point in the chart
    @FindBy(xpath = "//*[contains(@class,'highcharts-series')]/*[1]") 
    WebElement firstDataPoint;

    // Tooltip element
    @FindBy(xpath = "//*[contains(@class,'highcharts-tooltip')]")
    WebElement tooltip;

    public ChartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void switchToChartIframe() {
        driver.switchTo().frame(chartIframe);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    // Hover over the first data point
    public void hoverOnFirstDataPoint() {
        Actions actions = new Actions(driver);
        actions.moveToElement(firstDataPoint).perform();
    }

    // Get tooltip text
    public String getTooltipText() {
        return tooltip.getText();
    }
}
