package com.SalesForcePOM.Pages;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.SalesForcePOM.Pages.Base.BasePage;

public class LoginPage extends BasePage{

	@FindBy(id="username") WebElement userName;
	@FindBy(id="password") WebElement password;
	@FindBy(id="Login") WebElement loginButton;
	@FindBy(id="rememberUn") WebElement rememberMeCheckBox; 
	
	@FindBy(id="forgot_password_link") WebElement forgetPassword_Link;
	@FindBy(id="un") WebElement remember_UserName;
	@FindBy(id="continue") WebElement remember_ContinueButton;
	@FindBy(xpath="//h1[@id=\"header\"]") WebElement remember_Msg; 
	@FindBy(id="error") WebElement errorMsg;
	@FindBy(id="idcard-identity") WebElement userNameRememberValidation;
	
	public LoginPage(WebDriver driver)
	{
		// PageFactory.initElements(driver,this);    // initElements used to initialize the locator in page object model
		super(driver);
	}
	
	public void checkUserNameRememberValidation()
	{
		isDisplayed(userNameRememberValidation, "userName");
	}
	
	public String getTextErrorMsg() {
		String actualText = getText(errorMsg, "Error message");
		return actualText;
	}
	public void enterUserName(String data)
	{
		enterText(userName, data, "Username Filed");
	}
	
	public void enterPassword(String data)
	{
		enterText(password, data, "password Filed");
	}
	
	public WebDriver clickLoginButton()
	{
		clickElement(loginButton, "Login button");
		return driver;
	}
	public WebDriver clickforgetPassword_Link()
	{
		clickElement(forgetPassword_Link, "forgetPassword_Link");
		return driver;
	}
	public WebDriver clickRememberMeCheckBox()
	{
		clickElement(rememberMeCheckBox, "rememberMe CheckBox");
		return driver;
	}
	public void enterRemember_UserName(String data)
	{
		enterText(remember_UserName, data, "remember_UserName");
	}
	public WebDriver clickRemember_ContinueButton()
	{
		clickElement(remember_ContinueButton, "Remember_ContinueButton");
		return driver;
	}
	public String getTextRemember_Msg() {
		String actualText = getText(remember_Msg, "Remember message");
		return actualText;
	}
}
