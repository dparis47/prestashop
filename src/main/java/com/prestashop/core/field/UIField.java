package com.prestashop.core.field;

import org.openqa.selenium.WebElement;

import com.prestashop.core.Elt;
import com.prestashop.core.UIElementAdapter;

/** */
public abstract class UIField extends UIElementAdapter {

	/**
	 * 
	 * @param e
	 * @param value
	 * @return
	 */
    public abstract boolean addValue(Elt e, String value);

    
    /**
     * 
     * @param simpleClear
     * @param e
     * @return
     */
    public abstract boolean clearValue(boolean simpleClear, Elt e);

    /**
     * 
     * @param e
     * @return
     */
    public abstract String getValue(Elt e);
}