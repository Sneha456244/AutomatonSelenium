package testCases;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.LeavePage;

public class TC004_Leave_ApplyTest extends BaseClass {

    @Test
    public void verifyLeaveFilters() throws Exception {

        System.out.println("TC004: START");

        // Login
        LoginPage lp = new LoginPage(getDriver());
        lp.setUserName(getProperties().getProperty("username"));
        lp.setPassword(getProperties().getProperty("password"));
        lp.clickLogin();

        // Leave Page Actions
        LeavePage leave = new LeavePage(getDriver());
        leave.clickLeaveMenu();
        leave.openStatusDropdown();
        leave.openLeaveType();
        leave.enterEmployee("Admin");
        leave.openSubUnitDropdown();
        leave.clickSearch();

        System.out.println("TC004: COMPLETED");
    }
}
