package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjectModel.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinitions {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerpageProductName;
	TestContextSetup textContextSetup;

	public LandingPageStepDefinitions(TestContextSetup textContextSetup) {
		this.textContextSetup = textContextSetup;
	}

	@Given("User is on greenCart Landing Page")
	public void user_is_on_green_cart_landing_page() {
		textContextSetup.driver = new ChromeDriver();
		textContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}

	@When("user search shortname {string} and extracted actual name of product")
	public void user_search_short_name_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		LandingPage landingPage = new LandingPage(textContextSetup.driver);
		landingPage.searchItrem(shortName);	
	    Thread.sleep(3000);
		textContextSetup.landingpageProductName = landingPage.getProductName().split("-")[0].trim();
		//System.out.println(landingpageProductName + " is extracted from HomePage");
	}
	
}
