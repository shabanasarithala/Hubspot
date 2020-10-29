package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;
import com.qa.hubspot.utils.JavaScriptUtil;

public class ContactsPage {
	
	WebDriver driver;
	ElementUtil eu;
	JavaScriptUtil jsUtil;
	
	By createContact = By.xpath( "(//span[text()='Create contact'])[1]");
	By createContactForm = By.xpath( "(//span[text()='Create contact'])[2]");
	By email = By.xpath( "//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath( "//input[@data-field='lastname']");
	By jobTitle = By.xpath( "//textarea[@data-field='jobtitle']");
	By contactsNavigation = By.xpath( "(//i18n-string[text( ) ='Contacts'])[2]");


	 
	/**
	 * constructor of contacts page
	 * 
	 * @param driver
	 */

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		eu = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	public String getContactsPageTitle() {
		return eu.waitForTitleToBePresent(Constants.ContactsPage_Title, 15);
	}
	
	
	public void createNewContact(String emailId , String firstname , String lastname , String jobtitle) {
		eu.waitForElementToBePresent(createContact,  10);
		eu.click(createContact);
		eu.waitForElementToBePresent(email,  10).sendKeys( emailId);
		eu.waitForElementToBePresent(firstName,  5).sendKeys( firstname);
		eu.waitForElementToBePresent(lastName,  5).sendKeys(lastname);
		eu.waitForElementToBePresent(jobTitle,  10).sendKeys( jobtitle);
		eu.waitForElementToBeClickable(createContactForm,  10);
		jsUtil.clickElementByJS( eu.get_element(createContactForm));
		eu.waitForElementToBePresent(contactsNavigation, 15);
		eu.click(contactsNavigation);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
