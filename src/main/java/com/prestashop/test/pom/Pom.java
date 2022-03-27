package com.prestashop.test.pom;

import com.prestashop.core.UIElementAdapter;

public abstract class Pom {

	
	/** */
	private UIElementAdapter ui = new UIElementAdapter();

	/**
	 * 
	 * @return
	 */
	public UIElementAdapter getUI(){
		return ui;
	}
}
