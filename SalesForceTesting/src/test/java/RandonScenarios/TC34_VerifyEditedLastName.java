package RandonScenarios;

import BaseTest_SFT.BaseSalesforce_SFT;

/*
============
*Test : PASS 
============
 * TestCase Description:
-> Launch and Login  to SalesForce Application
-> Click on Home Tab
-> Click on the FirstName LastName link at the left had side of the home page
-> Click on the 'Edit Profile' icon near Contact
-> Click on the 'About' tab in the popup.
-> Edit the Last Name to 'Abcd' and click Saveall button
 * TestResult Expected:
-> SalesForce application should be Launched
-> Home page should be displayed.                                    
-> The 'User:FirstName LastName' page should be displayed.                                                                                                
-> The 'Edit Profile' popup should be displayed with the 'Contact' tab selected.
-> Focus should be in the First Name field.
	1. The 'Edit Profile' popup should be closed.            
	2. Verify that the updated LastName of the account holder is displayed 
	   at the top left hand side of the page.                                                                    
    3. Verify that the 'User menu for FirstName LastName' menu button shows 
       the updated Last Name, at the top right hand side of the page.          
    4. Verify that the 'User:FirstName LastName' page has the updated LastName.
 */
public class TC34_VerifyEditedLastName extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		String actual_Username = tab_HomeTab();
		String edit_Name = "Abcd";
		MyProfile_EditProfile(actual_Username, edit_Name);
		if(!Myprofile_ValidateName(edit_Name) == true) {
			System.out.println("Testcass pass");
		}
		else {
			System.out.println("Testcase failed");
		}
		
		close();
		
	}

}
