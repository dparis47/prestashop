package com.inwebo.test.testcase;

import static com.inwebo.core.InWeboAssertion.assertEquals;
import static com.inwebo.core.InWeboAssertion.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.inwebo.core.Bindings;
import com.inwebo.core.setup.TestSuite;
import com.inwebo.test.pom.ActivationPOM;
import com.inwebo.test.pom.AuthenticationPOM;
import com.inwebo.test.pom.VirtualAuthenticatorPOM;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;

/** */
@Epic("Technical tests")
@DisplayName("Enrolment and Authentication")
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class InweboTest extends TestSuite {

	AuthenticationPOM authentication = new AuthenticationPOM();
	ActivationPOM activation = new ActivationPOM();
	VirtualAuthenticatorPOM virtualAuthenticator = new VirtualAuthenticatorPOM();
	
	@Test
	@TmsLink("1234") 
	@Description("Load inWebo URL")
	@DisplayName("Load inWebo URL")
	@Feature("enrolment and authentication")
	public void test001LoadUrl() {
		authentication.loadURL();
	}
	
	
	@Test
	@TmsLink("1234") 
	@Description("InWebo activation code error")
	@DisplayName("InWebo activation code error")
	@Feature("enrolment and authentication")
	public void test002ActivationCodeFail() {

		authentication.clickOnActivationCode();
		
		activation.activationCode("12345");
		activation.sleep();
		activation.checkErrorMessage();
		activation.switchToDefaultFrame();
	}
	
	@Test
	@TmsLink("1234") 
	@Description("InWebo activation code success")
	@DisplayName("InWebo activation code success")
	@Feature("enrolment and authentication")
	public void test003ActivationCode() {

		activation.activationCode("6842354046");
		activation.switchToDefaultFrame();
	}
	
	@Test
	@TmsLink("1234") 
	@Description("InWebo activation code success")
	@DisplayName("InWebo activation code success")
	@Feature("enrolment and authentication")
	public void test004ActivationCode() {

		virtualAuthenticator.switchToIFrame();
		
		virtualAuthenticator.activationCode("david paris");
		virtualAuthenticator.checkBrowserName();
		virtualAuthenticator.inputPIN();
		virtualAuthenticator.clickOnValidateButton();

		virtualAuthenticator.switchToDefaultFrame();
	}
	
	
	@Test
	@TmsLink("1234") 
	@Description("InWebo activation code success")
	@DisplayName("InWebo activation code success")
	@Feature("enrolment and authentication")
	public void test005TrustedDevice() {
		
		virtualAuthenticator.checkSignButton();
	}
	
}
