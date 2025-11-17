package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AdminPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class TC002_AdminSearchTest extends BaseClass {

    @Test
    public void verifyAdminUserSearch() throws InterruptedException {
        LoginPage lp = new LoginPage(getDriver());
        lp.setUserName(getProperties().getProperty("username"));
        lp.setPassword(getProperties().getProperty("password"));
        lp.clickLogin();

        DashboardPage dp = new DashboardPage(getDriver());
        Assert.assertTrue(dp.isDashboardDisplayed(), "Login failed!");

        AdminPage ap = new AdminPage(getDriver());
        ap.navigateToAdmin();
        ap.searchUser("Admin");
        Assert.assertTrue(ap.isResultDisplayed(), "User search failed!");
    }
}
