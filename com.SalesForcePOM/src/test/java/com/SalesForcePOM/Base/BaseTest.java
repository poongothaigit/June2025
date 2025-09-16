package com.SalesForcePOM.Base;


import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.SalesForcePOM.Utility.Constants;
import com.SalesForcePOM.Utility.ExtentReportsUtility;
import com.SalesForcePOM.Utility.SF_PropertiesUtility;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {

	public static Logger mylog = LogManager.getLogger(BaseTest.class);
	protected ExtentReportsUtility extentReportsUtility = ExtentReportsUtility.getInstance();
	protected static WebDriver driver= null;
	private WebDriverWait wait = null;
	
	public static void launchBrowser(String browserName)
	{
		switch (browserName.toLowerCase()) {
		case "chrome": WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;

		case "firefox": WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
		
		case "edge": WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		break;
		
		case "safari": WebDriverManager.safaridriver().setup();
		driver=new SafariDriver();
		break;
		
		default: System.out.println("invalid browser selection");
			break;
		}
	}
	
	public static void goToURL(String url) throws Exception
	{
		driver.get(url);
		mylog.info(url+" is entered");
		driver.manage().window().maximize();
		Thread.sleep(4000);
	}

		
	public void takeScreenshot(String filepath) {
		TakesScreenshot screenCapture=(TakesScreenshot)driver;
		File src= screenCapture.getScreenshotAs(OutputType.FILE);
		File destFile=new File(filepath);
		try {
			Files.copy(src, destFile);
			mylog.info("screen captured");
		} catch (IOException e) {
			e.printStackTrace();
			mylog.error("problem occured during screenshot taking");
		}
	}
	
	@BeforeMethod
	@Parameters("browsername")
	public void setUp(@Optional("chrome")String browsername) throws Exception
	{
		launchBrowser(browsername);
		String url=SF_PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES,"url");
		goToURL(url);
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		closeDriver();
	}
	
	
	public static void closeDriver()
	{
		driver.quit();
		mylog.info("browser get closed successfully..");
	}
}
