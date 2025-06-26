package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.in.utils.DriverFactory;
import org.in.utils.LogUtil;
import org.in.utils.TestContext;
import org.openqa.selenium.WebDriver;


public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        LogUtil.info(" Starting Scenario: " + scenario.getName());
        TestContext.setTestName(scenario.getName());
        TestContext.setScenario(scenario);

        WebDriver driver= DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            LogUtil.error("cenario FAILED: " + scenario.getName());
        } else {
            LogUtil.info(" Scenario PASSED: " + scenario.getName());
        }
        DriverFactory.quitDriver();
        LogUtil.info(" Browser session ended for: " + scenario.getName());
    }

}
