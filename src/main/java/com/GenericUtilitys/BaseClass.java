package com.GenericUtilitys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.ObjectRepo.HomePage;
import com.ObjectRepo.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public DatabaseUtlity dLib=new DatabaseUtlity();
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib= new JavaUtility();

	public   WebDriver driver;
	public static  WebDriver Sdriver;
	@BeforeSuite(alwaysRun = true)
	public void open_DB() throws Throwable
	{
		dLib.ConnectToDB();
		System.out.println("----connect to db-----");
	}
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void connectTheBrowser(String BROWSER) throws Throwable
	{
		//String BROWSER=fLib.readDataFromPropertiesFile("browser");
		String URL=fLib.readDataFromPropertiesFile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("EdgeBrowser"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();

		}
		else if(BROWSER.equalsIgnoreCase("fireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();

		}
		else {
			System.out.println("invalid user");
		}
		driver.get(URL);
        Sdriver=driver;
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver, 10);
			
	}
	
	@BeforeMethod(alwaysRun = true)
	
	public void loginApp() throws Throwable
	{
		String USERNAME = fLib.readDataFromPropertiesFile("username");
		String PASSWORD = fLib.readDataFromPropertiesFile("psw");
		LoginPage log=new LoginPage(driver);
		log.loginPage(USERNAME, PASSWORD);
	}
	
	@AfterMethod(alwaysRun = true)
	public void logoutApp()
	{
		HomePage hm=new HomePage(driver);
		hm.LogOut();
	}
	@AfterClass(alwaysRun = true)
	public void disconnectBrowser()
	{
		driver.quit();
	}
	@AfterSuite(alwaysRun = true)
	public void closeDB() throws Throwable
	{
		dLib.CloseDB();
	}
}
