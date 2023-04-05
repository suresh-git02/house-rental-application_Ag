package RegistationUsingPOM;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilitys.DatabaseUtlity;
import com.GenericUtilitys.ExcelUtility;
import com.GenericUtilitys.FileUtility;
import com.GenericUtilitys.JavaUtility;
import com.GenericUtilitys.WebDriverUtility;
import com.ObjectRepo.ApartmentRegistration;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApartmentRegistrations {

	public static void main(String[] args) throws Throwable {

		DatabaseUtlity dLib=new DatabaseUtlity();
		WebDriverUtility wLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		wLib.maximizeWindow(driver);
		wLib.implicitelyWait(driver,20);
		String URL=fLib.readDataFromPropertiesFile("url");
		String USERNAME=fLib.readDataFromPropertiesFile("username");
		String PASSWORD=fLib.readDataFromPropertiesFile("psw");

		
		//lunch the browser and login
		
		driver.get(URL);
		LoginPage login=new LoginPage(driver);
		login.loginPage(USERNAME, PASSWORD);
		//	driver.findElement(By.).sendKeys(USERNAME);
//		driver.findElement(By.name("password")).sendKeys(PASSWORD);
//		driver.findElement(By.name("login")).click();
		
		//Cick on registar
		
		HomePage hm=new HomePage(driver);
		hm.RegisterClick();
		
		ApartmentRegistration ap=new ApartmentRegistration(driver);
		ap.clickApartmentRegTab();
		HashMap<String, String> data = eLib.readMultipleDataInExcel("sheet4");
		ap.registerapartment(driver, data, jLib);
		ap.clickAddMore();
		HashMap<String, String> addData = eLib.readMultipleDataInExcel("Sheet5");
		ap.moreDetails(driver, addData);
		ap.submitRegApartment();
		boolean expt=driver.findElement(By.xpath("//div[text()='Registration successfull. Thank you']")).isDisplayed();
	    
		
		if(expt)
		{
	System.out.println("sucessfully update");
		}
		else
		{
			System.out.println("not updated");
		}
		

	
//	HashMap<String, String> map = eLib.readMultipleDataInExcel("Sheet3");
//		RegisterInduvidualHome reg = new RegisterInduvidualHome(driver);
//		reg.registerHome(driver, jLib, map);
//		reg.registerInduvidualHome();
//		eLib.closeWorkbook(ExcelUtility.workBook());
//		
//		d.clickSendSMS();
//		
//		SendSMS s=new SendSMS(driver);
//		Thread.sleep(3000);
//		s.clickcheckBox(driver);
//
//		s.clickMessageBody("NoMessage");
//		s.submitSendSMS();
//		
		
	}
}

	

