package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class samplehome extends BasePage{
	
WebDriver driver ;
	
	By useremail = By.id( "username");
	By password = By.id( "password");
	By login_button = By.id( "loginBtn");
	By signup_link = By.linkText( "Sign up");
	
	

	public samplehome(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String umail , String pwd) {
		driver.findElement(useremail).sendKeys(umail);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(login_button).click();
		
	}

}
