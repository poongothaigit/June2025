package com.CucumberSFWithPOMUpgrade.Pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import  com.CucumberSFWithPOMUpgrade.Pages.Base.BasePage;



public class LoginPage extends BasePage{

	@FindBy(id="username") WebElement userName;
	@FindBy(id="password") WebElement password;
	@FindBy(id="Login") WebElement loginButton;
	@FindBy(id="rememberUn") WebElement rememberMeCheckBox; 
	
	@FindBy(id="forgot_password_link") WebElement forgetPassword_Link;
	@FindBy(id="un") WebElement forgetField_UserName;
	@FindBy(id="continue") WebElement forgetField_ContinueButton;
	@FindBy(xpath="//h1[@id=\"header\"]") WebElement forgetField_Msg; 
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
	public void enterforgetField_UserName(String data)
	{
		enterText(forgetField_UserName, data, "forgetField_UserName");
	}
	public WebDriver clickforgetField_ContinueButton()
	{
		clickElement(forgetField_ContinueButton, "forgetField_ContinueButton");
		return driver;
	}
	public String getTextforgetField_Msg() {
		String actualText = getText(forgetField_Msg, "forgetField message");
		return actualText;
	}
}
