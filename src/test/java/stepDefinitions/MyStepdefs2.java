package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.in.pages.OrderPAge2;

public class MyStepdefs2 {
    @And("user click mbile section")
    public void userClickMobileSection() {
        new OrderPAge2().clickMobile2();
    }

    @Then("user navigates to srch tab")
    public void userNavigatesToSearchTab() {
        new OrderPAge2().GoToSearchTab2();
    }

    @And("user  navigate to men tab")
    public void userNavigateToMensTab() {
        new OrderPAge2().clickMensTab2();
    }
}
