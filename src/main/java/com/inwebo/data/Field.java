package com.inwebo.data;

import java.text.MessageFormat;
import java.util.Map;

import com.inwebo.core.field.UIComponentType;

/** */
public class Field {
	
		/** */
		private String name;
		
		/** */
		private String value;

		/** */
		private UIComponentType fieldType;


		/**
		 * 
		 * @param name
		 * @param fieldType
		 */
		public Field(String name, UIComponentType fieldType) {
			this.name = name;
			this.fieldType = fieldType;
		}

		/**
		 * 
		 * @return
		 */
		public String getName() {
			return name;
		}


		/**
		 * 
		 * @param name
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * 
		 * @return
		 */
		public UIComponentType getFieldType() {
			return fieldType;
		}

		/**
		 * 
		 * @param fieldType
		 */
		public void setFieldType(UIComponentType fieldType) {
			this.fieldType = fieldType;
		}

		/**
		 * 
		 * @return
		 */
		public String getValue() {
			return value;
		}

		/**
		 * 
		 * @param value
		 */
		public void setValue(String value) {
			this.value = value;
		}

	}
