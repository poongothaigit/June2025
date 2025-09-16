package CreateOpportunity;

import BaseTest_SFT.BaseSalesforce_SFT;

/*
 * 
============
*Test : PASS
============
 * Test Description:
 -> Launch https://www.login.salesforce.com and provide
    positive <username> and <password> data to SalesForce Application. 
 -> Click on opportunities link from the main menu
 ->Verify opportunities drop down is present
 * TestResult expected:
 -> SalesForce login page is launched and application
    home page is logged in with correct username.
 -> Opportunities home page is displayed
 ->Drop down with 
   "All Oppotunities", 
   "Closing Next Month", 
   "Closing This Month", 
   "My Opportunities", 
   "New This Week", 
   "Recently Viewed Opportunities",
   "Won"  should be available
 */
public class TC15_OppDropDown extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		opportunies();
		opportunities_DropDown_validation();
		close();

	}

}
