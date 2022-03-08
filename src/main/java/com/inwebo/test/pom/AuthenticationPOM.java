package com.inwebo.test.pom;

import static com.inwebo.core.InWeboAssertion.assertTrue;

import com.inwebo.core.Bindings;

import io.qameta.allure.Step;

/** */
public class AuthenticationPOM extends Pom {


	@Step("Load URL")
	public void loadURL() {
		boolean result = getUI().loadURL("http://www.myinwebo.com");
		assertTrue(result, "Load URL");
	}
	
	@Step("Click on the Activation code link")
	public void clickOnActivationCode() {
		assertTrue(getUI().click(Bindings.LINK_INWEBO_ACTIVATION_CODE, null), "Click on InWebo Activation code link");
	}
}
