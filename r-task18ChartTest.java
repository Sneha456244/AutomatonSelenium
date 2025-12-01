package task18;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ChartTest {

    WebDriver driver;
    ChartPage chartPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.highcharts.com/demo/highcharts/bar-race");

        chartPage = new ChartPage(driver);
        chartPage.switchToChartIframe();
    }

    @Test
    public void verifyTooltipOnHover() {
        chartPage.hoverOnFirstDataPoint();
        String tooltipValue = chartPage.getTooltipText();

        // Print tooltip value
        System.out.println("Tooltip Value: " + tooltipValue);

        // Simple validation
        if (tooltipValue != null && !tooltipValue.isEmpty()) {
            System.out.println("Tooltip is displayed successfully!");
        } else {
            System.out.println("Tooltip is NOT displayed!");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
