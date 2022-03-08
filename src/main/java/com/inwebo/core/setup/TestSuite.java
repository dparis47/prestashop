/**
 * 
 */
package com.inwebo.core.setup;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.inwebo.core.UIElementAdapter;

/** */
public abstract class TestSuite {
	
	@BeforeAll
	public static void setUp() throws IOException {
		SetUp.setUp();
	}

	@AfterAll
	public static void tearDown() {
		SetUp.tearDown();
	}

}
