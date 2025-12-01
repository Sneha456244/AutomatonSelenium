package task18;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliderPagePF 
{

    WebDriver driver;
    Actions actions;

    @FindBy(xpath = "//span[@role='slider']")
    WebElement sliderHandle;

    public SliderPagePF(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    // Move slider by offset
    public void moveSlider(int xOffset) 
    {
        actions.clickAndHold(sliderHandle).moveByOffset(xOffset, 0).release().perform();
    }

    // Print slider value
    public void printSliderValue() 
    {
        String value = sliderHandle.getAttribute("aria-valuenow"); 
        System.out.println("Slider current value: " + value);
    }
}
