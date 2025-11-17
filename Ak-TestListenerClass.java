package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testCases.BaseClass;

public class TestListenerClass implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = BaseClass.getDriver();
        try {
            if (driver == null) return;
            File screenshotsDir = new File("./screenshots");
            if (!screenshotsDir.exists()) screenshotsDir.mkdirs();

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
            String fileName = result.getName() + "_" + timestamp + ".png";
            Path dst = new File(screenshotsDir, fileName).toPath();
            Files.copy(src.toPath(), dst);
            System.out.println("Saved screenshot: " + dst.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // avoid listener throwing exceptions that kill test run
            e.printStackTrace();
        }
    }

    // other listener methods can be left empty or implemented as needed
    @Override public void onTestStart(ITestResult result) {}
    @Override public void onTestSuccess(ITestResult result) {}
    @Override public void onTestSkipped(ITestResult result) {}
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override public void onStart(ITestContext context) {}
    @Override public void onFinish(ITestContext context) {}
}
