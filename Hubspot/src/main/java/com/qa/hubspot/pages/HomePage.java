package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {

	WebDriver driver;

	By header = By.cssSelector("h1.dashboard-selector__title");
	By account_avtar = By.id("account-menu-container");
	By username = By.className("user-info-name");
	By accountName = By.className("user-info-email");

	/**
	 * constructor of home page
	 * 
	 * @param driver
	 */

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * action methods of home page
	 * 
	 * @return
	 */

	public String get_HomepageTitle() {
		return driver.getTitle();
	}

	public String get_Homepage_Header() {
		if (driver.findElement(header).isDisplayed()) {
			return driver.findElement(header).getText();
		} else
			return null;

	}

	public String Verify_Useraccount() {

		driver.findElement(account_avtar).click();
		if (driver.findElement(username).isDisplayed()) {
			return driver.findElement(username).getText();
		} else
			return null;

	}

}
