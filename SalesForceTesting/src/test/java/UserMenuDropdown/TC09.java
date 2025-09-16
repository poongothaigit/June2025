package UserMenuDropdown;

import BaseTest_SFT.BaseSalesforce_SFT;

/*
 *  TestStep Description
 ->Select user menu for <username> drop down[TC01]
 		user menu for <username> drop down is selected
 ->Click on Logout option from the drop down
 	Click on Logout option from the drop down
 *Test Result Expected
	Drop down with "My profile", "My Settings", "Developer Console","Logout" is displayed
	Logout  of current sales force application  and https://login.salesforce.com/ page is displayed.

 */
public class TC09 extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		userMenuDropdown_CLick();
		userMenuDropdown_list();
		logout();
		close();

	}

}
