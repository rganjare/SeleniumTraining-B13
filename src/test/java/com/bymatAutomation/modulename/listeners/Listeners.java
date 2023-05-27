package com.bymatAutomation.modulename.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.bymatAutomation.modulename.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class Listeners extends TestBase implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		
		getDriver();
	}

	public void onTestSuccess(ITestResult result) {

	System.out.println("Test case is passed");
	
	teardown();
	}

	public void onTestFailure(ITestResult result) {

		test.log(LogStatus.FAIL, result.getThrowable().getMessage());
		takeaScreenShot();
		teardown();
		
	}
	
	public void onTestSkipped(ITestResult result) {


	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
