package com.prestashop.test.testcase;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.prestashop.core.setup.TestSuite;
import com.prestashop.test.pom.HomePagePOM;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;

/** */
@Epic("Technical tests")
@DisplayName("Enrolment and Authentication")
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class PrestashopTest extends TestSuite {

	private HomePagePOM homePage = new HomePagePOM();

	
	@Test
	@TmsLink("1234")
	@Description("Load Prestashop URL")
	@DisplayName("Load Prestashop URL")
	@Feature("Home page")
	public void test001LoadUrl() {
		homePage.loadURL();
	}

	@Test
	@TmsLink("1234")
	@Description("Select Language")
	@DisplayName("Select Language")
	@Feature("Home page")
	public void test002SelectLanguage() {

		if(!"fr".equals(homePage.getSelectedlanguage())){
			homePage.selectlanguage("fr");
		}
		
		homePage.selectlanguage("en");
		homePage.checkHeaderTitle("en");
	}

}
