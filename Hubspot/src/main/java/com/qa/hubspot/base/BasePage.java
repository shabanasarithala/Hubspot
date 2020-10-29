package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.hubspot.utils.OptionsManager;
import com.qa.hubspot.utils.TimeUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	
	public WebDriver driver;
	public Properties prop;
	OptionsManager optionsManager;
	
	/**
	 *  This method is used to initialize the driver
	 * @param prop
	 * @return
	 */
	
	public WebDriver initialize_driver(Properties prop)   {
		String browser = prop.getProperty( "browser");
		
		System.out.println("browser name is - "+browser);
		optionsManager = new OptionsManager(prop);
		 
		if(browser.equalsIgnoreCase( "chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(optionsManager.getChromeOptions());
		}
		
		else if(browser.equalsIgnoreCase( "firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
		}
		
		else if(browser.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance( SafariDriver.class).setup();
		}
		else {
			System.out.println("browser not found please pass correct browser name");
		}
		
		driver.get(  prop.getProperty( "url"));
		 TimeUtil.shortWait();
		driver.manage().deleteAllCookies();
		 
		driver.manage().window().maximize();
		return driver;
		
		
	}
	
	 
		
	
/**
 * This method is used to initialize properties from config.properties file
 * @return
 */
	public Properties initialize_properties() {
		
		  prop = new Properties();
		  try {
			FileInputStream ip = new FileInputStream( ".\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
			 prop.load(ip);
			
		} catch (FileNotFoundException e) {
			 
			e.printStackTrace();
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
		  
		  return prop;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
