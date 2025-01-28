package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/features",glue = "stepdef",tags = "@uniqueSingUp or @End-To-End or @existUser or @invalidLog",plugin={"pretty","html:target/reports/report.html"})
public class run extends AbstractTestNGCucumberTests {

}
