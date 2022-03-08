package com.inwebo.test.pom;

import static com.inwebo.core.InWeboAssertion.assertEquals;
import static com.inwebo.core.InWeboAssertion.assertTrue;

import com.inwebo.core.Bindings;

import io.qameta.allure.Step;

public class ActivationPOM extends Pom {


	@Step("Input activation code")
	public void activationCode(String code) {
		switchToIFrame();
		boolean result = getUI().input("286531529", Bindings.INWEBO_ACTIVATION_CODE_INPUT, null);
		assertTrue(result, "Input InWebo activation code");

		assertTrue(getUI().click(Bindings.INWEBO_ACTIVATION_CODE_BUTTON, null), "Click on InWebo activation code Validation button");
	}
	
	@Step("Check Activation code error message")
	public void checkErrorMessage() {
		String errorMsg = getUI().getText(Bindings.INWEBO_ACTIVATION_CODE_ERROR_MSG, null);
		assertEquals("Activation code is not valid", errorMsg, "InWebo activation code error message");
	}
	
}
