package task18;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SliderTestPF {

    WebDriver driver;
    SliderPagePF sliderPage;

    @BeforeClass
    public void setup() 
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dev.automationtesting.in/sliders");
        sliderPage = new SliderPagePF(driver);
    }

    @Test
    public void moveSliderScenarios() throws InterruptedException 
    {
        // Move left
        sliderPage.moveSlider(-50);
        Thread.sleep(1000);
        sliderPage.printSliderValue();

        // Move right
        sliderPage.moveSlider(50);
        Thread.sleep(1000);
        sliderPage.printSliderValue();

        // Move more right
        sliderPage.moveSlider(100);
        Thread.sleep(1000);
        sliderPage.printSliderValue();
    }

    @AfterClass
    public void tearDown() 
    {
        driver.quit();
    }
}
