package com.prestashop.core;

import com.prestashop.core.field.UIFieldType;

/** */
public enum Bindings implements Binding {

	HOME_PAGE_HEADER_TITLE("//title", QueryTypes.XPATH, UIFieldType.TEXT),//
	HOME_PAGE_LANGUAGE_SELECT("//button[@id='dropdown-language']", QueryTypes.XPATH, UIFieldType.TEXT),//
  ;

  private String query;
  private String queryType;
  private String fieldType;

  Bindings(String value, String type, String fieldType) {
    this.query = value;
    this.queryType = type;
    this.fieldType = fieldType;
  }

  @Override
  public String getQuery() {
    return query;
  }

  @Override
  public String getQueryType() {
    return queryType;
  }

  @Override
  public String getFieldType() {
    return fieldType;
  }

}
