package Login_Salesforce;

import BaseTest_SFT.BaseSalesforce_SFT;


public class TC02LoginSF extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		String Actualtitle =getTitle();
		login_SalesForce();
		String expectedTitle = getTitle();
		validationCheck(expectedTitle, Actualtitle);
		System.out.println("Succesfully loggin in");
		driver.close();

	}

}
