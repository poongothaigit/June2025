package Contacts;

import BaseTest_SFT.BaseSalesforce_SFT;

/*
============
*Test : PASS 
============
 * TestCase Description:
-> Login to Salesforce.com
Click on Contacts on the menu bar
Click on the New button
Enter the last name and Account Name(Last Name - Indian, Account Name-Global Media)
Click the Save & New button
 * TestResult Expected:;
-> "Logged in salesforce.com
Contacts page is opened.
Contact Edit: New Contact Page is dispalyed
Last Name and the Account Name should be enetered.
New contact is created. Contact Edit: New Contact Page is dispalyed
 */
public class TC32_SaveAndNewButton extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		contacts();
		contacts_SaveAndNewButton();
		close();

	}

}
