package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.samplehome;

public class sampleTest {
	
	Properties prop;
	WebDriver driver;
	BasePage basepage;
	samplehome sampleho;
	 
	
	
	@BeforeTest
	public void setup() {
		
		 basepage = new BasePage();
		prop = basepage.initialize_properties();
		driver = basepage.initialize_driver(prop);
		sampleho = new samplehome(driver);
		 
		
		
	}
	
	@Test
	public void login() {
		sampleho.login( prop.getProperty("usermail"), prop.getProperty( "password"));
	}

}
