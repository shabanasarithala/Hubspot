package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.utils.TimeUtil;

public class LogInPage {
	
	WebDriver driver ;
	 // bY LOCATORS
	By usermail = By.id("username");
	By password = By.id("password");
	By login_button = By.id( "loginBtn");
	By signup_link = By.linkText( "Sign up");
	
	// constructor of page class
	public LogInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// page actions or methods
	public String get_Loginpage_title() {
		   return  driver.getTitle();
		  
	}
	
	
	public boolean check_for_signuplink() {
		return driver.findElement(signup_link).isDisplayed();
	}
	
	public HomePage do_LogIn(String umail , String pwd) {
		driver.findElement(usermail).sendKeys(umail);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(login_button).click();
		 TimeUtil.longWait();
		return new HomePage(driver);
		
	}
	
	
	
	
	

}
