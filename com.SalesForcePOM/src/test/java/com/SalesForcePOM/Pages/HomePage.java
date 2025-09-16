package com.SalesForcePOM.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.SalesForcePOM.Pages.Base.BasePage;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver)
	{
		// PageFactory.initElements(driver,this);    // initElements used to initialize the locator in page object model
		super(driver);
	}
	@FindBy(id="userNavLabel") WebElement userMenuDropdown;
	@FindBy(xpath="//a[text()='Logout']") WebElement logout;
	@FindBy(xpath="//div[@id='userNav-menuItems']/a") List<WebElement> usermenuDropdownList;
	@FindBy(xpath="//div[@id='userNav-menuItems']//a[2]") WebElement mySettings;
	@FindBy(id="tsidLabel") WebElement MenuDropdown;
	@FindBy(xpath="//div[@id='tsid-menuItems']/a") List<WebElement> menuDropdownList;
	@FindBy(xpath="//ul[@id='tabBar']/li") List<WebElement> menuTabListSalesforce;
	
	public void validateReports_MenuDropdown_list() {
		for(WebElement element : menuDropdownList) {
			WaitForVisibility(element, 30, element.getText());
			if((element.getText()).equalsIgnoreCase("Salesforce Chatter")) {
				clickElement(element, element.getText());
				System.out.println("Clicked salesforce chatter");
				for(WebElement ele : menuTabListSalesforce) {
					if((ele.getText()).equalsIgnoreCase("Reports")){
						System.out.println("Reports tab validated in Salesforce dropedown");
					}
				}
					break;
			}
		}
	}
		
	public WebDriver clickMenuDropdown()
	{
		WaitForVisibility(MenuDropdown, 30,"MenuDropdown");
		clickElement(MenuDropdown, "MenuDropdown in HomePage");
		return driver;
	}
		
	public WebDriver clickMySettings()
	{
		WaitForVisibility(mySettings, 30,"mySettings");
		clickElement(mySettings, "My settings in Uermenu dropdown");
		return driver;
	}
	
	public WebDriver clickLogout()
	{
		WaitForVisibility(logout, 30,"logout button");
		clickElement(logout, "logout button");
		return driver;
	}
	public WebDriver clickUserMenuDropdown()
	{
		WaitForVisibility(userMenuDropdown, 30,"Usermenu_Dropdown");
		clickElement(userMenuDropdown, "UserMenuDropdown arrow");
		return driver;
	}
	
	
	public void validate_userMenuDropdown_list() {
		
		List<String> ExpectedList = new ArrayList<String>();
		ExpectedList.add("My Profile");
		ExpectedList.add("My Settings");
		ExpectedList.add("Developer Console");
		ExpectedList.add("Switch to Lightning Experience");
		ExpectedList.add("Logout");
		System.out.println("Expected list : "+ExpectedList);
		validate_DropDownMenu(ExpectedList, usermenuDropdownList);
	}
}
