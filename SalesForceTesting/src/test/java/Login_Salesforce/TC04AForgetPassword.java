package Login_Salesforce;

import BaseTest_SFT.BaseSalesforce_SFT;

public class TC04AForgetPassword extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		forgetPassword();
		System.out.println("validation passed");
		close();
		
	}

}
