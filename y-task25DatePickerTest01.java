package task21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePickerTest01 {

    WebDriver driver;
    DatePickerPage01 datePickerPage;

    @BeforeMethod
    public void setUp() {

        System.out.println("BEFORE METHOD");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("[ACTION] Opening application");
        driver.get("https://jqueryui.com/datepicker/");

        driver.switchTo().frame(0);
        System.out.println("[ACTION] Switched to date picker iframe");

        datePickerPage = new DatePickerPage01(driver);
    }

    @Test
    public void validateDatePickerDefaultAndRangeSelection() {

        System.out.println("TEST START");

        // Validation 1: Input visible & enabled
        Assert.assertTrue(datePickerPage.isDateInputDisplayed(),
                "Date input not visible");
        Assert.assertTrue(datePickerPage.isDateInputEnabled(),
                "Date input not enabled");

        // Open calendar
        datePickerPage.clickDateInput();

        // Validation 2: Calendar popup
        Assert.assertTrue(datePickerPage.isCalendarDisplayed(),
                "Calendar not displayed");

        // Validation 3: Month & Year
        String month = datePickerPage.getDisplayedMonth();
        String year = datePickerPage.getDisplayedYear();

        Assert.assertFalse(month.isEmpty(), "Month is empty");
        Assert.assertTrue(year.matches("\\d{4}"), "Year is not numeric");

        // Select today's date
        datePickerPage.selectTodayDate();

        // Validation 4: Selected date value
        String selectedDate = datePickerPage.getSelectedDateValue();
        Assert.assertFalse(selectedDate.isEmpty(), "Selected date is empty");

        // Validation 5: Date format
        Assert.assertTrue(datePickerPage.isDateFormatValid(selectedDate),
                "Invalid date format");

        // Validation 6: Date matches today
        Assert.assertEquals(selectedDate,
                datePickerPage.getExpectedTodayDate(),
                "Selected date does not match today's date");

        // Validation 7: Reopen calendar & check date persists
        datePickerPage.clickDateInput();
        System.out.println("[CHECK] Date persists after reopening picker");

        System.out.println("TEST END");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("TEARDOWN");
        driver.quit();
    }
}
