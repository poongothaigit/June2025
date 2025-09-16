package CreateAccount;
import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;

/*
============
*Test : PASS
============
 * TestStep Description
 ->Launch and Login 
 	Launch https://www.login.salesforce.com and provide positive <username> and <password> data to SalesForce Application. 
 ->Click on Accounts link on the home page
 	Click on Accounts link on the home page
 ->Click on the New button to create new account
 	New Account edit page is displayed. Enter <Account name>  select type as Technology partner from drop down,
 	 set coustomer priority as high 
 *Test Result Expected
	SalesForce login page is launched and application home page is logged in with correct username.
	Accounts page is displayed with correct <username>
	New account page is displayed with account details.

 */


import BaseTest_SFT.BaseSalesforce_SFT;

public class TC10_CreateNewAccount extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		login_SalesForce();
		accountTab();
		String ExpectedAccName = "Kannan";
		accountTab_New(ExpectedAccName);
		WebElement val_accName = driver.findElement(By.xpath("//h2[contains(text(),'Kannan')]"));
		WaitForVisibility(val_accName, 15);
		String ActualName = val_accName.getText();
		validate_NewAccount(val_accName, ActualName, ExpectedAccName);
		
		userMenuDropdown_CLick();
		logout();
		close();
		
	}

}
