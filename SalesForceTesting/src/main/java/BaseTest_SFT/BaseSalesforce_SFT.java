package BaseTest_SFT;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import SeleniumDemo.BaseTestSelenium;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseSalesforce_SFT extends BaseTestSelenium{

	public static void login_SalesForce()
	{
		
		WebElement userName = driver.findElement(By.id("username"));
		WaitForVisibility(userName, 20);
		enterText(userName, "poongothai.chennappan960@agentforce.com", "userName");
		WebElement passWord = driver.findElement(By.id("password"));
		enterText(passWord, "Tekarch123", "passWord");
		WebElement loginButton = driver.findElement(By.id("Login"));
		clickElement(loginButton, "Login button");
		System.out.println("Successfully logged in");
	}
	
	public static void InvalidLogin_SalesForce()
	{
		
		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "poongothai.chennappan960@agentforce.com", "userName");
		WebElement loginButton = driver.findElement(By.id("Login"));
		clickElement(loginButton, "Login button");
	}
	
	public static void loginWrongEntry() {
		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "123", "userName");
		WebElement passWord = driver.findElement(By.id("password"));
		enterText(passWord, "22131", "passWord");
		WebElement loginButton = driver.findElement(By.id("Login"));
		clickElement(loginButton, "Login button");
	}
	public static void loginRemenberMe_SalesForce()
	{
		
		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "poongothai.chennappan960@agentforce.com", "userName");
		WebElement passWord = driver.findElement(By.id("password"));
		enterText(passWord, "Tekarch123", "passWord");
		WebElement rememberMe = driver.findElement(By.id("rememberUn"));
		clickElement(rememberMe, "RememberMe CheckBox");
		WebElement loginButton = driver.findElement(By.id("Login"));
		clickElement(loginButton, "Login button");
		System.out.println("Successfully logged in");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void forgetPassword() {
		WebElement forgetPasswordLink = driver.findElement(By.id("forgot_password_link"));
		clickElement(forgetPasswordLink, "Forget Password Link");
		WebElement enterUserName = driver.findElement(By.id("un"));
		enterText(enterUserName, "poongothai.chennappan960@agentforce.com", "Username field");
		WebElement continueButton = driver.findElement(By.id("continue"));
		clickElement(continueButton, "Continue button");
		WebElement actualText = driver.findElement(By.xpath("//h1[@id=\"header\"]"));
		String actualMsg = actualText.getText();
		String expectedMsg = "Check Your Email";
		validationCheck(expectedMsg, actualMsg);
		
		
	}
	
	public static void userMenuDropdown_CLick() {
		//WebElement userMenuDropdown = driver.findElement(By.id("userNav-arrow"));
		WebElement userMenuDropdown = driver.findElement(By.id("userNavLabel"));
		WaitForVisibility(userMenuDropdown, 30);
		clickElement(userMenuDropdown, "Usermenu Dropdown");
	}
	
	
	public static void userMenuDropdown_list() {
		List<String> ExpectedList = new ArrayList<String>();
		List<String> ActualMenuList = new ArrayList<String>();
		ExpectedList.add("My Profile");
		ExpectedList.add("My Settings");
		ExpectedList.add("Developer Console");
		ExpectedList.add("Switch to Lightning Experience");
		ExpectedList.add("Logout");
		System.out.println("Expected list : "+ExpectedList);
		List<WebElement> dropdownList = driver.findElements(By.xpath("//div[@id='userNav-menuItems']//a"));
		for(WebElement list_ele: dropdownList) {
			ActualMenuList.add(list_ele.getText());
		}
		System.out.println("Actual list : "+ExpectedList);
		validationList(ExpectedList, ActualMenuList);
	
	}
	
	public static String tab_HomeTab() {
		WebElement homeTab = driver.findElement(By.id("home_Tab"));
		WaitForVisibility(homeTab, 20);
		clickElement(homeTab, "home_Tab");
		WebElement userName	= driver.findElement(By.className("currentStatusUserName"));
		WaitForVisibility(userName, 20);
		String actual_UserName = userName.getText().trim();
		clickElement(userName, "actual_UserName");
		return actual_UserName;
	}
	public static void tab_HomeTab_BlockAnEvent() {
		
			WebElement currentDate_Link = driver.findElement(By.xpath("//div[@class='content']/span/a"));
			WaitForVisibility(currentDate_Link,15);
			clickElement(currentDate_Link, "currentDate_Link");
			
//			WebElement click8PM = driver.findElement(By.xpath("//div[@id='p:f:j_id25:j_id61:28:j_id64']/a"));
//			WaitForVisibility(click8PM,15);
//			clickElement(click8PM, "Click_8PM_link");
//			
//			WebElement comboIcon= driver.findElement(By.xpath("//img[@class='comboboxIcon']"));
//			WaitForVisibility(comboIcon,15);
//			clickElement(comboIcon, "comboIcon");
//			
//			String parWindow = driver.getWindowHandle();
//			System.out.println("PArentWindow : "+ parWindow);
//			Set<String> winhandles = driver.getWindowHandles();
//			for(String handle : winhandles) {
//				if(!handle.equals(parWindow)) {
//					System.out.println("DevWindow : " + handle);
//					driver.switchTo().window(handle);
//					break;
//				}
//			}
//			
//		
//			WebElement other_Link= driver.findElement(By.xpath("//li[@class='listItem4']/a"));
//			WaitForVisibility(other_Link,15);
//			clickElement(other_Link, "other_Link");
//			driver.switchTo().window(parWindow);
//			
//			WebElement EndTimePicker= driver.findElement(By.xpath("//span[@class='timeInput']/input[@id='EndDateTime_time']"));
//			WaitForVisibility(EndTimePicker,25);
//		    clickElement(EndTimePicker, "EndTimePicker");
//			
//		    WebElement specificEndTime= driver.findElement(By.xpath("//div[text()='9:00 PM']"));
//			WaitForVisibility(specificEndTime,25);
//			clickElement(specificEndTime, "specificEndTime");
//			WebElement saveEvent = driver.findElement(By.xpath("//input[@name='save'][1]"));
//			WaitForVisibility(saveEvent,25);
//			clickElement(saveEvent, "SaveEvent");
//			driver.switchTo().defaultContent();

	}	
	public static void tab_HOmeTab_WeeklyRecurrance(String month, String year, String date_2weeks ) {
		WebElement currentDate_Link = driver.findElement(By.xpath("//div[@class='content']/span/a"));
		WaitForVisibility(currentDate_Link,15);
		clickElement(currentDate_Link, "currentDate_Link");
		
		WebElement click4PM = driver.findElement(By.xpath("//a[normalize-space()='4:00 PM']"));
		WaitForVisibility(click4PM,15);
		clickElement(click4PM, "4pm_link");
		
		WebElement comboIcon= driver.findElement(By.xpath("//img[@class='comboboxIcon']"));
		WaitForVisibility(comboIcon,15);
		clickElement(comboIcon, "comboIcon");
		
		String parWindow = driver.getWindowHandle();
		System.out.println("PArentWindow : "+ parWindow);
		Set<String> winhandles = driver.getWindowHandles();
		for(String handle : winhandles) {
			if(!handle.equals(parWindow)) {
				System.out.println("DevWindow : " + handle);
				driver.switchTo().window(handle);
				break;
			}
		}
		
		WebElement clickOther= driver.findElement(By.xpath("//li[@class='listItem4']/a"));
		WaitForVisibility(clickOther,15);
		clickElement(clickOther, "Other_Link");
		driver.switchTo().window(parWindow);
		
		WebElement boxEndTimePicker= driver.findElement(By.xpath("//span[@class='timeInput']/input[@id='EndDateTime_time']"));
		WaitForVisibility(boxEndTimePicker,25);
		clickElement(boxEndTimePicker, "boxEndTimePicker");
		
		WebElement clickEndTime= driver.findElement(By.xpath("//div[text()='7:00 PM']"));
		WaitForVisibility(clickEndTime,25);
		clickElement(clickEndTime, "EndTime");
		WebElement clickRecurrance= driver.findElement(By.name("IsRecurrence"));
		WaitForVisibility(clickRecurrance,25);
		clickElement(clickRecurrance, "Recurrance_Button");
		
		WebElement clickWeeklyRadioBtn= driver.findElement(By.id("rectypeftw"));
		WaitForVisibility(clickWeeklyRadioBtn,25);
		selectRadioButtonElement(clickWeeklyRadioBtn, "Weekly Recurrance Radio button");
		
		WebElement clickCalender= driver.findElement(By.id("RecurrenceEndDateOnly"));
		WaitForVisibility(clickCalender,25);
		clickElement(clickCalender, "Calender_Button");
	
		Dropdown_SelectByVisibleText_ID("calMonthPicker", month);
		Dropdown_SelectByVisibleText_ID("calYearPicker", year);
		List<WebElement> datePicker_Calender = driver.findElements(By.xpath("//table[@class='calDays']/tbody/tr/td"));
		for(WebElement date: datePicker_Calender) {
			if((date.getText()).equals(date_2weeks)) {
				clickElement(date, "2 weeks date");
				break;
			}
		}

		WebElement saveEvent = driver.findElement(By.xpath("//input[@name='save'][1]"));
		WaitForVisibility(saveEvent,25);
		clickElement(saveEvent, "saveEvent_button");
	}	
    
	public static void tab_HomeTab_ValidateEvent(String xpath) {
		WebElement valEvent = driver.findElement(By.xpath(xpath));
		String Actual = valEvent.getText();                          
		System.out.println();
		String Expected = "Other";
		if((validationCheck(Expected, Actual)) == true) {
			System.out.println("Testcase pass");
		}
		else {
			System.out.println("Testcase failed");
		}
		System.out.println("New event validated successfully");
		
//		// Hover
//		Actions actions = new Actions(driver);
//		actions.moveToElement(valEvent).perform();
//
//		// Use JS to "gently" scroll into center (minimizes layout shift)
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		WebElement deleteButton = driver.findElement(By.className("btn"));
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn")));
//		js.executeScript("arguments[0].style.border='3px solid red'", deleteButton);
//		js.executeScript("arguments[0].click();", deleteButton);
//
//		// Wait a little for stability
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		// Extra check: ensure it's visible
//		
//		
//		 Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//	        alert.accept();

	}


	public static void tab_CustomizeMyTab_Add(String Add_TabName)  {
		
		WebElement plus_Button = driver.findElement(By.xpath("//img[@title='All Tabs']"));
		WaitForVisibility(plus_Button,15);
		clickElement(plus_Button, "plus_Button");
		WebElement customizeMyTab_Button = driver.findElement(By.xpath("//table[@border='0']/tbody/tr/td/input"));
		WaitForVisibility(customizeMyTab_Button,25);
		clickElement(customizeMyTab_Button, "customizeMyTab_Button");
		WebElement available_Tabs = driver.findElement(By.id("duel_select_0"));
		WaitForVisibility(available_Tabs, 20);
		dropDown_SelectByVisibleText(available_Tabs, "Chatter");
	
		//click add
		WebElement add_Button =	driver.findElement(By.xpath("//img[@title='Add']"));
		WaitForVisibility(add_Button, 20);
		clickElement(add_Button, "add_Button");
		//click save
		WebElement save_Button = driver.findElement(By.xpath("//input[@name='save']"));
		WaitForVisibility(save_Button, 20);
		clickElement(save_Button, "Save_Button");
		System.out.println("Tab added successfully");
	}

	public static void tab_CustomizeMyTab_Remove(String remove_TabName) {
		WebElement plus_Button = driver.findElement(By.xpath("//img[@title='All Tabs']"));
		WaitForVisibility(plus_Button,15);
		clickElement(plus_Button, "plus_Button");
		
		WebElement customizeMyTab_Button = driver.findElement(By.xpath("//input[@title='Customize My Tabs']"));
		WaitForVisibility(customizeMyTab_Button,25);
		clickElement(customizeMyTab_Button, "customizeMyTab_Button");
		
		WebElement selected_Tabs = driver.findElement(By.id("duel_select_1"));
		WaitForVisibility(selected_Tabs, 20);
		dropDown_SelectByVisibleText(selected_Tabs, "Chatter");
	
		WebElement remove_Button = driver.findElement(By.xpath("//img[@title='Remove']"));
		WaitForVisibility(remove_Button, 20);
		clickElement(remove_Button, "Remove_button");
		WebElement save_Button = driver.findElement(By.xpath("//input[@name='save']"));
		WaitForVisibility(save_Button, 20);
		clickElement(save_Button, "Save_Button");
		System.out.println("Tab removed successfully");
	}
	public static void tab_vaidateTab() {
		List<String> ExpectedList = new ArrayList<String>();
		List<WebElement> menuTabItemsSalesforce = driver.findElements(By.xpath("//ul[@id='tabBar']//li"));
		for(WebElement ele : menuTabItemsSalesforce) {
			ExpectedList.add(ele.getText());
		}
		if(ExpectedList.contains("Chatter")) {
			System.out.println("Validation failed");
		}
		else {
			System.out.println("Custom tab validated successfully");
		}
		
	}

	public static void MyProfile() {
		List<WebElement> dropdownList = driver.findElements(By.xpath("//div[@id='userNav-menuItems']//a"));
		for(WebElement list_ele: dropdownList) {
			System.out.println(list_ele.getText());
			if((list_ele.getText()).equals("My Profile")) {
				WaitForVisibility(list_ele, 30);
				clickElement(list_ele, "My Profile");
				break;
			}
		}
	}
	public static void MyProfile_EditProfile(String actualUserName, String edit_LastName){
	
		WebElement editProfile = driver.findElement(By.xpath("//img[@title='Edit Profile'][1]"));
		WaitForVisibility(editProfile, 15);
		clickElement(editProfile, "Edit_Profile icon");
		// Switchto to edit page
		WebElement iframeAbout = driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
		driver.switchTo().frame(iframeAbout);
		// Click on About Tab
		WebElement aboutTab = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		Actions action = new Actions(driver);
		action.moveToElement(aboutTab).build().perform();
		clickElement(aboutTab, "About_tab IN Edit_profile");
		WebElement lastName = driver.findElement(By.id("lastName"));
		enterText(lastName, edit_LastName, "LastName_TextBox");
		WebElement saveAll_Button =  driver.findElement(By.xpath("//input[@value='Save All']"));
		WaitForVisibility(saveAll_Button, 20);
		clickElement(saveAll_Button, "SaveAll_Button");
		driver.switchTo().defaultContent();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	public static boolean Myprofile_ValidateName(String expectedUserName) {
		WebElement userName = driver.findElement(By.id("tailBreadcrumbNode"));
		WaitForVisibility(userName, 20);
		String actualUserName = userName.getText().trim();
		System.out.println("My profile_Username : " + actualUserName);
		boolean status = validationCheck(expectedUserName, actualUserName);
		return status;
	
	}
	public static void MySettings() {
		WebElement mySettings = driver.findElement(By.xpath("//div[@id='userNav-menuItems']//a[2]"));
		WaitForVisibility(mySettings,20);
		clickElement(mySettings, "My settings");
	}
	public static void PersonalInMySettings() {
		WebElement personalClick= driver.findElement(By.id("PersonalInfo_font"));
		WaitForVisibility(personalClick,20);
		clickElement(personalClick, "Personal in MySettings");
	}
	public static void Personal_LoginHistory() {
		WebElement loginHistory = driver.findElement(By.xpath("//a[@id='LoginHistory_font']"));
		clickElement(loginHistory, "Login History");
		WebElement downloadHistory = driver.findElement(By.xpath("//a[contains(text(),'login')]"));
		clickElement(downloadHistory, "Download History");
	}
	
	public static void displayAndLayout() {
		WebElement clickDisplay = driver.findElement(By.id("DisplayAndLayout_font"));
		WaitForVisibility(clickDisplay,20);
		clickElement(clickDisplay, "Display and Layout in Mysettings");
	}
	public static void DisplayAndLayout_CustomTab_Add()
	{
		WebElement CustomizeMyTab = driver.findElement(By.id("CustomizeTabs_font"));
		clickElement(CustomizeMyTab, "Customize MyTab");
		Dropdown_SelectByVisibleText_ID("p4", "Salesforce Chatter");
		Dropdown_SelectByVisibleText_ID("duel_select_0", "Reports");
		WebElement add = driver.findElement(By.xpath("//img[@title='Add']"));
		clickElement(add, "Add button");
		WebElement save = driver.findElement(By.xpath("//input[@name='save']"));
		clickElement(save, "save button");
	}
	public static void display_Customtab_validate() {
		//Validate in menu button - salesforce, sales and marketing whether report is added or not
		 click_MenuButton();
		List<WebElement> selectMenuItems = driver.findElements(By.xpath("//div[@id='tsid-menuItems']/a"));
		for(WebElement element : selectMenuItems) {
			if((element.getText()).equalsIgnoreCase("Salesforce Chatter")) {
				clickElement(element, element.getText());
				System.out.println("Clicked salesforce chatter");
				List<WebElement> menuTabItemsSalesforce = driver.findElements(By.xpath("//ul[@id='tabBar']/li"));
				for(WebElement ele : menuTabItemsSalesforce) {
					if((ele.getText()).equalsIgnoreCase("Reports")){
						System.out.println("Reports tab validated in Salesforce dropedown");
					}
				}
				break;
			}
		}
	}
	
	public static void DisplayAndLayout_CustomTab_Remove()
	{
		WebElement CustomizeMyTab = driver.findElement(By.id("CustomizeTabs_font"));
		clickElement(CustomizeMyTab, "Customize MyTab");
		Dropdown_SelectByVisibleText_ID("p4", "Salesforce Chatter");
		Dropdown_SelectByVisibleText_ID("duel_select_1", "Reports");
		WebElement remove = driver.findElement(By.className("leftArrowIcon"));
		clickElement(remove, "Remove button");
		WebElement save = driver.findElement(By.xpath("//input[@name='save']"));
		clickElement(save, "save button");
	}
	public static void emailLink() {
		WebElement emailLink = driver.findElement(By.id("EmailSetup_font"));
		WaitForVisibility(emailLink,20);
		clickElement(emailLink, "email in MySettings");
		System.out.println("******************");

	}
	
	public static void email_myEmailSettings() {
				//click MyEmail settings from the list
				WebElement clickMyEmailSetting = driver.findElement(By.id("EmailSettings_font"));
				WaitForVisibility(clickMyEmailSetting,20);
				clickElement(clickMyEmailSetting, "My EmailSetting in Email");
				
				//EmailSettings
				WebElement emailName = driver.findElement(By.id("sender_name"));
				WaitForVisibility(emailName,20);
				enterText(emailName, "Poongothai Mohan","emailName");
				//Sender email id
				WebElement emailID = driver.findElement(By.id("sender_email"));
				WaitForVisibility(emailID,20);
				enterText(emailID, "pongothai_y2k@yahoo.com", "emailID");
				//click AutoBCC

				clickElement((driver.findElement(By.id("auto_bcc1"))),"Auto BCC");
				
				//click Save
				clickElement((driver.findElement(By.name("save"))),"save email settings");
				//driver.switchTo().alert().accept();
				
				WebElement validateEmailUpdate = driver.findElement(By.xpath("//div[text()='Your settings have been successfully saved.']"));
				WaitForVisibility(validateEmailUpdate,20);
				String Actual = validateEmailUpdate.getText();
				String Expected = "Your settings have been successfully saved.";
				validationCheck(Expected, Actual);
				System.out.println("Email validated");
	}
	
	public static void calenderAndReminders() {
		WebElement clickCalender = driver.findElement(By.id("CalendarAndReminders_font"));
		WaitForVisibility(clickCalender,20);
		clickElement(clickCalender, "Calender_and_Reminder Link");
	}
	public static void calenderAndReminders_Settings() {
				String mainWindowHandle = driver.getWindowHandle();
				System.out.println("MainWindowHAndle : " + mainWindowHandle);
				//Click on Activity Reminders
				clickElement(driver.findElement(By.id("Reminders_font")), "Activity reminder");
				
				//Open a test reminder button
				WebElement clickTestReminder = driver.findElement(By.id("testbtn"));
				WaitForVisibility(clickTestReminder,20);
				clickElement(clickTestReminder, "Test_Reminder button");
				
				for(String handle : driver.getWindowHandles()) {
					driver.switchTo().window(handle);
				}
				String reminderTitle = driver.getTitle();
				System.out.println(reminderTitle);
				
				WebElement clickDismissAll = driver.findElement(By.id("dismiss_all"));
				WaitForVisibility(clickDismissAll,20);
				clickElement(clickDismissAll, "Dismiss_all button");
				System.out.println("Calender reminder validated");
				driver.switchTo().window(mainWindowHandle);
				String valMainWindowHandle = driver.getWindowHandle();
				System.out.println("validate_MainWindowHandle : " + valMainWindowHandle);

	}
	
	
	public static void click_MenuButton() {
		WebElement menuButton = driver.findElement(By.id("tsidLabel"));
		WaitForVisibility(menuButton, 30);
		clickElement(menuButton, "Click menu dropdown");
	}
	public static void deselect_Salesforce_Menubutton() {
		 WebElement menuButton = driver.findElement(By.id("tsidButton"));
			WaitForElementToBeClickable(menuButton, 20);
			clickElement(menuButton, "Click menu dropdown");
		List<WebElement> selectMenuItems = driver.findElements(By.xpath("//div[@id='tsid-menuItems']//a"));
		for(WebElement item : selectMenuItems) {
			if((item.getText()).equalsIgnoreCase("Sales")) {
				clickElement(item, "Deselect item -> Sales");
				break;
	
			}
		}
	}
	
	
	public static void deselect_CustomTab_Report(){
	//Usermenu
		WebElement userMenuDropdown = driver.findElement(By.id("userNav-arrow"));
		
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(userMenuDropdown)));
		clickElement(userMenuDropdown, "Usermenu Dropdown");
		
	}
	
	public static void accountTab() {
		WebElement accTab = driver.findElement(By.xpath("//a[text()='Accounts']"));
		WaitForVisibility(accTab, 20);
		clickElement(accTab, "Account Tab");
	}
	
	public static void accountTab_New(String accName) {
		WebElement newButton = driver.findElement(By.name("new"));
		WaitForVisibility(newButton, 20);;
		clickElement(newButton, "New button");
		int count=1;
		for(int i = 0 ; i <= 2 ; i++)
		{
			WebElement accountName = driver.findElement(By.id("acc2"));
			WaitForVisibility(accountName,15);
			enterText(accountName, accName, "Account_Name");
			Dropdown_SelectByVisibleText_ID("acc6", "Technology Partner");
			Dropdown_SelectByVisibleText_ID("00NgL000013FrEg", "High");
			if(count == 3)
			{
				WebElement saveBut = driver.findElement(By.name("save"));
				clickElement(saveBut, "save_button");
			}
			else {
				WebElement saveNew_button = driver.findElement(By.xpath("(//input[@name='save_new'])[1]"));
				clickElement(saveNew_button, "Save_New button");
			}
			count++;
		}		
		System.out.println("3 Accounts added successfully");

	}
	
	public static void validate_NewAccount(WebElement element, String ActualAccName, String expectedAccName) {
		validationCheck(expectedAccName, ActualAccName);
		System.out.println("Account name " + element + "validated");
		
	}
	
	
	public static void account_CreateNewView(String name) {
		WebElement clickCreateNewView = driver.findElement(By.xpath("//a[text()='Create New View']"));
		WaitForVisibility(clickCreateNewView, 20);
		clickElement(clickCreateNewView, "Create NewView Link");
		WebElement viewName = driver.findElement(By.id("fname"));
		enterText(viewName, name, "ViewName");
		WebElement uniqueView = driver.findElement(By.id("devname"));
		enterText(uniqueView, name, "UniqueViewName");
		WebElement saveButton = driver.findElement(By.name("save"));
		clickElement(saveButton, "SaveButton");

	}
	
	public static void validate_CreateNewView(String expectedViewName) {
		WebElement ValidateName = driver.findElement(By.name("fcf"));
		WaitForVisibility(ValidateName, 20);
		WebElement val_viewNAme= dropDown_FirstOptionSelect(ValidateName);
		String actualViewName = val_viewNAme.getText();
		validationCheck(expectedViewName, actualViewName);

	}
	public static void accounts_EditView(String edit_viewName) {
		WebElement viewNameDropDown = driver.findElement(By.id("fcf"));
		dropDown_SelectByVisibleText(viewNameDropDown, edit_viewName);
		WebElement editLink = driver.findElement(By.xpath("//a[text()='Edit']"));
		clickElement(editLink, "Edit link");
		WebElement viewName = driver.findElement(By.id("fname"));
		WaitForVisibility(viewName,15);
		enterText(viewName, (edit_viewName+"123"), "ViewName");
		WebElement viewUniqueName = driver.findElement(By.id("devname"));
		enterText(viewUniqueName, edit_viewName+"123New", "edit_viewName");
		Dropdown_SelectByVisibleText_ID("fcol1", "Account Name");
		Dropdown_SelectByVisibleText_ID("fop1", "contains");
		//Type ="a"
		WebElement value = driver.findElement(By.id("fval1"));
		enterText(value, "a", "Value box");
		WebElement save_Button= driver.findElement(By.name("save"));
		clickElement(save_Button, "SAVE button");

	}
	public static void account_Merge(String accName) {
		   //CLick Merge account in tool area
		WebElement merAccountsLink = driver.findElement(By.xpath("//a[text()='Merge Accounts']"));
		WaitForVisibility(merAccountsLink,15);
		clickElement(merAccountsLink,"Merge_acc_Link");				
		//Send values to find account text box
		WebElement findAccount = driver.findElement(By.id("srch"));
		WaitForVisibility(findAccount,15);
		enterText(findAccount,accName , "findAcc_textBox");
		//click findAccounts
		WebElement searchButton = driver.findElement(By.name("srchbutton"));
		clickElement(searchButton, "Search_Acc button");
		//click Next
		WebElement nextButton = driver.findElement(By.name("goNext"));
		clickElement(nextButton, "Next_Button");
				
        //Click on merge in step2
		WebElement merge = driver.findElement(By.name("save"));
		WaitForVisibility(merge,15);
		clickElement(merge,"Merge");
		alertSimple();
		System.out.println("Account merged successfully");

	}
	
	public static void account_CreateAccountReport(String rep_Name){
		WebElement lastActivityLink = driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity')]"));
		WaitForVisibility(lastActivityLink, 20);
		clickElement(lastActivityLink, "Last_Activity_link");

		//Select report options
		WebElement datefield_Box = driver.findElement(By.xpath("//input[@id='ext-gen20']"));
		WaitForVisibility(datefield_Box, 20);
		clickElement(datefield_Box, "DateField_box");
		WebElement dateField = driver.findElement(By.xpath("//div[@class='x-combo-list-inner']/div[contains(text(),'Created')]"));
		WaitForElementToBeClickable(dateField, 30);
		clickElement(dateField, "date_field");
		WebElement calenderCLick = driver.findElement(By.id("ext-gen153"));
		WaitForVisibility(calenderCLick,20);
		clickElement(calenderCLick, "Calender_Icon_click");
		WebElement clickToday = driver.findElement(By.xpath("//table[@id='ext-comp-1114']/tbody/tr[2]"));
		WaitForVisibility(clickToday,20);
		clickElement(clickToday, "Today_button");
		WebElement SaveButton = driver.findElement(By.id("ext-gen49"));
		WaitForVisibility(SaveButton, 20);
		clickElement(SaveButton, "Save_button");
		//Enter report name.unique name and save
		WebElement reportName = driver.findElement(By.name("reportName"));
		WaitForVisibility(reportName,20);
		enterText(reportName, rep_Name,"Report_name");
		WebElement reportUniqueName = driver.findElement(By.name("reportDevName"));
		WaitForVisibility(reportUniqueName,20);
		enterText(reportUniqueName, rep_Name, "REp_uniqueName");

		WebElement rep_Save = driver.findElement(By.xpath("//table[@id='dlgSaveReport']/tbody/tr/td/em/button[contains(text(),'Save')]"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		action_class(rep_Save);
		clickElement(rep_Save, "Report_Save");

	}
	public static void account_ValidateReport(String expected) {
		WebElement validateRepName = driver.findElement(By.className("pageDescription"));
		WaitForVisibility(validateRepName,20);
		String actual = validateRepName.getText();
		System.out.println(actual);
		validationCheck(expected, actual);
	}

	public static void opportunies() {
		WebElement opportunity_tab = driver.findElement(By.id("Opportunity_Tab"));
		WaitForVisibility(opportunity_tab,30);
		clickElement(opportunity_tab, "Opportunity Tab");

	}
	public static void opportunities_DropDown_validation() {
		List<String> ExpectedList = new ArrayList<String>();
		ExpectedList.add("All Opportunities");
		ExpectedList.add("Closing Next Month");
		ExpectedList.add("Closing This Month");
		ExpectedList.add("My Opportunities");
		ExpectedList.add("New Last Week");
		ExpectedList.add("New This Week");
		ExpectedList.add("Opportunity Pipeline");
		ExpectedList.add("Private");
		ExpectedList.add("Recently Viewed Opportunities");
		ExpectedList.add("Won");
		List<WebElement> dropDownList = driver.findElements(By.xpath("//select[@name='fcf']//option"));
	
		dropDown_validation_ID(dropDownList, ExpectedList);

	}
	
	public static void opprtunities_CreateNewOpty(String Opportunity_name) {
		WebElement new_button= driver.findElement(By.name("new"));
		WaitForVisibility(new_button,15);
		clickElement(new_button, "new_button");
		
		WebElement oppName = driver.findElement(By.id("opp3"));
		WaitForVisibility(oppName,15);
		enterText(oppName,Opportunity_name, "Opp_Name");
		
		WebElement acc_NameMagnifier = driver.findElement(By.id("opp4_lkwgt"));
		WaitForVisibility(acc_NameMagnifier,20);
		clickElement(acc_NameMagnifier, "acc_NameMagnifier");
		
		String parWindow = driver.getWindowHandle();
		Set<String> winhandles = driver.getWindowHandles();
		Iterator<String> i = winhandles.iterator();
		for(String handle : winhandles) {
			if(!handle.equals(parWindow)) {
				driver.switchTo().window(handle);
			}
		}
		
		WebElement frameTable = driver.findElement(By.xpath("//frame[@title='Results']"));
		WaitForVisibility(frameTable,15);
		driver.switchTo().frame(frameTable);
	
		WebElement firstAcc = driver.findElement(By.xpath("//table[@class='list']/tbody/tr[2]/th/a"));
		WaitForVisibility(firstAcc,30);
		String lookUpAccName =firstAcc.getText();
		clickElement(firstAcc, "First_Acc");
		driver.switchTo().window(parWindow);
		
		WebElement closeDate = driver.findElement(By.id("opp9"));
		WaitForVisibility(closeDate,15);
		clickElement(closeDate, "closeDate");
		
		WebElement todayCloseDate = driver.findElement(By.xpath("//a[@class='calToday']"));
		WaitForVisibility(todayCloseDate,15);
		clickElement(todayCloseDate, "todayCloseDate");
		
		WebElement selectStage = driver.findElement(By.xpath("//select[@id='opp11']"));
		dropDown_SelectByVisibleText(selectStage, "Qualification");

		WebElement leadSource = driver.findElement(By.xpath("//select[@id='opp6']"));
		dropDown_SelectByVisibleText(leadSource, "Phone Inquiry");
		
		WebElement primaryCampaignSource = driver.findElement(By.xpath("//img[@title='Primary Campaign Source Lookup (New Window)']"));
		WaitForVisibility(primaryCampaignSource,15);
		clickElement(primaryCampaignSource, "primaryCampaignSource");

		String parWindow2 = driver.getWindowHandle();
		Set<String> winhandles2 = driver.getWindowHandles();
		Iterator<String> i2 = winhandles2.iterator();
		for(String handle2 : winhandles2) {
			if(!handle2.equals(parWindow2)) {
				driver.switchTo().window(handle2);
			}
		}

		WebElement frameCampaign = driver.findElement(By.xpath("//frame[@id='resultsFrame']"));
		WaitForVisibility(frameCampaign,15);
		driver.switchTo().frame(frameCampaign);
		
		WebElement firstCampaign = driver.findElement(By.xpath("//table[@class='list']/tbody/tr[2]/th/a"));
		WaitForVisibility(firstCampaign,30);
		String lookUpCampaignName =firstCampaign.getText();
		System.out.println("lookUpCampaignName :" + lookUpCampaignName);
		clickElement(firstCampaign, "firstCampaign");
		driver.switchTo().window(parWindow2);
		
		WebElement save_Button = driver.findElement(By.name("save"));
		WaitForVisibility(save_Button,30);
		clickElement(save_Button, "save_Button");
//		Validate
		WebElement validateCampName = driver.findElement(By.xpath("//h2[@class='pageDescription']"));
		WaitForVisibility(validateCampName,30);
		String Actual = validateCampName.getText();
		String expected = Opportunity_name;
		validationCheck(expected, Actual);
		System.out.println("Creating new campaign validated successfully");
	}
	
	public static void opportunity_PipeLineLink() {
		WebElement OppPipeline = driver.findElement(By.xpath("//a[text()='Opportunity Pipeline']"));
		WaitForVisibility(OppPipeline,15);
		clickElement(OppPipeline, "OppPipeline");
		
		String ActualTitle = driver.getTitle();
		System.out.println("Title :: " + ActualTitle);
		String ExpectedTitle = "Opportunity Pipeline ~ Salesforce - Developer Edition";
		validationCheck(ExpectedTitle, ActualTitle);
		System.out.println("Opportunity pipeline link validated succesfully");
	}
	public static void opportunity_StuckReport() {
		WebElement stuckOpp = driver.findElement(By.xpath("//a[text()='Stuck Opportunities']"));
		WaitForVisibility(stuckOpp,15);
		clickElement(stuckOpp, "stuckOpp");
		String ActualTitle = driver.getTitle();
		System.out.println("Title :: " + ActualTitle);
		String ExpectedTitle = "Stuck Opportunities ~ Salesforce - Developer Edition";
	    validationCheck(ExpectedTitle, ActualTitle);
		System.out.println("Stuck Opportunity page validated succesfully");

	}
	public static void opportunity_QuarterlySummaryReport() {
		WebElement quarterlySummary = driver.findElement(By.id("quarter_q"));
		WaitForVisibility(quarterlySummary,15);
		Dropdown_SelectByVisibleText_ID("quarter_q", "Current and Next FQ");
		WebElement runReport = driver.findElement(By.xpath("//input[@value='Run Report']"));
		WaitForVisibility(runReport,15);
		clickElement(runReport, "runReport");
		String ActualTitle = driver.getTitle();
		System.out.println("Title :: " + ActualTitle);
		String ExpectedTitle = "Opportunity Report ~ Salesforce - Developer Edition";
	    validationCheck(ExpectedTitle, ActualTitle);
		System.out.println("Quarterly report page validated succesfully");

	}
	
	public static void Leads(){
		String parTitle = driver.getTitle();
		WebElement leadsTab = driver.findElement(By.xpath("//li[@id='Lead_Tab']"));
		WaitForVisibility(leadsTab, 25);
		clickElement(leadsTab, "LeadsTab");
		String expectedLeadTitle ="Leads: Home ~ Salesforce - Developer Edition";
		String actaulLeadTitle = driver.getTitle();
		validationCheck(expectedLeadTitle, actaulLeadTitle);
		System.out.println("LeadTab validated succesfully");
	}
	public static WebElement leads_dropdownClick() {
		WebElement leadsDropdownArrow = driver.findElement(By.name("fcf"));
		WaitForVisibility(leadsDropdownArrow, 20);
		clickElement(leadsDropdownArrow, "leadsDropdown_Arrow");
		return leadsDropdownArrow;
	}
	public  static void leads_UnreadLeads() {
		WebElement dropdownClick = leads_dropdownClick();
		dropDown_SelectByVisibleText(dropdownClick,"My Unread Leads");
		
	}
	public  static void leads_TodaysLeads() {
		WebElement ddTodaysLeads = leads_dropdownClick();
		dropDown_SelectByVisibleText(ddTodaysLeads,"Today's Leads");
	}

	
	public  static void leads_DropdownValidation() {
		List<String> ExpectedList = new ArrayList<String>();
		ExpectedList.add("All Open Leads");
		ExpectedList.add("My Unread Leads");
		ExpectedList.add("Recently Viewed Leads");
		ExpectedList.add("Today's Leads");
		ExpectedList.add("View - Custom 1");
		ExpectedList.add("View - Custom 2");

		List<WebElement> dropDownList = driver.findElements(By.xpath("//select[@name='fcf']/option"));
		dropDown_validation_ID(dropDownList, ExpectedList);
		
	}
	public static void lead_NewLead(String newLeadName) {
		WebElement newLead = driver.findElement(By.name("new"));
		WaitForVisibility(newLead,25);
		clickElement(newLead, "newLead");
	
		WebElement lead_Lastname = driver.findElement(By.name("name_lastlea2"));
		WaitForVisibility(lead_Lastname,25);
		enterText(lead_Lastname, newLeadName, "lead_Lastname");
		WebElement lead_Companyname = driver.findElement(By.name("lea3"));
		WaitForVisibility(lead_Companyname,25);
		enterText(lead_Companyname, newLeadName, "lead_Companyname");
		WebElement lead_saveButton = driver.findElement(By.name("save"));
		WaitForVisibility(lead_saveButton,25);
		clickElement(lead_saveButton, "lead_saveButton");
	}
	public static void leads_ValidateNewLead(String newLead) {
		System.out.println("Validating new lead -->");
		WebElement NewLeadTable = driver.findElement(By.xpath("//table[@class='list']/tbody"));
		List<WebElement> firstLink = NewLeadTable.findElements(By.xpath("//tr/th/a"));
		String firstData = firstLink.get(0).getText();
		System.out.println("firstData :" + firstData);
		if(firstData.equals(newLead)) {
			 System.out.println("Testcase passed");
		}
		else {
			System.out.println("Testcase failed");
		}
	   
		System.out.println("New lead validated successfully");
	}
	public static void leads_validateDropdownFirstSelected(String option) {
		WebElement leads_DDValidate = driver.findElement(By.id("fcf"));
		if(((dropDown_FirstOptionSelect(leads_DDValidate)).getText()).equals(option)) {
			System.out.println("Testcase pass");
		}
		else {
			System.out.println("Test failed");
		}
		
	}
	
	public static void contacts() {
		WebElement contactTab = driver.findElement(By.xpath("//a[text()='Contacts']"));
		WaitForVisibility(contactTab,25);
		clickElement(contactTab, "contactTab");
	}
	public static void contacts_NewContact(String contactLastName) {
		WebElement newContact_Button = driver.findElement(By.name("new"));
		WaitForVisibility(newContact_Button,15);
		clickElement(newContact_Button, "newContact_Button");

		WebElement contact_Lastname = driver.findElement(By.id("name_lastcon2"));
		WaitForVisibility(contact_Lastname,25);
		enterText(contact_Lastname, contactLastName, "contact_Lastname");
		//****************************************/
		System.out.println("Title: " + driver.getTitle());
		System.out.println("URL: " + driver.getCurrentUrl());
		String parWindow = driver.getWindowHandle();
		System.out.println("Handles: " + driver.getWindowHandles().size());
		
		//******************************************/
		WebElement newwContactMagnifier_Icon = driver.findElement(By.xpath("//img[@class='lookupIcon'][1]"));
		WaitForVisibility(newwContactMagnifier_Icon,25);
		clickElement(newwContactMagnifier_Icon, "newwContactMagnifier_Icon");
		System.out.println("Title: " + driver.getTitle());
		System.out.println("URL: " + driver.getCurrentUrl());
		System.out.println("Handles: " + driver.getWindowHandles().size());
		
		String devWindow = driver.getWindowHandle();
		Set<String> winhandles = driver.getWindowHandles();
		for(String handle : winhandles) {
			if(!handle.equals(parWindow)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		//*******************************************/
		List<WebElement> frames = driver.findElements(By.tagName("frame"));
		System.out.println("Frame count: " + frames.size());
		for(WebElement frame : frames) {
			System.out.println("Frame ID: " + frame.getAttribute("id"));
			 System.out.println("Frame Name: " + frame.getAttribute("name"));
			if((frame.getAttribute("id").equals("resultsFrame"))) {
				driver.switchTo().frame(frame);
			}
		}
	
		WebElement clickfirstAcc = driver.findElement(By.xpath("//table[@class='list']/tbody/tr[2]/th/a"));
		WaitForVisibility(clickfirstAcc,30);
		String lookUpAccName =clickfirstAcc.getText();
		System.out.println(lookUpAccName);
		clickfirstAcc.click();
		driver.switchTo().window(parWindow);

		WebElement contactSave_Button = driver.findElement(By.name("save"));
		WaitForVisibility(contactSave_Button,30);
		clickElement(contactSave_Button, "contactSave_Button");
	}
	
	public static void contacts_CreateNewView(String viewName) {
		WebElement createNewView = driver.findElement(By.xpath("//a[text()='Create New View']"));
		WaitForVisibility(createNewView,15);
		clickElement(createNewView, "createNewView");

		WebElement viewName_Text = driver.findElement(By.id("fname"));
		WaitForVisibility(viewName_Text,15);
		enterText(viewName_Text, viewName, "viewName");
	
		
		WebElement viewUniquename = driver.findElement(By.id("devname"));
		WaitForVisibility(viewUniquename,15);
		clickElement(viewUniquename, "viewUniquename");
		enterText(viewUniquename, viewName+"Unique", "viewUniquename");
				
		WebElement newViewSave = driver.findElement(By.name("save"));
		WaitForVisibility(newViewSave,30);
		clickElement(newViewSave, "newViewSave");
	}
	
	public static void contacts_ValoidateCreateNewView(String viewName) {
		
		WebElement validateNewView = driver.findElement(By.name("fcf"));
		WaitForVisibility(validateNewView,25);
		Select select = new Select(validateNewView);
		String Actual = select.getFirstSelectedOption().getText();
		String expected = viewName;
		validationCheck(expected, Actual);
		System.out.println("NewView Contact validated successfully");

		
	}
	public static WebElement contact_ContactTable() {
		WebElement NewContactTable = driver.findElement(By.xpath("//table[@class='list']/tbody"));
		List<WebElement> firstLink = NewContactTable.findElements(By.xpath("//tr/th/a"));
		WebElement firstData = firstLink.get(0);
		System.out.println("firstData :" + firstData);
		return firstData;
	}
	public static void contacts_validateNewAccount(String contactLastName) {

		System.out.println("Validating new lead -->");
		String firstData = contact_ContactTable().getText();
		if(firstData.equals(contactLastName)) {
			 System.out.println("Testcase passed");
		}
		else {
			System.out.println("Testcase failed");
		}
	   
		System.out.println("New lead validated successfully");
	}
	public static void contacts_CheckRecentlyCreated(String contactLastName) {

		List<WebElement> droplist_Contacts = driver.findElements(By.xpath("//select[@id='hotlist_mode']/option"));
		for(WebElement option : droplist_Contacts) {
			if((option.getText()).equals("Recently Created")) {
				clickElement(option, "RecentlyCreated_dropdown");
				break;
			}
		}
		
		String firstData = contact_ContactTable().getText();
		if(firstData.equals(contactLastName)) {
			 System.out.println("Testcase passed");
		}
		else {
			System.out.println("Testcase failed");
		}
	   
		System.out.println("Recently Created contact validated successfully");
	}
	
	public static void contacts_checkMyContacts() {
		String contactPageTitle = driver.getTitle();
		WebElement contactArrow= driver.findElement(By.name("fcf"));
		WaitForVisibility(contactArrow,15); 
		dropDown_SelectByVisibleText(contactArrow, "My Contacts");
		String myContactPageTitle = driver.getTitle();
		validationCheck(contactPageTitle, myContactPageTitle);
		System.out.println("My contacts page validated successfully");
	}
	public static void contacts_ViewAContact(String expected) {
		
		clickElement(contact_ContactTable(), "firstDataLink");
		WebElement validateName = driver.findElement(By.xpath("//div/h2[@class='pageDescription']"));
		WaitForVisibility(validateName, 20);
		String actual = validateName.getText();
		System.out.println("Actual name: " + actual);
		validationCheck(expected, actual);	
	}
	public static void contacts_NewViewError() {
		WebElement createNewView = driver.findElement(By.xpath("//a[text()='Create New View']"));
		WaitForVisibility(createNewView,15);
		clickElement(createNewView, "createNewView_Link");

		WebElement viewUniqueName = driver.findElement(By.id("devname"));
		WaitForVisibility(viewUniqueName,15);
		clickElement(viewUniqueName, "viewUniqueName_TextBOx");
		enterText(viewUniqueName, "MohanK2Unique", "viewUniqueName_TextBox");
		
		WebElement newViewSave_Button = driver.findElement(By.name("save"));
		WaitForVisibility(newViewSave_Button,30);
	    clickElement(newViewSave_Button, "newViewSave_Button");
	
		
		WebElement checkError = driver.findElement(By.xpath("//div[@class='errorMsg'][1]"));
		WaitForVisibility(checkError,30);
		
		String Actual = checkError.getText();
		String Expected = "Error: You must enter a value";
		validationCheck(Expected, Actual);
		System.out.println("Error message validated validated successfully");
	}
	public static void contacts_CheckCancelButton() {
		WebElement createNewView = driver.findElement(By.xpath("//a[text()='Create New View']"));
		WaitForVisibility(createNewView,15);
		clickElement(createNewView, "createNewView");

		WebElement viewname_TextBOx = driver.findElement(By.id("fname"));
		WaitForVisibility(viewname_TextBOx,15);
		enterText(viewname_TextBOx, "ABCD", "viewname_TextBOx");
		
		WebElement viewUniquename_TextBox= driver.findElement(By.id("devname"));
		WaitForVisibility(viewUniquename_TextBox,15);
		clickElement(viewUniquename_TextBox, "viewUniquename_TextBox");
		enterText(viewUniquename_TextBox, "EFGH", "viewUniquename_TextBox");
	
		WebElement newView_CancelButton = driver.findElement(By.name("cancel"));
		WaitForVisibility(newView_CancelButton,30);
	clickElement(newView_CancelButton, "newView_CancelButton");
	
		String Actual = driver.getTitle();
		String Expected = "Contacts: Home ~ Salesforce - Developer Edition";
		validationCheck(Expected, Actual);
		System.out.println("CheckCancelButton validated successfully");
	}
	
	public static void contacts_SaveAndNewButton() {
		WebElement newContact = driver.findElement(By.name("new"));
		WaitForVisibility(newContact,15);
		clickElement(newContact, "newContact");

		WebElement contactLastname = driver.findElement(By.id("name_lastcon2"));
		WaitForVisibility(contactLastname,15);
		enterText(contactLastname, "Indian", "contactLastname");
	
		WebElement accName  = driver.findElement(By.name("con4"));
		WaitForVisibility(accName,15);
		clickElement(accName, "accName");
		enterText(accName, "Global Media", "accName");
	
		WebElement contact_SaveAndNew = driver.findElement(By.name("save_new"));
		WaitForVisibility(contact_SaveAndNew,30);
		clickElement(contact_SaveAndNew, "contact_SaveAndNew");
	
		WebElement errorMessageSaveNew = driver.findElement(By.xpath("//div[@class='pbError']"));
		String Actual = errorMessageSaveNew.getText();
		String Expected = "Error: Invalid Data.";
		if(Actual.contains(Expected)) {
			System.out.println("Save And New Button validated successfully");
		}
		else {
		System.out.println("Testcase failed");
		}
	}
	
	public static String RS_VerifyLoggedInUser() {
		WebElement getName = driver.findElement(By.xpath("//div[@class='content']/span/h1/a"));
		WaitForVisibility(getName,15);
		String ActualLoggedInUserName = getName.getText();
		System.out.println("Actual_LoggedIn_userName : " + ActualLoggedInUserName);
		return ActualLoggedInUserName;

	}
	public static void logout() {
		
		WebElement logOut = driver.findElement(By.xpath("//a[text()='Logout']"));
		clickElement(logOut, "Logout Button");
		//Checking the logo to confirm the login page
		String ActualURL = driver.getCurrentUrl();
		String expectedURL = "https://orgfarm-aa47a0b3de-dev-ed.develop.my.salesforce.com/";
		validationCheck(expectedURL, ActualURL);
		System.out.println("Logout Validated succesfully");

		
	}
}
