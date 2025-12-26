package task21;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DatePickerPage01 {

    WebDriver driver;

    @FindBy(id = "datepicker")
    WebElement dateInput;

    @FindBy(className = "ui-datepicker-calendar")
    WebElement calendarTable;

    public DatePickerPage01(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        System.out.println("[INFO] DatePickerPage initialized");
    }

    public boolean isDateInputDisplayed() {
        boolean displayed = dateInput.isDisplayed();
        System.out.println("[CHECK] Date input displayed: " + displayed);
        return displayed;
    }

    public boolean isDateInputEnabled() {
        boolean enabled = dateInput.isEnabled();
        System.out.println("[CHECK] Date input enabled: " + enabled);
        return enabled;
    }

    public void clickDateInput() {
        dateInput.click();
        System.out.println("[ACTION] Clicked date input box");
    }

    public boolean isCalendarDisplayed() {
        boolean displayed = calendarTable.isDisplayed();
        System.out.println("[CHECK] Calendar displayed: " + displayed);
        return displayed;
    }

    public String getDisplayedMonth() {
        String month = driver.findElement(By.className("ui-datepicker-month")).getText();
        System.out.println("[CHECK] Displayed month: " + month);
        return month;
    }

    public String getDisplayedYear() {
        String year = driver.findElement(By.className("ui-datepicker-year")).getText();
        System.out.println("[CHECK] Displayed year: " + year);
        return year;
    }

    public void selectTodayDate() {
        String today = String.valueOf(LocalDate.now().getDayOfMonth());
        selectDateByDay(today);
    }

    public void selectDateByDay(String day) {

        List<WebElement> dates = driver.findElements(
                By.xpath("//table[@class='ui-datepicker-calendar']//a"));

        System.out.println("[INFO] Total selectable dates: " + dates.size());

        for (WebElement date : dates) {
            if (date.getText().equals(day)) {
                date.click();
                System.out.println("[ACTION] Selected date: " + day);
                return;
            }
        }

        throw new RuntimeException("Date not found: " + day);
    }

    public String getSelectedDateValue() {
        String value = dateInput.getAttribute("value");
        System.out.println("[CHECK] Selected date value: " + value);
        return value;
    }

    public String getExpectedTodayDate() {
        String expected = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println("[CHECK] Expected today date: " + expected);
        return expected;
    }

    public boolean isDateFormatValid(String date) {
        boolean valid = date.matches("\\d{2}/\\d{2}/\\d{4}");
        System.out.println("[CHECK] Date format valid (MM/dd/yyyy): " + valid);
        return valid;
    }
}
