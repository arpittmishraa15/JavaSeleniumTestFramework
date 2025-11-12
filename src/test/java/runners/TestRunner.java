package runners;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@ConfigurationParameter(
        key = io.cucumber.junit.platform.engine.Constants.FEATURES_PROPERTY_NAME,
        value = "src/test/resources/features"
)
@ConfigurationParameter(
        key = io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME,
        value = "stepDefinitions"
)
@ConfigurationParameter( key = io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME,
        value = "pretty, html:target/cucumber-reports/report.html, json:target/cucumber-reports/report.json")
@ConfigurationParameter(
        key = io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME,
        value = ""
) // Tag you want to run
//@ExtendWith(RetryExtension.class)
public class TestRunner {
}
