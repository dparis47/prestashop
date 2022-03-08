package com.inwebo.test.pom;

import static com.inwebo.core.InWeboAssertion.assertTrue;

import com.inwebo.core.Bindings;
import com.inwebo.core.UIElementAdapter;

import io.qameta.allure.Step;

public abstract class Pom {

	
	/** */
	private UIElementAdapter ui = new UIElementAdapter();
	
	@Step("Switch to iframe")
	public void switchToIFrame() {
		boolean result = getUI().switchToIFrame(Bindings.INWEBO_ACTIVATION_CODE_IFRAME, null);
		assertTrue(result, "Switch InWebo activation iframe");
	}
	
	public void switchToDefaultFrame() {
		getUI().switchToDefaultFrame();
	}
	
	public void sleep() {
		getUI().sleep(3000l);
	}
	
	/**
	 * 
	 * @return
	 */
	public UIElementAdapter getUI(){
		return ui;
	}
}
