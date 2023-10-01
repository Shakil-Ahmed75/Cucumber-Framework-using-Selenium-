package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjectModel.LandingPage;
import pageObjectModel.OffersPage;
import pageObjectModel.PageObjectManager;
import utils.GenericUtils;
import utils.TestContextSetup;

public class OfferPageStepDefinitions {
	public WebDriver driver;
	public String OffersPageProductName;
	public PageObjectManager pageObjectManager;
	public GenericUtils genericUtils;
	TestContextSetup testContextSetup;
	

	public OfferPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException{

		switchToOffersPage();
		OffersPage OffersPage = new OffersPage(testContextSetup.driver);
		OffersPage.searchItrem(shortName);
		Thread.sleep(3000);
		OffersPageProductName = OffersPage.getProductName();
	}

	public void switchToOffersPage()
	{
		//if switched to offer page-> skip below part
		// offer -> enter-> text
		   // pageObjectManager = new PageObjectManager(testContextSetup.driver);
			LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
			landingPage.selectedTopDeals();
			testContextSetup.genericUtils.SwitchWindowToChild();
		//explicit wait, parse string
		
		
	}

	@Then("validate product name in offers page matches with Landing page")
	public void validate_product_name_in_offers_page_matches_with_Landing_page() {

		Assert.assertEquals(OffersPageProductName, testContextSetup.landingpageProductName);

	}

}
