package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class TC001_LoginTest extends BaseClass {

    @Test
    public void verifyLogin() {
        LoginPage lp = new LoginPage(getDriver());
        lp.setUserName(getProperties().getProperty("username"));
        lp.setPassword(getProperties().getProperty("password"));
        lp.clickLogin();

        DashboardPage dp = new DashboardPage(getDriver());
        Assert.assertTrue(dp.isDashboardDisplayed(), "Login Failed!");
    }
}
