package Login_Salesforce;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement;

import BaseTest_SFT.BaseSalesforce_SFT;

/*
 * *TestStep Description
	Open <https://www.Login.salesforce.com> page in browser
	Provide valid <username> in username text field and valid <password> in password text field and 
	selet the remember user name check box and click on Login to Slaesforce button
	Click on user menu drop down and select log out link
	UserName <userName> should be displayed 
*Test Result Expected
	SFDC login page is opened
	Sales force home page is displayed
	Login sales force page is displayed with <username> populated and remember user name checked
	Validate the user name displayed in user name field
 */

public class TC03RememberMe extends BaseSalesforce_SFT{

	public static void main(String[] args) throws InterruptedException {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		loginRemenberMe_SalesForce();
		userMenuDropdown_CLick();
		logout();
		Thread.sleep(3000);
		WebElement userName = driver.findElement(By.id("idcard-identity"));
		if(userName.isDisplayed())
		{
			System.out.println("Username displayed");
		}
		else
		{
			System.out.println("Test failed");
		}
		
		close();

	}

}
