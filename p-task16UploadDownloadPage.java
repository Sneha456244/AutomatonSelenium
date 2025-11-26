package task17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadDownloadPage {

    WebDriver driver;

    // locators
    @FindBy(id = "uploadFile")
    WebElement uploadButton;

    @FindBy(id = "downloadButton")
    WebElement downloadButton;

    // Constructor
    public UploadDownloadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to upload file
    public void uploadFile(String filePath) {
        uploadButton.sendKeys(filePath);
    }

    // Method to download file
    public void downloadFile() {
        downloadButton.click();
    }
}
