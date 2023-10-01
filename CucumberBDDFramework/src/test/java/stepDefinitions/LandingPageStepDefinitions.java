package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjectModel.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinitions {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerpageProductName;
	public LandingPage landingPage;
	TestContextSetup testContextSetup ;

	public LandingPageStepDefinitions(TestContextSetup testContextSetup ) {
		this.testContextSetup  = testContextSetup ;
	}

	@Given("User is on greenCart Landing Page")
	public void user_is_on_green_cart_landing_page() {
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));

	}

	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_search_short_name_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
		landingPage.searchItrem(shortName);	
	    Thread.sleep(3000);
		testContextSetup .landingpageProductName = landingPage.getProductName().split("-")[0].trim();
		//System.out.println(landingpageProductName + " is extracted from HomePage");
	}
	
	
	@When("Added {string} items of the selected product to cart")
	public void Added_items_product(String quantity)
	{
		
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
		
	}
		
	
}
