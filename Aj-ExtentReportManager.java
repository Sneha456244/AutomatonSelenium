package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentReports getReport() {
        if (extent == null) {
            String reportName = "./reports/Report_" +
                    new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportName);
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

    public static ExtentTest createTest(String name) {
        ExtentTest t = getReport().createTest(name);
        test.set(t);
        return t;
    }

    public static ExtentTest getTest() {
        return test.get();
    }
}
