package com.GenericUtilitys;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImPlementation implements ITestListener {

	
	public ExtentReports repoter;
	 ExtentTest test;
	public void onTestStart(ITestResult result) {
		//Execution Start  From Here
		 String methodname = result.getMethod().getMethodName();
		 System.out.println(methodname); 
		  test = repoter.createTest(methodname);
		  Reporter.log(methodname+"----->Test script Execution Started");
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		
        test.log(Status.PASS,methodname+"--->passed" )	;//for extend report
        Reporter.log(methodname+"-------->testScript Execution SucessFully");//testng reporter/emalable report
	}

	public void onTestFailure(ITestResult result) {
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.Sdriver);
		File srs = edriver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screnshot/faildss.png");
	   try {
		FileUtils.copyFile(srs,dest);
	} catch (IOException e) {
	
		e.printStackTrace();
	}
	   String path = dest.getAbsolutePath();
	   test.addScreenCaptureFromPath(path);
	   test.log(Status.FAIL, result.getMethod().getMethodName());
	
		
//		try {
//			String screenshotname=WebDriverUtility.getScreenShot(BaseClass.Sdriver,result.getMethod().getMethodName());
//			test.addScreenCaptureFromPath(screenshotname);
//			
//		} catch (Throwable e) {
//						e.printStackTrace();
//		}
//	    test.log(Status.FAIL,result.getThrowable())	;//for extend report
//        Reporter.log("testScript execution is Falid");//testng reporter/emalable report
	

		
	}

	public void onTestSkipped(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
  test.log(Status.SKIP, methodname+"-->Skiped");
  test.log(Status.SKIP,result +"-->Skiped");
Reporter.log("TestScript Execution Skiped");
	}

	public void onStart(ITestContext context) {
		//Create html Report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report1.html");
		htmlreport.config().setDocumentTitle("team 04 project");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("hrm");
		
		
		 repoter = new ExtentReports();
		 repoter.attachReporter(htmlreport);
		 repoter.setSystemInfo("base_browser", "chrome");
		 repoter.setSystemInfo("os", "windows");
		 repoter.setSystemInfo("base url", "https://localhost:8888");
		 repoter.setSystemInfo("repoter_name", "Suresh");

	}

	public void onFinish(ITestContext context) {
	//consolidate the repot
		repoter.flush();
	}
	

	
}
