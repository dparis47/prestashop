package com.inwebo.core;

import com.inwebo.core.field.UIFieldType;

/** */
public enum Bindings implements Binding {
  LINK_INWEBO_ACTIVATION_CODE(".homeEnroleHelium>a", QueryTypes.CSS, UIFieldType.TEXT), //

  INWEBO_ACTIVATION_CODE_IFRAME("iwVt", QueryTypes.ID, UIFieldType.TEXT), //
  
  INWEBO_ACTIVATION_CODE_INPUT("iwcode", QueryTypes.ID, UIFieldType.TEXT), //
  INWEBO_ACTIVATION_CODE_BUTTON("submitCode", QueryTypes.ID, UIFieldType.TEXT), //
  INWEBO_ACTIVATION_CODE_ERROR_MSG("flashError", QueryTypes.ID, UIFieldType.TEXT), //
  
  VIRTUAL_AUTHENTIFICATION_PROFILE("iwprofile", QueryTypes.ID, UIFieldType.TEXT), //
  VIRTUAL_AUTHENTIFICATION_BROWSER("iwbrowser", QueryTypes.ID, UIFieldType.TEXT), //
  VIRTUAL_AUTHENTIFICATION_PWD("passwd", QueryTypes.ID, UIFieldType.TEXT), //
  VIRTUAL_AUTHENTIFICATION_VALIDATION_BUTTON("confirmPin", QueryTypes.ID, UIFieldType.TEXT), //
  
  INWEBO_USER_BROWSER_BUTTON(".heliumNextButton>a", QueryTypes.ID, UIFieldType.TEXT), //
  
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
