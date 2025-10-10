package Day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
        driver.manage().window().maximize();

        // Single file upload - FirstTestcase.txt
        /*driver.findElement(By.xpath("//input[@id='filesToUpload']"))
              .sendKeys("C:\\Users\\Sneha S\\AutomationWebDrive\\seleniumwebdrive\\src\\test\\java\\day01");

        Thread.sleep(2000); 

        // Get uploaded file name
        String uploadedFileName = driver.findElement(By.xpath("//ul[@id='fileList']/li")).getText();

        // Verify upload
        if (uploadedFileName.equals("day01")) {
            System.out.println("File successfully uploaded");
        } else {
            System.out.println("Upload failed");
        }*/

        // Multiple file upload - provide full paths to each file separated by "\n"
        String file1 = "C:\\Users\\Sneha S\\AutomationWebDrive\\seleniumwebdrive\\src\\test\\java\\day01";
        String file2 = "C:\\Users\\Sneha S\\AutomationWebDrive\\seleniumwebdrive\\src\\test\\java\\day02";

        driver.findElement(By.xpath("//input[@id='filesToUpload']"))
              .sendKeys(file1 + "\n" + file2);

        Thread.sleep(2000); 

        // Get uploaded file names
        String uploadedFile1 = driver.findElement(By.xpath("//ul[@id='fileList']/li[1]")).getText();
        String uploadedFile2 = driver.findElement(By.xpath("//ul[@id='fileList']/li[2]")).getText();

        // Verify upload
        if (uploadedFile1.equals("day01") && uploadedFile2.equals("day02")) {
            System.out.println("Both files successfully uploaded!");
        } else {
            System.out.println("Upload failed for one or both files");
        }

        //driver.quit();
    }
}
