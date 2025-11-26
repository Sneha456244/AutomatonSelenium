package task17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExportPage {

    WebDriver driver;

    @FindBy(id = "textbox")
    WebElement textArea;

    @FindBy(id = "createTxt")
    WebElement generateTxtBtn;

    @FindBy(id = "link-to-download")
    WebElement downloadTxtBtn;

    @FindBy(id = "pdfbox")
    WebElement pdfTextArea;

    @FindBy(id = "createPdf")
    WebElement generatePdfBtn;

    @FindBy(id = "pdf-link-to-download")
    WebElement downloadPdfBtn;

    public ExportPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void exportCSV() {
        textArea.sendKeys("Automation Export CSV Testing");
        generateTxtBtn.click();
        downloadTxtBtn.click();
    }

    public void exportPDF() {
        pdfTextArea.sendKeys("Automation Export PDF Testing");
        generatePdfBtn.click();
        downloadPdfBtn.click();
    }
}

