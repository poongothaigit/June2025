package RandonScenarios;

import org.openqa.selenium.JavascriptExecutor;

import BaseTest_SFT.BaseSalesforce_SFT;

/*
============
*Test : PASS 
============
 * TestCase Description:
-> Launch and Login  to SalesForce Application
-> Click on Home Tab
-> Click on the FirstName LastName link in the home page
 * TestResult Expected:;
-> SalesForce application should be Launced.
-> 1. Home page should be displayed.                                  
   2. Verify that the FirstName LastName of the account holder is displayed 
      at the top left hand side of the page, as a link.                                                                                        
-> 1. 'User:FirstName LastName' page should be displayed.                                                                                               
-> 2. This page should be same as the 'My Profile' page.
 */
public class TC33_VerifyLoggedInUser extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
	
		String expectedUserName = RS_VerifyLoggedInUser();
		userMenuDropdown_CLick();
		MyProfile();
		Myprofile_ValidateName(expectedUserName);
		close();
	
	}

}
