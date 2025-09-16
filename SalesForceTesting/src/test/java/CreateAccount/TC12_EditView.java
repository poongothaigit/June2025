package CreateAccount;
/*
 *  TestStep Description 
============
*Test : PASS
============
 ->Launch and Login 
 	Launch https://www.login.salesforce.com and provide positive <username> and <password> data to SalesForce Application. 
 ->Click on Accounts link on the home page
 	Click on Accounts link on the home page
 ->Select the <view name> from the view drop down list on the account page to edit
 	Select the <view name> from the view drop down list on the account page. Click on the 
 	Edit link the accounts page.
 ->Edit the view
 	Change the <view name> to <new view name>. 
 	Select the filters field <Account name>, 
 	operator  <contains>, 
 	Value <a>. 
 	In Select fields to display,  Click on save button.
 *Test Result Expected
	SalesForce login page is launched and application home page is logged in with correct username.
	Accounts page is displayed with correct <username>
	<View name> edit page Is displayed
	View page with <new view name> in the drop down is displayed. View will have Last activity column added 
	and the data of the list will have all account names which has <a> in the text.
 */
import BaseTest_SFT.BaseSalesforce_SFT;

public class TC12_EditView extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		accountTab();
		accounts_EditView("Saatvi");
		close();

	}

}
