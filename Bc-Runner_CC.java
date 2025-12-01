package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "C:\\Users\\Sneha S\\AutomationWebDrive\\Cucumber_testNG\\src\\test\\resources\\Features",
		glue="StepDef"
		)

public class Runner extends AbstractTestNGCucumberTests{

	
}
