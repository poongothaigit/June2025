package CreateAccount;
/*
 * TestStep Description 
============
*Test : PASS
============
 ->Launch and Login 
 	Launch https://www.login.salesforce.com and provide positive <username> and <password> data to SalesForce Application. 
 ->Click on Accounts link on the home page
 	Click on Accounts link on the home page
 ->Select accounts to merge
 	On the accounts page in Tools area, click on Merge Accounts link.
 	Enter the <Account name> in the text box of merge accounts 
 	page and click Find accounts button. 
 	Entered <Account name> should result in atleast 2 or more account links. 
 	Select first two account links displayed in the list and click on Next button
 ->Merge accounts
 	Click on Merge button on Merge by accounts step 2 page. Click on OK button on the pop up.
 *Test Result Expected
	SalesForce login page is launched and application home page is logged in with correct username.
	Accounts page is displayed with correct <username>
	Merge by Accounts step 2 page is displayed with the selected accounts details to merge
	New pop up for account merge confirmation is displayed and once the accounts are merged, account page is displayed.
	 In recently viewed view, new merged account is listed.


 */
import BaseTest_SFT.BaseSalesforce_SFT;

public class TC13_MergeAccounts extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		accountTab();
		String accName = "Kannu";
		accountTab_New(accName);
		accountTab();
		account_Merge(accName);
		close();
		
		
	}

}
