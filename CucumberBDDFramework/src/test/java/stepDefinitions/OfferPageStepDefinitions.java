package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjectModel.LandingPage;
import pageObjectModel.OfferPage;
import pageObjectModel.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinitions {
	public WebDriver driver;
	public String offerpageProductName;
	public PageObjectManager pageObjectManager;
	TestContextSetup textContextSetup;

	public OfferPageStepDefinitions(TestContextSetup textContextSetup) {
		this.textContextSetup = textContextSetup;
	}

	@Then("User searched for {string} shortname in offers page")
	public void user_searched_for_same_shorted_name_in_offers_page(String shortName) throws InterruptedException {

		switchToOffersPage();
		OfferPage offerPage = new OfferPage(textContextSetup.driver);
		offerPage.searchItrem(shortName);
		textContextSetup.driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortName);
		Thread.sleep(3000);
		offerpageProductName = offerPage.getProductName();
	}

	public void switchToOffersPage()
	{
		//if switched to offer page-> skip below part
		// offer -> enter-> text
		   // pageObjectManager = new PageObjectManager(textContextSetup.driver);
			LandingPage landingPage = textContextSetup.pageObjectManager.getLandingPage();
			landingPage.selectedTopDeals();
			Set<String> s1 = textContextSetup.driver.getWindowHandles();
			Iterator<String> i1 = s1.iterator();
			String parentWindow = i1.next();
			String childWindow = i1.next();
			textContextSetup.driver.switchTo().window(childWindow);
		//explicit wait, parse string
		
		
	}

	@Then("validate product name in offers page matches with Landing page")
	public void validate_product_name_in_offers_page_matches_with_Landing_page() {

		Assert.assertEquals(offerpageProductName, textContextSetup.landingpageProductName);

	}

}
