package task17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ExportTest {

    WebDriver driver;
    ExportPage exportPage;
    String downloadPath;

    @BeforeClass
    public void setup() {
        downloadPath = Paths.get(System.getProperty("user.dir"), "downloads").toString();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadPath);
        prefs.put("download.prompt_for_download", false);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/FileDownload.html");

        exportPage = new ExportPage(driver);
    }

    public boolean isFileDownloaded(String extension) throws InterruptedException {
        Thread.sleep(3000);
        File folder = new File(downloadPath);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().endsWith(extension)) {
                    return file.exists();
                }
            }
        }
        return false;
    }

    @Test(priority = 1)
    public void verifyCSVExport() throws InterruptedException {
        exportPage.exportCSV();
        Assert.assertTrue(isFileDownloaded(".txt"), "CSV/Text export failed");
        System.out.println("CSV Export Test Passed");
    }

    @Test(priority = 2)
    public void verifyPDFExport() throws InterruptedException {
        exportPage.exportPDF();
        Assert.assertTrue(isFileDownloaded(".pdf"), "PDF export failed");
        System.out.println("PDF Export Test Passed");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

