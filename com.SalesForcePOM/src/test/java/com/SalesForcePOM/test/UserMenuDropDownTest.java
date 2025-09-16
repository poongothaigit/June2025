package com.SalesForcePOM.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SalesForcePOM.Base.BaseTest;
import com.SalesForcePOM.Pages.HomePage;
import com.SalesForcePOM.Pages.LoginPage;
import com.SalesForcePOM.Pages.MySettingsPage;
import com.SalesForcePOM.Utility.Constants;
import com.SalesForcePOM.Utility.ExtentReportsUtility;
import com.SalesForcePOM.Utility.SF_PropertiesUtility;

@Listeners(com.SalesForcePOM.Utility.SF_ListenerUtility.class)
public class UserMenuDropDownTest extends BaseTest{
	
	private Logger mylog = LogManager.getLogger(LoginTest.class);
	protected ExtentReportsUtility extentReportsUtility = ExtentReportsUtility.getInstance();
	
	LoginPage loginPage;
	HomePage homePage;
	MySettingsPage mysettingsPage;
	
	public String usernameData=SF_PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES,"username");
	public String passwordData=SF_PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES,"password");
	public String emailName=SF_PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES,"emailName");
	public String emailID=SF_PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES,"emailID");
	
	@Test
	public void TC05() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		
		loginPage.enterUserName(usernameData);
		loginPage.enterPassword(passwordData);
		loginPage.clickLoginButton();
		
		homePage.clickUserMenuDropdown();
		homePage.validate_userMenuDropdown_list();
		extentReportsUtility.logTestInfo("Usermenu dropwoen validated succesfully");
	}
	
	@Test
	public void TC07() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		mysettingsPage = new MySettingsPage(driver);
		
		loginPage.enterUserName(usernameData);
		loginPage.enterPassword(passwordData);
		loginPage.clickLoginButton();
		//Homepage
		homePage.clickUserMenuDropdown();
		homePage.clickMySettings();
		//MySettings-Page personal link
		mysettingsPage.clickPersonal();
		mysettingsPage.clickPersonal_LoginHistory();
		mysettingsPage.clickPersonal_DownloadHistory();
		// Display & Layout
		mysettingsPage.clickDisplayAndLayout();
		mysettingsPage.clickDAC_CustomizeMyTab();
		mysettingsPage.select_SalesforceChatter();
		mysettingsPage.select_Reports();
		mysettingsPage.clickAdd_Button();
		mysettingsPage.clickSave_Button();
		homePage.clickMenuDropdown();
		homePage.validateReports_MenuDropdown_list();
		//Email
		homePage.clickUserMenuDropdown();
		homePage.clickMySettings();
		mysettingsPage.clickEmailLink();
		mysettingsPage.clickMyEmailSetting();
		mysettingsPage.enterEmailName(emailName);
		mysettingsPage.enterEmailID(emailID);
		mysettingsPage.clickAuto_BCC();
		mysettingsPage.clicksave_EmailSetting();
		mysettingsPage.validate_EmailUpdate();
		//Calender_And_Reminders
		mysettingsPage.clickCalender();
		mysettingsPage.click_TestReminder();	
		//Deselect report from customizeMytabs
		homePage.clickUserMenuDropdown();
		homePage.clickMySettings();
		mysettingsPage.clickDisplayAndLayout();
		mysettingsPage.clickDAC_CustomizeMyTab();
		mysettingsPage.select_SalesforceChatter();
		mysettingsPage.click_ReportsDeselect();
		mysettingsPage.click_RemoveButton();
		mysettingsPage.click_SaveDeselectButton();
	}
	
	
}
