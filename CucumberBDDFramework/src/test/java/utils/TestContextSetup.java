package utils;

import org.openqa.selenium.WebDriver;

import pageObjectModel.PageObjectManager;

public class TestContextSetup {
	public WebDriver driver;
	public String landingpageProductName;
	public PageObjectManager pageObjectManager;

  public TestContextSetup() {
	  PageObjectManager pageObjectManager = new PageObjectManager(driver);
	  
  } 
	
}
