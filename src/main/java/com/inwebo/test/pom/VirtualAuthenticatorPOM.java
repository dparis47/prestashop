package com.inwebo.test.pom;

import static com.inwebo.core.InWeboAssertion.assertEquals;
import static com.inwebo.core.InWeboAssertion.assertTrue;

import com.inwebo.core.Bindings;

import io.qameta.allure.Step;

public class VirtualAuthenticatorPOM extends Pom {


	@Step("Check InWebo activating profile")
	public void activationCode(String expectedProfile) {
		assertEquals(expectedProfile, getUI().getText(Bindings.VIRTUAL_AUTHENTIFICATION_PROFILE, null), "Check InWebo activating profile");
	}
	
	@Step("Check Activation code error message")
	public void checkErrorMessage() {
		String errorMsg = getUI().getText(Bindings.INWEBO_ACTIVATION_CODE_ERROR_MSG, null);
		assertEquals("Activation code is not valid", errorMsg, "InWebo activation code error message");
	}
	
	@Step("Check browser name is not empty")
	public void checkBrowserName() {
		String browser = getUI().getText(Bindings.VIRTUAL_AUTHENTIFICATION_BROWSER, null);
		assertTrue( browser!=null && !browser.isEmpty(), "Check InWebo activating profile");
	}
	
	@Step("Input PIN")
	public void inputPIN() {
		// input PIN
		boolean result = getUI().input("1234", Bindings.VIRTUAL_AUTHENTIFICATION_PWD, null);
		assertTrue(result, "Input PIN");
	}
	
	@Step("Click on validate button")
	public void clickOnValidateButton() {
		assertTrue(getUI().click(Bindings.VIRTUAL_AUTHENTIFICATION_VALIDATION_BUTTON, null), "Click on InWebo activation PIN Validation button");
	}
	
	
	@Step("Check Sign button is present")
	public void checkSignButton() {
		assertTrue(getUI().isPresent(Bindings.INWEBO_USER_BROWSER_BUTTON, null), "'Sign me in safely to my Secure Sites' button is present");
	}

	
}
