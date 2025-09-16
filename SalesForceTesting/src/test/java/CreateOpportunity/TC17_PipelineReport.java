package CreateOpportunity;
/*
============
*Test : PASS
============
 * Test Description:
->Launch https://www.login.salesforce.com and provide positive <username> and 
  <password> data to SalesForce Application. 
->Click on opportunities link from the main menu
->Click on Opportunity Pipeline link  under Reports.
TestResult Expected:
->SalesForce login page is launched and application home page is logged in 
  with correct username.
->Opportunities home page is displayed
->Report Page with the Opportunities that are pipelined will be displayed.
 */
import BaseTest_SFT.BaseSalesforce_SFT;

public class TC17_PipelineReport extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		opportunies();
		opportunity_PipeLineLink();
		close();
	}

}
