package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.in.pages.OrderPage;
import org.in.utils.NavigationUtils;
import org.junit.jupiter.api.Order;

public class TestStepdefs {


    @Given("user navigate to URL")
    public void userNavigateToURL() {
        NavigationUtils.navigateTo();
    }

    @Then("user navigates to search tab")
    public void userNavigatesToSearchTab() {
        new OrderPage().GoToSearchTab();
    }

    @And("user click mobile section")
    public void userClickMobileSection() {
        new OrderPage().clickMobile();
    }

    @When("user searches for product {string}")
    public void userSearchesForProduct(String product) {
        new OrderPage().searchMonitor(product);
    }

    @And("user  navigate to mens tab")
    public void userNavigateToMensTab() {
        new OrderPage().clickMensTab();
    }
}
