package com.prestashop.core.setup;

import com.prestashop.core.Mapper;
import com.prestashop.core.setup.ConfigManager;
import com.prestashop.data.Config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
