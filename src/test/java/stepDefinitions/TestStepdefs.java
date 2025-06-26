package stepDefinitions;

import io.cucumber.java.en.Given;
import org.in.utils.NavigationUtils;

public class TestStepdefs {


    @Given("user navigate to URL")
    public void userNavigateToURL() {
        NavigationUtils.navigateTo();
    }
}
