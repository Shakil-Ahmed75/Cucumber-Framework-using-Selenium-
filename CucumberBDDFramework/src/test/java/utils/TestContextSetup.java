package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjectModel.PageObjectManager;

public class TestContextSetup {
	public WebDriver driver;
	public String landingpageProductName;
	public PageObjectManager pageObjectManager;
    public TestBase testbase;
    public GenericUtils genericUtils;
  public TestContextSetup() throws IOException {
	  testbase = new TestBase();
	  PageObjectManager pageObjectManager = new PageObjectManager(testbase.WebDriverManager());
	  genericUtils = new GenericUtils(testbase.WebDriverManager());
  } 
	
}
