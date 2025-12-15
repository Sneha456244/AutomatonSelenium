package task20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileTransferPage {

    WebDriver driver;

    public FileTransferPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "uploadFile")
    WebElement uploadInput;

    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFileText;

    @FindBy(id = "downloadButton")
    WebElement downloadButton;

    public void uploadFile(String filePath) {
        uploadInput.sendKeys(filePath);
    }

    public boolean isUploadTextDisplayed() {
        return uploadedFileText.isDisplayed();
    }

    public String getUploadedFileName() {
        return uploadedFileText.getText();
    }

    public boolean isDownloadButtonEnabled() {
        return downloadButton.isEnabled();
    }

    public void clickDownload() {
        downloadButton.click();
    }
}
