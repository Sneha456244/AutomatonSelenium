package utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility {

    public static String getCellData(String filePath, String sheetName, int row, int col) throws Exception {
        FileInputStream fi = new FileInputStream(filePath);
        XSSFWorkbook wb = new XSSFWorkbook(fi);
        XSSFSheet sheet = wb.getSheet(sheetName);
        String data = sheet.getRow(row).getCell(col).getStringCellValue();
        wb.close();
        return data;
    }
}

