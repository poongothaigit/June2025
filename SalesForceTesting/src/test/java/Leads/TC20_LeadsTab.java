package Leads;

import BaseTest_SFT.BaseSalesforce_SFT;

/*
============
*Test : PASS
============
 * TestCase Description:
-> Click leads tab link from Home Page
 * TestResult Expected:
-> Link should navigate to Leads Home page
 */
public class TC20_LeadsTab extends BaseSalesforce_SFT {

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		Leads();
		close();

	}

}
