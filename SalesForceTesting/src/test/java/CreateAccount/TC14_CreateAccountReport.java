package CreateAccount;
/*
============
*Test : PASS
============
 * *TestStep Description 
 ->Launch and Login 
 	Launch https://www.login.salesforce.com and provide positive <username> and <password> data to SalesForce Application. 
 ->Click on Accounts link on the home page
 	Click on Accounts link on the home page
 ->Create account report
 	Click on Accounts with last activity > 30 days link in reports area on accounts page. 
 ->Select report options
 	Select create date in the date field drop down, select <todays date> in From and 
 	To fileds on the unsaved report filed
 ->Save report
 	Click on the save button on unsaved report page. Provide <report name>, <report unique name> 
 	in the pop window and click on save and run report button.
  *
  *Test Result Expected
	->SalesForce login page is launched and application home page is logged in with correct username.
	->Accounts page is displayed with correct <username>
	->Unsaved Repoet page is diaplayed
	->List of accounts qualified is displayed
	Report page with details and <report name>is displayed.

 */
import BaseTest_SFT.BaseSalesforce_SFT;

public class TC14_CreateAccountReport extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		accountTab();
		String reportName = "JULY_2025";
		account_CreateAccountReport(reportName);
		account_ValidateReport(reportName);
		close();
		

	}

}
