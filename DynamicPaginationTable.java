package Day10;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationTable {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://datatables.net/examples/data_sources/ajax.html");
        driver.manage().window().maximize();
        
        // 1 Read "Showing 1 to 10 of 57 entries"
        String text = driver.findElement(By.id("example_info")).getText();
        System.out.println("Info Text: " + text);
        
        // 2️ Calculate total pages
        int totalEntries = Integer.parseInt(text.split("of")[1].replaceAll("[^0-9]", ""));
        int rowsPerPage = 10; // default rows per page
        int totalPages = (int) Math.ceil((double) totalEntries / rowsPerPage);
        System.out.println("Total Pages: " + totalPages);
        
        // 3️ Loop through pages
        for(int p = 1; p <= totalPages; p++) {

            if(p > 1) {
                // Click on page number
                WebElement activePage = driver.findElement(By.xpath("//a[@data-dt-idx='" + p + "']"));
                activePage.click();
                Thread.sleep(1000); // wait for page to load
            }

            // 4️ Read data from the page
            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='example']//tbody/tr"));
            for(WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                for(WebElement cell : cells) {
                    System.out.print(cell.getText() + "\t");
                }
                System.out.println();
            }
        }
        
        driver.quit();
    }
}
