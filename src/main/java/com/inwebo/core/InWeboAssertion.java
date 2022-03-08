package com.inwebo.core;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.inwebo.core.setup.ConfigManager;

import io.qameta.allure.Attachment;

/** */
public class InWeboAssertion {

	/** */
	private static final String ALL = "ALL";

	/** */
	private static final String FAIL = "FAIL";
	
	/** */
	private static final String ERROR = " ERROR while : ";

	/** */
	private static Logger log = LogManager.getLogger("Assertions");

	/**
	 * 
	 * @param condition
	 * @param message
	 */
	public static void assertTrue(boolean condition, String message) {
		try {
			Assertions.assertTrue(condition, LocalDateTime.now() + ERROR + message);
			getLogger().info(message);

			if (ALL.equalsIgnoreCase(ConfigManager.getConfig().getScreenshot())) {
				takeScreenshot();
			}
		} catch (AssertionError err) {
			if ((ALL.equalsIgnoreCase(ConfigManager.getConfig().getScreenshot()))
					|| (FAIL.equalsIgnoreCase(ConfigManager.getConfig().getScreenshot()))) {
				takeScreenshot();
			}
			throw err;
		}
	}

	/**
	 * 
	 * @param expected
	 * @param actual
	 * @param message
	 */
	public static void assertEquals(Object expected, Object actual, String message) {
		try {

			Assertions.assertEquals(expected, actual, LocalDateTime.now() + ERROR + message);
			getLogger().info(message);

			if (ALL.equalsIgnoreCase(ConfigManager.getConfig().getScreenshot())) {
				takeScreenshot();
			}
		} catch (AssertionError err) {

			if ((ALL.equalsIgnoreCase(ConfigManager.getConfig().getScreenshot()))
					|| (FAIL.equalsIgnoreCase(ConfigManager.getConfig().getScreenshot()))) {
				takeScreenshot();
			}
			throw err;
		}
	}

	@Attachment(value = "screenshot", type = "image/png")
	public static byte[] takeScreenshot() {
		return ((TakesScreenshot) ConfigManager.getDriver()).getScreenshotAs(OutputType.BYTES);
	}

	private static Logger getLogger() {
		return log;
	}
	
}
