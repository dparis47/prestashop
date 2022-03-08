package com.inwebo.core.field;

import com.inwebo.core.Elt;

/** */
public class UIFieldText extends UIField{

	 @Override
	 public boolean addValue(Elt e, String value) {
	        try {
	            findElement(e.getBy()).sendKeys(value);

	            log.debug("Value setted to " + value);
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
