package com.Demoguru.Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.Demoguru.BaseTest.BaseTest;
import com.Demoguru.Reports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ITestListeners extends BaseTest implements ITestListener{

	ExtentReports extent=ExtentReporter.generateReport();
	ExtentTest test;
	//WebDriver driver=null;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		test.log(Status.PASS, result.getName());
		test.log(Status.PASS, result.getTestContext().getName());
		//test.pass("Browser Opened Successfully");
		System.out.println("Test Started Successfully");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Launched succesfully :" +result.toString());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		GetScreenShot gs = new GetScreenShot();
		System.out.println("TestCase Failed");
		String name = result.getMethod().getMethodName();
		test.log(Status.FAIL,result.getThrowable());
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
		}
		try {
			//gs.onErrorScreenShot(driver,name);
			test.addScreenCaptureFromPath(gs.onErrorScreenShot(driver,name), name);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}
	

}
