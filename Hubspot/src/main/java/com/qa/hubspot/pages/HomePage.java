package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil eu;

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
		eu = new ElementUtil(driver);
	}

	/**
	 * action methods of home page
	 * 
	 * @return
	 */

	public String get_HomepageTitle() {
		return eu.waitForTitleToBePresent(Constants.HomePage_Title, 15);
	}

	public String get_Homepage_Header() {
		if (eu.isDisplayed(header)) {
			return eu.get_text(header);
		} else
			return null;

	}

	public String Verify_Useraccount() {
		eu.waitForElementToBePresent(accountName, 10);
		eu.click(account_avtar);

		if (eu.isDisplayed(accountName)) {
			return eu.get_text(username);
		} else
			return null;

	}

}
