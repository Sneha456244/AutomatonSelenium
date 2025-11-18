package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LeavePage {

    WebDriver driver;
    WebDriverWait wait;

    public LeavePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Leave Menu
    @FindBy(xpath="//span[normalize-space()='Leave']")
    WebElement menuLeave;

    // Show Leave with Status
    @FindBy(xpath="//label[normalize-space()='Show Leave with Status']/following::div[contains(@class,'oxd-select-text-input')][1]")
    WebElement showLeaveStatus;

    // Leave Type
    @FindBy(xpath="//label[normalize-space()='Leave Type']/following::div[contains(@class,'oxd-select-text-input')][1]")
    WebElement leaveTypeDropdown;

    // Employee Name
    @FindBy(xpath="//label[normalize-space()='Employee Name']/following::input[@placeholder='Type for hints...']")
    WebElement employeeName;

    // Sub Unit
    @FindBy(xpath="//label[normalize-space()='Sub Unit']/following::div[contains(@class,'oxd-select-text-input')][1]")
    WebElement subUnitDropdown;

    // Search Button
    @FindBy(xpath="//button[normalize-space()='Search']")
    WebElement searchButton;


    public void clickLeaveMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(menuLeave)).click();
    }

    public void openStatusDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(showLeaveStatus)).click();
    }

    public void openLeaveType() {
        wait.until(ExpectedConditions.elementToBeClickable(leaveTypeDropdown)).click();
    }

    public void enterEmployee(String emp) {
        wait.until(ExpectedConditions.visibilityOf(employeeName)).sendKeys(emp);
    }

    public void openSubUnitDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(subUnitDropdown)).click();
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
}
