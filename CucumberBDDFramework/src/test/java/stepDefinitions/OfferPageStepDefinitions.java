package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import utils.TestContextSetup;

public class OfferPageStepDefinitions {
	public WebDriver driver;
	public String offerpageProductName;
	TestContextSetup textContextSetup;

	public OfferPageStepDefinitions(TestContextSetup textContextSetup) {
		this.textContextSetup = textContextSetup;
	}
	
	@Then("User searched for {string} shortname in offers page")
	public void user_searched_for_same_shorted_name_in_offers_page(String shortName) throws InterruptedException {

		// offer -> enter-> text
		textContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		Set<String> s1 = textContextSetup.driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		textContextSetup.driver.switchTo().window(childWindow);
		textContextSetup.driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortName);
		Thread.sleep(3000);
		offerpageProductName = textContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	}
	@Then("validate product name in offers page matches with Landing page")
	public void validate_product_name_in_offers_page_matches_with_Landing_page() {
        
		Assert.assertEquals(offerpageProductName, textContextSetup.landingpageProductName);
		
	}

}
