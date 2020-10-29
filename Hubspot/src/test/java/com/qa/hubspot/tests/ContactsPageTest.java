package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LogInPage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ExcelUtil;

public class ContactsPageTest {
	
	Properties prop;
	WebDriver driver;
	BasePage basepage;
	LogInPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	
	@BeforeTest
	public void setup() {
		 basepage = new BasePage();
		
		prop = basepage.initialize_properties();
		driver = basepage.initialize_driver(prop);
		loginpage = new LogInPage(driver);
		homepage = loginpage.do_LogIn( prop.getProperty( "usermail"), prop.getProperty("password"));
		contactspage = homepage.goToContactsPage();
		
		
	}
	
	
	@Test(priority = 1)
	public void verify_ContactsPageTitle_Test() {
		String contactspage_title = contactspage.getContactsPageTitle();
		System.out.println("homepage title is - "+contactspage_title);
		Assert.assertEquals( contactspage_title, Constants.ContactsPage_Title , "contacts page title not found .........");
	}
	
	@DataProvider
	public Object[][] getContactsTestData() {
		Object data [][] = ExcelUtil.getTestData( Constants.Contacts_sheetName);
		return data;
		
	}
	
	@Test(priority = 2 , dataProvider = "getContactsTestData")
	public void createNewContact_Test(String email , String firstname , String lastname , String jobtitle){
		contactspage.createNewContact(email, firstname, lastname, jobtitle);
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
