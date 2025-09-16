package com.CucumberSFWithPOMUpgrade.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/features/Login.feature"},
		glue = {"com.CucumberSFWithPOMUpgrade.StepDefinition"},
		plugin= {"pretty",
				"json:target/cucumber-reports/cucumber.json",
				"html:target/cucumber-reports/cucumberReports.html"}
		//dryRun = true
		)
public class LoginRunner extends AbstractTestNGCucumberTests {

}
