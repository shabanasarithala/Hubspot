package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LogInPage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest {
	
	
	Properties prop;
	WebDriver driver;
	BasePage basepage;
	LogInPage loginpage;
	HomePage homepage;
	
	
	@BeforeTest
	public void setup() {
		 basepage = new BasePage();
		
		prop = basepage.initialize_properties();
		driver = basepage.initialize_driver(prop);
		loginpage = new LogInPage(driver);
		homepage = loginpage.do_LogIn( prop.getProperty( "usermail"), prop.getProperty("password"));
		
		
	}
	
	
	@Test(priority = 1)
	public void verify_HomePageTitle_Test() {
		String homepage_title = homepage.get_HomepageTitle();
		System.out.println("homepage title is - "+homepage_title);
		Assert.assertEquals( homepage_title, Constants.HomePage_Title , "homepage title not found .........");
	}
	
	@Test(priority = 2)
	public void verify_HomePageHeader_Test() {
	String	homepage_header = homepage.get_Homepage_Header();
	System.out.println("the homepage header is - "+homepage_header);
	Assert.assertEquals( homepage_header, Constants.HomePage_header , "homepage header not found....");
	}
	
	
	@Test(priority = 3)
	public void verify_Useraccount_Test() {
		String account_name = homepage.Verify_Useraccount();
		System.out.println("the account name is - "+account_name);
		Assert.assertEquals( account_name, prop.getProperty( "username"), "verify useraccount failed......");
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
