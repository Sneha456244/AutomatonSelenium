package task17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class UploadDownloadTest {

    WebDriver driver;
    UploadDownloadPage uploadDownloadPage;
    String downloadPath;

    @BeforeClass
    public void setup() {
        // Set download folder
        downloadPath = Paths.get(System.getProperty("user.dir"), "downloads").toString();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadPath);
        prefs.put("download.prompt_for_download", false);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/upload-download");

        // Initialize Page Object
        uploadDownloadPage = new UploadDownloadPage(driver);
    }

    @Test
    public void verifyDownloadFunctionality() {
        uploadDownloadPage.downloadFile();
        System.out.println("Download button clicked successfully.");
        // Add verification logic for downloaded file if needed
    }

    @AfterClass
    public void teardown() {
            driver.quit();
    }
}
