package CreateAccount;

import BaseTest_SFT.BaseSalesforce_SFT;

/*
============
*Test : PASS
============
 *  TestStep Description
 ->Launch and Login 
 	Launch https://www.login.salesforce.com and provide positive <username> and <password> data to SalesForce Application. 
 ->Click on Accounts link on the home page
 	Click on Accounts link on the home page
 ->Click on create new view link on accounts page
 	Click on create new view link and provide <View name>, <View unique name> and click on save button
 *Test Result Expected
	SalesForce login page is launched and application home page is logged in with correct username.
	Accounts page is displayed with correct <username>
	Newely added View should be displayed in the account view list

 */
public class TC11_CreateNewViewLink extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		accountTab();
		account_CreateNewView("Saatvi");
		validate_CreateNewView("Saatvi");
		userMenuDropdown_CLick();
		logout();
		close();

	}

}
