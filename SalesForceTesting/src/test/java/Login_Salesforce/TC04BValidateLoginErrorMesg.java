package Login_Salesforce;

import org.openqa.selenium.By;

import BaseTest_SFT.BaseSalesforce_SFT;
/**
 * 
 * @author poong
 *Test Step Description
	Open <https://login.salesforce.com/> page in browser
	Enter 123 in user name field
	Enter Password 22131 
	Click on Login button
 *Expected Result
	SFDC login page is opened
	Username 123 is entered in username field
	Password is entered in the pwd field
	"Error message should be displayed
	'Your login attempt has failed. The username or password may be incorrect, or your location or login time may be restricted. 
	Please contact the administrator at your company for help'"
 */

public class TC04BValidateLoginErrorMesg extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		
		loginWrongEntry();
		String actualMsg = (driver.findElement(By.id("error")).getText());
		String expectedMsg = "Error: Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		validationCheck(expectedMsg, actualMsg);
		System.out.println("Validation passed");
		close();
	}

}
