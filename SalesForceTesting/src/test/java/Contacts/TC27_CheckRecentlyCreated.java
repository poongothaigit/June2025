package Contacts;
/*
============
*Test : PASS
============
 * TestCase Description:
-> Launch and Login  to SalesForce Application
-> Click ON Contact Tab
-> Select 'Recently created' from the drop down list in the right hand side of the 'Recent contact' frame of contacts page
 * TestResult Expected:;
-> SalesForce application should be Launched
-> Contact Home page should be displayed
-> Recently created contacts should be displayed
 */
public class TC27_CheckRecentlyCreated extends TC25_CreateNewContact{

	public static void main(String[] args) {
		
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		contacts();
		contacts_CheckRecentlyCreated(contactLastName);
		close();
		
		
	}

}
