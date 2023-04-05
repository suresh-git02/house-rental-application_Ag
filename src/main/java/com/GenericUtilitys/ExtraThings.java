package com.GenericUtilitys;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtraThings implements ITestListener {

	public void onTestStart(ITestResult result) {
			}

	public void onTestSuccess(ITestResult result) {
			}

	public void onTestFailure(ITestResult result) {
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		}

	ExtentSparkReporter htmlRepot=new ExtentSparkReporter("./tapuRepot/falid.html");
	
	
	
	
	public void onFinish(ITestContext context) {
	
	}

	
	
	
}
