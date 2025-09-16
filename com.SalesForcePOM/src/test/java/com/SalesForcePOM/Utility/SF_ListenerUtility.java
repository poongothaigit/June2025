package com.SalesForcePOM.Utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.SalesForcePOM.Base.BaseTest;

public class SF_ListenerUtility extends BaseTest implements ITestListener{

	private Logger mylog = LogManager.getLogger(SF_ListenerUtility.class);
	private ExtentReportsUtility extentReportUtility=ExtentReportsUtility.getInstance();
	
	@Override
	public void onTestStart(ITestResult result) {
		mylog.info(result.getMethod().getMethodName()+" My Test Started---------------");
		extentReportUtility.startSingleTestReport(result.getMethod().getMethodName());;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		mylog.info(result.getMethod().getMethodName()+" My Test Success------------");
		extentReportUtility.logTestpassed(result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		mylog.error(result.getMethod().getMethodName()+" My Test Failed------------------");
		extentReportUtility.logTestFailedWithException(result.getThrowable());
		String filename=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		String path=Constants.SCREENSHOTS_DIRECTORY_PATH+filename+".png";
		takeScreenshot(path);
		extentReportUtility.logTestWithscreenshot(path);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		mylog.warn(result.getMethod().getMethodName()+" My Test Skipped-----------------");
		extentReportUtility.logTestFailed(result.getMethod().getMethodName());
	}

	@Override
	public void onStart(ITestContext context) {
		mylog.info(context.getName()+" Start of my TC----------");
		extentReportUtility.startExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		mylog.info(context.getName()+" End of my TC--------------");
		extentReportUtility.endReport();
	}

}
