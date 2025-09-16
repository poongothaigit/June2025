package com.SalesForcePOM.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SalesForcePOM.Base.BaseTest;
import com.SalesForcePOM.Pages.HomePage;
import com.SalesForcePOM.Pages.LoginPage;
import com.SalesForcePOM.Utility.Constants;
import com.SalesForcePOM.Utility.ExtentReportsUtility;
import com.SalesForcePOM.Utility.SF_PropertiesUtility;

@Listeners(com.SalesForcePOM.Utility.SF_ListenerUtility.class)
public class LoginTest extends BaseTest{

	private Logger mylog = LogManager.getLogger(LoginTest.class);
	protected ExtentReportsUtility extentReportsUtility = ExtentReportsUtility.getInstance();
	
	LoginPage loginPage;
	HomePage homePage;
	
	public String usernameData=SF_PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES,"username");
	public String passwordData=SF_PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES,"password");
	
	@Test
	public void TC01_ErrorSF() {
		loginPage = new LoginPage(driver);
		loginPage.enterUserName(usernameData);
		loginPage.clickLoginButton();
		
		String expectedStr = "Error: Please enter your password.";
		String actualStr = loginPage.getTextErrorMsg();
		loginPage.validationCheck_Equals(expectedStr, actualStr);
		extentReportsUtility.logTestInfo("ErrorMesage validated, test completed");
	}
	
	@Test
	public void TC02_LoginSF() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		String actualTitle =loginPage.getTitle();
		loginPage.enterUserName(usernameData);
		loginPage.enterPassword(passwordData);
		loginPage.clickLoginButton();
		String ExpectedTitle = homePage.getTitle();
		homePage.validationCheck_NotEquals(ExpectedTitle, actualTitle);
		extentReportsUtility.logTestInfo("HomePage displayed, test completed");
	}
	
	@Test
	public void TC03_RememberMe() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.enterUserName(usernameData);
		loginPage.enterPassword(passwordData);
		loginPage.clickRememberMeCheckBox();
		loginPage.clickLoginButton();
		extentReportsUtility.logTestInfo("LoggedIn succesfully");
		
		
		homePage.clickUserMenuDropdown();
		homePage.clickLogout();
		String ActualURL = loginPage.getCurrentURL();
		String expectedURL = "https://orgfarm-aa47a0b3de-dev-ed.develop.my.salesforce.com/";
		loginPage.validationCheck_Equals(expectedURL, ActualURL);
		extentReportsUtility.logTestInfo("Logout validated successfully");
		loginPage.checkUserNameRememberValidation();
		extentReportsUtility.logTestInfo("Remember validated successfully");
	}
	
	@Test
	public void TC04A_ForgetPassword() {
		loginPage = new LoginPage(driver);
		loginPage.clickforgetPassword_Link();
		loginPage.enterRemember_UserName(usernameData);
		loginPage.clickRemember_ContinueButton();
		String actualMsg = loginPage.getTextRemember_Msg();
		String expectedMsg = "Check Your Email";
		loginPage.validationCheck_Equals(expectedMsg, actualMsg);
		extentReportsUtility.logTestInfo("Forget password message validated successfully");
	}
	
	@Test
	public void TC04B_ValidateLoginErrorMesg() {
		loginPage = new LoginPage(driver);
		loginPage.enterUserName("123");
		loginPage.enterPassword("22131");
		loginPage.clickLoginButton();
		
		String actualMsg = loginPage.getTextErrorMsg();
		String expectedMsg = "Error: Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		loginPage.validationCheck_Equals(expectedMsg, actualMsg);
		extentReportsUtility.logTestInfo("Wrong login entry error message validated succesfully");
		
	}
}
