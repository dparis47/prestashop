package com.prestashop.core;

import java.text.MessageFormat;
import java.time.Duration;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.prestashop.core.field.UIField;
import com.prestashop.core.setup.ConfigManager;

/** */
public class UIElementAdapter {

	/** */
	protected Logger log;

	/** */
	public UIElementAdapter() {
		log = LogManager.getLogger(this.getClass().getName());
	}

	/**
	 * 
	 * @param url
	 * @return
	 */
	public boolean loadURL(String url) {
		try {
			ConfigManager.getDriver().get(url);
			ConfigManager.getDriver().manage().window().maximize();
			debug("url loaded");
			return true;
		} catch (Exception e) {
			error("Unable to connect to " + url);
			error(e.toString());
			return false;
		}
	}

	/**
	 * 
	 * @param b
	 * @param args
	 * @return
	 */
	public boolean click(Binding b, String... args) {
		Elt e = getXR(b, args);

		try {
			WebElement el = findElement(e.getBy());
			el.click();
			return true;
		} catch (StaleElementReferenceException stale) {
			error("error while clicking on button");
			return false;
		}

	}

	/**
	 * 
	 * @param value
	 * @param b
	 * @param args
	 * @return
	 */
	public boolean input(String value, Bindings b, String... args) {
		try {
			Elt e = getXR(b, args);
			UIField f = e.getUiField();
			return f.addValue(e, value);
		} catch (Exception ex) {
			error("Error during input");
			return false;
		}
	}

	/**
	 * 
	 * @param b
	 * @param args
	 * @return
	 */
	public String getText(Bindings b, String... args) {
		Elt e = getXR(b, args);
		WebElement el = findElement(e.getBy());
		return el.getText().trim();
	}

	/**
	 * 
	 * @param b
	 * @param args
	 * @return
	 */
	public String getInputFieldValue(Bindings b, String... args) {
		try {
			Elt e = getXR(b, args);
			UIField f = e.getUiField();
			return (f != null ? f.getValue(e) : null);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 
	 * @param by
	 * @return
	 */
	public WebElement findElement(By by) {
		return ConfigManager.getDriver().findElement(by);
	}

	/**
	 * 
	 * @return
	 */
	private Logger getLogger() {
		return log;
	}

	/**
	 * 
	 * @param message
	 */
	private void debug(String message) {
		getLogger().debug(message);
	}

	/**
	 * 
	 * @param message
	 */
	public void error(String message) {
		log.error(message);
	}

	public synchronized Elt getXR(Binding e, String... args) {
		return new Elt(e.getQueryType(), e.getFieldType(),
				MessageFormat.format(e.getQuery().trim().replace("'", "''"), args));
	}

}
