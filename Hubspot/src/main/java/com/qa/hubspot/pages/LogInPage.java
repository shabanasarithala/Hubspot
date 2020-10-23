package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;
import com.qa.hubspot.utils.TimeUtil;

public class LogInPage {

	WebDriver driver;
	ElementUtil eu;
	// bY LOCATORS
	By usermail = By.id("username");
	By password = By.id("password");
	By login_button = By.id("loginBtn");
	By signup_link = By.linkText("Sign up");

	// constructor of page class
	public LogInPage(WebDriver driver) {
		this.driver = driver;
		eu = new ElementUtil(driver);
	}

	// page actions or methods
	public String get_Loginpage_title() {
		return eu.waitForTitleToBePresent(Constants.LogInPage_Title, 10);

	}

	public boolean check_for_signuplink() {
		return eu.isDisplayed(signup_link);
	}

	public HomePage do_LogIn(String umail, String pwd) {

		eu.sendkeys(usermail, umail);
		eu.sendkeys(password, pwd);
		eu.click(login_button);

		TimeUtil.longWait();
		return new HomePage(driver);

	}

}
