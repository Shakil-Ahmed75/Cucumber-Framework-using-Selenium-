package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MainSteps {
	

@Given("user is on netBanking landing Page")
public void user_is_on_net_banking_landing_page() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("user is on netBanking landing Page");
}

@When("user login into application")
public void user_login_into_application() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("user login into application");
}

@Then("Home Page is displayed")
public void home_page_is_displayed() {
    // Write code here that turns the phrase above into concrete actions
  System.out.println("Home Page is displayed");
}

@Then("cards are displayed")
public void cards_are_displayed() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("cards are displayed");
}

}
