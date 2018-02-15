package testrunner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features/", glue = "stepdefinitions", plugin = {"pretty", "html:target/cucumber",}, tags={"@paintcalculator"})

public class RunTest {

}
