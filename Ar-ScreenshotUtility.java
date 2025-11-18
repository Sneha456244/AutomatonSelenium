package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.*;

import org.apache.commons.io.FileUtils;

public class ScreenshotUtility {

    public static String capture(WebDriver driver, String testName) {
        try {
            String ts = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
            String path = "./screenshots/" + testName + "_" + ts + ".png";
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(path);
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot saved at: " + path);
            return path;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

