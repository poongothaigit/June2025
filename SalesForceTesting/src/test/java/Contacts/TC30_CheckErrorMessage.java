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
-> Enter the VIEw Unique Name(Unique Name : EFGH)
-> Click the Save Button
 * TestResult Expected:;
-> Logged in salesforce.com
-> Contacts page is opened.
-> Create New VIEw page is opened.
-> Unique Name : "EFGH"
-> Error message is appeared under the VIEw Name fIEld. The Error message appears
   as "Error: You must enter a value".
 */
public class TC30_CheckErrorMessage extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		contacts();
		contacts_NewViewError();
		close();
	}

}
