package Contacts;

import BaseTest_SFT.BaseSalesforce_SFT;

/*
============
*Test : PASS 
============
 * TestCase Description:
-> Login to Salesforce.com with the login credentails.
-> Click on Contacts on the Menu bar
-> Click on Create New VIEw hyperlink 
-> "Enter the required fIElds like VIEw Name, VIEw Unique Name(VIEw Name : ABCD
    Unique Name : EFGH)"
-> Click the Cancel Button
 * TestResult Expected:;
-> Logged in salesforce.com
-> Contacts page is opened.
-> Create New VIEw page is opened.
-> The vIEw name and Unique name should be enetered
-> Contacts Home page is displayed and the VIEw ABCD should not be created.
 */
public class TC31_CreateNewVIew_CheckCancelButton extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		contacts();
		contacts_CheckCancelButton();
		close();
	}

}
