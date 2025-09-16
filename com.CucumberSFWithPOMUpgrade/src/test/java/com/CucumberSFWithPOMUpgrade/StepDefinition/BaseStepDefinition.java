package com.CucumberSFWithPOMUpgrade.StepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;

import com.CucumberSFWithPOMUpgrade.Pages.HomePage;
import com.CucumberSFWithPOMUpgrade.Pages.LoginPage;
import com.CucumberSFWithPOMUpgrade.Pages.MySettingsPage;
import com.CucumberSFWithPOMUpgrade.Utility.Constants;
import com.CucumberSFWithPOMUpgrade.Utility.MasterthoughtReportGenerator;
import com.CucumberSFWithPOMUpgrade.Utility.SF_PropertiesUtility;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


//import com.SFCucumberWithPOM.Utility.ExtentReportsUtility;

@Listeners(com.CucumberSFWithPOMUpgrade.Utility.SF_ListenerUtility.class)
public class BaseStepDefinition {

	private static Logger mylog = LogManager.getLogger(LoginStepDefinition.class);
//	protected ExtentReportsUtility extentReportsUtility = ExtentReportsUtility.getInstance();
	protected static WebDriver driver =null;
	public String Title = null;
	
	public static LoginPage loginPage;
	public static HomePage homePage;
	public static MySettingsPage mySettingsPage;
	
	public String usernameData=SF_PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES,"username");
	public String passwordData=SF_PropertiesUtility.readDataFromPropertiesFile(Constants.APPLICATION_PROPERTIES,"password");
	
	@Before
	public void beforeScenario(Scenario scenario) {
		
		try {
            System.out.println("Launching browser...");
            launchBrowser("chrome");
        } catch (Exception e) {
            scenario.log("Driver initialization failed: " + e.getMessage());
            // Mark scenario as failed explicitly by throwing an exception
            throw new RuntimeException("Driver setup failed", e);
        }
	}
	@After
	public void afterScenario(Scenario scenario) {
		  try {
	            if (scenario.isFailed()) {
	                // Take screenshot for failed scenario
	                final byte[] screenshot = ((TakesScreenshot) driver)
	                        .getScreenshotAs(OutputType.BYTES);
	                scenario.attach(screenshot, "image/png", scenario.getName());
	            }
	        } catch (Exception e) {
	            scenario.log("Teardown error: " + e.getMessage());
	        } finally {
	            if (driver != null) {
	            	closeDriver();
	            }
	        }
		
	}
	@AfterSuite
	public void after_all() {
		 System.out.println("=== Generating Masterthought Report ===");
        MasterthoughtReportGenerator.generateReport();
    }
	public static void launchBrowser(String browserName)
	{
		switch (browserName.toLowerCase()) {
		case "chrome": WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		break;

		case "firefox": WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		break;
		
		case "edge": WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		break;
		
		case "safari": WebDriverManager.safaridriver().setup();
		driver=new SafariDriver();
		driver.manage().window().maximize();
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

	public static void closeDriver()
	{
		driver.quit();
		mylog.info("browser get closed successfully..");
	}
	
	@Given("the url {string}")
	public void the_url(String url) throws Exception {
		 goToURL(url);
	}
	
	@When("i enter username")
	public void i_enter_username() {
		 loginPage.enterUserName(usernameData);
	}

	@When("i click the login button")
	public void i_click_the_login_button() {
		 Title = loginPage.getTitle();
		  loginPage.clickLoginButton();
	}
	
	@When("i land in {string}")
	public void i_land_in(String page) {
		switch (page.toLowerCase()) {
		case "loginpage": loginPage = new LoginPage(driver);
					  System.out.println("Login driver: ...."+ driver);
					  break;

		case "homepage": homePage = new HomePage(driver);
						 break;
		
		case "mysettingpage": mySettingsPage = new MySettingsPage(driver);
							  break;
		
		default: System.out.println("invalid page selection");
				 break;
		}
	}

	@When("i enter the password")
	public void i_enter_the_password() {
		loginPage.enterPassword(passwordData);
	}
	@Then("i should be able to see homepage")
	public void i_should_be_able_to_see_homepage() {
		String actualTitle = Title;
		System.out.println("Title : " + Title);
		String expectedTitle = homePage.getTitle();
		System.out.println("expectedTitle : " + expectedTitle);
		Assert.assertNotEquals(actualTitle, expectedTitle, "Both titles are not equals, validation success!!!");
	}

	@When("i click usermenu dropdown")
	public void i_click_usermenu_dropdown() {
		 homePage.clickUserMenuDropdown();
	}
	
	@When("i click logout")
	public void i_click_logout() {
		 homePage.clickLogout();
	}



}
