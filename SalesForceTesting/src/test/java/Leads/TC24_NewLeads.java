package Leads;

import BaseTest_SFT.BaseSalesforce_SFT;

/*
============
*Test : PASS
============
 * TestCase Description:
-> Link should navigate to Leads Home page
-> click on the new button displayed in the Recent Leads frame
-> enter "ABCD" in the last name field 
-> enter "ABCD" in the company name field
-> click on the save button
 * TestResult Expected:;
-> Leads homepage should be displayed
-> New Lead creation page should open
-> ABCD is entered
-> ABCD is entered
-> new lead should be saved and the newly created lead view page should be opened
 */
public class TC24_NewLeads extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		Leads();
		String newLeadName = "ABCDFGH";
		lead_NewLead(newLeadName);
		Leads();
		leads_ValidateNewLead(newLeadName);
		close();
	}

}
