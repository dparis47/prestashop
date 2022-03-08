/**
 * 
 */
package com.inwebo.core;

import com.fasterxml.jackson.databind.ObjectMapper;

/** */
public enum Mapper {
	
	
	INSTANCE;

	private final ObjectMapper mapper = new ObjectMapper();
	

	public ObjectMapper getObjectMapper() {
		return mapper;
	}
}
