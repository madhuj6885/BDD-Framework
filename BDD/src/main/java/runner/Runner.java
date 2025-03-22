package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features = "featurefiles",
		glue={"stepdefinitions","hooks"},
		monochrome = true,
		dryRun = true,
		plugin = {"html:target/report.html","json:target/report.json"},
		tags="@Add_to_cart"
		)
public class Runner extends AbstractTestNGCucumberTests{

}
