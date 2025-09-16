package Contacts;
/*
============
*Test : PASS 
============
 * TestCase Description:
-> Launch and Login  to SalesForce Application
-> Click ON Contact Tab
-> Click on New Button
-> Enter Last Name <LastName> in Last name fIEld
-> "Enter account name in account name fIEld <AccountName>"
-> Click on Save button
 * TestResult Expected:;
-> SalesForce application should be Launched
-> Contact Home page should be displayed
-> New Contact home page should be displayed
-> Last name should be entered in Last name field
-> Account name should be displayed in account name fIEld
-> New contact should be created
 */
import BaseTest_SFT.BaseSalesforce_SFT;


public class TC25_CreateNewContact extends BaseSalesforce_SFT {
	public static String contactLastName = "MK2025";
	
	public static void main(String[] args) {
		
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		contacts();
		contacts_NewContact(contactLastName);
		contacts();
		contacts_validateNewAccount(contactLastName);
		close();

	}

}
