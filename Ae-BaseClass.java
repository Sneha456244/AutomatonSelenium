package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

    protected static WebDriver driver;
    protected static Properties p;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuiteSetup() throws Exception {
        // load properties
        p = new Properties();
        FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
        p.load(fis);
        // create folders used by the framework
        createFolderIfNotExist("./screenshots");
        createFolderIfNotExist("./reports");
        createFolderIfNotExist("./logs");
    }

    @BeforeClass(alwaysRun = true)
    public void setup() {
        // Use WebDriverManager to manage drivers automatically
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // add options if needed
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(p.getProperty("baseURL"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static Properties getProperties() {
        return p;
    }

    private void createFolderIfNotExist(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }
}
