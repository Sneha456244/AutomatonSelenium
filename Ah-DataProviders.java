package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name="LoginData")
    public Object[][] getLoginData() throws Exception {
        String path = "./testData/LoginData.xlsx";
        Object[][] data = new Object[2][2];

        data[0][0] = ExcelUtility.getCellData(path, "Sheet1", 0, 0);
        data[0][1] = ExcelUtility.getCellData(path, "Sheet1", 0, 1);

        data[1][0] = ExcelUtility.getCellData(path, "Sheet1", 1, 0);
        data[1][1] = ExcelUtility.getCellData(path, "Sheet1", 1, 1);

        return data;
    }
}
