package com.prestashop.core.field;

public class UIFieldType {

    public static final String TEXT = "text";
    public static final String SELECT = "select";
    public static final String NUMBER = "number";
    public static final String NO_FIELD = "Not a field";

    private UIFieldType() {
        throw new AssertionError();
    }
	
}
