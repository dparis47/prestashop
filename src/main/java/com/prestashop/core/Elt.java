package com.prestashop.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.prestashop.core.field.UIField;
import com.prestashop.core.field.UIFieldSelect;
import com.prestashop.core.field.UIFieldText;
import com.prestashop.core.field.UIFieldType;

/** */
public class Elt {

	/** */
	private static Logger log = LogManager.getLogger(Elt.class);
	
	/** */
    private String queryType;

    /** */
    private String query;
    
    /** */
    private String fieldTypeBinding;
    
    /** */
    private UIField uiField;
    
    /** */
    private By by;

    
    /**
     * 
     * @param queryType
     * @param fieldTypeBinding
     * @param query
     */
    public Elt(String queryType, String fieldTypeBinding, String query) {
        this.queryType = queryType;
        this.query = query;
        this.setFieldTypeBinding(fieldTypeBinding);
        autosetBy();
        setUIField();
    }

    public String getType() {
        return queryType;
    }

    public void setType(String type) {
        this.queryType = type;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
	
    public By getBy() {

        return by;
    }
	
    public void setBy(By by) {
        this.by = by;
    }

    public String getFieldTypeBinding() {
        return fieldTypeBinding;
    }

    public void setFieldTypeBinding(String fieldTypeBinding) {
        this.fieldTypeBinding = fieldTypeBinding;
    }

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
    
	public UIField getUiField() {
		return uiField;
	}

	public void setUiField(UIField uiField) {
		this.uiField = uiField;
	}

	public void autosetBy() {
        if (queryType.equals(QueryTypes.XPATH)) {
            this.by = By.xpath(query);
        }
        if (queryType.equals(QueryTypes.ID)) {
            this.by = By.id(query);
        }
        if (queryType.equals(QueryTypes.CSS)) {
            this.by = By.cssSelector(query);
        }

    }


    public void setUIField() {
        if (fieldTypeBinding.equals(UIFieldType.TEXT)) {
            this.uiField = new UIFieldText();
        }
        if (fieldTypeBinding.equals(UIFieldType.SELECT)) {
            this.uiField = new UIFieldSelect();
        }
        if (fieldTypeBinding.equals("checkbox")) {
            log.info("Field type checkbox selected. No action will be performed");
        }
        if (fieldTypeBinding.equals(UIFieldType.NUMBER)) {
            this.uiField = new UIFieldText();
        }
        
    }
	

    
}
