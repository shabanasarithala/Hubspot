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

public class LogInPageTest {
	
	Properties prop;
	WebDriver driver;
	BasePage basepage;
	LogInPage loginpage;
	
	
	@BeforeTest
	public void setup() {
		
		 basepage = new BasePage();
		prop = basepage.initialize_properties();
		driver = basepage.initialize_driver(prop);
		loginpage = new LogInPage(driver);
		
		
	}
	
	@Test(priority=1)
	public void verifyloginpage_title_Test() {
		String loginpage_title = loginpage.get_Loginpage_title();
		System.out.println("login page title is "+loginpage_title);
		Assert.assertEquals( loginpage_title, Constants.LogInPage_Title , "login page title not found...");
	}
	
	@Test(priority=2)
	public void verifysignup_link_Test() {
		Assert.assertTrue(loginpage.check_for_signuplink() , "signup link not found.....");
	}
	
	@Test(priority=3)
	public void login_Test() {
		HomePage homepage = loginpage.do_LogIn(prop.getProperty("usermail"),prop.getProperty("password"));
		Assert.assertEquals( homepage.Verify_Useraccount(), prop.getProperty("username") , "login failed ....");
	}
	
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	

}
