package com.inwebo.core.setup;

import com.inwebo.core.Mapper;
import com.inwebo.core.setup.ConfigManager;
import com.inwebo.data.Config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


//import selenium.driver.WebDriverUtility;

/** */
public class SetUp {

	/**
	 * 
	 * @throws IOException
	 */
	public static void setUp() throws IOException {
		String path = System.getProperty("config");
		String json = new String(Files.readAllBytes(Paths.get(path)));
		Config config = Mapper.INSTANCE.getObjectMapper().readValue(json, Config.class);
		
		ConfigManager.setConfig(config);
		ConfigManager.initWebDriver();
	}

	/**
	 * 
	 */
	public static void tearDown() {
		ConfigManager.closeWebDriver();	
	}
}
