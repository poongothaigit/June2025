package Leads;
/*
============
*Test : PASS
============
 * TestCase Description:
-> Click leads tab link from Home Page
-> click on the drop down list handle
* TestResult Expected:
-> Link should navigate to Leads Home page
-> List should drop down and should show the following contents: 
	All Open Leads / 
	My Unread Leads / 
	Recently Viewed Leads / 
	Today's Leads.   
 */
import BaseTest_SFT.BaseSalesforce_SFT;

public class TC21_LeadsSelectView extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		Leads();
		leads_DropdownValidation();
		close();

	}

}
