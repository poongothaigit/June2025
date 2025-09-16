package CreateOpportunity;
/*
============
*Test : PASS
============
 * Test Description:
-> Launch https://www.login.salesforce.com and provide 
   positive <username> and <password> data to SalesForce Application. 
-> Click on opportunities link from the main menu
-> New Opportunity Edit page is displayed. 
   Enter Opportunity Name,Account Name,Close Date,Stage,Probability,
   Lead Source , Primary Campaign Source and click on save button.
 * TestResult Expected:
->SalesForce login page is launched and application home page is 
  logged in with correct username.
->Opportunities home page is displayed
->New Opportunity page is displayed with Opportunity details.
 */
import BaseTest_SFT.BaseSalesforce_SFT;

public class TC16_CreateNewOpty extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		opportunies();
		String Opp_Name = "Opp3";
		opprtunities_CreateNewOpty(Opp_Name);
		close();

	}

}
