package Leads;

import BaseTest_SFT.BaseSalesforce_SFT;

/*
============
*Test : PASS
============
 * TestCase Description:
-> Link should navigate to Leads Home page
-> click on Today's Leads from the view drop down click on go button
 * TestResult Expected:;
-> Leads homepage should be displayed
-> Todays's Lead page should be displayed.
 */
public class TC23_DDTodaysLeads extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		Leads();
		leads_TodaysLeads();
		leads_validateDropdownFirstSelected("Today's Leads");
		close();
	}

}
