package RegistationUsingPOM;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilitys.DatabaseUtlity;
import com.GenericUtilitys.ExcelUtility;
import com.GenericUtilitys.FileUtility;
import com.GenericUtilitys.JavaUtility;
import com.GenericUtilitys.WebDriverUtility;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.IndivitualHomeRegistration;
import com.ObjectRepo.LoginPage;
import com.ObjectRepo.SendSms;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IndivitualRegANDsendSMSs {


	public static void main(String[] args) throws Throwable {
		
		DatabaseUtlity dLib =new DatabaseUtlity();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		
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
		IndivitualHomeRegistration reg=new IndivitualHomeRegistration(driver);
		//reg.IndivisualHoemDetails(wLib,eLib.readDataFromExcel("sheet1",0,1)+jLib.random(),eLib.readDataFromExcel("sheet1",1, 1)+jLib.random(),eLib.readDataFromExcel("sheet1", 2, 1) ,"Ag"+jLib.random()+eLib.readDataFromExcel("sheet1", 3, 1), eLib.readDataFromExcel("sheet1", 4, 1), eLib.readDataFromExcel("sheet1", 5, 1), eLib.readDataFromExcel("sheet1", 6, 1), eLib.readDataFromExcel("sheet1", 7, 1), eLib.readDataFromExcel("sheet1", 8, 1), eLib.readDataFromExcel("sheet1", 9, 1), eLib.readDataFromExcel("sheet1", 10, 1), eLib.readDataFromExcel("sheet1", 11, 1), eLib.readDataFromExcel("sheet1", 12, 1), eLib.readDataFromExcel("sheet1", 13, 1), eLib.readDataFromExcel("sheet1", 14, 1), eLib.readDataFromExcel("sheet1", 15, 1), eLib.readDataFromExcel("sheet1", 16, 1));
		//read the multipledata in ExcelSheet
		
		
		HashMap<String, String> map = eLib.readMultipleDataInExcel("Sheet1");
		reg.RegisterHome(driver, map, jLib);
		reg.RIsubmit();
		hm.SendSMSclick();
		SendSms sms=new SendSms(driver);
		sms.clickcheckBox(driver,eLib.readDataFromExcel("Sheet2", 2, 0) );
		sms.clickMessageBody("kukura");
		sms.submitSendSMS();
		
}
}