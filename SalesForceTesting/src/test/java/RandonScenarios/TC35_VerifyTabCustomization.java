package RandonScenarios;

import BaseTest_SFT.BaseSalesforce_SFT;

/*
============
*Test : PASS 
============
 * TestCase Description:
-> Click on the all tab '+'
-> Clcik on the 'Customize My Tabs' button on the right hand side of the page.
-> Select any tab from the 'Selected Tabs' section and click Remove button.
-> Click on Save button
-> Click on User menu 'FirstName LastName' menu button and click Logout.
-> Launch and Login  to SalesForce Application
 * TestResult Expected:
-> The 'All Tabs' page should be displayed.
-> The 'Customize My Tabs' page should be displayed.
-> The selected tab should be removed from the 'Selected Tabs' section and 
   should be moved to the 'Available Tabs' section.
		1. The 'All Tabs' page should be displayed.           
	    2. The tab removed at step 3 should not be displayed in the tab bar.
 */
public class TC35_VerifyTabCustomization extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		tab_vaidateTab();
		String tabName = "Chatter";
		tab_CustomizeMyTab_Remove(tabName);
		tab_vaidateTab();
		tab_CustomizeMyTab_Add(tabName);
		close();

	}

}

