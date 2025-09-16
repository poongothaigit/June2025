package com.TestNG_Demo.Day_2;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener{

	public void onTestStart(ITestResult result) {
	System.out.println("My Test started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("My Test success");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("My Test failed");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("My Test skipped");
	}

	public void onStart(ITestContext context) {
		System.out.println("Start of my TC");
	}

	public void onFinish(ITestContext context) {
		System.out.println("End of my TC");
	}

}
