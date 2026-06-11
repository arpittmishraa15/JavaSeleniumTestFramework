package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.in.pages.APITesting;
import org.in.pages.OrderPage;
import org.in.utils.NavigationUtils;
import org.junit.jupiter.api.Order;

public class TestStepdefs {


    @Given("user navigate to URL")
    public void userNavigateToURL() {
        NavigationUtils.navigateTo();
    }

    @Then("user navigates to aboutUS tab")
    public void userNavigatesToAboutUSTab() {
        new OrderPage().clickAboutUS();
    }

    @And("user click home tab")
    public void userClickHomeTab() {
        new OrderPage().clickHome();

    }

    @When("user types user name as {string} and password as {string}")
    public void userTypesUserNameAsAndPasswordAs(String user, String pass) {
        new OrderPage().loginUser(user, pass);
    }



    @When("user triggers GET API")
    public void userTriggersGETAPI() {
        APITesting.triggerGetAPI();
    }

    @When("user triggers POST API")
    public void userTriggersPOSTAPI() {
        APITesting.triggerPostAPI();
    }
}

