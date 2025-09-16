package Login_Salesforce;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement;
import BaseTest_SFT.BaseSalesforce_SFT;


public class TC01ErrorSF extends BaseSalesforce_SFT{

	public static void main(String[] args) {
		launchBrowser("chrome");
		goToUrl("https://login.salesforce.com/");
		InvalidLogin_SalesForce();
		
		WebElement errorMsg = driver.findElement(By.id("error"));
		String expectedStr = "Error: Please enter your password.";
		String actualStr = errorMsg.getText();
		validationCheck(expectedStr, actualStr);
		driver.close();
		

	}

}
