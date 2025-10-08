package Day10;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://practice.expandtesting.com/tables");
		driver.manage().window().maximize();
		
		//1) Find total no of rows in a table
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
		int totalRows = rows.size();
		System.out.println("no of rows: " + totalRows); //if we have multiple table in that webpage
		
		/*int rows = driver.findElements(By.tagName("tr")).size();
		System.out.println("No of rows: " + rows);*/ //if we have single table in that webpage

		
		//2) Find total no of columns in a table
		List<WebElement> Cols = driver.findElements(By.xpath("//table[@id='table1']//th"));
		int totalCols = Cols.size();
		System.out.println("no of columns: " + totalCols); //if we have multiple table in that webpage
		
		/*int cols = driver.findElements(By.tagName("th")).size();
		System.out.println("No of cols: " + cols);*/ //if we have single table in that webpage
		
		// 3) Read data from specific rows and columns
		String Classname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[4]/td[1]")).getText();
		System.out.println("Specific cell value: " + Classname);
		
		//4) Read data from all the rows and columns safely
		System.out.println("Last Name" + "\t" + "First Name" + "\t" + "Email" + "\t" + "Due" + "\t" + "Website");

		for (int r = 1; r <= rows.size(); r++) // start from 2 to skip header
		{
		    // Get all cells (td) of the current row
		    List<WebElement> cells = driver.findElements(By.xpath("//table[@id='table1']//tr[" + r + "]//td"));
		    
		    for (int c = 0; c < cells.size(); c++)
		    {
		        System.out.print(cells.get(c).getText() + "\t");
		    }
		    System.out.println(); // new line after each row
		}

		//5) Find email of the person whose Last Name is "Conway"
		for (int r = 2; r <= rows.size(); r++) { // skip header row
		    String lastName = driver.findElement(By.xpath("//table[@id='table1']//tr[" + r + "]//td[1]")).getText();
		    
		    if (lastName.equals("Conway")) {
		        String email = driver.findElement(By.xpath("//table[@id='table1']//tr[" + r + "]//td[3]")).getText();
		        System.out.println("Email of " + lastName + " is: " + email);
		        break; // stop after finding the first match
		    }
		}
		
		//6) Find total Due of all
		// Find total Due of all
		double totalDue = 0;

		// Get all rows (skip header row)
		for (int r = 2; r <= rows.size(); r++) {
		    // Get all td cells in this row
		    List<WebElement> cells = driver.findElements(By.xpath("//table[@id='table1']//tr[" + r + "]//td"));
		    
		    // Check if the 4th cell exists
		    if (cells.size() >= 4) {
		        String dueText = cells.get(3).getText(); // index 3 = 4th column
		        double due = Double.parseDouble(dueText.replace("$", "").trim());
		        totalDue += due;
		    }
		}

		System.out.println("Total Due of all: $" + totalDue);




	}
}
