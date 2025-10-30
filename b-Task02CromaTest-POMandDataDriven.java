package Task0002;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CromaTest01 {

    WebDriver driver;
    CromaPage01 croma;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        System.out.println("Croma Automation Test Started");
    }

        // Method to read Excel data
        public String[] getExcelData(int rowNum) throws IOException {
    	String filePath = System.getProperty("user.dir") + "\\testdata\\CromaData.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("SearchData");

        String url = sheet.getRow(rowNum).getCell(0).getStringCellValue();
        String product = sheet.getRow(rowNum).getCell(1).getStringCellValue();
        String message = sheet.getRow(rowNum).getCell(2).getStringCellValue();

        workbook.close();
        fis.close();

        return new String[]{url, product, message};
    }

    @Test(priority = 1)
    void testCromaFlow() throws Exception {

        // Run for multiple rows in Excel
        for (int i = 1; i <= 3; i++) {
            String[] data = getExcelData(i);
            String url = data[0];
            String product = data[1];
            String message = data[2];

            System.out.println("------------------------------");
            System.out.println("Test Data Row: " + i);
            System.out.println("URL: " + url);
            System.out.println("Product: " + product);
            System.out.println("Message: " + message);
            System.out.println("------------------------------");

            // Navigate to URL
            driver.get(url);
            croma = new CromaPage01(driver);

            // Execute test flow
            System.out.println("Starting Flow: " + message);
            croma.searchProduct(product);
            croma.selectBrandFilters();
            croma.selectFeatureFilters();
            croma.clearAllFilters();
            croma.openCart();
            croma.verifyCartPage();

            // Print current URL
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Final Page URL: " + currentUrl);
            System.out.println("Completed Flow for product: " + product);
        }

        Assert.assertTrue(true, "Croma Test Completed Successfully");
    }

    @AfterClass
    void tearDown() {
        driver.quit();
        System.out.println("Croma Automation Test Completed");
    }
}

