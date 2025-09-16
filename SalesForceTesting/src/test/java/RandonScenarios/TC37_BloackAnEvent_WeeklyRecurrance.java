package RandonScenarios;

import BaseTest_SFT.BaseSalesforce_SFT;

/*
============
*Test : PASS 
============
 * TestCase Description:
-> Click on Home Tab
-> Click on the current date link
-> Click on '4:00PM' link
-> Click on 'Subject Combo' icon next to Subject field.
-> Click 'Other' from Combobox
-> Click on the 'End' time field
-> Select '7:00 PM' from the dropdown.
-> Check the'Create Recurring Series of Events' under the 'Recurrence' field
-> Select 'Weekly' radiobutton
-> Click on the 'End Date' field and select 2 weeks from then.
-> Click Save button
-> Click 'Month View' icon
* TestCase Result:
-> 1. Home page should be displayed.                                                                                                                                                                                 2. Current date is displayed as a link below the FirstName and LastName in Day Month Date,Year format. Ex: Thursday July 18,2019
-> The 'Calendar for FirstName LastName' page should be displayed.
-> The 'Calendar: New Event' page should be displayed with the cursor at the Subject field.
-> The 'Combobox' popup should be opened.
 		1. The 'Combobox' popup should be closed.                                                                     
 		2.Other should be entered in the Subject field
-> Drop down should be displayed with time starting from 5:00 PM till 11:30 PM.
->7:00 PM should be selected in the 'End' field.
		1. The box should be checked.                                                                                                 
		2. 'Frequency', 'Start Date', 'End Date' sections should be displayed.
-> 1. 'Weekly' radio button should be selected.                                                                     
   2. 'Recurs Every..' section shlould be displayed with '1' entered in it.                      
   3. Current day of the week should be checked. Ex:Thursday
-> The 'End Date' should be selected and the calendar should be closed.
-> The 'Calendar for FirstName LastName' page should be displayed with 'Other' event in the time slot 4:00PM to 7:00PM, as a link.
		1. The 'Calendar for FirstName LastName - Month View' page should be displayed.         
		2. Current date and a week from current date should have the 'Other' event blocked as a link.
 */
public class TC37_BloackAnEvent_WeeklyRecurrance extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		String xpath = "//span[@id='p:f:j_id25:j_id69:20:j_id71:0:j_id72:calendarEvent:j_id84']/a";
		tab_HOmeTab_WeeklyRecurrance("August", "2025", "13");
		tab_HomeTab_ValidateEvent(xpath);
	
	}

}
