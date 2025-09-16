package com.CucumberSFWithPOMUpgrade.StepDefinition;

import org.apache.logging.log4j.LogManager; 

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.CucumberSFWithPOMUpgrade.Utility.Constants;
import com.CucumberSFWithPOMUpgrade.Utility.SF_PropertiesUtility;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@Listeners(com.CucumberSFWithPOMUpgrade.Utility.SF_ListenerUtility.class)
public class LoginStepDefinition {

	private static Logger mylog = LogManager.getLogger(LoginStepDefinition.class);
//	protected ExtentReportsUtility extentReportsUtility = ExtentReportsUtility.getInstance();
//	protected static WebDriver driver;
	public String Title = null;
	
//	LoginPage loginPage;
//	HomePage homePage;
//	MySettingsPage mySettingsPage;
	
	public String usernameData=SF_PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES,"username");
	public String passwordData=SF_PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES,"password");

	
	@Then("i should see error message {string}")
	public void i_should_see_error_message(String expectedErrorMessage) {
		  String actualErrorMessage =  BaseStepDefinition.loginPage.getTextErrorMsg();
		   Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		   mylog.info("password error message validated succesfully!!!");
		   System.out.println("password error message validated succesfully!!!");
	}
	
	@When("i click remember me check box")
	public void i_click_remember_me_check_box() {
	   BaseStepDefinition.loginPage.clickRememberMeCheckBox();
	}
	
	@Then("i validate username remember validation")
	public void i_validate_username_remember_validation() {
		BaseStepDefinition.loginPage.checkUserNameRememberValidation();
	}
}
