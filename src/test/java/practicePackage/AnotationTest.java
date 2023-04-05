package practicePackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnotationTest {

	
	@BeforeSuite
	public void connect_DB()
	{
		System.out.println("connect data base");
	}
	@BeforeTest
	public void stateParallelExecution()
	{
		System.out.println("Start paallel execution");
	}
	@BeforeClass
	public void open_the_Browser()
	{
		System.out.println("Open The Browser");
	}
	@BeforeMethod
	public void login_application()
	{
		System.out.println("Login to the application");
	}

	@Test
	public void Execute()
	{
		System.out.println("Execute the Script");
	}
	@AfterMethod
	public void logout_application()
	{
	System.out.println("Log out the application");
	}
	@AfterClass
	public void close_the_browser()
	
	{
		System.out.println("close the browser");
	}
	@AfterTest
	public void stopParallelExecution()
	{
		System.out.println("Stop the parallel  Execution");
	}
	@AfterSuite
	public void dis_Connect_Database()
	{
		System.out.println("close the database connection");
	}
	
	
	
	
}
