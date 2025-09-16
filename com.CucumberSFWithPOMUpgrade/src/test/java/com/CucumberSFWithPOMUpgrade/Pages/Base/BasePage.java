package com.CucumberSFWithPOMUpgrade.Pages.Base;

import java.util.ArrayList;



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import com.SFCucumberWithPOM.Utility.ExtentReportsUtility;


public class BasePage{

	private static Logger mylog = LogManager.getLogger(BasePage.class);
	//protected ExtentReportsUtility extentReportsUtility = ExtentReportsUtility.getInstance();
	protected static WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public static void enterText(WebElement ele, String data, String ObjName) 
	{
		if(ele.isDisplayed())
		{
			ele.clear();
			ele.sendKeys(data);
			mylog.info("Data entered in the  " + ObjName);
			
		}
		else
		{
			mylog.error("WebElement is not displayed");
		}
	}
	
	public static void isDisplayed(WebElement ele, String ObjName) 
	{
		if(ele.isDisplayed())
		{
			mylog.info(ObjName + " is displayed");
			
		}
		else
		{
			mylog.error(ObjName + " is NOT displayed" );
		}
	}
	public static void clickElement(WebElement ele, String ObjName)
	{
		if(ele.isEnabled())
		{
			ele.click();
			mylog.info(ObjName + " was enabled and clicked");
		}
		else
		{
			mylog.error(ObjName + "Button is displayed");
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getTitle()
	{
		mylog.info("Title: " + driver.getTitle());
		return driver.getTitle();
	}
	
	public static String getCurrentURL() {
		mylog.info("Title: " + driver.getTitle());
		return driver.getCurrentUrl();
	}

	public String getText(WebElement ele, String ObjName)
	{
		String text = ele.getText();
		mylog.info("Text : "  + text);
		return text;
	}


	public static void selectRadioButtonElement(WebElement ele, String ObjName)
	{
		if(!ele.isSelected())
		{
			ele.click();
			mylog.info(ObjName + " is selected");
		}
		else
		{
			mylog.error(ObjName + " is already selected");
		}
	}
	public static void dropDown_validation_ID(List<WebElement> dropdown_list, List ExpectedList) {
		List<String> ActualMenuList = new ArrayList<String>();
		
		for(WebElement element : dropdown_list) {
			mylog.info(element.getText());
			ActualMenuList.add(element.getText());	
		}
		mylog.info(ActualMenuList.size());
		validationList(ExpectedList, ActualMenuList);
	}
		
	public static void dropDown_SelectByVisibleText(WebElement element, String data) {
		Select select = new Select(element);
		select.selectByVisibleText(data);
		mylog.info(data + " is selected from dropdown menu");
	}
	public static WebElement dropDown_FirstOptionSelect(WebElement element) {
		Select select = new Select(element);
		WebElement val_item = select.getFirstSelectedOption();
		return val_item;
	}
	
	public static void validationCheck_Equals(String expectedStr, String actualStr)
	{
		mylog.info("Checking validation...");
		Assert.assertEquals(actualStr, expectedStr);
	}
	public static void validationCheck_NotEquals(String expectedStr, String actualStr)
	{
		mylog.info("Checking validation...");
		Assert.assertNotEquals(actualStr, expectedStr, "Strings should not be equal");
	}
	
	public static void validationCheckList_Equals(List<String> expectedList, List<String> actualList)
	{
		mylog.info("Checking List validation...");
		Assert.assertEquals(expectedList, actualList);
	}
	public static void validationList(List<String> expectedList, List<String> actualList)
	{
		if (expectedList.equals(actualList)) {
			mylog.info("Lists are equal");
        } else {
           mylog.error("Lists are NOT equal");
        }
	}

	public static void WaitForVisibility(WebElement element, int time, String ObjName) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public static void WaitForElementToBeClickable(WebElement element, int time, String ObjName) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		mylog.info(ObjName +" is Wait For Element To Be Clickable" );
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void WaitForInvisibilityOfElement_ID(String ID, int time, String ObjName) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		mylog.info(ObjName +" Waiting For Invisibility Of Element" );
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(ID)));
		
	}
	public static void WaitForFrameSwitchTo(WebElement element, int time, String ObjName) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		mylog.info(ObjName +" Waiting For Frame SwitchTo" );
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		
	}
	
	public static void action_class(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		mylog.info("Moved to current element" );
	}
	
	public static void waitForAlertToPresent(long timeInSec, String string)
	{
		mylog.info("waiting for Alert box visibility for maximum of "+timeInSec+ "sec");
		WebDriverWait wait=new WebDriverWait(driver,timeInSec);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public Alert switchToAlert() {
		waitForAlertToPresent(30,"error login alert box");
		Alert alert=driver.switchTo().alert();
		mylog.info("switched to an alert and handled");
		mylog.info("Alert message : " +alert.getText());
		return alert;

	}

	public String getAlertText(Alert alert, String objectname) {
		return objectname;
	}
	public void AcceptAlert(Alert alert) {
		alert.accept();
		mylog.info("Alert accepted");

	}
	public void CancelAlert(Alert alert) {
		alert.dismiss();
		mylog.info("Alert cancelled");

	}
	
	public static void validate_DropDownMenu(List<String> expectedMenuList, List<WebElement> elements) {
		
		List<String> ActualMenuList = new ArrayList<String>();
		
		
		for(WebElement list_ele: elements) {
			ActualMenuList.add(list_ele.getText());
		}
		System.out.println("Expected MenuList : "+expectedMenuList);
		validationCheckList_Equals(expectedMenuList, ActualMenuList);
	}
	
	
}
