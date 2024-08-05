package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features=".//Features/customers.feature",glue="StepDefination",dryRun=true,monochrome=true,plugin= {"json:target/json/cucumberjson.json","html:target/html/cucumberhtml.html","junit:target/junit/junitreport"})


public class TestRun {

}
