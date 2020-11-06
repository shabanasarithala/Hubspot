package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	public static ThreadLocal<WebDriver> t1driver = new ThreadLocal<WebDriver>();
	
	public static synchronized WebDriver getDriver() {
		return t1driver.get();
 
		
	}
	
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
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
			t1driver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}
		
		else if(browser.equalsIgnoreCase( "firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			t1driver.set( new FirefoxDriver(optionsManager.getFirefoxOptions()));
		}
		
		else if(browser.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance( SafariDriver.class).setup();
			t1driver.set( new SafariDriver());
		}
		else {
			System.out.println("browser not found please pass correct browser name");
		}
		getDriver().manage().deleteAllCookies();
		 
		getDriver().manage().window().maximize();
		
		getDriver().get(  prop.getProperty( "url"));
		 TimeUtil.shortWait();
		
		return getDriver();
		
		
	}
	
	 
		
	
/**
 * This method is used to initialize properties from config.properties file
 * @return
 */
	public Properties initialize_properties() {
		
		  prop = new Properties();
		  String env = null;
		  String path = null;
		  try {
			   
			  env = System.getProperty("env");
				if (env == null) {
					path = "./src/main/java/com/qa/hubspot/config/config.properties";
				} else {
					switch (env) {
					case "qa":
						path = "./src/main/java/com/qa/hubspot/config/qa.config.properties";
						break;
					case "dev":
						path = "./src/main/java/com/qa/hubspot/config/dev.config.properties";
						break;
					case "stage":
						path = "./src/main/java/com/qa/hubspot/config/stage.config.properties";
						break;
					default:
						System.out.println("Please pass the correct env value...");
						break;
					}
				}
			FileInputStream ip = new FileInputStream(   path);
			 prop.load(ip);
			
		} catch (FileNotFoundException e) {
			 
			e.printStackTrace();
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
		  
		  return prop;
		
	}
	
	public String getScreenshot() {
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs( OutputType.FILE);
		String path = System.getProperty( "user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
		return path;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
