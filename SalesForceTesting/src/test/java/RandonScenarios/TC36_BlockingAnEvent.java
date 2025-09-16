package RandonScenarios;

import BaseTest_SFT.BaseSalesforce_SFT;

/*
============
*Test : PASS 
============
 * TestCase Description:
-> Click on the current date link
-> Click on '8:00PM' link
-> Click on 'Subject Combo' icon next to Subject field.
-> Click 'Other' from Combobox
-> Click on the 'End' time field
->Select '9:00 PM' from the dropdown.
-> Click Save button
 * TestResult Expected:
-> The 'Calendar for FirstName LastName' page should be displayed.
-> The 'Calendar: New Event' page should be displayed with the cursor at the Subject field.
-> The 'Combobox' popup should be opened.
		1. The 'Combobox' popup should be closed.                                                                     
		2.Other should be entered in the Subject field
-> Drop down should be displayed with time starting from 9:00 PM till 11:30 PM.
-> 9:00 PM should be selected in the 'End' field.
-> The 'Calendar for FirstName LastName' page should be displayed with 'Other' event in 
   the time slot 8:00PM to 9:00PM, as a link.
 */
public class TC36_BlockingAnEvent extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		tab_HomeTab_BlockAnEvent();
		String xpath = "//span[@id='p:f:j_id25:j_id69:28:j_id71:0:j_id72:calendarEvent:j_id84']/a";
		tab_HomeTab_ValidateEvent(xpath);
	//	close();

	}

}
