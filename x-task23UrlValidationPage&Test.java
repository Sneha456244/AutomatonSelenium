package task21;

import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.Map;

public class UrlValidationPage {

    WebDriver driver;

    public UrlValidationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Get current URL
    public String getCurrentUrl() 
    {
        return driver.getCurrentUrl();
    }

    // Extract query parameters into Map
    public Map<String, String> getQueryParams() 
    {
        String url = driver.getCurrentUrl();
        String queryString = url.split("\\?")[1];

        String[] params = queryString.split("&");
        Map<String, String> paramMap = new HashMap<>();

        for (String param : params) 
        {
            String[] keyValue = param.split("=");
            paramMap.put(keyValue[0], keyValue[1]);
        }
        return paramMap;
    }
}


package task21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Map;

public class UrlValidationTest {

    WebDriver driver;
    UrlValidationPage page;

    @BeforeClass
    public void setup() 
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://httpbin.org/get?query=selenium&page=1&sort=asc");
        page = new UrlValidationPage(driver);
    }

    @Test
    public void verifyUrlParametersAndQueryStrings() 
    {

        Map<String, String> params = page.getQueryParams();

        // Validate parameter presence
        Assert.assertTrue(params.containsKey("query"), "Query param missing");
        Assert.assertTrue(params.containsKey("page"), "Page param missing");
        Assert.assertTrue(params.containsKey("sort"), "Sort param missing");

        // Validate parameter values
        Assert.assertEquals(params.get("query"), "selenium");
        Assert.assertEquals(params.get("page"), "1");
        Assert.assertEquals(params.get("sort"), "asc");

        // Validate no extra parameters
        Assert.assertEquals(params.size(), 3, "Unexpected parameters found");
    }

    @AfterClass
    public void tearDown() 
    {
        driver.quit();
    }
}

