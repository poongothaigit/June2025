package com.SalesForcePOM.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.SalesForcePOM.Pages.Base.BasePage;

public class MySettingsPage extends BasePage{

	public MySettingsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id="PersonalInfo_font") WebElement personalClick;
	@FindBy(xpath="//a[@id='LoginHistory_font']") WebElement loginHistory;
	@FindBy(xpath= "//a[contains(text(),'login')]") WebElement downloadHistory;
	@FindBy(id="DisplayAndLayout_font") WebElement display;
	@FindBy(id="CustomizeTabs_font") WebElement CustomizeMyTab;
	@FindBy(id="p4") WebElement Salesforce_Chatter;
	@FindBy(id="duel_select_0") WebElement Reports;
	@FindBy(xpath="//img[@title='Add']") WebElement addButton;
	@FindBy(xpath="//input[@name='save']") WebElement SaveButton;
	@FindBy(id="EmailSetup_font") WebElement emailLink;
	@FindBy(xpath="//a[@id='EmailSettings_font']") WebElement MyEmailSetting;
	@FindBy(id="sender_name") WebElement emailName;
	@FindBy(id="sender_email") WebElement emailID;
	@FindBy(id="auto_bcc1") WebElement Auto_BCC;
	@FindBy(name="save") WebElement save_EmailSetting;
	@FindBy(xpath="//div[text()='Your settings have been successfully saved.']") WebElement validateEmailUpdate;
	@FindBy(id="CalendarAndReminders_font") WebElement calender;
	@FindBy(xpath="//span[@id='Reminders_font']") WebElement Activity_reminder;
	@FindBy(id="testbtn") WebElement testReminder;
	@FindBy(id="dismiss_all") WebElement dismissAll_Button;
	//deselect  customize mytab
	@FindBy(className = "leftArrowIcon") WebElement removeButton;
	@FindBy(xpath="//input[@name='save']") WebElement saveDeselectButton; 
	@FindBy(id="duel_select_1") WebElement reportsDeselect;

	public WebDriver click_ReportsDeselect()
	{
		WaitForVisibility(reportsDeselect, 20, "Reports Deselect");
		dropDown_SelectByVisibleText(reportsDeselect, "Reports");
		return driver;
	}
	public WebDriver click_RemoveButton()
	{
		WaitForVisibility(removeButton, 20, "remove Button");
		clickElement(removeButton, "remove Button");
		return driver;
	}
	public WebDriver click_SaveDeselectButton()
	{
		WaitForVisibility(saveDeselectButton, 20, "saveDeselectButton");
		clickElement(saveDeselectButton, "save Deselect Button");
		return driver;
	}

	public WebDriver click_TestReminder()
	{
		
		String mainWindowHandle = click_activityReminder();
		WaitForVisibility(testReminder, 20, "testReminder");
		clickElement(testReminder, "test Reminder button");
		
		for(String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
		        driver.switchTo().window(handle);
		        break; 
		}
		String reminderTitle = driver.getTitle();
		System.out.println("Reminder window title : "+ reminderTitle);
		}      
		WaitForVisibility(dismissAll_Button,20, "DismissAll button");
		clickElement(dismissAll_Button, "Dismiss_all button");
		driver.switchTo().window(mainWindowHandle);
		return driver;
	}

	public String click_activityReminder()
	{
		
		String mainWindowHandle = driver.getWindowHandle();
		System.out.println("MainWindowHAndle : " + mainWindowHandle);
		WaitForVisibility(Activity_reminder, 20, "Activity reminder");
		clickElement(Activity_reminder, "Activity reminder");
		return mainWindowHandle;
	}
	public WebDriver clickCalender()
	{
		WaitForVisibility(calender, 20, "Calender");
		clickElement(calender, "Calender");
		return driver;
	}
	public void validate_EmailUpdate() {
		WaitForVisibility(validateEmailUpdate,20, "validate Email Update");
		String Actual = validateEmailUpdate.getText();
		String Expected = "Your settings have been successfully saved.";
		validationCheck_Equals(Expected, Actual);
	}
	public WebDriver clicksave_EmailSetting()
	{
		WaitForVisibility(save_EmailSetting, 20, "save_EmailSetting");
		clickElement(save_EmailSetting, "save_EmailSetting");
		return driver;
	}
	public WebDriver clickAuto_BCC()
	{
		WaitForVisibility(Auto_BCC, 20, "Auto_BCC");
		clickElement(Auto_BCC, "Auto_BCC");
		return driver;
	}
	public void enterEmailName(String data)
	{
		WaitForVisibility(emailName, 20, "email Name");
		enterText(emailName, data, "email Name");
	}
	public void enterEmailID(String data)
	{
		WaitForVisibility(emailID, 20, "emailID");
		enterText(emailID, data, "emailID");
	}
	public WebDriver clickMyEmailSetting()
	{
		WaitForVisibility(MyEmailSetting, 20, "MyEmailSetting");
		clickElement(MyEmailSetting, "MyEmailSetting in email link");
		return driver;
	}
	public WebDriver clickEmailLink()
	{
		WaitForVisibility(emailLink, 20, "emailLink");
		clickElement(emailLink, "emailLink in MySettings");
		return driver;
	}
	
	public WebDriver clickSave_Button()
	{
		WaitForVisibility(SaveButton, 20, "Save Button");
		clickElement(SaveButton, "Save Button");
		return driver;
	}
	public WebDriver clickAdd_Button()
	{
		WaitForVisibility(addButton, 20, "add Button");
		clickElement(addButton, "add Button");
		return driver;
	}
	public void select_Reports() {
		WaitForVisibility(Reports, 20, "Reports");
		dropDown_SelectByVisibleText(Reports, "Reports");
	}
	public void select_SalesforceChatter() {
		WaitForVisibility(Salesforce_Chatter, 20, "Salesforce Chatter");
		dropDown_SelectByVisibleText(Salesforce_Chatter, "Salesforce Chatter");
	}
	public WebDriver clickDAC_CustomizeMyTab()
	{
		WaitForVisibility(CustomizeMyTab, 20, "CustomizeMyTab");
		clickElement(CustomizeMyTab, " CustomizeMyTab in DisplayAndLayout ");
		return driver;
	}
	public WebDriver clickDisplayAndLayout()
	{
		WaitForVisibility(display, 20, "display");
		clickElement(display, "DisplayAndLayout in MySettings");
		return driver;
	}
	public WebDriver clickPersonal()
	{
		WaitForVisibility(personalClick, 20, "personalClick");
		clickElement(personalClick, "Personal in MySettings");
		return driver;
	}
	public WebDriver clickPersonal_LoginHistory()
	{
		WaitForVisibility(loginHistory, 20, "loginHistory");
		clickElement(loginHistory, "Login history");
		return driver;
	}
	public WebDriver clickPersonal_DownloadHistory()
	{
		WaitForVisibility(downloadHistory, 20, "download History");
		clickElement(downloadHistory, "download History");
		return driver;
	}
}
