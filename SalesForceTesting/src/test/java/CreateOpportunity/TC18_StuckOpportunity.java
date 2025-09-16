package CreateOpportunity;
/*
============
*Test : PASS
============
 * Testcase Description:
-> Launch https://www.login.salesforce.com and provide positive <username> and 
   <password> data to SalesForce Application. 
-> Click on opportunities link from the main menu
-> Click on Stuck Opportunities link  under Reports.
*Test Result Expected:
-> SalesForce login page is launched and application home page is logged in 
   with correct username.
-> Opportunities home page is displayed
-> Report Page with the Opportunities that are Stuck will be displayed.

 */
import BaseTest_SFT.BaseSalesforce_SFT;

public class TC18_StuckOpportunity extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		opportunies();
		opportunity_StuckReport();
		close();
	}

}
