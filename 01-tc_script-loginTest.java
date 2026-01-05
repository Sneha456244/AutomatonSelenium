package test01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class scriptTest {

    WebDriver driver;
    scriptPage loginPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new scriptPage(driver);
    }

    // NEGATIVE TEST CASE: Invalid login
    @Test(priority = 1)
    public void invalidLoginTest() {
        loginPage.enterUsername("wrong_user");
        loginPage.enterPassword("wrong_pass");
        loginPage.clickLogin();

        String error = loginPage.getErrorMessage();
        System.out.println(" Negative Login Error: " + error); // console output

        Assert.assertTrue(
            error.contains("Username and password do not match"),
            "Expected error message not displayed for invalid login"
        );
    }

    // POSITIVE TEST CASE: Valid login
    @Test(priority = 2)
    public void validLoginTest() {
        driver.navigate().refresh();

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        String title = loginPage.getProductsTitle();
        System.out.println(" Positive Login Page Title: " + title); // console output

        // Fix for case-sensitive assertion
        Assert.assertTrue(
            title.equalsIgnoreCase("PRODUCTS"),
            "Login failed or Products page not displayed"
        );
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
