package com.GenericUtilitys;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpClass  implements IRetryAnalyzer {

int count=0;
int  Retrylimints=3;

public boolean retry(ITestResult result) {
	
	if(count<Retrylimints)
	{
		count++;
		return true;
	}
	return false;
}}
