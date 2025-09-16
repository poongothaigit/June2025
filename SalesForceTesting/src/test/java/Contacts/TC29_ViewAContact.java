package Contacts;

import BaseTest_SFT.BaseSalesforce_SFT;

/*
============
*Test : PASS 
============
 * TestCase Description:
-> Launch and Login  to SalesForce Application
-> Click ON Contact Tab
-> Click on a <contact name> under the Name fIEld in the Recent Contact Frame
 * TestResult Expected:;
-> SalesForce application should be Launced
-> Contact Home page should be displayed
-> Contact Page related to <contact name>, which contains entire information 
   about that <contact name> should be displayed 
 */
public class TC29_ViewAContact extends TC25_CreateNewContact{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		contacts();
		contacts_ViewAContact(contactLastName);
		close();
	}

}