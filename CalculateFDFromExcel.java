package Day14;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculateFDFromExcel {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
        driver.manage().window().maximize();

        // Excel file path
        String filePath = System.getProperty("user.dir") + "\\testdata\\caldata.xlsx";

        int rows = ExcelUtils.getRowCount(filePath, "Sheet1");

        for (int i = 1; i <= rows; i++) {

            // 1️ Read data from Excel
            String pric = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
            String rateofinterest = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
            String per1 = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
            String per2 = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
            String fre = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
            String exp_mvalue = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);

            // 2️ Pass above data into the application
            driver.findElement(By.xpath("//input[@id='principal']")).clear();
            driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(pric);

            driver.findElement(By.xpath("//input[@id='interest']")).clear();
            driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateofinterest);

            driver.findElement(By.xpath("//input[@id='tenure']")).clear();
            driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);

            Select perdrp = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
            perdrp.selectByVisibleText(per2);

            Select fredrp = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
            fredrp.selectByVisibleText(fre);

            driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click(); // click on Calculate

            // 3️ Validation
            String act_mvalue = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();

            // Remove commas before comparing numeric values
            act_mvalue = act_mvalue.replace(",", "");
            exp_mvalue = exp_mvalue.replace(",", "");

            if (Double.parseDouble(exp_mvalue) == Double.parseDouble(act_mvalue)) {
                System.out.println("Test Passed for row " + i);
                ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Passed");
                ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
            } else {
                System.out.println("Test Failed for row " + i);
                ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Failed");
                ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
            }

            // 4️ Wait for overlay to disappear before clearing
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.wzrk-overlay")));
            } catch (Exception e) {
                System.out.println("No overlay found or already gone.");
            }

            // 5️ Click Clear button using JS to avoid interception
            WebElement clearBtn = driver.findElement(By.cssSelector("img.PL5"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clearBtn);

            Thread.sleep(2000); // optional wait before next iteration
        }

        driver.quit();
    }
}
