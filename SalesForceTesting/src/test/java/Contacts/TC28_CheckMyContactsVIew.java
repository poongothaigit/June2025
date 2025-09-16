package Contacts;

import BaseTest_SFT.BaseSalesforce_SFT;

/*
============
*Test : PASS 
============
 * TestCase Description:
-> Launch and Login  to SalesForce Application
-> Click ON Contact Tab
-> Select 'My Contacts'  VIEw from the drop down list in contacts page
 * TestResult Expected:;
-> SalesForce application should be Launced
-> Contact Home page should be displayed
-> My contacts VIEw should be displayed
 */
public class TC28_CheckMyContactsVIew extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		contacts();
		contacts_checkMyContacts();
		close();

	}

}
