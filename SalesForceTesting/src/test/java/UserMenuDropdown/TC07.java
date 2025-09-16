package UserMenuDropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseTest_SFT.BaseSalesforce_SFT;

/*
 * * TestStep Description
	user menu for <username> drop down is selected
	Click "My Settings" option from user menu
->	Click on personal link and select Login History link. 
	Click on Download login  history link.
	
->	Click on Display & Layout link and select Customize My Tabs link.
	Select "Salesforce Chatter" option from custom App: drop down.
	Select Reports tab from Available Tabs list. Click on >(Add) button. And save.
	
->	Click on Email link and click on my email settings link under that
	Provide <EmailName> in Email Name field, <EmailAddress> in Email Address field, 
	Select automatic BCC radio button 
	and click on save button
->	Click on Calendar & Remainders link and click on Activity Remainders link. 
	On Remainders page click on Open a test Remainder button.
 * Test Result Expected
	Drop down with "My profile", "My Settings", "Developer Console","Logout" is displayed
	My Settings page is displayed
	Login history is displayed and the data is downloaded in .csv format.
	Reports field is added to Selected Tabs list and also added in the links available in top of salesforce page
	 and sales force chatter page and sales and marketing pages.
	Given details are saved as default mail options and My settings page is displayed. 
	(It's ok)
	Sample event pop window is dispayed.
 */
public class TC07 extends BaseSalesforce_SFT{

	public static void main(String[] args) throws InterruptedException {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		userMenuDropdown_CLick();
		MySettings();
		System.out.println("---------------------------");
		
		//personal link
		PersonalInMySettings();
		Personal_LoginHistory();
		System.out.println("---------------------------");
//		
		// Display & Layout
		displayAndLayout();
		DisplayAndLayout_CustomTab_Add();
		display_Customtab_validate();
		System.out.println("---------------------------");
		
        //Email
		userMenuDropdown_CLick();
		MySettings();
		emailLink();
		email_myEmailSettings();
		System.out.println("---------------------------");
		
		//Calender_And_Reminders
		calenderAndReminders();
		calenderAndReminders_Settings();
		System.out.println("---------------------------");
		
		//deselect
	
		userMenuDropdown_CLick();
		MySettings();
		displayAndLayout();
		DisplayAndLayout_CustomTab_Remove();
		Thread.sleep(3000);
		deselect_Salesforce_Menubutton();
		Thread.sleep(3000);
	
		close();

	}

}
