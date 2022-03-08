package com.inwebo.core.field;

import org.openqa.selenium.support.ui.Select;

import com.inwebo.core.Elt;

/** */
public class UIFieldSelect extends UIField{


    @Override
    public boolean addValue(Elt e, String value) {
        try {
            Select selectElement = new Select(findElement(e.getBy()));
            selectElement.selectByValue(value);

            log.debug("value selected");
            return true;
        } catch(Exception ex) {
        	log.error(ex);
            return false;
        }
    }

	@Override
	public boolean clearValue(boolean simpleClear, Elt e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getValue(Elt e) {
		// TODO Auto-generated method stub
		return null;
	}


}
