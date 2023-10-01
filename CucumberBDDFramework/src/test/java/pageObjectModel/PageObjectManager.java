package pageObjectModel;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	public LandingPage landingPage;
	public CheckoutPage checkoutPage;
	public OffersPage offerPage; 
	
 public PageObjectManager(WebDriver driver) {
	 this.driver =driver; 
 }
 
 public LandingPage getLandingPage() {
	 landingPage = new  LandingPage(driver);
	 return landingPage;
}
 public OffersPage offerPage() {
	   offerPage = new OffersPage(driver);
	   return offerPage;
 }
 
 public CheckoutPage getCheckoutPage() {
	 
	 checkoutPage =new CheckoutPage(driver);
	 return checkoutPage;
 }
 
}
