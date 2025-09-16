package Leads;
import org.openqa.selenium.By;

/*
============
*Test : PASS
============
 * TestCase Description:
-> Click leads tab link from Home Page
-> Select 'My unread leads' from the view drop down and logout from the application
-> Enter Username and pasword and click login 
-> Click leads tab link from Home Page
-> Click on go button without changing list selection
 * TestResult Expected:;
-> Leads homepage should be displayed
-> Todays leads' should be selected from the drop down and the salesforce login page appears
-> User should be logged in to the application
-> Leads homepage should be displayed
-> Which ever default view was selected during last session, that page should be 
   displayed.Ex:'Todays leads' view should have been the default view and
   that view's page should be displayed once the go button is clicked
 */
import BaseTest_SFT.BaseSalesforce_SFT;

public class TC22_DefaultView extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		Leads();
		leads_UnreadLeads();
		userMenuDropdown_CLick();
		logout();
		login_SalesForce();
		Leads();
		leads_validateDropdownFirstSelected("My Unread Leads");
		close();

		
	}

}
