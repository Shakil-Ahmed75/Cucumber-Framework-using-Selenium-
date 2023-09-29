package pageObjectModel;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
	public WebDriver driver;
	public OfferPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	By search = By.xpath("//input[@placeholder='Search for Vegetables and Fruits']");
	By productName =By.cssSelector("tr td:nth-child(1)");
	
	public void searchItrem(String name) {
		driver.findElement(search).sendKeys(name);	
	}
	 public void getSearchText () {
		driver.findElement(search).getText();	
	}
	 public String getProductName() {
		 return driver.findElement(productName).getText();
		
	}
	

}
