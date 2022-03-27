package com.prestashop.test.pom;

import static com.prestashop.core.PrestashopAssertion.assertEquals;
import static com.prestashop.core.PrestashopAssertion.assertTrue;

import com.prestashop.core.Bindings;

import io.qameta.allure.Step;

/** */
public class HomePagePOM extends Pom {

	/** */
	public static final String HEADER_TITLE_FR="Créez et développez votre boutique en ligne avec PrestaShop";

	/** */
	public static final String HEADER_TITLE_EN="Create and build your online store with PrestaShop";
	
	@Step("Load URL")
	public void loadURL() {
		boolean result = getUI().loadURL("https://www.prestashop.com/");
		assertTrue(result, "Load URL");
	}
	
	@Step("Check hearder title")
	public void checkHeaderTitle(String locale) {
		String result = getUI().getText(Bindings.HOME_PAGE_HEADER_TITLE, null);
		
		if("en".equals(HEADER_TITLE_EN)) {
			assertEquals(result, HEADER_TITLE_EN, "Chech EN header title");
		} else if ("fr".equals(HEADER_TITLE_FR)) {
			assertEquals(result, HEADER_TITLE_FR, "Chech FR header title");
		} else {
			//TODO other language
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSelectedlanguage() {
		return getUI().getText(Bindings.HOME_PAGE_LANGUAGE_SELECT, null);
	}
	
	@Step("Select language")
	public void selectlanguage(String locale) {
		boolean result = getUI().click(Bindings.HOME_PAGE_LANGUAGE_SELECT, null);
		assertTrue(result, "Click on select language button");
		
		 result = getUI().input(locale, Bindings.HOME_PAGE_LANGUAGE_SELECT, null);
		assertTrue(result, "Select language");
	}
	
}
