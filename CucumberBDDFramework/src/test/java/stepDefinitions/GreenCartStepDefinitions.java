package stepDefinitions;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreenCartStepDefinitions {
	public WebDriver driver;
	public String landingpageProductName;
	public String offerpageProductName;

	@Given("User is on greenCart Landing Page")
	public void user_is_on_green_cart_landing_page() {
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}

	@When("user search shortname {string} and extracted actual name of product")
	public void user_search_short_name_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Search for Vegetables and Fruits']")).sendKeys(shortName);
		Thread.sleep(3000);
		landingpageProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println(landingpageProductName + " is extracted from HomePage");
	}

	@Then("User searched for {string} shortname in offers page")
	public void user_searched_for_same_shorted_name_in_offers_page(String shortName) throws InterruptedException {

		// offer -> enter-> text
		driver.findElement(By.linkText("Top Deals")).click();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortName);
		Thread.sleep(3000);
		offerpageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	}

	@Then("validate product name in offers page matches with Landing page")
	public void validate_product_name_in_offers_page_matches_with_Landing_page() {
        
		Assert.assertEquals(offerpageProductName, landingpageProductName);
		
	}

}
