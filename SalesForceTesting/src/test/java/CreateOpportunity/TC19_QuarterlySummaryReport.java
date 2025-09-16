package CreateOpportunity;
/*
============
*Test : PASS
============
 * TestCase Description: 
-> Launch https://www.login.salesforce.com and provide positive <username> and 
   <password> data to SalesForce Application. 
-> Click on opportunities link from the main menu
-> Click on Quarterly Summary link and choose list of values for Interval 
   such as Current FQ,Next FQ and Include such as All,Open or closed Opportunities
*  TestResult Expected:
-> SalesForce login page is launched and application home page is logged in 
   with correct username.
-> Opportunities home page is displayed
-> Report Page with the Opportunities that satisfies the search criteria will be displayed.
 */
import BaseTest_SFT.BaseSalesforce_SFT;

public class TC19_QuarterlySummaryReport extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		opportunies();
		opportunity_QuarterlySummaryReport();
		close();

	}

}
