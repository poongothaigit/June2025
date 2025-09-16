package Contacts;

import BaseTest_SFT.BaseSalesforce_SFT;

/*
============
*Test : PASS
============
 * TestCase Description:
-> Launch and Login  to SalesForce Application
-> Click ON Contact Tab
-> Click on Create New VIEw link
-> Enter the <VIEw Name> field in the View Name field
-> Enter the <VIEw Unique Name> fIEld in the view Unique Name field.It will be automatically given by the salesforce application, one can modify if they wish
-> Click on save button
 * TestResult Expected:;
-> SalesForce application should be Launched
-> Contact Home page should be displayed
-> New VIEw Page should be displayed
-> VIEw Name should be entered in the vIEw name field
-> VIEw Unique Name should be entered in the view Unique Name field.
-> Contacts Home page is opened. Created VIEw name is displayed in drop down in that page by defalut. 
 */
public class TC26_CreateNewView extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		String viewName= "MohanK123";
		contacts();
		contacts_CreateNewView(viewName);
		contacts_ValoidateCreateNewView(viewName);
	}

}
