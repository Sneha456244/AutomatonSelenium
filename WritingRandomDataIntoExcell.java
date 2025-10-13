package Day14;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingRandomDataIntoExcel {

public static void main(String[] args) throws IOException {
		
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\Test04Random.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet("Random");
		
		XSSFRow row=sheet.createRow(7);
		XSSFCell cell=row.createCell(4);
		
		cell.setCellValue("Selenium");
		    
	    workbook.write(file);
	    workbook.close();
	    file.close();
	    
	    System.out.println("File is created...");
	}

}
