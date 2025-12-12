package task20;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomControlsPage {

    WebDriver driver;

    public CustomControlsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Custom radio labels
    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement maleRadio;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement femaleRadio;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement otherRadio;

    // Hidden radio inputs
    @FindBy(id = "gender-radio-1")
    WebElement maleRadioInput;

    @FindBy(id = "gender-radio-2")
    WebElement femaleRadioInput;

    @FindBy(id = "gender-radio-3")
    WebElement otherRadioInput;

    // ------------ ACTIONS -------------

    public void selectMale() {
        maleRadio.click();
    }

    public void selectFemale() {
        femaleRadio.click();
    }

    public void selectOther() {
        otherRadio.click();
    }

    // BASIC VALIDATIONS

    public boolean isMaleSelected() {
        return maleRadioInput.isSelected();
    }

    public boolean isFemaleSelected() {
        return femaleRadioInput.isSelected();
    }

    public boolean isOtherSelected() {
        return otherRadioInput.isSelected();
    }

    // EXTRA VALIDATIONS 

    public boolean isMaleEnabled() {
        return maleRadio.isEnabled();
    }

    public boolean isFemaleEnabled() {
        return femaleRadio.isEnabled();
    }

    public boolean isOtherEnabled() {
        return otherRadio.isEnabled();
    }

    public String getMaleLabel() {
        return maleRadio.getText();
    }

    public String getFemaleLabel() {
        return femaleRadio.getText();
    }

    public String getOtherLabel() {
        return otherRadio.getText();
    }
}
