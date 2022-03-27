package com.prestashop.core.setup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.prestashop.data.Config;

import io.github.bonigarcia.wdm.WebDriverManager;

/** */
public class ConfigManager {
	
	/** */
	private static WebDriver driver;
	
	/** */
	private static Config config;

	
	/**
	 * @return the driver
	 */
	public static WebDriver getDriver() {
		return driver;
	}
		
	/**
	 * 
	 * @return
	 * @throws MalformedURLException
	 */
	public static void initWebDriver() throws MalformedURLException {
		WebDriver driver; 
		if (getConfig().isGrid()) {
			driver = getGridWebDriver();
		} else {
			driver = getWebDriver();
		}
		
		ConfigManager.driver = driver;
	}

	/** */
	public static Config getConfig() {
		return config;
	}


	public static void setConfig(Config config) {
		ConfigManager.config = config;
	}
	
	
	private static final String CHROME = "CHROME";
	private static final String FIREFOX = "FIREFOX";
	
	public static WebDriver getWebDriver() throws MalformedURLException {
		WebDriver webDriver;
		switch (getConfig().getBrowser()) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			webDriver = new FirefoxDriver(getFireFoxOptions());
			break;
		case CHROME:
		default:
			WebDriverManager.chromedriver().setup();
			webDriver = new ChromeDriver(getChromeOptions());
		}
		webDriver.manage().window().maximize();

		return webDriver;
	}

	/**
	 * 
	 * @return
	 * @throws MalformedURLException
	 */
	public static WebDriver getGridWebDriver() throws MalformedURLException {
		WebDriver webdriver;
		switch (getConfig().getBrowser()) {
		case FIREFOX:
			DesiredCapabilities caps = DesiredCapabilities.firefox();
			caps.setCapability("marionette", true);
			caps.setBrowserName("firefox");
			caps.setCapability("browser.privatebrowsing.autostart", true); 
			webdriver = new RemoteWebDriver(new URL(getConfig().getGridServer()), caps);
			break;
		case CHROME:
		default:
			webdriver = new RemoteWebDriver(new URL(getConfig().getGridServer()), getChromeOptions());
			break;
		}

		webdriver.manage().window().maximize();

		return webdriver;
	}

	/**
	 * 
	 */
	public static void closeWebDriver() {
		if (getDriver() != null)
			getDriver().quit();
	}

	/**
	 * 
	 * @return
	 */
	private static ChromeOptions getChromeOptions() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("lang=en-GB");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
		return options;
	}

	/**
	 * 
	 * @return
	 */
	private static FirefoxOptions getFireFoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages", "en-GB");
		options.setProfile(profile);
		return options;
	}

	
}
