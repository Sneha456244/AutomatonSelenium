package task20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class FileTransferTest {

    WebDriver driver;
    FileTransferPage page;

    String downloadPath = "C:\\Downloads";
    File uploadFile;

    @BeforeClass
    public void setup() throws Exception {

        System.out.println("Browser Setup Started");

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadPath);
        prefs.put("download.prompt_for_download", false);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/upload-download");

        page = new FileTransferPage(driver);

        // Create temp file for upload
        uploadFile = File.createTempFile("selenium-upload-", ".txt");
        FileWriter writer = new FileWriter(uploadFile);
        writer.write("This is a test file for Selenium upload");
        writer.close();

        System.out.println("Upload file created at: " + uploadFile.getAbsolutePath());
        System.out.println("Browser Setup Completed");
    }

    @Test
    public void verifyFileUploadAndDownloadWithValidations() throws InterruptedException {

        System.out.println("TEST STARTED: File Upload & Download");

        // Upload 
        System.out.println("Validating upload file exists");
        Assert.assertTrue(uploadFile.exists(), "Upload file does not exist");

        System.out.println("Uploading file");
        page.uploadFile(uploadFile.getAbsolutePath());

        System.out.println("Validating upload success message");
        Assert.assertTrue(page.isUploadTextDisplayed(),
                "Upload confirmation not displayed");

        System.out.println("Validating uploaded file name");
        Assert.assertTrue(page.getUploadedFileName().contains(uploadFile.getName()),
                "Uploaded file name mismatch");

        System.out.println("Upload validation PASSED");

        // Download 
        System.out.println("Checking download button enabled");
        Assert.assertTrue(page.isDownloadButtonEnabled(),
                "Download button disabled");

        File downloadedFile = new File(downloadPath + "\\sampleFile.jpeg");
        if (downloadedFile.exists()) {
            System.out.println("Old downloaded file deleted");
            downloadedFile.delete();
        }

        System.out.println("Clicking download button");
        page.clickDownload();
        Thread.sleep(3000);

        System.out.println("Validating downloaded file existence");
        Assert.assertTrue(downloadedFile.exists(),
                "Downloaded file not found");

        System.out.println("Validating downloaded file size");
        Assert.assertTrue(downloadedFile.length() > 0,
                "Downloaded file size is zero");

        System.out.println("TEST COMPLETED SUCCESSFULLY");
    }

    @AfterClass
    public void tearDown() {

        System.out.println("Closing Browser");

        if (uploadFile.exists()) {
            uploadFile.delete();
            System.out.println("Temporary upload file deleted");
        }

        driver.quit();
    }
}
