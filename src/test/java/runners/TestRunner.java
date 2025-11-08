package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue= "stepDefinitions",
        tags= "@test22",
        plugin = {
                "pretty",
                "html:src/test/resources/cucumber-reports/index.html",
                "json:src/test/resources/cucumber-reports/cucumber.json"
        }

)


public class TestRunner {
}
