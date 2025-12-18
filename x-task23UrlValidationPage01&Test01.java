package task21;

import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.Map;

public class UrlValidationPage01 {

    WebDriver driver;

    public UrlValidationPage01(WebDriver driver) {
        this.driver = driver;
    }

    // Get current URL
    public String getCurrentUrl() 
    {
        return driver.getCurrentUrl();
    }

    // Extract query parameters
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

public class UrlValidationTest01 {

    WebDriver driver;
    UrlValidationPage01 page;

    @BeforeClass
    public void setup() 
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://reqres.in/api/users?page=2");

        page = new UrlValidationPage01(driver);
    }

    @Test
    public void verifyUrlParametersAndQueryStrings() 
    {

        Map<String, String> params = page.getQueryParams();

        // Validate parameter exists
        Assert.assertTrue(params.containsKey("page"),
                "Page parameter is missing");

        // Validate value
        Assert.assertEquals(params.get("page"), "2",
                "Page value is incorrect");

        // Validate parameter count
        Assert.assertEquals(params.size(), 1,
                "Unexpected query parameters found");
    }

    @AfterClass
    public void tearDown() 
    {
        driver.quit();
    }
}
