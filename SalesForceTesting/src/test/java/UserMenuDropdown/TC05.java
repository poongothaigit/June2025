package UserMenuDropdown;

import BaseTest_SFT.BaseSalesforce_SFT;

/*
 **TestStep Description
    *Launch https://www.login.salesforce.com and provide positive <username> 
	 and <password> data to SalesForce Application. 
	*After salesforce application launch check for 
	*the user menu drop down on the web page
	*Click on the user menu for <username> drop down
  *Test Result Expected
	*SalesForce login page is launched and application home page is logged in with correct username.
	*User menu drop down shpuld be available
	*Drop down with 
	*"My profile", 
	*"My Settings", 
	*"Developer Console",
	*"Logout" , 
	*"Switching to lightning Experience" is displayed

 */
public class TC05 extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		userMenuDropdown_CLick();
		userMenuDropdown_list();
		close();
		
		

	}

}
