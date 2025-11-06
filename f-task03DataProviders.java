package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

    // DataProvider 1
    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {

        String path = ".\\testData\\Opencart_LoginData.xlsx"; // Taking Excel file from testData folder

        ExcelUtility xlutil = new ExcelUtility(path); // Creating an object for ExcelUtility

        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1", 1);

        // Created a two-dimensional array to store data
        String logindata[][] = new String[totalrows][totalcols];

        // Read data from Excel and store it in the 2D array
        for (int i = 1; i <= totalrows; i++) { // i=1 because 0 is header
            for (int j = 0; j < totalcols; j++) {
                logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
            }
        }

        return logindata; // Returning two-dimensional array
    }
    
    // DataProvider 2
    
    
    // DataProvider 3
}


